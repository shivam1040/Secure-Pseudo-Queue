package com.example.securepseudoqueuereceiver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.securepseudoqueuereceiver.entity.TransactionEntity;
import com.example.securepseudoqueuereceiver.repository.TransactionRepository;

@Service
public class ReceiverService {
	
	@Autowired
	private TransactionRepository transactionRepository;

	public TransactionEntity save(TransactionEntity transactionEntity) {
			return transactionRepository.save(transactionEntity);
	}

	public List<TransactionEntity> fetch() {
		return transactionRepository.findAll();
	}
}
