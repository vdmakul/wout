package lv.vdm.wout.domain.training.planned;

import lv.vdm.wout.domain.person.Trainer;
import lv.vdm.wout.domain.training.Training;

import java.util.Date;
import java.util.List;

public class PlannedTraining {
    private List<PlannedWorkout> plannedWorkouts;
    private Date plannedDate;
    private String comments;

    private Trainer author;
    private Training origin;
}
