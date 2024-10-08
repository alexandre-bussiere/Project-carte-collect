package com.TCG.card_collection_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int defensiveStat;
    private int offensiveStat;
    private String effect;
    private int cost;
    private String rarity;

    public Card() {
    }

    public Card(String name, int defensiveStat, int offensiveStat, String effect, int cost, String rarity) {
        this.name = name;
        this.defensiveStat = defensiveStat;
        this.offensiveStat = offensiveStat;
        this.effect = effect;
        this.cost = cost;
        this.rarity = rarity;
    }
    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDefensiveStat() {
        return defensiveStat;
    }

    public void setDefensiveStat(int defensiveStat) {
        this.defensiveStat = defensiveStat;
    }

    public int getOffensiveStat() {
        return offensiveStat;
    }

    public void setOffensiveStat(int offensiveStat) {
        this.offensiveStat = offensiveStat;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }
}
