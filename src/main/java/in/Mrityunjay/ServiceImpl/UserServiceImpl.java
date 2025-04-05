package in.Mrityunjay.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import in.Mrityunjay.Entity.User;
import in.Mrityunjay.Repo.UserRepo;
import in.Mrityunjay.Service.UserService;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service  // Marks this as a service component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo repo;

    @Transactional  
    public User saveUser(User user) {
        try {
            return repo.save(user);
        } catch (ObjectOptimisticLockingFailureException e) {
            System.out.println("Optimistic Locking Exception: " + e.getMessage());
            return null; // Or throw an exception if needed
        }
    }

        
    	 

    @Override
    public Optional<User> getUserById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    @Override
    public void deleteUser(Integer id) {
        repo.deleteById(id);
    }

	@Override
	@Transactional
	public User updateUser(User u) {
		
		// TODO Auto-generated method stub
		if(u.getId()!=null)
		{
		return  repo.save(u);
		}
		else
			{
			return null;
			}
			}

	@Override
	public Optional<User> getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return repo.findByEmail(email);
	}
}
