package lv.vdm.wout.repository;

import lv.vdm.wout.domain.training.Training;
import org.springframework.data.repository.CrudRepository;

public interface TrainingRepository extends CrudRepository<Training, Long> {
}
