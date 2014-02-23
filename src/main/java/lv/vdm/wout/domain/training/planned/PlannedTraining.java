package lv.vdm.wout.domain.training.planned;

import lv.vdm.wout.domain.person.Trainer;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class PlannedTraining {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plannedTraining", fetch = FetchType.EAGER) //todo fix eager
    private Set<PlannedWorkout> plannedWorkouts = new HashSet<>();

    @Temporal(TemporalType.DATE)
    private Date plannedDate;

    private String comments;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = true)
    private Trainer author;

    public void attach(PlannedWorkout workout) {
        workout.setPlannedTraining(this);
        getPlannedWorkouts().add(workout);
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

    public Set<PlannedWorkout> getPlannedWorkouts() {
        return plannedWorkouts;
    }

    public void setPlannedWorkouts(Set<PlannedWorkout> plannedWorkouts) {
        this.plannedWorkouts = plannedWorkouts;
    }
}
