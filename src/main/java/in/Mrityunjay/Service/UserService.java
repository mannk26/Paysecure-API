package in.Mrityunjay.Service;
import java.util.List;
import java.util.Optional;

import in.Mrityunjay.Entity.User;

public interface UserService {
	 User saveUser(User user); 
	    Optional<User> getUserById(Integer id); 
	    List<User> getAllUsers(); 
	    void deleteUser(Integer id); 
	    User updateUser(User u);
		Optional<User> getUserByEmail(String email);
}
