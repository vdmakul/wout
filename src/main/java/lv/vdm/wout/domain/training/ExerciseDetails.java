package lv.vdm.wout.domain.training;

import lv.vdm.wout.domain.Difficulty;

public abstract class ExerciseDetails extends ExerciseDetailsTemplate {
    private Workout workout;

    private String comments;
    private Difficulty difficulty;
}
