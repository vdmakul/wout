package lv.vdm.wout.domain.exercise;

import lv.vdm.wout.domain.body.MuscleUtilisation;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

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
    private Set<Inventory> requiredInventories = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "exercise", fetch = FetchType.EAGER) //todo fix eager loading
    private Set<MuscleUtilisation> muscleUtilisations = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private TechnicalLevel technicalLevel;

    @Enumerated(EnumType.STRING)
    private ExerciseClass exerciseClass;

    @SuppressWarnings("unused")
    protected Exercise() {
    }

    public Exercise(String uniqueCode, TechnicalLevel technicalLevel, ExerciseClass exerciseClass) {
        this.uniqueCode = uniqueCode;
        this.name = uniqueCode;
        this.technicalLevel = technicalLevel;
        this.exerciseClass = exerciseClass;
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

    public void utilizes(MuscleUtilisation muscleUtilisation) {
        muscleUtilisation.setExercise(this);
        getMuscleUtilisations().add(muscleUtilisation);
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

    public void setRequiredInventories(Set<Inventory> requiredInventories) {
        this.requiredInventories = requiredInventories;
    }

    public Set<MuscleUtilisation> getMuscleUtilisations() {
        return muscleUtilisations;
    }

    public void setMuscleUtilisations(Set<MuscleUtilisation> muscleUtilisations) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exercise exercise = (Exercise) o;

        if (uniqueCode != null ? !uniqueCode.equals(exercise.uniqueCode) : exercise.uniqueCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return uniqueCode != null ? uniqueCode.hashCode() : 0;
    }
}
