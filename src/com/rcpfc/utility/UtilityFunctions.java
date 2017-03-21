package com.rcpfc.utility;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class UtilityFunctions {
	public static String encrypt(String input) {
	       String key = "fedcba9876543210"; 
		   byte[] crypted = null;
	       try {
	            SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
	            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	            cipher.init(Cipher.ENCRYPT_MODE, skey);
	            crypted = cipher.doFinal(input.getBytes());
	            } 
	       catch (Exception e) 
	       		  {
	    	   		System.out.println("Exception in Encrypt");
	              }
	              return new String(org.apache.commons.codec.binary.Base64.encodeBase64(crypted));
	       }

	       public static String decrypt(String input) throws IllegalBlockSizeException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException  {
	    	   	  String key = "fedcba9876543210";    
	    	      byte[] output = null;
	              SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
	              Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	              cipher.init(Cipher.DECRYPT_MODE, skey);
	              output = cipher.doFinal(org.apache.commons.codec.binary.Base64.decodeBase64(input));
	              return new String(output);
	       }

	       public static void main(String args[]){
	    		String myname = "abcdefg";
	    		String enc = UtilityFunctions.encrypt(myname);
	    		System.out.println("Encrypted value = "+enc);
	    		try{
	    		System.out.println("Decrypted value = "+UtilityFunctions.decrypt(enc));
	    		}
	    		catch (Exception e){
	    			System.out.println("Exception occured");
	    		}
	    	}       
}
