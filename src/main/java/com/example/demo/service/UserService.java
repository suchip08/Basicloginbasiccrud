package com.example.demo.service; // Package declaration
 
import java.util.List; // Import List
import org.springframework.beans.factory.annotation.Autowired; // Import Autowired
import org.springframework.stereotype.Service; // Import Service annotation
import com.example.demo.model.User; // Import User model
import com.example.demo.repository.UserRepository; // Import UserRepository
 
@Service // Marks this class as a Service component
public class UserService {
 
    @Autowired // Injects UserRepository
    private UserRepository repo;
 
    public User saveUser(User user) {
        // Business logic: Set default values if missing
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            user.setEmail("Email not provided added by service implementaion");
        }
        if (user.getPanNo() == null || user.getPanNo().isBlank()) {
            user.setPanNo("not given");
        }
        if (user.getPhone() == null || user.getPhone().isBlank()) {
            user.setPhone("Not provided");
        }
        return repo.save(user); // Save user to DB
    }
 
    public List<User> getAllUsers() {
        return repo.findAll(); // Get all users
    }

    public User getUserById(Long id) {
        return repo.findById(id).orElse(null); // Get user by ID
    }

    public void deleteUser(Long id) {
        repo.deleteById(id); // Delete user
    }
}
