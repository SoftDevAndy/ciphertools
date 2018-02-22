package vig.enere.breaker;

import java.util.HashMap;

public class AtBash {
	
	public static String encrypt(String text){
		
		HashMap<Character, Character> hm = new HashMap<Character, Character>();
		StringBuffer sb = new StringBuffer();
		
		for(int i = 1; i < 27; i++){		
			
			Character key = (char)(64 + i);
			Character value = (char)(91 - i);
			
			hm.put(key, value);
		}
		
		for(Character c : text.toUpperCase().toCharArray()){
			
			if(Character.isLetter(c)){				
				sb.append(hm.get(c));
			}
		}
		
		return sb.toString();
	}
}
