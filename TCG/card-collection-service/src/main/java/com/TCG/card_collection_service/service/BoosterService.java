package com.TCG.card_collection_service.service;

import com.TCG.card_collection_service.model.Booster;
import com.TCG.card_collection_service.repository.BoosterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoosterService {

    @Autowired
    private BoosterRepository boosterRepository;

    public List<Booster> getAllBoosters() {
        return boosterRepository.findAll();
    }

    public Booster getBoosterById(Long id) {
        return boosterRepository.findById(id).orElse(null);
    }

    public Booster createBooster(Booster booster) {
        return boosterRepository.save(booster);
    }

    public void deleteBooster(Long id) {
        boosterRepository.deleteById(id);
    }
}
