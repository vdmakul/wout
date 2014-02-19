package lv.vdm.wout;

import lv.vdm.wout.domain.exercise.Exercise;
import lv.vdm.wout.domain.exercise.ExerciseClass;
import lv.vdm.wout.domain.exercise.Inventory;
import lv.vdm.wout.domain.exercise.TechnicalLevel;
import lv.vdm.wout.repository.ExerciseRepository;
import lv.vdm.wout.repository.InventoryRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.ArrayList;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class App {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
        lef.setDataSource(dataSource);
        lef.setJpaVendorAdapter(jpaVendorAdapter);
        lef.setPackagesToScan("lv.vdm.wout.domain");
        return lef;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(false);
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        hibernateJpaVendorAdapter.setDatabase(Database.H2);
        return hibernateJpaVendorAdapter;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager();
    }


    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        ExerciseRepository exerciseRepo = context.getBean(ExerciseRepository.class);
        InventoryRepository inventoryRepo = context.getBean(InventoryRepository.class);

        Inventory perekladina = new Inventory("perekladina", "Perekladina");
        Inventory ruki = new Inventory("ruki", "Ruki");

        inventoryRepo.save(perekladina);
        inventoryRepo.save(ruki);

        Exercise jogging = new Exercise("jogging", "Jogging", TechnicalLevel.NOVICE, ExerciseClass.CARDIO);
        Exercise running = new Exercise("running", "Running", TechnicalLevel.NOVICE, ExerciseClass.CARDIO);
        Exercise podtjagivanie = new Exercise("podtjagivanie", "Podtjagivanie", TechnicalLevel.NOVICE, ExerciseClass.BASE);
        podtjagivanie.setRequiredInventories(new ArrayList<Inventory>());
        podtjagivanie.requires(perekladina);
        podtjagivanie.requires(ruki);

        exerciseRepo.save(jogging);
        exerciseRepo.save(running);
        exerciseRepo.save(podtjagivanie);
    }
}
