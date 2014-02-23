package lv.vdm.wout.domain.training.planned;

import lv.vdm.wout.domain.training.ExerciseDetailsTemplate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PlannedExerciseDetails extends ExerciseDetailsTemplate {

    @ManyToOne
    @JoinColumn(name = "planned_workout_id", nullable = false)
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
