package lv.vdm.wout.domain.body;

import javax.persistence.*;

@Entity
public class MuscleUtilisation {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "muscle_id", nullable = false)
    private Muscle muscle;

    @Enumerated(EnumType.STRING)
    private UtilisationLevel utilisationLevel;

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

    public UtilisationLevel getUtilisationLevel() {
        return utilisationLevel;
    }

    public void setUtilisationLevel(UtilisationLevel utilisationLevel) {
        this.utilisationLevel = utilisationLevel;
    }
}
