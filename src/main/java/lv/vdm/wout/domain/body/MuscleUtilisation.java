package lv.vdm.wout.domain.body;

public class MuscleUtilisation {
    private Muscle muscle;
    private UtilisationLevel utilisationLevel;

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
