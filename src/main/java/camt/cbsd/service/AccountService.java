package camt.cbsd.service;


import camt.cbsd.entity.Account;

/**
 * Created by pariy on 5/14/2017.
 */

public interface AccountService {
   Account getAccountForTransfer(String username);
   //Account addStudent(Account account);
}
