
package pe.cibertec.ecommerce.ApiAuth.service;

import pe.cibertec.ecommerce.ApiAuth.entity.User;


public interface UserService {
    User  findByEmail(String email);
    User findByUserName(String username);
    User findByUserNameOrEmail(String username,String email);
    Boolean existsByEmail(String email);
    Boolean existsByUserName(String username);
    User add(User user);  
}
