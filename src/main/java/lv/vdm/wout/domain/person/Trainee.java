package lv.vdm.wout.domain.person;

import lv.vdm.wout.domain.training.Training;
import lv.vdm.wout.domain.training.planned.PlannedTraining;

import java.util.List;

public class Trainee extends User {
    private Trainer mainTrainer;
    private List<Trainer> trainers;
    private List<Training> trainingHistory;
    private List<PlannedTraining> plannedTrainings;

    public Trainer getMainTrainer() {
        return mainTrainer;
    }

    public void setMainTrainer(Trainer mainTrainer) {
        this.mainTrainer = mainTrainer;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }

    public List<Training> getTrainingHistory() {
        return trainingHistory;
    }

    public void setTrainingHistory(List<Training> trainingHistory) {
        this.trainingHistory = trainingHistory;
    }

    public List<PlannedTraining> getPlannedTrainings() {
        return plannedTrainings;
    }

    public void setPlannedTrainings(List<PlannedTraining> plannedTrainings) {
        this.plannedTrainings = plannedTrainings;
    }
}
