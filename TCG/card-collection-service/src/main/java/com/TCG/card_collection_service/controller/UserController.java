package com.TCG.card_collection_service.controller;

import com.TCG.card_collection_service.service.UserCreationService;
import com.TCG.card_collection_service.model.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/TCG/users")
@Tag(name = "User Controller", description = "Manage users in the card collection service")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserCreationService userCreationService;

    // Récupérer tous les utilisateurs
    @GetMapping
    @Operation(summary = "Get all users", description = "Retrieve a list of all users.")
    public List<User> getAllUsers() {
        logger.info("Fetching all users");
        return userCreationService.getAllUsers();
    }

    // Créer un utilisateur avec des paramètres spécifiques
    @PostMapping("/create/{username}/{password}/{pseudo}/{gold}")
    @Operation(summary = "Create user with specified attributes", description = "Create a new user with a username, password, pseudo, and gold amount.")
    public Mono<ResponseEntity<User>> createUserWithId(@PathVariable("username") String username,
            @PathVariable("password") String password, @PathVariable("pseudo") String pseudo,
            @PathVariable("gold") int gold) {
        logger.info("Creating user with username: {}, pseudo: {}, and gold: {}", username, pseudo, gold);
        return userCreationService.createUserWithId(username, password, pseudo, gold)
                .map(user -> ResponseEntity.ok(user));
    }
}
