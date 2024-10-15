package com.TCG.card_collection_service.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import com.TCG.card_collection_service.model.User;

@Service
public class ExternalUserService {

    private WebClient webClient;

    public ExternalUserService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8081")
                .build();
    }

    public Mono<String> getUserId(String username, String password) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/users/login/{username}/{password}")
                        .build(username, password))
                .retrieve()
                .onStatus(status -> status.is4xxClientError(),
                        clientResponse -> Mono
                                .error(new RuntimeException("Client error: Invalid credentials or user not found")))
                .bodyToMono(User.class)
                .flatMap(user -> {
                    if (user != null && user.getId() != null) {
                        return Mono.just(user.getId());
                    } else {
                        return Mono.empty();
                    }
                })
                .switchIfEmpty(Mono.error(new RuntimeException("User not found or invalid credentials")));
    }

}
