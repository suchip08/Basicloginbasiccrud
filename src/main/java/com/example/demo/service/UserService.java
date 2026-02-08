package com.example.demo.service;
 
 import java.util.List;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;
 import com.example.demo.model.User;
 import com.example.demo.repository.UserRepository;
 
 @Service
 public class UserService {
 
     @Autowired
     private UserRepository repo;
 
     public void saveUser(User user) {
         if (user.getEmail() == null || user.getEmail().isBlank()) {
             user.setEmail("Email not provided added by service implementaion");
         }
         if (user.getPanNo() == null || user.getPanNo().isBlank()) {
             user.setPanNo("not given");
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
 
     public org.springframework.data.domain.Page<User> findPaged(String q, int page, int size) {
        org.springframework.data.domain.Pageable pageable = org.springframework.data.domain.PageRequest.of(page, size);
        if (q != null && !q.trim().isEmpty()) {
            return repo.findByNameContainingIgnoreCase(q.trim(), pageable);
        }
        return repo.findAll(pageable);
    }
    
    public long getInvalidNameCount() {
        return repo.countUsersWhoseNameContainsNumberOrSpecial();
    }
}
