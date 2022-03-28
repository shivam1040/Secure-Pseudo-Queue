package com.example.securepseudoqueuesender.config;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.SerializationUtils;

@Configuration
public class AESEncryptDecrypt implements AttributeConverter<Object, String> {
	
	@Value("${aes.encryption.key}")
	private String encryptionkey;
	private String encrytpioncipher="AES";
	
	private Key key;
	private Cipher cipher;
	
	private Key getKey() {
		if(key==null)
			key=new SecretKeySpec(encryptionkey.getBytes(), encrytpioncipher);
		return key;
	}
	
	private Cipher getCipher() {
		if(cipher==null)
			try {
				cipher=Cipher.getInstance(encrytpioncipher);
			} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return cipher;
	}
	
	private void initCipher(int encryptMode) {
		try {
			getCipher().init(encryptMode, getKey());
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String convertToDatabaseColumn(Object attribute) {
		if(attribute==null)
			return null;
		initCipher(Cipher.ENCRYPT_MODE);
		byte[] bytes=SerializationUtils.serialize(attribute);
		try {
			return Base64.getEncoder().encodeToString(getCipher().doFinal(bytes));
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Object convertToEntityAttribute(String dbData) {
		if(dbData==null)
			return null;
		initCipher(Cipher.DECRYPT_MODE);
		byte[] bytes=null;
		try {
			bytes = getCipher().doFinal(Base64.getDecoder().decode(dbData));
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SerializationUtils.deserialize(bytes);
	}
	
}
