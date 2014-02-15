package lv.vdm.wout.domain.exercise;

import lv.vdm.wout.domain.body.MuscleUtilisation;

import java.util.List;

public class Exercise {

    private String uniqueCode;
    private String name;
    private String description;
    private List<Inventory> requiredInventories;
    private List<MuscleUtilisation> muscleUtilisations;
    private TechnicalLevel technicalLevel;
    private ExerciseClass exerciseClass;

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

    public List<Inventory> getRequiredInventories() {
        return requiredInventories;
    }

    public void setRequiredInventories(List<Inventory> requiredInventories) {
        this.requiredInventories = requiredInventories;
    }

    public List<MuscleUtilisation> getMuscleUtilisations() {
        return muscleUtilisations;
    }

    public void setMuscleUtilisations(List<MuscleUtilisation> muscleUtilisations) {
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
