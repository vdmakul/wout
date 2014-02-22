package lv.vdm.wout.domain.training;

import lv.vdm.wout.domain.Difficulty;
import lv.vdm.wout.domain.exercise.Exercise;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Workout {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workout", fetch = FetchType.EAGER) //todo fix eager
    private Set<ExerciseDetails> exerciseDetails = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @ManyToOne
    @JoinColumn(name = "training_id", nullable = false)
    private Training training;

    @SuppressWarnings("unused")
    protected Workout() {
    }

    public Workout(Exercise exercise) {
        assert exercise != null;
        this.exercise = exercise;
    }

    public void with(ExerciseDetails details) {
        details.setWorkout(this);
        getExerciseDetails().add(details);
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

    public Set<ExerciseDetails> getExerciseDetails() {
        return exerciseDetails;
    }

    public void setExerciseDetails(Set<ExerciseDetails> exerciseDetails) {
        this.exerciseDetails = exerciseDetails;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }
}
