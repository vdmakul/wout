package lv.vdm.wout.domain.body;

import lv.vdm.wout.domain.exercise.Exercise;

import javax.persistence.*;

@Entity
public class MuscleUtilisation {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "muscle_id", nullable = false)
    private Muscle muscle;

    @ManyToOne
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @Enumerated(EnumType.STRING)
    private UtilisationLevel utilisationLevel;

    @SuppressWarnings("unused")
    protected MuscleUtilisation() {
    }

    public MuscleUtilisation(Muscle muscle, UtilisationLevel utilisationLevel) {
        this.muscle = muscle;
        this.utilisationLevel = utilisationLevel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Muscle getMuscle() {
        return muscle;
    }

    public void setMuscle(Muscle muscle) {
        this.muscle = muscle;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public UtilisationLevel getUtilisationLevel() {
        return utilisationLevel;
    }

    public void setUtilisationLevel(UtilisationLevel utilisationLevel) {
        this.utilisationLevel = utilisationLevel;
    }
}
