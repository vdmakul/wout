package lv.vdm.wout.domain.training;

import lv.vdm.wout.domain.Difficulty;

import javax.persistence.*;

@Entity
public class ExerciseDetails extends ExerciseDetailsTemplate {
    @ManyToOne
    @JoinColumn(name = "workout_id", nullable = false)
    private Workout workout;

    private String comments;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @SuppressWarnings("unused")
    protected ExerciseDetails() {
    }

    public ExerciseDetails(Workout workout) {
        assert workout != null;
        this.workout = workout;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExerciseDetails details = (ExerciseDetails) o;

        if (workout != null ? !workout.equals(details.workout) : details.workout != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return workout != null ? workout.hashCode() : 0;
    }
}
