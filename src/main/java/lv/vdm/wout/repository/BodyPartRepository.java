package lv.vdm.wout.repository;

import lv.vdm.wout.domain.body.BodyPart;
import org.springframework.data.repository.CrudRepository;

public interface BodyPartRepository extends CrudRepository<BodyPart, Long> {

    BodyPart findByUniqueCode(String uniqueCode);

}