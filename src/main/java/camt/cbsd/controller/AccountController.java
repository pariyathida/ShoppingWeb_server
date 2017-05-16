package camt.cbsd.controller;

import camt.cbsd.entity.Account;
import camt.cbsd.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by pariy on 5/14/2017.
 */

public class AccountController {
    AccountService accountService;

    @Autowired
    public void setAccountService(AccountService accountService){
        this.accountService = accountService;
    }

//    @PostMapping("/accountAuthen")
//    public Account uploadStudentAuthen(@RequestBody Account user) {
//
//        Account account = accountService.addStudent(user);
//        return account;
//
//    }

}

