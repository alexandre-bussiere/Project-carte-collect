package com.TCG.card_collection_service.controller;

import com.TCG.card_collection_service.service.BoosterService;
import com.TCG.card_collection_service.model.Booster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/TCG/boosters")
@Tag(name = "Booster Controller", description = "Manage boosters in the card collection")
public class BoosterController {

    private static final Logger logger = LoggerFactory.getLogger(BoosterController.class);

    @Autowired
    private BoosterService boosterService;

    // Récupérer tous les boosters
    @GetMapping
    @Operation(summary = "Get all boosters", description = "Retrieve a list of all boosters.")
    public List<Booster> getAllBoosters() {
        logger.info("Fetching all boosters");
        return boosterService.getAllBoosters();
    }

    // Récupérer un booster par son ID
    @GetMapping("/{id}")
    @Operation(summary = "Get booster by ID", description = "Retrieve a booster by its ID.")
    public Booster getBoosterById(@PathVariable("id") Long id) {
        logger.info("Fetching booster with ID: {}", id);
        return boosterService.getBoosterById(id);
    }

    // Créer un nouveau booster
    @PostMapping
    @Operation(summary = "Create a new booster", description = "Create a new booster.")
    public Booster createBooster(@RequestBody Booster booster) {
        logger.info("Creating a new booster: {}", booster);
        return boosterService.createBooster(booster);
    }

    // Supprimer un booster par son ID
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete booster by ID", description = "Delete a booster by its ID.")
    public void deleteBooster(@PathVariable("id") Long id) {
        logger.info("Deleting booster with ID: {}", id);
        boosterService.deleteBooster(id);
    }
}