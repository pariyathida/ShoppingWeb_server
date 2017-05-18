package camt.cbsd.service;


import camt.cbsd.entity.User;

public interface UserService {
    User addUser(User user);
    User addCustomer(User user);
    User findByUsername(String username);
}
