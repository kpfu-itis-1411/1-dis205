package org.example.service;
import org.example.model.UserForRegister;
import org.example.repository.UserRepository;

import java.util.List;

public class UserService {

    private UserRepository repository;

    public UserService() {
        repository = new UserRepository();
    }

    public UserForRegister save(UserForRegister UserForRegister) {
        return repository.save(UserForRegister);
    }

    public List<UserForRegister> findAll() {
        return repository.findAll();
    }

    public UserForRegister findById(Long id) {
        return repository.findById(id);
    }

    public UserForRegister findByLogin(String login) {
        return repository.findByLogin(login);
    }
    public UserForRegister findByEmail(String email) {
        return repository.findByEmail(email);
    }
    public UserForRegister findByPhoneNumber(String phone_number) {
        return repository.findByPhoneNumber(phone_number);
    }
}