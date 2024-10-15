package com.TCG.card_collection_service.controller;

import com.TCG.card_collection_service.service.BoosterService;
import com.TCG.card_collection_service.model.Booster;
import com.TCG.card_collection_service.model.Card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TCG/boosters")
public class BoosterController {

    @Autowired
    private BoosterService boosterService;

}
