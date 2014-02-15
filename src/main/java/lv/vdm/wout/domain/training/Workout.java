package lv.vdm.wout.domain.training;

import lv.vdm.wout.domain.Difficulty;
import lv.vdm.wout.domain.exercise.Exercise;

import java.util.List;

public class Workout {

    private Exercise exercise;
    private List<ExerciseDetails> exerciseDetails;
    private Difficulty difficulty;

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public List<ExerciseDetails> getExerciseDetails() {
        return exerciseDetails;
    }

    public void setExerciseDetails(List<ExerciseDetails> exerciseDetails) {
        this.exerciseDetails = exerciseDetails;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
}
