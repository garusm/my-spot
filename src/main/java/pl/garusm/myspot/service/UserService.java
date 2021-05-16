package pl.garusm.myspot.service;

import pl.garusm.myspot.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getUsers();
    void addUser(User user);
    Optional<User> getUser(Long id);
    void deleteUser(Long id);
    void updateUser(User user);
    User findByEmail(String email);
    Optional<User> findByUserName(String userName);

}
