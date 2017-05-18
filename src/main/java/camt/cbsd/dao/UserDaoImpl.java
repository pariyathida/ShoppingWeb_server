package camt.cbsd.dao;


import camt.cbsd.entity.User;
import camt.cbsd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    UserRepository userRepository;

    public User addUser(User user) {
        return this.userRepository.save(user);
    }

    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }
}
