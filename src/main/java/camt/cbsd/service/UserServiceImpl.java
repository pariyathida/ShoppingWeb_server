package camt.cbsd.service;


import camt.cbsd.dao.UserDao;
import camt.cbsd.entity.User;
import camt.cbsd.entity.security.Authority;
import camt.cbsd.entity.security.AuthorityName;
import camt.cbsd.security.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    AuthorityRepository authorityRepository;

    public User addUser(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return this.userDao.addUser(user);
    }

    public User addCustomer(User user) {
        List<Authority> authorities = new ArrayList<>();
        authorities.add(authorityRepository.findByName(AuthorityName.ROLE_CUSTOMER));
        user.setAuthorities(authorities);
        return this.addUser(user);
    }

    public User findByUsername(String username) {
        return this.userDao.findByUsername(username);
    }
}
