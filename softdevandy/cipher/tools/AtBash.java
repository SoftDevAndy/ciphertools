package softdevandy.cipher.tools;

import java.util.HashMap;

public class AtBash {
	
	public static String encrypt(String plaintext){
		
		HashMap<Character, Character> hm = new HashMap<Character, Character>();
		StringBuffer sb = new StringBuffer();
		
		for(int i = 1; i < 27; i++){		
			
			Character key = (char)(64 + i); 
			Character value = (char)(91 - i);			
			hm.put(key, value);
			
			// Adds KeyValue to the hashmap e.g A-Z,B-Y,C-X
			// The HashMap is our lookup table
		}
		
		for(Character c : plaintext.toUpperCase().toCharArray()){
			
			// Foreach character in our plaintext convert it to uppercase
			
			if(Character.isLetter(c))				
				sb.append(hm.get(c));
			
			// If the character is a letter, look up the hashmap and add the value otherwise ignore it
		}
		
		return sb.toString();
	}
}
