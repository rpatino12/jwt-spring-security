package dev.rpatino12.jwt_demo.controller;

import dev.rpatino12.jwt_demo.model.User;
import dev.rpatino12.jwt_demo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public UserController(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @PostMapping
    public User register(@RequestBody User user) {
        User newUser = new User(user.getUsername(), encoder.encode(user.getPassword()), user.getRoles());
        return userRepository.save(newUser);
    }
}
