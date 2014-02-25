package lv.vdm.wout;

import lv.vdm.wout.config.CoreConfig;
import lv.vdm.wout.config.PersistenceConfig;
import lv.vdm.wout.config.WebAppInitializer;
import lv.vdm.wout.domain.exercise.Exercise;
import lv.vdm.wout.domain.exercise.ExerciseClass;
import lv.vdm.wout.domain.exercise.Inventory;
import lv.vdm.wout.domain.exercise.TechnicalLevel;
import lv.vdm.wout.repository.ExerciseRepository;
import lv.vdm.wout.repository.InventoryRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(new Class[]{CoreConfig.class, PersistenceConfig.class, WebAppInitializer.class}, args);
        ExerciseRepository exerciseRepo = context.getBean(ExerciseRepository.class);
        InventoryRepository inventoryRepo = context.getBean(InventoryRepository.class);

        Inventory perekladina = new Inventory("perekladina", "Perekladina");
        Inventory ruki = new Inventory("ruki", "Ruki");

        inventoryRepo.save(perekladina);
        inventoryRepo.save(ruki);

        Exercise jogging = new Exercise("jogging", "Jogging", TechnicalLevel.NOVICE, ExerciseClass.CARDIO);
        Exercise running = new Exercise("running", "Running", TechnicalLevel.NOVICE, ExerciseClass.CARDIO);
        Exercise podtjagivanie = new Exercise("podtjagivanie", "Podtjagivanie", TechnicalLevel.NOVICE, ExerciseClass.BASE);
        podtjagivanie.requires(perekladina);
        podtjagivanie.requires(ruki);

        exerciseRepo.save(jogging);
        exerciseRepo.save(running);
        exerciseRepo.save(podtjagivanie);
    }
}
