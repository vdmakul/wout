package lv.vdm.wout.repository;

import lv.vdm.wout.domain.person.Trainer;
import org.springframework.data.repository.CrudRepository;

public interface TrainerRepository extends CrudRepository<Trainer, String> {
}
