package pulson.java_generally.cors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:63342")//zezwolenie na przetwarzanie requestów wysyłanych przez przeglądarkę
//resources/static/testCors.html
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
        userService.saveAll();
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getById(id));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        return ResponseEntity.ok(userService.deleteById(id));
    }
}
