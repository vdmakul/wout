package lv.vdm.wout.domain.training.planned;

import lv.vdm.wout.domain.exercise.Exercise;

import java.util.List;

public class PlannedWorkout {
    private Exercise exercise;
    private List<PlannedExerciseDetails> plannedDetails;

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public List<PlannedExerciseDetails> getPlannedDetails() {
        return plannedDetails;
    }

    public void setPlannedDetails(List<PlannedExerciseDetails> plannedDetails) {
        this.plannedDetails = plannedDetails;
    }
}
