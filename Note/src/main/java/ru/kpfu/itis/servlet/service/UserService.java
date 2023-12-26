package ru.kpfu.itis.servlet.service;

import ru.kpfu.itis.servlet.models.User;
import ru.kpfu.itis.servlet.repository.UserRepository;
import ru.kpfu.itis.servlet.repository.UserRepositoryImpl;


import java.util.List;
import java.util.Optional;

public class UserService {

    private  UserRepository userRepository;

    public UserService() {
        userRepository = new UserRepositoryImpl();
    }

    public void createUser(User user) {
        userRepository.saveUser(user);
    }

    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    public void deleteUserById(long id) {
        userRepository.deleteUserById(id);
    }

    public User getUserById(long id) {
        return userRepository.getUserById(id);
    }
    public void saveUser(User user) {
        userRepository.saveUser(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}
