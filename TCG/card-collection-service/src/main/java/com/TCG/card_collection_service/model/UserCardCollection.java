package com.TCG.card_collection_service.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.HashSet;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.CascadeType;

@Entity
public class UserCardCollection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id") // This is the foreign key in the User table
    @JsonBackReference
    private User user;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "card_collection_id") // This is the foreign key in the Card table
    private Set<Card> cards = new HashSet<>();

    // Constructor
    public UserCardCollection() {
    }

    public UserCardCollection(User user, Set<Card> cards) {
        this.user = user;
        if (cards != null) {
            this.cards.addAll(cards);
        } else {
            this.cards = new HashSet<>(); // Assurez-vous que cards est toujours initialisé

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

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    public void addCardToCollection(Card card) {
        this.cards.add(card);
    }

    public void addCardSetToCollection(Set<Card> cards) {
        for (Card card : cards) {
            this.cards.add(card);
        }
    }
}