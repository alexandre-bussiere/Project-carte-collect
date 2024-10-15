package com.TCG.card_collection_service.controller;

import com.TCG.card_collection_service.service.UserCreationService;

import reactor.core.publisher.Mono;

import com.TCG.card_collection_service.model.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/TCG/users")
public class UserController {

    @Autowired
    private UserCreationService userCreationService;

    @GetMapping
    public List<User> getAllUsers() {
        return userCreationService.getAllUsers();
    }

    @PostMapping("/create/{username}/{password}/{pseudo}/{gold}")
    public Mono<ResponseEntity<User>> createUserWithId(@PathVariable("username") String username,
            @PathVariable("password") String password, @PathVariable("pseudo") String pseudo,
            @PathVariable("gold") int gold) {
        return userCreationService.createUserWithId(username, password, pseudo, gold)
                .map(user -> ResponseEntity.ok(user));
    }

}
