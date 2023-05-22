
package pe.cibertec.ecommerce.ApiAuth.service;

import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.cibertec.ecommerce.ApiAuth.dao.UserRepository;
import pe.cibertec.ecommerce.ApiAuth.entity.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        /*validamos que el usuario exista en mi BD Mysql*/
        User user = userRepository.findByUserNameOrEmail(username, username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
        
        /*Obtenemos los roles que le pertenecen al usuario*/
        Set<GrantedAuthority> authorities= user.getRoles()
                .stream()
                .map((role)->new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());
        /* Devuelvo el objeto UserDetails de springSecurity*/
        return new org.springframework.security.core.userdetails.User
        (user.getUserName(),user.getPassword(),authorities);    
    }
    
}
