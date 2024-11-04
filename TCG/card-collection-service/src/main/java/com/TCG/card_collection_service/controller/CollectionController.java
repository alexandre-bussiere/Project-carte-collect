package com.TCG.card_collection_service.controller;

import com.TCG.card_collection_service.model.UserBoosterCollection;
import com.TCG.card_collection_service.model.UserCardCollection;
import com.TCG.card_collection_service.service.CollectionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/TCG/{userid}/collection")
@Tag(name = "Collection Controller", description = "Manage collections of boosters and cards for users")
public class CollectionController {

    private static final Logger logger = LoggerFactory.getLogger(CollectionController.class);

    @Autowired
    private CollectionService collectionService;

    @GetMapping()
    @Operation(summary = "Get user's collection", description = "Retrieve a summary of the user's collection.")
    public ResponseEntity<String> getCollection(@PathVariable("userid") String userId) {
        logger.info("Fetching collection for user: {}", userId);
        return ResponseEntity.ok("Collection");
    }

    @GetMapping("/booster")
    @Operation(summary = "Get user's booster collection", description = "Retrieve the user's booster collection.")
    public ResponseEntity<UserBoosterCollection> getBoosterCollection(@PathVariable("userid") String userId) {
        logger.info("Fetching booster collection for user: {}", userId);
        UserBoosterCollection boosterCollection = collectionService.getBoosterCollection(userId);
        return ResponseEntity.ok(boosterCollection);
    }

    @GetMapping("/card")
    @Operation(summary = "Get user's card collection", description = "Retrieve the user's card collection.")
    public ResponseEntity<UserCardCollection> getCardCollection(@PathVariable("userid") String userId) {
        logger.info("Fetching card collection for user: {}", userId);
        UserCardCollection cardCollection = collectionService.getCardCollection(userId);
        return ResponseEntity.ok(cardCollection);
    }

    @PutMapping("/addbooster/{boosterId}")
    @Operation(summary = "Add booster to collection", description = "Add a specific booster to the user's collection.")
    public ResponseEntity<UserBoosterCollection> addBoosterToCollection(@PathVariable("userid") String userId,
            @PathVariable("boosterId") Long boosterId) {
        logger.info("Adding booster with ID: {} to user: {} collection", boosterId, userId);
        UserBoosterCollection boosterCollection = collectionService.addBoosterToCollection(userId, boosterId);
        return ResponseEntity.ok(boosterCollection);
    }

    @PutMapping("/addbooster/{boosterId}/{quantity}")
    @Operation(summary = "Add multiple boosters to collection", description = "Add a specified quantity of boosters to the user's collection.")
    public ResponseEntity<UserBoosterCollection> addBoosterToCollection(@PathVariable("userid") String userId,
            @PathVariable("boosterId") Long boosterId, @PathVariable("quantity") int quantity) {
        logger.info("Adding {} boosters with ID: {} to user: {} collection", quantity, boosterId, userId);
        UserBoosterCollection boosterCollection = null;
        for (int i = 0; i < quantity; i++) {
            boosterCollection = collectionService.addBoosterToCollection(userId, boosterId);
        }
        return ResponseEntity.ok(boosterCollection);
    }

    @PutMapping("/addcard/{cardId}")
    @Operation(summary = "Add card to collection", description = "Add a specific card to the user's collection.")
    public ResponseEntity<UserCardCollection> addCardToCollection(@PathVariable("userid") String userId,
            @PathVariable("cardId") Long cardId) {
        logger.info("Adding card with ID: {} to user: {} collection", cardId, userId);
        UserCardCollection cardCollection = collectionService.addCardToCollection(userId, cardId);
        return ResponseEntity.ok(cardCollection);
    }
}
