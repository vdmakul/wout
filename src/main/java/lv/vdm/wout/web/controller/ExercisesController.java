package lv.vdm.wout.web.controller;

import lv.vdm.wout.domain.exercise.Exercise;
import lv.vdm.wout.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ExercisesController {

    @Autowired
    private ExerciseRepository exerciseRepo;

    @RequestMapping(value = "/exercises", method = RequestMethod.GET)
    public List<Exercise> getAllExercises() {
        List<Exercise> exercises = new ArrayList<>();
        for (Exercise exercise : exerciseRepo.findAll()) {
            exercises.add(exercise);
        }
        return exercises;
    }

    @RequestMapping(value = "/exercises/{uniqueCode}", method = RequestMethod.GET)
    public Exercise getExercise(@PathVariable String uniqueCode) {
        return exerciseRepo.findByUniqueCode(uniqueCode);
    }
}
