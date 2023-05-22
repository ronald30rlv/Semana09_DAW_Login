
package pe.cibertec.ecommerce.ApiAuth.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.ecommerce.ApiAuth.dto.SignUpDto;
import pe.cibertec.ecommerce.ApiAuth.entity.User;
import pe.cibertec.ecommerce.ApiAuth.service.UserService;


@RestController
@RequestMapping("/api/Auth")
public class AuthController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private AuthenticationManager authManager;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @GetMapping("/hello")
    public ResponseEntity<String> Hello(){
        return new ResponseEntity<>("Hello world",HttpStatus.OK);
    }
    
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto){
        //mapper
        User user = new User();
        user.setName(signUpDto.getName());
        user.setUserName(signUpDto.getUserName());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        user.setRoles(signUpDto.getRoles());
        
        var result=userService.add(user);
        return new ResponseEntity<>(result,HttpStatus.CREATED);    
        
    }
    
    
    
    
}
