
package pe.cibertec.ecommerce.ApiAuth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    
    //Sobreescribe el comportamiento por default (validar con el usuario user)
    //para validar contra mis usuarios de la BD de Mysql
    @Autowired
    private UserDetailsService userDetailsService;
    
    //Sobreescribe el comportamiento por default (password no encriptado)
    //se usara el algoritmo de encriptacion BCrypt
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    //sobreescribir para obtener el AuthenticationManager
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();  
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
         http.csrf().disable()
                .authorizeHttpRequests((authorize) ->
                    authorize.requestMatchers("/api/auth/**").permitAll()
                     .anyRequest().permitAll()
                );
        
         return http.build();
    }
    
}
