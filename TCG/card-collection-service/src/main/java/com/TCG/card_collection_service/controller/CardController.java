package com.TCG.card_collection_service.controller;

import com.TCG.card_collection_service.service.CardService;
import com.TCG.card_collection_service.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping("/create")
    public ResponseEntity<Card> createCard(@RequestBody Card card) {
        return ResponseEntity.ok(cardService.createCard(card));
    }

    @PostMapping("/addToUser")
    public ResponseEntity<String> addCardToUser(@RequestParam Long userId, @RequestParam Long cardId) {
        cardService.addCardToUser(userId, cardId);
        return ResponseEntity.ok("Card added to user");
    }
}
