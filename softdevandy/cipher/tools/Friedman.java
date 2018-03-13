package softdevandy.cipher.tools;

import java.util.LinkedHashMap;

public class Friedman {

	private LinkedHashMap<Character, Integer> alphabetFrequencyTable;
	private final int ALPHA = 26;
	private final int ASCII = 65;
	private float MIN = 0.038f;
	private float MAX = 0.065f;
	
	public float getIndexOfCoincidence(String ciphertext){
		
		alphabetFrequencyTable = buildAlphabetFrequencyTable(ciphertext);
		
		float nTotal = valueCount(alphabetFrequencyTable);
		float otherTotal = otherValueCount(alphabetFrequencyTable);		
		
		return otherTotal / (nTotal * (nTotal - 1));	
	}
	
	public float getKeysizeUsingFriedman(float indexOfCoincidence, String ciphertext){
		
		alphabetFrequencyTable = buildAlphabetFrequencyTable(ciphertext);
		
		float nTotal = valueCount(alphabetFrequencyTable);		
		float a = 0.027f * nTotal;
		float b = (nTotal - 1) * indexOfCoincidence - MIN * nTotal + MAX;
				
		return a / b;
	}
	
	private LinkedHashMap<Character, Integer> buildAlphabetFrequencyTable(String ciphertext){

		LinkedHashMap<Character, Integer> alphabetFrequency = new LinkedHashMap<Character, Integer>();
		
		for(int i = 0; i < ALPHA; i++){
			Character letter = (char)(ASCII + i);			
			alphabetFrequency.put(letter, 0);
		}
		
		for(Character c : ciphertext.toCharArray()){
					
			c = Character.toUpperCase(c);
			
			int incrementOne = alphabetFrequency.get(c);
			incrementOne++;
			
			alphabetFrequency.put(c, incrementOne);		
		}
		
		return alphabetFrequency;
	}
	
	private int valueCount(LinkedHashMap<Character, Integer> frequencyTable){
		
		int total = 0;
		
		for(int x : frequencyTable.values())
			total += x;
		
		return total;
	}
	
	private int otherValueCount(LinkedHashMap<Character, Integer> frequencyTable){
		
		int total = 0;
		
		for(int x : frequencyTable.values()){
			
			if(x != 0)
				total += (x * (x - 1));
		}
		
		return total;
	}
}