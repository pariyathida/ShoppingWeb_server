package camt.cbsd.repository;

import camt.cbsd.entity.Account;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by pariy on 5/14/2017.
 */

public interface AccountRepository extends CrudRepository<Account,Long> {
    Account findByUsername(String username);
}
