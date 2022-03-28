package com.example.securepseudoqueuereceiver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.securepseudoqueuereceiver.entity.TransactionEntity;
import com.example.securepseudoqueuereceiver.service.Decrypt;
import com.example.securepseudoqueuereceiver.service.ReceiverService;

@RestController
@RequestMapping("/receiver")
public class ReceiverController {
	
	@Autowired
	private ReceiverService receiverService;
	
	@Autowired
	private Decrypt decrypt;
	
	@PostMapping("/post")
	public TransactionEntity save(@RequestBody TransactionEntity transactionEntity) {
		//System.out.println(transactionEntity);
		transactionEntity=decrypt.decrypt(transactionEntity);
		//System.out.println(transactionEntity);
		return receiverService.save(transactionEntity);
	}
	
	@GetMapping("/get")
	public List<TransactionEntity> fetch() {
		return receiverService.fetch();
	}
}