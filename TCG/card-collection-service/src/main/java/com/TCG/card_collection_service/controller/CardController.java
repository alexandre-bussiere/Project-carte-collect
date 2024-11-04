package com.TCG.card_collection_service.controller;

import com.TCG.card_collection_service.service.CardService;
import com.TCG.card_collection_service.model.Card;
import com.TCG.card_collection_service.repository.CardRepository;

import jakarta.transaction.Transactional;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TCG/cards")
@Tag(name = "Card Controller", description = "Manage cards in the card collection")
public class CardController {

    private static final Logger logger = LoggerFactory.getLogger(CardController.class);

    @Autowired
    private CardService cardService;

    @Autowired
    private CardRepository cardRepository;

    // Récupérer toutes les cartes
    @GetMapping
    @Operation(summary = "Get all cards", description = "Retrieve a list of all cards.")
    public List<Card> getAllCards() {
        logger.info("Fetching all cards");
        return cardService.getAllCards();
    }

    // Récupérer une carte par son ID
    @Transactional
    @GetMapping("/{id}")
    @Operation(summary = "Get card by ID", description = "Retrieve a card by its ID.")
    public Card getCardById(@PathVariable("id") Long id) {
        logger.info("Fetching card with ID: {}", id);
        return cardRepository.findById(id).orElse(null);
    }

    // Créer une nouvelle carte
    @PostMapping
    @Operation(summary = "Create a new card", description = "Create a new card.")
    public Card createCard(@RequestBody Card card) {
        logger.info("Creating a new card: {}", card);
        return cardService.createCard(card);
    }

    // Supprimer une carte par son ID
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete card by ID", description = "Delete a card by its ID.")
    public void deleteCard(@PathVariable("id") Long id) {
        logger.info("Deleting card with ID: {}", id);
        cardService.deleteCard(id);
    }
}
