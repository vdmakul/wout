package lv.vdm.wout.domain.person;

import lv.vdm.wout.domain.training.planned.PlannedTraining;

import java.util.List;

public class Trainer extends User {

    private List<Trainee> trainees;
    private List<PlannedTraining> trainingPortfolio;

    public List<Trainee> getTrainees() {
        return trainees;
    }

    public void setTrainees(List<Trainee> trainees) {
        this.trainees = trainees;
    }

    public List<PlannedTraining> getTrainingPortfolio() {
        return trainingPortfolio;
    }

    public void setTrainingPortfolio(List<PlannedTraining> trainingPortfolio) {
        this.trainingPortfolio = trainingPortfolio;
    }
}
