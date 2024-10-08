package com.TCG.card_collection_service.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import com.TCG.card_collection_service.model.User;

@Service
public class UserIdService {

    private final WebClient webClient;

    public UserIdService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080/users").build(); // URL de votre service user
    }

    public Mono<String> getUserId(String username) {
        return webClient.get()
                .uri("/username/{username}", username)
                .retrieve()
                .bodyToMono(User.class)
                .map(User::getId);
    }
}
