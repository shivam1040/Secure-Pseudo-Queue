package com.example.securepseudoqueuereceiver.repository;

import org.springframework.stereotype.Repository;

import com.example.securepseudoqueuereceiver.entity.TransactionEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

}
