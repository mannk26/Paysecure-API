package in.Mrityunjay.Controller;

import in.Mrityunjay.Entity.User;
import in.Mrityunjay.Repo.UserRepo;
//import in.Meghana.Repo.SalaryRepo;
import in.Mrityunjay.Service.UserService;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")  
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepository;
//    @Autowired
//    private SalaryRepo salaryRepository;
   

    
    
    
//    // 1️⃣ Save User (with password hashing)
//    @PostMapping("/register")
//	@Transactional
//	
//
//    public ResponseEntity<User> saveUser(@RequestBody User user) {
//        	    
//    	
//
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//
//        // Save the user using the userService
//        try {
//        userService.saveUser(user);
//        }
//        catch(Exception e)
//        {
//        	System.out.println(e.getMessage());
//        }
//
//        // Return a response with status 201 (Created) and the saved user object
//        return ResponseEntity.status(HttpStatus.CREATED).body(user);
//    }

    
    
    @PostMapping("/register")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
    	System.out.println("User ID before findById: " + user.getId());
    	Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
      
    	  if (existingUser.isPresent()) { 	  
    	       

    	        return ResponseEntity.status(HttpStatus.CONFLICT).body(existingUser.get());
    	    }
    	  else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.saveUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        } 
    }

    
    
    
    
    
    

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getUser/{id}")
    public User getUserById(@PathVariable Integer id) { 
    	System.out.println("getUSer");
        return userService.getUserById(id)
            .orElseThrow(() -> new RuntimeException("User not found!"));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User updatedUser) {
    	System.out.println("ID received for lookup: " + id);

    	User existingUser = getUserById(id) ;
        if (existingUser == null) {
            throw new RuntimeException("User not found!");
        }
    	
            // Hash the new password before updating
        existingUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        existingUser.setUsername(updatedUser.getUsername());
    	existingUser.setEmail(updatedUser.getEmail());
    	//existingUser.setPassword(updatedUser.getPassword());
        return userService.updateUser(existingUser);
    
    }

  
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
    
    
}
