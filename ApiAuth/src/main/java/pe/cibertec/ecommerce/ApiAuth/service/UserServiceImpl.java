
package pe.cibertec.ecommerce.ApiAuth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.ecommerce.ApiAuth.dao.UserRepository;
import pe.cibertec.ecommerce.ApiAuth.entity.User;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).get();
    }

    @Override
    public User findByUserName(String username) {
        
        return userRepository.findByUserName(username).get();
    }

    @Override
    public User findByUserNameOrEmail(String username, String email) {
        return userRepository.findByUserNameOrEmail(username,email).get();
    }

    @Override
    public Boolean existsByEmail(String email) {
        
        return userRepository.existsByEmail(email).get();
    }

    @Override
    public Boolean existsByUserName(String username) {
        return userRepository.existsByUserName(username).get();
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }
    
}
