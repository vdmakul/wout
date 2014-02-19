package lv.vdm.wout.repository;

import lv.vdm.wout.domain.body.Muscle;
import lv.vdm.wout.domain.body.MuscleUtilisation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MuscleUtilisationRepository extends CrudRepository<MuscleUtilisation, Long> {

    List<MuscleUtilisation> findByMuscle(Muscle muscle);

    List<MuscleUtilisation> findByMuscleUniqueCode(String uniqueCode);
}
