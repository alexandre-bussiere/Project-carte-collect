package com.TCG.card_collection_service.repository;

import com.TCG.card_collection_service.model.UserCardCollection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCardCollectionRepository extends JpaRepository<UserCardCollection, Long> {
}
