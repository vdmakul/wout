package lv.vdm.wout.repository;

import lv.vdm.wout.domain.training.Workout;
import org.springframework.data.repository.CrudRepository;

public interface WorkoutRepository extends CrudRepository<Workout, Long> {
}
