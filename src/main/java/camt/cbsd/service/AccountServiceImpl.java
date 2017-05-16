package camt.cbsd.service;

import camt.cbsd.dao.AccountDao;
import camt.cbsd.entity.Account;
import camt.cbsd.entity.security.Authority;
import camt.cbsd.entity.security.AuthorityName;
import camt.cbsd.security.repository.AuthorityRepository;
import camt.cbsd.security.repository.UserRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by pariy on 5/14/2017.
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDao accountDao;

    @Autowired
    public void setAccountDao(AccountDao accountDao){
        this.accountDao = accountDao;
    }

    @Transactional
    @Override
    public Account getAccountForTransfer(String username) {
        Account account = accountDao.findByUsername(username);
        Hibernate.initialize(account.getAuthorities());
        return account;
    }

    @Autowired
    AuthorityRepository authorityRepository;

    @Autowired
    UserRepository userRepository;

//    @Override
//    public Account addStudent(Account account) {
//        Authority authority;
//        if (account.getRole().equals("Admin")){
//            authority =
//                    authorityRepository.findByName(AuthorityName.ROLE_ADMIN);
//        }else if (account.getRole().equals("Shopkeeper")){
//            authority =
//                    authorityRepository.findByName(AuthorityName.ROLE_SHOPKEEPER);
//        }else{
//            authority =
//                    authorityRepository.findByName(AuthorityName.ROLE_CUSTOMER);
//        }
//        return null;
//    }
}
