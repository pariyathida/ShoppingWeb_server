package camt.cbsd.dao;


import camt.cbsd.entity.User;

public interface UserDao {
    User addUser(User user);
    User findByUsername(String username);
}
