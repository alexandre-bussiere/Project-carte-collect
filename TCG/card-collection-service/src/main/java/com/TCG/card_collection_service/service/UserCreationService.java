package com.TCG.card_collection_service.service;

import com.TCG.card_collection_service.model.User;
import com.TCG.card_collection_service.model.UserBoosterCollection;
import com.TCG.card_collection_service.model.UserCardCollection;
import com.TCG.card_collection_service.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserCreationService {

    @Autowired
    private ExternalUserService externalUserService;
    @Autowired
    private UserRepository userRepository;

    public Mono<User> createUserWithId(String username, String password, String pseudo, int gold) {
        return externalUserService.getUserId(username, password)
                .flatMap(userId -> {
                    User user = new User(userId, username, pseudo, gold);
                    return Mono.just(userRepository.save(user)); // Save user to DB
                });
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }
}
