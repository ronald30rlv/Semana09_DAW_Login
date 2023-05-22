
package pe.cibertec.ecommerce.ApiAuth.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.ecommerce.ApiAuth.entity.Role;
import pe.cibertec.ecommerce.ApiAuth.service.RoleService;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    
    @GetMapping("/findAll")
    public ResponseEntity<List<Role>> findAll(){
        return new ResponseEntity<>(roleService.findAll(),HttpStatus.OK);
    }
    
    @GetMapping("/findByName/{name}")
    public ResponseEntity<Role> findByName(@PathVariable String name){
        return new ResponseEntity<>(roleService.findByName(name),HttpStatus.OK);
    }
    
     
    @PostMapping("/add")
    public ResponseEntity<Role> add(@RequestBody Role role){
        return new ResponseEntity<>(roleService.add(role),HttpStatus.CREATED);
    }
    
}
