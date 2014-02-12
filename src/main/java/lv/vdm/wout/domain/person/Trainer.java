package lv.vdm.wout.domain.person;

import lv.vdm.wout.domain.training.planned.PlannedTraining;

import java.util.List;

public class Trainer extends User {


    private List<Trainee> trainees;

    private List<PlannedTraining> trainingPortfolio;
}
