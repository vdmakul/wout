package lv.vdm.wout.domain.body;

import java.util.List;

public class Muscle {
    private String name;
    private List<Muscle> medias;
    private BodyPart bodyPart;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Muscle> getMedias() {
        return medias;
    }

    public void setMedias(List<Muscle> medias) {
        this.medias = medias;
    }

    public BodyPart getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(BodyPart bodyPart) {
        this.bodyPart = bodyPart;
    }
}
