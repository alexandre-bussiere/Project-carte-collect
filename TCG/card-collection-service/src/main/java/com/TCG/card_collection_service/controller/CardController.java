package com.TCG.card_collection_service.controller;

import com.TCG.card_collection_service.service.CardService;
import com.TCG.card_collection_service.model.Card;
import com.TCG.card_collection_service.repository.CardRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TCG/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @Autowired
    private CardRepository cardRepository;

    @GetMapping
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @Transactional
    @GetMapping("/{id}")
    public Card getCardById(@PathVariable("id") Long id) {
        return cardRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Card createCard(@RequestBody Card card) {
        return cardService.createCard(card);
    }

    @DeleteMapping("/{id}")
    public void deleteCard(@PathVariable("id") Long id) {
        cardService.deleteCard(id);
        return;
    }
}