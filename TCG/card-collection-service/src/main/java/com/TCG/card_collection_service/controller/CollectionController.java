package com.TCG.card_collection_service.controller;

import com.TCG.card_collection_service.model.UserBoosterCollection;
import com.TCG.card_collection_service.model.UserCardCollection;
import com.TCG.card_collection_service.service.CollectionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/TCG/{userid}/collection")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    @GetMapping()
    public ResponseEntity<String> getCollection(@PathVariable("userid") String userId) {
        return ResponseEntity.ok("Collection");
    }

    @GetMapping("/booster")
    public ResponseEntity<UserBoosterCollection> getBoosterCollection(@PathVariable("userid") String userId) {
        UserBoosterCollection boosterCollection = collectionService.getBoosterCollection(userId);
        return ResponseEntity.ok(boosterCollection);
    }

    @GetMapping("/card")
    public ResponseEntity<UserCardCollection> getCardCollection(@PathVariable("userid") String userId) {
        UserCardCollection cardCollection = collectionService.getCardCollection(userId);
        return ResponseEntity.ok(cardCollection);
    }

    @PutMapping("/addbooster/{boosterId}")
    public ResponseEntity<UserBoosterCollection> addBoosterToCollection(@PathVariable("userid") String userId,
            @PathVariable("boosterId") Long boosterId) {
        UserBoosterCollection boosterCollection = collectionService.addBoosterToCollection(userId, boosterId);
        return ResponseEntity.ok(boosterCollection);
    }

    @PutMapping("/addbooster/{boosterId}/{quantity}")
    public ResponseEntity<UserBoosterCollection> addBoosterToCollection(@PathVariable("userid") String userId,
            @PathVariable("boosterId") Long boosterId, @PathVariable("quantity") int quantity) {
        UserBoosterCollection boosterCollection = null;
        for (int i = 0; i < quantity; i++) {
            boosterCollection = collectionService.addBoosterToCollection(userId, boosterId);
        }
        return ResponseEntity.ok(boosterCollection);
    }

    @PutMapping("/addcard/{cardId}")
    public ResponseEntity<UserCardCollection> addCardToCollection(@PathVariable("userid") String userId,
            @PathVariable("cardId") Long cardId) {
        UserCardCollection cardCollection = (UserCardCollection) collectionService.addCardToCollection(userId, cardId);
        return ResponseEntity.ok(cardCollection);
    }
}
