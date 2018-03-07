package vig.enere.breaker;

import java.util.HashMap;

public class Tools {
		
	public String alphabetFrequency(String plaintext){
		
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>(); 
		
		for(Character c : plaintext.toUpperCase().toCharArray()){
			
			if(c != ' ' && Character.isLetter(c)){
			
				if(hm.containsKey(c)){				
					int val = hm.get(c) + 1;
					hm.replace(c, val);				
				}
				else
					hm.put(c, 1);
			}
		}
		
		return hm.toString();
	}
}
