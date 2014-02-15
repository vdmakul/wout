package lv.vdm.wout.domain.body;

import java.util.List;

public class BodyPart {

    private String name;
    private BodyPart placement;
    private List<Muscle> muscles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BodyPart getPlacement() {
        return placement;
    }

    public void setPlacement(BodyPart placement) {
        this.placement = placement;
    }

    public List<Muscle> getMuscles() {
        return muscles;
    }

    public void setMuscles(List<Muscle> muscles) {
        this.muscles = muscles;
    }
}
