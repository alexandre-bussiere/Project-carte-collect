package com.TCG.card_collection_service.controller;

import com.TCG.card_collection_service.service.BoosterService;
import com.TCG.card_collection_service.model.Booster;
import com.TCG.card_collection_service.model.Card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boosters")
public class BoosterController {

    @Autowired
    private BoosterService boosterService;

    @PostMapping("/create")
    public ResponseEntity<Booster> createBooster(@RequestBody Booster booster) {
        return ResponseEntity.ok(boosterService.createBooster(booster));
    }

    @PostMapping("/addToUser")
    public ResponseEntity<String> addBoosterToUser(@RequestParam Long userId, @RequestParam Long boosterId) {
        boosterService.addBoosterToUser(userId, boosterId);
        return ResponseEntity.ok("Booster added to user");
    }

    @PostMapping("/open")
    public ResponseEntity<List<Card>> openBooster(@RequestParam Long userId, @RequestParam Long boosterId) {
        return ResponseEntity.ok(boosterService.openBooster(userId, boosterId));
    }
}
