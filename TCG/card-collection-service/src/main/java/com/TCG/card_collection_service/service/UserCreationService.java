package com.TCG.card_collection_service.service;

import com.TCG.card_collection_service.model.User;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserCreationService {

    private final UserIdService userIdService;

    public UserCreationService(UserIdService userIdService) {
        this.userIdService = userIdService;
    }

    public Mono<User> createUserWithId(String username, String pseudo, int gold) {
        return userIdService.getUserId(username)
                .map(userId -> new User(userId, username, pseudo, gold));
    }
}
