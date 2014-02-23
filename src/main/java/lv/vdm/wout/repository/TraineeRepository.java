package lv.vdm.wout.repository;

import lv.vdm.wout.domain.person.Trainee;
import org.springframework.data.repository.CrudRepository;

public interface TraineeRepository extends CrudRepository<Trainee, String> {
}
