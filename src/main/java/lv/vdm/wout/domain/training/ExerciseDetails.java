package lv.vdm.wout.domain.training;

import lv.vdm.wout.domain.Difficulty;

public class ExerciseDetails extends ExerciseDetailsTemplate {
    private Workout workout;

    private String comments;
    private Difficulty difficulty;

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
}
