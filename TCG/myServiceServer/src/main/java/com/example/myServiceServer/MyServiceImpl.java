package com.example.myServiceServer;

import com.example.lib.CardExchangeRequest;
import com.example.lib.CardExchangeResponse;
import com.example.lib.CardServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class MyServiceImpl extends CardServiceGrpc.CardServiceImplBase {

    Logger logger = LoggerFactory.getLogger(MyServiceImpl.class);

    @Override
    public void cardExchange(CardExchangeRequest request, StreamObserver<CardExchangeResponse> responseObserver) {
        // Logique de traitement de la requête
        String idDeJoueur = request.getIdDeJoueur();
        String idDeCarte = request.getIdDeCarte();

        // Logique simplifiée pour l'échange de carte (à adapter selon les besoins
        // réels)
        boolean success = performCardExchange(idDeJoueur, idDeCarte);
        String message;

        if (success) {
            message = "Card exchange successful for player: " + idDeJoueur;
            logger.info("Exchange successful for player: {} and card: {}", idDeJoueur, idDeCarte);
        } else {
            message = "Card exchange failed for player: " + idDeJoueur;
            logger.warn("Exchange failed for player: {} and card: {}", idDeJoueur, idDeCarte);
        }

        // Construire et envoyer la réponse
        CardExchangeResponse response = CardExchangeResponse.newBuilder()
                .setSuccess(success)
                .setMessage(message)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    // Méthode fictive pour exécuter la logique d'échange
    private boolean performCardExchange(String idDeJoueur, String idDeCarte) {
        // TODO: Implémenter la logique d'échange de carte ( inutile pour le rendue du
        // projet)
        if (Math.random() < 0.5) {
            return true;
        } else {
            return false;
        }
    }
}
