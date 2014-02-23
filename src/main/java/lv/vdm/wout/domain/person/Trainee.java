package lv.vdm.wout.domain.person;

import lv.vdm.wout.domain.training.Training;
import lv.vdm.wout.domain.training.planned.PlannedTraining;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Trainee extends User {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "training", fetch = FetchType.EAGER) //todo fix eager

    @ManyToOne
    @JoinColumn(name = "trainer_id", nullable = true)
    private Trainer trainer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainee", fetch = FetchType.EAGER) //todo fix eager
    private Set<Training> trainingHistory = new HashSet<>();

    @Transient
    private Set<PlannedTraining> plannedTrainings = new HashSet<>();

    protected Trainee() {
    }

    public Trainee(String login) {
        this.login = login;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Set<Training> getTrainingHistory() {
        return trainingHistory;
    }

    public void setTrainingHistory(Set<Training> trainingHistory) {
        this.trainingHistory = trainingHistory;
    }

    public Set<PlannedTraining> getPlannedTrainings() {
        return plannedTrainings;
    }

    public void setPlannedTrainings(Set<PlannedTraining> plannedTrainings) {
        this.plannedTrainings = plannedTrainings;
    }
}
