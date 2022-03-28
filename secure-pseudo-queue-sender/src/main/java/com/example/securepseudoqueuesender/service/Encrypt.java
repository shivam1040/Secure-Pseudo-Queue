package com.example.securepseudoqueuesender.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.securepseudoqueuesender.config.AESEncryptDecrypt;
import com.example.securepseudoqueuesender.entity.TransactionEntity;

@Service
public class Encrypt {
	
	@Autowired
	private AESEncryptDecrypt aesEncryptDecrypt;
	
	public TransactionEntity encrypt(TransactionEntity transactionEntity) {
		transactionEntity.setAccountNumber(aesEncryptDecrypt.convertToDatabaseColumn(transactionEntity.getAccountNumber()));
		transactionEntity.setType(aesEncryptDecrypt.convertToDatabaseColumn(transactionEntity.getType()));
		transactionEntity.setAmount(aesEncryptDecrypt.convertToDatabaseColumn(transactionEntity.getAmount()));
		transactionEntity.setCurrency(aesEncryptDecrypt.convertToDatabaseColumn(transactionEntity.getCurrency()));
		transactionEntity.setAccountFrom(aesEncryptDecrypt.convertToDatabaseColumn(transactionEntity.getAccountFrom()));
		return transactionEntity;
	}
}
