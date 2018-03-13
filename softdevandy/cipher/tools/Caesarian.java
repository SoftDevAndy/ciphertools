package softdevandy.cipher.tools;

import java.util.ArrayList;
import java.util.List;

public class Caesarian {

	public String encrypt(int shift, String plaintext){
				
		List<Character> originalAlphabet = new ArrayList<Character>();
		List<Character> caesarAlphabet = new ArrayList<Character>();
						
		for(int i = 1; i < 27; i++)			
			originalAlphabet.add((char)(64 + i));
		
		// Creating an alphabet character list A->Z
		
		int startPosition;		
		int count = 0;
		
		if(shift != 0)		
			startPosition = 64 + shift;
		else 
			startPosition = 64;
				
		int positionMarker = startPosition;
		
		// Takes a position to start the shifted alphabet at
		
		while(count < 26){
			
			if(positionMarker > 90)
				positionMarker = 65;
			
			caesarAlphabet.add((char)(positionMarker));
						
			++positionMarker;
			++count;
		}
		
		// Builds the shifted alphabet
						
		StringBuffer cipherText = new StringBuffer();
		
		for(Character c : plaintext.toCharArray()){
								
			if(Character.isAlphabetic(c)){
			
				int pos = Character.toUpperCase(c) - 64;
								
				if(pos < 26 && pos >= 0)
					cipherText.append(caesarAlphabet.get(pos));
				else if(pos == 26)
					cipherText.append(caesarAlphabet.get(0));
				else
					cipherText.append(" ");
			}
			else
				cipherText.append(" ");
		}
		
		// Foreach letter of the alphabet, find the matching letter in the shifted alphabet and append it.
		
		return cipherText.toString();
	}
	
}
