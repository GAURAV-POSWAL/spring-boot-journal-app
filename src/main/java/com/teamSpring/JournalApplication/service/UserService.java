package com.teamSpring.JournalApplication.service;

import com.teamSpring.JournalApplication.entities.User;
import com.teamSpring.JournalApplication.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(List.of("USER"));
        repository.save(user);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public Optional<User> getUserById(ObjectId id) {
        return repository.findById(id);
    }

    public void removeUserById(ObjectId id) {
        repository.deleteById(id);
    }

    public User getUserByUsername(String username) {
        return repository.findByUsername(username);
    }
}
