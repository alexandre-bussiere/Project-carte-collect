package com.TCG.card_collection_service.controller;

import com.TCG.card_collection_service.service.CardService;
import com.TCG.card_collection_service.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/TCG/cards")
public class CardController {

    @Autowired
    private CardService cardService;

}