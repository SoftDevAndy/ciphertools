package vig.enere.breaker;

public class CaesarNum {
	
	public String encrypt(String plainText){
		
		StringBuilder ciphertext = new StringBuilder();
		
		for(Character c : plainText.toUpperCase().toCharArray()){			
			if(Character.isLetter(c))				
				ciphertext.append(((int)c - 64) + ",");
		}
		
		return ciphertext.toString();
	}
}
