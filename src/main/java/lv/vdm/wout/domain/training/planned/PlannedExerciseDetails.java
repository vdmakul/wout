package lv.vdm.wout.domain.training.planned;

import lv.vdm.wout.domain.training.ExerciseDetailsTemplate;

public class PlannedExerciseDetails extends ExerciseDetailsTemplate {
    private PlannedWorkout plannedWorkout;

    private String comments;

    public PlannedWorkout getPlannedWorkout() {
        return plannedWorkout;
    }

    public void setPlannedWorkout(PlannedWorkout plannedWorkout) {
        this.plannedWorkout = plannedWorkout;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
