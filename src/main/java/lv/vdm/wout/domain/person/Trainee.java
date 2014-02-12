package lv.vdm.wout.domain.person;

import lv.vdm.wout.domain.training.Training;
import lv.vdm.wout.domain.training.planned.PlannedTraining;

import java.util.List;

public class Trainee extends User {
    private Trainer mainTrainer;
    private List<Trainer> trainers;
    private List<Training> trainingHistory;
    private List<PlannedTraining> plannedTrainings;

}
