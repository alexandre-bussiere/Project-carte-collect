package com.TCG.card_collection_service.service;

import com.example.lib.CardExchangeRequest;
import com.example.lib.CardExchangeResponse;
import com.example.lib.CardServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

@Service
public class GrpcClientService {

    private final CardServiceGrpc.CardServiceBlockingStub grpcServiceStub;

    public GrpcClientService() {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 9090) // Adresse et port de votre service gRPC
                .usePlaintext()
                .build();

        this.grpcServiceStub = CardServiceGrpc.newBlockingStub(channel);
    }

    public String callCardExchange(String idDeJoueur, String idDeCarte) {
        // Construire la requête gRPC
        CardExchangeRequest request = CardExchangeRequest.newBuilder()
                .setIdDeJoueur(idDeJoueur)
                .setIdDeCarte(idDeCarte)
                .build();

        // Appeler le service gRPC et récupérer la réponse
        CardExchangeResponse response = grpcServiceStub.cardExchange(request);

        return response.getMessage(); // Retourne le message de confirmation ou d'erreur
    }
}
