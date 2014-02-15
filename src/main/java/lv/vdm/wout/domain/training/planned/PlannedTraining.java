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

    public Training getOrigin() {
        return origin;
    }

    public void setOrigin(Training origin) {
        this.origin = origin;
    }

    public Trainer getAuthor() {
        return author;
    }

    public void setAuthor(Trainer author) {
        this.author = author;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getPlannedDate() {
        return plannedDate;
    }

    public void setPlannedDate(Date plannedDate) {
        this.plannedDate = plannedDate;
    }

    public List<PlannedWorkout> getPlannedWorkouts() {
        return plannedWorkouts;
    }

    public void setPlannedWorkouts(List<PlannedWorkout> plannedWorkouts) {
        this.plannedWorkouts = plannedWorkouts;
    }
}
