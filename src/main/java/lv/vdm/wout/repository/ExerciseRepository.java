package lv.vdm.wout.repository;

import lv.vdm.wout.domain.exercise.Exercise;
import org.springframework.data.repository.CrudRepository;

public interface ExerciseRepository extends CrudRepository<Exercise, Long> {

    Exercise findByUniqueCode(String uniqueCode);
}
