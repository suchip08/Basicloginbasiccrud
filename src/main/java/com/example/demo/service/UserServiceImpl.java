package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    public void saveUser(User user) {
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            user.setEmail("Email not provided added by service implementaion");
        }
        repo.save(user);
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User getUserById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteUser(Long id) {
        repo.deleteById(id);
    }
}
