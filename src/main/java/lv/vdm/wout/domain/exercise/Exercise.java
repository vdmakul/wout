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

}
