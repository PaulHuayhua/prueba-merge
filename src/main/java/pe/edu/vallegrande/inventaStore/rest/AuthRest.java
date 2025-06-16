package pe.edu.vallegrande.inventaStore.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.inventaStore.model.User;
import pe.edu.vallegrande.inventaStore.service.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/api/auth")
public class AuthRest {

    private final UserService userService;

    @Autowired
    public AuthRest(UserService userService) {
        this.userService = userService;
    }

    // ✅ Iniciar sesión (login)
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String name = credentials.get("name");
        String password = credentials.get("password");

        Optional<User> userOpt = userService.findByName(name);

        if (userOpt.isPresent()) {
            User user = userOpt.get();

            if (user.getPassword_hash().equals(password)) {
                Map<String, String> response = new HashMap<>();
                response.put("name", user.getName());
                response.put("rol", user.getRol());
                response.put("token", "fake-jwt-token");
                return ResponseEntity.ok(response);
            }
        }

        return ResponseEntity.status(401).body("Credenciales inválidas");
    }
}
