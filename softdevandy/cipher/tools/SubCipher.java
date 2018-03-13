package softdevandy.cipher.tools;

import java.util.HashMap;

public class SubCipher {
	
	String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String mixedalphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	HashMap<Character, Character> hm;
	
	public String encrypt(String mixedalphabet, String plaintext, boolean encoding){
		
		this.mixedalphabet = mixedalphabet;
		hm = new HashMap<Character, Character>();
	
		if(mixedalphabet.length() == alphabet.length()){
		
			StringBuffer ciphertext = new StringBuffer();		
			int index = 0;
			
			for(Character c : alphabet.toCharArray()){	
				
				if(encoding)				
					hm.put(c, mixedalphabet.charAt(index));
				else
					hm.put(mixedalphabet.charAt(index), c);
				
				index++;
			}
		
			for(Character c : plaintext.toUpperCase().toCharArray()){
				
				if(Character.isLetter(c))				
					ciphertext.append(hm.get(Character.toUpperCase(c)));
				else
					ciphertext.append(" ");
			}
			
			return ciphertext.toString();
		}
		else
			return "Alphabet isn't a standard size of " + alphabet.length();		
	}
}
