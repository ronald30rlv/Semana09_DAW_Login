package pe.cibertec.ecommerce.ApiAuth.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.ecommerce.ApiAuth.entity.User;


public interface UserRepository extends JpaRepository<User, Long> { 
    Optional<User>  findByEmail(String email);
    Optional<User> findByUserName(String username);
    Optional<User> findByUserNameOrEmail(String username,String email);
    Optional<Boolean> existsByEmail(String email);
    Optional<Boolean> existsByUserName(String username);
}
