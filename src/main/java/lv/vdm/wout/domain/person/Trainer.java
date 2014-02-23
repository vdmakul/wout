package lv.vdm.wout.domain.person;

import lv.vdm.wout.domain.training.planned.PlannedTraining;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Trainer extends User {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainer", fetch = FetchType.EAGER) //todo fix eager
    private Set<Trainee> trainees = new HashSet<>();

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "trainer", fetch = FetchType.EAGER) //todo fix eager
    @Transient
    private Set<PlannedTraining> trainingPortfolio = new HashSet<>();


    protected Trainer() {
    }

    public Trainer(String login) {
        this.login = login;
    }

    public void mentor(Trainee trainee) {
        trainee.setTrainer(this);
        getTrainees().add(trainee);
    }

    public Set<Trainee> getTrainees() {
        return trainees;
    }

    public void setTrainees(Set<Trainee> trainees) {
        this.trainees = trainees;
    }

    public Set<PlannedTraining> getTrainingPortfolio() {
        return trainingPortfolio;
    }

    public void setTrainingPortfolio(Set<PlannedTraining> trainingPortfolio) {
        this.trainingPortfolio = trainingPortfolio;
    }
}
