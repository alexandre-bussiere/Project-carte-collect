package com.TCG.card_collection_service.controller;

import com.TCG.card_collection_service.service.BoosterService;
import com.TCG.card_collection_service.model.Booster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TCG/boosters")
public class BoosterController {

    @Autowired
    private BoosterService boosterService;

    // Récupérer tous les boosters
    @GetMapping
    public List<Booster> getAllBoosters() {
        return boosterService.getAllBoosters();
    }

    // Récupérer un booster par son ID
    @GetMapping("/{id}")
    public Booster getBoosterById(@PathVariable("id") Long id) {
        return boosterService.getBoosterById(id);
    }

    // Créer un nouveau booster
    @PostMapping
    public Booster createBooster(@RequestBody Booster booster) {
        return boosterService.createBooster(booster);
    }

    // Supprimer un booster par son ID
    @DeleteMapping("/{id}")
    public void deleteBooster(@PathVariable("id") Long id) {
        boosterService.deleteBooster(id);
    }
}
