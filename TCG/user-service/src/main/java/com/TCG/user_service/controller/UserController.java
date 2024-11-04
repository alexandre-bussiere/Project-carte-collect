package com.TCG.user_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.TCG.user_service.model.User;
import com.TCG.user_service.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
@Tag(name = "User Controller", description = "Manage users in the system")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    // Récupérer tous les utilisateurs
    @GetMapping
    @Operation(summary = "Get all users", description = "Retrieve a list of all users.")
    public Flux<User> getAllUsers() {
        logger.info("Fetching all users");
        return userService.getAllUsers();
    }

    // Récupérer un utilisateur par ID
    @GetMapping("/{id}")
    @Operation(summary = "Get user by ID", description = "Retrieve a user by their ID.")
    public Mono<ResponseEntity<User>> getUserById(@PathVariable("id") String id) {
        logger.info("Fetching user with ID: {}", id);
        return userService.getUserById(id)
                .map(user -> ResponseEntity.ok(user))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    // Connexion utilisateur par identifiant et mot de passe
    @GetMapping("/login/{username}/{password}")
    @Operation(summary = "Login user", description = "Authenticate a user by username and password.")
    public Mono<ResponseEntity<User>> getUserByLogin(@PathVariable("username") String username,
            @PathVariable("password") String password) {
        logger.info("Attempting to login user with username: {}", username);
        return userService.getUserByLogin(username, password)
                .map(user -> ResponseEntity.ok(user))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    // Créer un nouvel utilisateur
    @PostMapping
    @Operation(summary = "Create a new user", description = "Create a new user in the system.")
    public Mono<User> createUser(@RequestBody User user) {
        logger.info("Creating new user: {}", user);
        return userService.createUser(user);
    }

    // Mettre à jour un utilisateur existant par ID
    @PutMapping("/{id}")
    @Operation(summary = "Update user by ID", description = "Update an existing user by their ID.")
    public Mono<ResponseEntity<User>> updateUser(@PathVariable("id") String id, @RequestBody User user) {
        logger.info("Updating user with ID: {}", id);
        return userService.updateUser(id, user)
                .map(updatedUser -> ResponseEntity.ok(updatedUser))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    // Supprimer un utilisateur par ID
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user by ID", description = "Delete a user by their ID.")
    public Mono<ResponseEntity<Void>> deleteUser(@PathVariable("id") String id) {
        logger.info("Deleting user with ID: {}", id);
        return userService.deleteUser(id)
                .map(r -> ResponseEntity.noContent().<Void>build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    // Supprimer tous les utilisateurs
    @DeleteMapping
    @Operation(summary = "Delete all users", description = "Delete all users from the system.")
    public Mono<ResponseEntity<Void>> deleteAllUsers() {
        logger.info("Deleting all users");
        return userService.deleteAllUsers()
                .then(Mono.just(ResponseEntity.noContent().<Void>build()));
    }
}
