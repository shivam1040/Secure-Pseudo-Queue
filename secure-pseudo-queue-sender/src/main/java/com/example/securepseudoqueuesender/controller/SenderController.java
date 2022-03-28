package com.example.securepseudoqueuesender.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.securepseudoqueuesender.entity.TransactionEntity;
import com.example.securepseudoqueuesender.service.Encrypt;

@RestController
@RequestMapping("/sender")
public class SenderController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Encrypt encrypt;
	
	@Value("${receiver.url}")
	private String url;
	
	@PostMapping("/post")
	public String save(@RequestBody TransactionEntity transactionEntity) {
		transactionEntity=encrypt.encrypt(transactionEntity);
		URI uri = URI.create(url);
		ResponseEntity<TransactionEntity> result=restTemplate.postForEntity(uri, transactionEntity, TransactionEntity.class);
		if(result.getStatusCodeValue()==200)
			return "Success";
		return "failure";
	}
}