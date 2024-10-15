package com.TCG.user_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.TCG.user_service.model.User;
import com.TCG.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class); // LE LOGGGGGEEEEEEEEERRRRRRRR
    @Autowired
    private UserService userService;

    @GetMapping
    public Flux<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<User>> getUserById(@PathVariable("id") String id) {
        return userService.getUserById(id)
                .map(user -> ResponseEntity.ok(user))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/login/{username}/{password}")
    public Mono<ResponseEntity<User>> getUserByLogin(@PathVariable("username") String username,
            @PathVariable("password") String password) {
        logger.info("Attempting to login user with username: {}", username); // Log d'information
        return userService.getUserByLogin(username, password)
                .map(user -> ResponseEntity.ok(user))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<User> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<User>> updateUser(@PathVariable("id") String id, @RequestBody User user) {
        return userService.updateUser(id, user)
                .map(updatedUser -> ResponseEntity.ok(updatedUser))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteUser(@PathVariable("id") String id) {
        return userService.deleteUser(id)
                .map(r -> ResponseEntity.noContent().<Void>build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public Mono<ResponseEntity<Void>> deleteAllUsers() {
        return userService.deleteAllUsers()
                .then(Mono.just(ResponseEntity.noContent().<Void>build()));
    }

}
