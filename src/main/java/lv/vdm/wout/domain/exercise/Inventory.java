package lv.vdm.wout.domain.exercise;

import lv.vdm.wout.domain.Media;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Inventory {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String uniqueCode;

    private String name;

    private String description;

    @Transient
    private Collection<Media> medias;

    @ManyToMany(mappedBy = "requiredInventories")
    private Collection<Exercise> exercises;

    protected Inventory() {
    }

    public Inventory(String uniqueCode, String name) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Media> getMedias() {
        return medias;
    }

    public void setMedias(Collection<Media> medias) {
        this.medias = medias;
    }

    public Collection<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(Collection<Exercise> exercises) {
        this.exercises = exercises;
    }
}
