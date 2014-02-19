package lv.vdm.wout.domain.exercise;

import lv.vdm.wout.domain.body.MuscleUtilisation;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Exercise {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String uniqueCode;
    private String name;
    private String description;

    @ManyToMany
    @JoinTable(name = "exercise_inventory",
            joinColumns = @JoinColumn(name = "exercise_id"),
            inverseJoinColumns = @JoinColumn(name = "inventory_id"))
    private Collection<Inventory> requiredInventories;

    //    @OneToMany(orphanRemoval = true)
//    @JoinColumn(name = "exercise_id")
    @Transient
    private Collection<MuscleUtilisation> muscleUtilisations;

    @Enumerated(EnumType.STRING)
    private TechnicalLevel technicalLevel;

    @Enumerated(EnumType.STRING)
    private ExerciseClass exerciseClass;

    protected Exercise() {
    }

    public Exercise(String uniqueCode, String name, TechnicalLevel technicalLevel, ExerciseClass exerciseClass) {
        this.uniqueCode = uniqueCode;
        this.name = name;
        this.technicalLevel = technicalLevel;
        this.exerciseClass = exerciseClass;
    }

    public void requires(Inventory inventory) {
        getRequiredInventories().add(inventory);
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

    public Collection<Inventory> getRequiredInventories() {
        return requiredInventories;
    }

    public void setRequiredInventories(Collection<Inventory> requiredInventories) {
        this.requiredInventories = requiredInventories;
    }

    public Collection<MuscleUtilisation> getMuscleUtilisations() {
        return muscleUtilisations;
    }

    public void setMuscleUtilisations(Collection<MuscleUtilisation> muscleUtilisations) {
        this.muscleUtilisations = muscleUtilisations;
    }

    public TechnicalLevel getTechnicalLevel() {
        return technicalLevel;
    }

    public void setTechnicalLevel(TechnicalLevel technicalLevel) {
        this.technicalLevel = technicalLevel;
    }

    public ExerciseClass getExerciseClass() {
        return exerciseClass;
    }

    public void setExerciseClass(ExerciseClass exerciseClass) {
        this.exerciseClass = exerciseClass;
    }
}
