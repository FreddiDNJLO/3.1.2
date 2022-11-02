package ru.web312.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.web312.model.User;
import ru.web312.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImp(UserRepository userRepository, RoleService roleService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    @Transactional
    public User passwordCoder(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.getUserById(id);
    }

    @Override
    @Transactional
    public void addUser(User user, List<Long> roles) {
        user.setRoles(roleService.findByIdRoles(roles));
        userRepository.addUser(passwordCoder(user));
    }

    @Override
    @Transactional
    public void removeUser(long id) {
        userRepository.removeUser(id);
    }

    @Override
    @Transactional
    public void updateUser(User user, List<Long> roles) {
        user.setRoles(roleService.findByIdRoles(roles));
        userRepository.updateUser(passwordCoder(user));
    }

    @Override
    public User getUserByLogin(String username) {
        return userRepository.getUserByLogin(username);
    }
}
