package br.com.rpdesenvolve.rds_database_hexagonal_api.adapters.input.rest;

import br.com.rpdesenvolve.rds_database_hexagonal_api.application.service.UserService;
import br.com.rpdesenvolve.rds_database_hexagonal_api.domain.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
