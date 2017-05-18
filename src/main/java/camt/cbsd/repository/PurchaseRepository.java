package camt.cbsd.repository;

import camt.cbsd.entity.Purchase;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by pariy on 5/18/2017.
 */
public interface PurchaseRepository extends CrudRepository<Purchase, Long> {
}
