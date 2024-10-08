package com.TCG.card_collection_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.CascadeType;

@Entity
public class User {

    @Id
    private String id;
    private String username;
    private String pseudo;
    private int gold;

    @OneToOne(cascade = CascadeType.ALL) // Cascade allows auto-saving of the collections when User is saved
    @JoinColumn(name = "booster_collection_id")
    private UserBoosterCollection userBoosterCollection;

    @OneToOne(cascade = CascadeType.ALL) // Cascade allows auto-saving of the collections when User is saved
    @JoinColumn(name = "card_collection_id")
    private UserCardCollection userCardCollection;

    public User() {
    }

    public User(String id, String username, String pseudo, int gold) {
        this.id = id;
        this.username = username;
        this.pseudo = pseudo;
        this.gold = gold;

        this.userBoosterCollection = new UserBoosterCollection(this, null);
        this.userCardCollection = new UserCardCollection(this, null);
    }

    // Getters et Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public UserBoosterCollection getUserBoosterCollection() {
        return userBoosterCollection;
    }

    public void setUserBoosterCollection(UserBoosterCollection userBoosterCollection) {
        this.userBoosterCollection = userBoosterCollection;
    }

    public UserCardCollection getUserCardCollection() {
        return userCardCollection;
    }

    public void setUserCardCollection(UserCardCollection userCardCollection) {
        this.userCardCollection = userCardCollection;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", gold=" + gold +
                ", userBoosterCollection=" + userBoosterCollection +
                ", userCardCollection=" + userCardCollection +
                '}';
    }
}
