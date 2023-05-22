package pe.cibertec.ecommerce.ApiAuth.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.ecommerce.ApiAuth.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Long>  {
    Optional<Role> findByName(String name);
    
}

