package com.example.demo.service;

import java.util.List;
import com.example.demo.model.User;

public interface UserService {
    void saveUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    void deleteUser(Long id);
}
