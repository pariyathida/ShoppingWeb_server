package camt.cbsd.dao;


import camt.cbsd.entity.Account;
import camt.cbsd.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by pariy on 5/14/2017.
 */

@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    AccountRepository accountRepository;

   @Autowired
   public void setAccountRepository(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
   }

    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }
}
