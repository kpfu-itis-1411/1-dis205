package ru.kpfu.itis.servlet.repository;
import ru.kpfu.itis.servlet.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> getAllUsers();

    User getUserById(long id);

    public Optional<User> getUserByUsername(String username);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(long id);
}


