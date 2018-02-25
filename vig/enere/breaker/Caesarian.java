package vig.enere.breaker;

import java.util.ArrayList;
import java.util.List;

public class Caesarian {

	public String encrypt(int shift, String plainText){
				
		List<Character> original = new ArrayList<Character>();
		List<Character> caesar = new ArrayList<Character>();
						
		for(int i = 1; i < 27; i++){			
			original.add((char)(64 + i));
		}		
		
		int startPosition;		
		int count = 0;
		
		if(shift != 0)		
			startPosition = 64 + shift;
		else 
			startPosition = 64;
				
		int positionMarker = startPosition;
		
		while(count < 26){
			
			if(positionMarker > 90)
				positionMarker = 65;
			
			caesar.add((char)(positionMarker));
						
			++positionMarker;
			++count;
		}
						
		StringBuffer cipherText = new StringBuffer();
		
		for(Character c : plainText.toCharArray()){
								
			if(Character.isAlphabetic(c)){
			
				int pos = Character.toUpperCase(c) - 64;
								
				if(pos < 26 && pos >= 0)
					cipherText.append(caesar.get(pos));
				else if(pos == 26)
					cipherText.append(caesar.get(0));
				else
					cipherText.append(" ");
			}
			else
				cipherText.append(" ");
		}
		
		return cipherText.toString();
	}
	
}
