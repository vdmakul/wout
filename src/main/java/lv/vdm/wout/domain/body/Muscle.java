package lv.vdm.wout.domain.body;

import lv.vdm.wout.domain.Media;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Muscle {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String uniqueCode;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER) //todo howto remove eager and keep test working?
    @JoinTable(name = "muscle_media",
            joinColumns = @JoinColumn(name = "muscle_id"),
            inverseJoinColumns = @JoinColumn(name = "media_id"))
    private Set<Media> medias = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "bodypart_id", nullable = false)
    private BodyPart bodyPart;

    @SuppressWarnings("unused")
    protected Muscle() {
    }

    public Muscle(String uniqueCode, BodyPart bodyPart) {
        this(uniqueCode, uniqueCode, bodyPart);
    }

    public Muscle(String uniqueCode, String name, BodyPart bodyPart) {
        this.uniqueCode = uniqueCode;
        this.name = name;
        this.bodyPart = bodyPart;
    }

    public void link(Media media) {
        getMedias().add(media);
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

    public Set<Media> getMedias() {
        return medias;
    }

    public void setMedias(Set<Media> medias) {
        this.medias = medias;
    }

    public BodyPart getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(BodyPart bodyPart) {
        this.bodyPart = bodyPart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Muscle muscle = (Muscle) o;

        if (uniqueCode != null ? !uniqueCode.equals(muscle.uniqueCode) : muscle.uniqueCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return uniqueCode != null ? uniqueCode.hashCode() : 0;
    }
}
