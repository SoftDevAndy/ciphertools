package vig.enere.breaker;

import java.util.ArrayList;
import java.util.List;

public class Polybius {
	
	private final int defaultSize = 5;
	private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private Character letterPosition = 'I';

	public String encrypt(String plainText){
		
		List<StringBuilder> polySquare = new ArrayList<StringBuilder>();
		
		for(int i = 0; i < defaultSize; i++)
			polySquare.add(new StringBuilder());
		
		int count = 0;
		int ignorePos = -1;
		
		for(int i =  0; i < polySquare.size(); i++){
			
			int j = 0;
			
			while(j < polySquare.size()){
								
				Character current = alphabet.charAt(count);
				
				if(letterPosition == current)
					ignorePos = count + 1;
				
				if(ignorePos != count){				
					StringBuilder col = polySquare.get(i);				
					col.append(current);
					j++;
				}	
				
				++count;
			}
		}
				
		StringBuilder cipher = new StringBuilder();
		
		for(Character c : plainText.toUpperCase().toCharArray()){
			
			if(Character.isLetter(c)){
				
				int row = -1;
				int col = -1;
				
				for(int i =  0; i < polySquare.size(); i++){
					
					if(c == (letterPosition + 1))
						c = letterPosition;
					
					Character first = polySquare.get(i).charAt(0);
					Character last = polySquare.get(i).charAt(defaultSize - 1);
										
					if(withinRange(first ,last, c)){
						
						row = (i + 1);						
						
						for(int j = 0; j < polySquare.get(i).length(); j++){
							
							Character a = polySquare.get(i).charAt(j);
							
							if(a == c)
								col = (j + 1);
						}
					
						if(col != -1 && row != -1)
							cipher.append(row + "" + col);
						else
							cipher.append(" ");
					
					}
				}
			}
		}
		
		return cipher.toString(); 
	}
	
	private boolean withinRange(Character first, Character last, Character inQuestion){
		
		if(inQuestion >= first && inQuestion <= last)
			return true;
		
		return false;
	}
	
}
