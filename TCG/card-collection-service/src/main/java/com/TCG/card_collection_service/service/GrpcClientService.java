package com.TCG.card_collection_service.service;

import com.example.lib.CardExchangeRequest;
import com.example.lib.CardExchangeResponse;
import com.example.lib.CardServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class GrpcClientService {

    private final CardServiceGrpc.CardServiceBlockingStub grpcServiceStub;

    public GrpcClientService() {

        Logger logger = LoggerFactory.getLogger(GrpcClientService.class);
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 9090) // Adresse et port de votre service gRPC
                .usePlaintext()
                .build();
        logger.info("gRPC channel created successfully");
        this.grpcServiceStub = CardServiceGrpc.newBlockingStub(channel);

    }

    public String callCardExchange(String idDeJoueur, String idDeCarte) {
        Logger logger = LoggerFactory.getLogger(GrpcClientService.class);
        // Construire la requête gRPC
        logger.info("Preparing to call gRPC method 'cardExchange' with idDeJoueur={} and idDeCarte={}", idDeJoueur,
                idDeCarte);
        // CardExchangeRequest request = CardExchangeRequest.newBuilder()
        // .setIdDeJoueur(idDeJoueur)
        // .setIdDeCarte(idDeCarte)
        // .build();
        // CardExchangeResponse response = grpcServiceStub.cardExchange(request);
        String responses = "Success: true, Message: Card exchange successful"; // POUR TESTER NE PAS OUBLIER DE RETABLIR
                                                                               // SE FICHIER POUR L'APPELLE
        return responses;
    }
}
