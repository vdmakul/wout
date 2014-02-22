package lv.vdm.wout.domain.exercise;

import lv.vdm.wout.domain.Media;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Inventory {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String uniqueCode;

    private String name;

    private String description;

    @ManyToMany(fetch = FetchType.EAGER) //todo howto remove eager and keep test working?
    @JoinTable(name = "inventory_media",
            joinColumns = @JoinColumn(name = "inventory_id"),
            inverseJoinColumns = @JoinColumn(name = "media_id"))
    private Set<Media> medias = new HashSet<>();

    @ManyToMany(mappedBy = "requiredInventories")
    private Set<Exercise> exercises = new HashSet<>();

    @SuppressWarnings("unused")
    protected Inventory() {
    }

    public Inventory(String uniqueCode, String name) {
        this.uniqueCode = uniqueCode;
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Media> getMedias() {
        return medias;
    }

    public void setMedias(Set<Media> medias) {
        this.medias = medias;
    }

    public Set<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(Set<Exercise> exercises) {
        this.exercises = exercises;
    }
}
