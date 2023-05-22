
package pe.cibertec.ecommerce.ApiAuth.service;

import java.util.List;
import pe.cibertec.ecommerce.ApiAuth.entity.Role;


public interface RoleService {
    List<Role> findAll();
    Role add(Role role);
    Role findByName(String name);
}
