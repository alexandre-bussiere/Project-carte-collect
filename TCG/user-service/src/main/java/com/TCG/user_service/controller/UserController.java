package com.TCG.user_service.controller;

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

    @Autowired
    private UserService userService;

    // Récupérer tous les utilisateurs (Flux est utilisé pour renvoyer un flux de
    // données réactif)
    @GetMapping
    public Flux<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Récupérer un utilisateur par ID (Mono est utilisé pour renvoyer un seul
    // élément réactif)
    @GetMapping("/{id}")
    public Mono<ResponseEntity<User>> getUserById(@PathVariable String id) {
        return userService.getUserById(id)
                .map(user -> ResponseEntity.ok(user))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    // Créer un utilisateur (Mono pour un seul utilisateur)
    @PostMapping
    public Mono<User> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // Mettre à jour un utilisateur par ID (Mono)
    @PutMapping("/{id}")
    public Mono<ResponseEntity<User>> updateUser(@PathVariable String id, @RequestBody User user) {
        return userService.updateUser(id, user)
                .map(updatedUser -> ResponseEntity.ok(updatedUser))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    // Supprimer un utilisateur par ID (Mono pour indiquer une action)
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteUser(@PathVariable String id) {
        return userService.deleteUser(id)
                .map(r -> ResponseEntity.noContent().<Void>build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    // Supprimer tous les utilisateurs
    @DeleteMapping
    public Mono<ResponseEntity<Void>> deleteAllUsers() {
        return userService.deleteAllUsers()
                .then(Mono.just(ResponseEntity.noContent().<Void>build()));
    }

}
