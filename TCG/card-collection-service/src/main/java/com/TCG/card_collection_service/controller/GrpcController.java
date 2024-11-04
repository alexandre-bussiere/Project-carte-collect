package com.TCG.card_collection_service.controller;

import com.TCG.card_collection_service.service.GrpcClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrpcController {

    private final GrpcClientService grpcClientService;

    @Autowired
    public GrpcController(GrpcClientService grpcClientService) {
        this.grpcClientService = grpcClientService;
    }

    @GetMapping("/exchange-card")
    public String exchangeCard(@RequestParam String idDeJoueur, @RequestParam String idDeCarte) {
        // Appeler le client gRPC pour échanger la carte
        return grpcClientService.callCardExchange(idDeJoueur, idDeCarte);
    }
}
