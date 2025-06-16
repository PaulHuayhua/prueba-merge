package pe.edu.vallegrande.inventaStore.rest;

import pe.edu.vallegrande.inventaStore.model.User;
import pe.edu.vallegrande.inventaStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/api/user")
public class UserRest {

    private final UserService userService;

    @Autowired
    public UserRest(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{identifier}")
    public Optional<User> findById(@PathVariable Long identifier) {
        return userService.findById(identifier);
    }

    @GetMapping("/state/{state}")
    public List<User> findByState(@PathVariable Boolean state) {
        return userService.findByState(state);
    }

    @PostMapping("/save")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/update")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @PutMapping("/delete/{identifier}")
    public Optional<User> softDelete(@PathVariable Long identifier) {
        return userService.softDelete(identifier);
    }

    @PutMapping("/restore/{identifier}")
    public Optional<User> restore(@PathVariable Long identifier) {
        return userService.restore(identifier);
    }
}

