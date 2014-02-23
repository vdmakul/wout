package lv.vdm.wout.repository;

import lv.vdm.wout.domain.training.planned.PlannedTraining;
import org.springframework.data.repository.CrudRepository;

public interface PlannedTrainingRepository extends CrudRepository<PlannedTraining, Long> {
}
