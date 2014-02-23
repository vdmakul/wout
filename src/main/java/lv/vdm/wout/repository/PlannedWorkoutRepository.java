package lv.vdm.wout.repository;

import lv.vdm.wout.domain.training.planned.PlannedWorkout;
import org.springframework.data.repository.CrudRepository;

public interface PlannedWorkoutRepository extends CrudRepository<PlannedWorkout, Long> {
}
