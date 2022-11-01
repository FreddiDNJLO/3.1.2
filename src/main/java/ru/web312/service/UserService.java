package ru.web312.service;

import ru.web312.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers ();
    User getUserById(long id);
    void addUser(User user, List<Long> roles);
    void removeUser(long id);
    void updateUser(User user);
    User getUserByLogin(String username);
    User passwordCoder(User user);
}
