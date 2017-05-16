package camt.cbsd.dao;


import camt.cbsd.entity.Account;

/**
 * Created by pariy on 5/14/2017.
 */

public interface AccountDao {
   Account findByUsername(String username);
}
