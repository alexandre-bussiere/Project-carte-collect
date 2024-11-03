package com.TCG.card_collection_service.service;

import com.TCG.card_collection_service.model.Booster;
import com.TCG.card_collection_service.model.Card;
import com.TCG.card_collection_service.model.User;
import com.TCG.card_collection_service.model.UserBoosterCollection;
import com.TCG.card_collection_service.model.UserCardCollection;
import com.TCG.card_collection_service.repository.BoosterRepository;
import com.TCG.card_collection_service.repository.CardRepository;
import com.TCG.card_collection_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CollectionService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BoosterRepository boosterRepository;

    @Autowired
    private CardRepository cardRepository;

    public UserBoosterCollection getBoosterCollection(String userId) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            return user.get().getUserBoosterCollection();
        } else {
            throw new RuntimeException("User with ID " + userId + " not found.");
        }
    }

    public UserCardCollection getCardCollection(String userId) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            return user.get().getUserCardCollection();
        } else {
            throw new RuntimeException("User with ID " + userId + " not found.");
        }
    }

    public UserBoosterCollection addBoosterToCollection(String userId, Long boosterId) {

        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Booster> boosterOptional = boosterRepository.findById(boosterId);

        if (userOptional.isPresent() && boosterOptional.isPresent()) {
            User user = userOptional.get();
            Booster booster = boosterOptional.get();

            UserBoosterCollection userBoosterCollection = user.getUserBoosterCollection();

            userBoosterCollection.addBoosterInCollection(booster);

            userRepository.save(user);

            return userBoosterCollection;
        } else {
            throw new RuntimeException("User or Booster not found with the provided IDs.");
        }
    }

    public UserCardCollection addCardToCollection(String userId, Long cardId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Card> cardOptional = cardRepository.findById(cardId);

        if (userOptional.isPresent() && cardOptional.isPresent()) {
            User user = userOptional.get();
            Card card = cardOptional.get();

            UserCardCollection cardCollection = user.getUserCardCollection();
            cardCollection.addCardInCollection(card);

            userRepository.save(user);

            return cardCollection;
        } else {
            throw new RuntimeException("User or Card not found with the provided IDs.");
        }
    }

}
