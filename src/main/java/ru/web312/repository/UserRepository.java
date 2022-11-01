package ru.web312.repository;

import ru.web312.model.User;

import java.util.List;

public interface UserRepository {

    List<User> getAllUsers ();
    User getUserById(long id);
    void addUser(User user);
    void removeUser(long id);
    void updateUser(User user);
    User getUserByLogin(String username);
}
