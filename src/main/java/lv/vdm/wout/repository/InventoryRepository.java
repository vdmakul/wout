package lv.vdm.wout.repository;

import lv.vdm.wout.domain.exercise.Inventory;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<Inventory, Long> {

    Inventory findByUniqueCode(String uniqueCode);
}
