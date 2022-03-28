package com.example.securepseudoqueuereceiver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.securepseudoqueuereceiver.config.AESEncryptDecrypt;
import com.example.securepseudoqueuereceiver.entity.TransactionEntity;

@Service
public class Decrypt {
	
	@Autowired
	private AESEncryptDecrypt aesEncryptDecrypt;
	
	public TransactionEntity decrypt(TransactionEntity transactionEntity) {
		transactionEntity.setAccountNumber((String)aesEncryptDecrypt.convertToEntityAttribute(transactionEntity.getAccountNumber()));
		transactionEntity.setType((String)aesEncryptDecrypt.convertToEntityAttribute(transactionEntity.getType()));
		transactionEntity.setAmount((String)aesEncryptDecrypt.convertToEntityAttribute(transactionEntity.getAmount()));
		transactionEntity.setCurrency((String)aesEncryptDecrypt.convertToEntityAttribute(transactionEntity.getCurrency()));
		transactionEntity.setAccountFrom((String)aesEncryptDecrypt.convertToEntityAttribute(transactionEntity.getAccountFrom()));
		return transactionEntity;
	}
}
