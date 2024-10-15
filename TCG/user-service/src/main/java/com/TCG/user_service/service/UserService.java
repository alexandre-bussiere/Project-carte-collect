package com.TCG.user_service.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.TCG.user_service.model.User;
import com.TCG.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;

    public Flux<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Mono<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    public Mono<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Mono<User> getUserByLogin(String username, String password) {
        User user = userRepository.findByUsername(username).block(); // will block until the user is fetched
        logger.info("User: {}", user);
        if (user != null && user.getPassword().equals(password)) { // check if the user exists and the password correct
            return Mono.just(user);
        } else {
            return Mono.empty();
        }
    }

    public Mono<User> createUser(User user) {
        return userRepository.save(user);
    }

    public Mono<User> updateUser(String id, User updatedUser) {
        return userRepository.findById(id)
                .flatMap(existingUser -> {
                    existingUser.setUsername(updatedUser.getUsername());
                    existingUser.setEmail(updatedUser.getEmail());
                    return userRepository.save(existingUser);
                });
    }

    public Mono<Void> deleteUser(String id) {
        return userRepository.deleteById(id);
    }

    public Mono<Void> deleteAllUsers() {
        return userRepository.deleteAll();
    }

}
