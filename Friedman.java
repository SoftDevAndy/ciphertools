import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Friedman {

	private List<Float> estimateTable;
	private LinkedHashMap<Character, Integer> alphabetFrequencyTable;
	private final int ALPHA = 26;
	private final int ASCII = 65;
	private float MIN = 0.0385f;
	private float MAX = 0.065f;
		
	public Friedman(){
		estimateTable = new ArrayList<Float>();
		estimateTable.add(0.0407f);
		estimateTable.add(0.0410f);
		estimateTable.add(0.0414f);
		estimateTable.add(0.0419f);
		estimateTable.add(0.0426f);
		estimateTable.add(0.0435f);
		estimateTable.add(0.0449f);
		estimateTable.add(0.0473f);
		estimateTable.add(0.0520f);		
		estimateTable.add(0.0660f);		
	}
	
	public float getPolyAlphabeticValue(String cipherText){
		
		alphabetFrequencyTable = buildAlphabetFrequencyTable(cipherText);
		
		float nTotal = valueCount(alphabetFrequencyTable);
		float otherTotal = otherValueCount(alphabetFrequencyTable);		
		float result = otherTotal / (nTotal * nTotal - 1);		
		
		return result;
	}
	
	public int getKeysizeEstimateUsingFriedman(float polyAlphabeticValue, String cipherText){
		
		alphabetFrequencyTable = buildAlphabetFrequencyTable(cipherText);
		
		float nTotal = valueCount(alphabetFrequencyTable);		
		float a = (0.027f * nTotal);
		float b = (nTotal - 1) * polyAlphabeticValue + MAX - (MIN * nTotal);
				
		return (int)(a / b);
	}
	
	public int getKeysizeEstimateUsingTable(float polyAlphabeticValue){
		
		int pos = 0;
		
		for(int i = 0; i < estimateTable.size(); i++){
			
			if(polyAlphabeticValue > estimateTable.get(i))				
				pos = i;
		}
		
		return (pos + 1);
	}
	
	private LinkedHashMap<Character, Integer> buildAlphabetFrequencyTable(String cipherText){

		LinkedHashMap<Character, Integer> alphabetFrequency = new LinkedHashMap<Character, Integer>();
		
		for(int i = 0; i < ALPHA; i++){
			Character letter = (char)(ASCII + i);			
			alphabetFrequency.put(letter, 0);
		}
		
		for(Character c : cipherText.toCharArray()){
					
			c = Character.toUpperCase(c);
			
			int incrementOne = alphabetFrequency.get(c);
			incrementOne++;
			
			alphabetFrequency.put(c, incrementOne);		
		}
		
		return alphabetFrequency;
	}
	
	private int valueCount(LinkedHashMap<Character, Integer> frequencyTable){
		
		int total = 0;
		
		for(int x : frequencyTable.values()){
			total += x;
		}
		
		return total;
	}
	
	private int otherValueCount(LinkedHashMap<Character, Integer> frequencyTable){
		
		int total = 0;
		
		for(int x : frequencyTable.values()){
			total += (x * (x - 1));
		}
		
		return total;
	}
}