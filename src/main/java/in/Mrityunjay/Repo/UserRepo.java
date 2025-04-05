package in.Mrityunjay.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.Mrityunjay.Entity.User;

public interface UserRepo extends JpaRepository<User,Integer>{
    Optional<User> findByEmail(String email);
    Optional<User> findById(Integer id);
    Optional<User> findByUsername(String Username);

}
