package lv.vdm.wout.domain.training.planned;

import lv.vdm.wout.domain.exercise.Exercise;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class PlannedWorkout {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "planned_training_id", nullable = false)
    private PlannedTraining plannedTraining;

    @ManyToOne
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plannedWorkout", fetch = FetchType.EAGER) //todo fix eager
    private Set<PlannedExerciseDetails> plannedDetails = new HashSet<>();

    public void with(PlannedExerciseDetails details) {
        details.setPlannedWorkout(this);
        getPlannedDetails().add(details);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Set<PlannedExerciseDetails> getPlannedDetails() {
        return plannedDetails;
    }

    public void setPlannedDetails(Set<PlannedExerciseDetails> plannedDetails) {
        this.plannedDetails = plannedDetails;
    }

    public PlannedTraining getPlannedTraining() {
        return plannedTraining;
    }

    public void setPlannedTraining(PlannedTraining plannedTraining) {
        this.plannedTraining = plannedTraining;
    }
}
