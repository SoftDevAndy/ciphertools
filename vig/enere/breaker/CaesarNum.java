package vig.enere.breaker;

public class CaesarNum {
	
	public String encrypt(String plainText){
		
		StringBuilder ciphertext = new StringBuilder();
		
		int pos = 1;
		
		for(Character c : plainText.toUpperCase().toCharArray()){			
			
			pos++;
			
			if(Character.isLetter(c)){
				
				ciphertext.append(((int)c - 64));
				
				if(pos < plainText.length())
					 ciphertext.append(",");			
			}
		}
		
		return ciphertext.toString();
	}
}
