package lv.vdm.wout.domain.body;

import lv.vdm.wout.domain.Media;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Muscle {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String uniqueCode;

    private String name;
    @Transient
    private Collection<Media> medias; //todo

    @ManyToOne
    @JoinColumn(name = "bodypart_id", nullable = false)
    private BodyPart bodyPart;

    protected Muscle() {
    }

    public Muscle(String uniqueCode, String name) {
        this.uniqueCode = uniqueCode;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode(String uniqueCode) {
        this.uniqueCode = uniqueCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Media> getMedias() {
        return medias;
    }

    public void setMedias(Collection<Media> medias) {
        this.medias = medias;
    }

    public BodyPart getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(BodyPart bodyPart) {
        this.bodyPart = bodyPart;
    }
}
