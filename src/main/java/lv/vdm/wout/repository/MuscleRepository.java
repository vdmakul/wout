package lv.vdm.wout.repository;

import lv.vdm.wout.domain.body.Muscle;
import org.springframework.data.repository.CrudRepository;

public interface MuscleRepository extends CrudRepository<Muscle, Long> {

    Muscle findByUniqueCode(String uniqueCode);
}