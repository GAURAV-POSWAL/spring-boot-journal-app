package com.teamSpring.JournalApplication.controller;

import com.teamSpring.JournalApplication.entities.User;
import com.teamSpring.JournalApplication.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User updatedUser) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User existingUser = userService.getUserByUsername(username);
        if (existingUser != null) {
            existingUser.setUsername(!updatedUser.getUsername().isEmpty() ? updatedUser.getUsername() : existingUser.getUsername());
            existingUser.setName(!updatedUser.getName().isEmpty() ? updatedUser.getName() : existingUser.getName());
            existingUser.setPassword(!updatedUser.getPassword().isEmpty() ? updatedUser.getPassword() : existingUser.getPassword());
            userService.addUser(existingUser);
            return new ResponseEntity<>(existingUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public void deleteUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User existingUser = userService.getUserByUsername(username);
        if (existingUser != null) {
            userService.removeUserById(existingUser.getId());
        }
    }
}
