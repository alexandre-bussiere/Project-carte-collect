package com.TCG.card_collection_service.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;

@Entity
public class UserBoosterCollection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id") // This is the foreign key in the User table
    private User user;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "booster_collection_id") // This is the foreign key in the Booster table
    private Set<Booster> boosters = new HashSet<>();

    // Default constructor
    public UserBoosterCollection() {
    }

    public UserBoosterCollection(User user, Set<Booster> boosters) {
        this.user = user;
        for (Booster booster : boosters) {
            this.boosters.add(booster);
        }
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Booster> getBoosters() {
        return boosters;
    }

    public void setBoosters(Set<Booster> boosters) {
        this.boosters = boosters;
    }

    @Override
    public String toString() {
        return "UserBoosterCollection{" +
                "id=" + id +
                ", user=" + user.getUsername() + // Show the username for clarity
                ", boosters=" + boosters +
                '}';
    }
}