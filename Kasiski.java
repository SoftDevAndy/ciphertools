package vig.enere.breaker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Kasiski {
	
	public Kasiski(){}
				
	public List<LinkedHashMap<String,ArrayList<Integer>>> getKeyDifferences(String cipherText, int min, int max){
		
		List<LinkedHashMap<String,ArrayList<Integer>>> keyPositions = keyPositions(cipherText, min, max);
		List<LinkedHashMap<String,ArrayList<Integer>>> klf = new ArrayList<LinkedHashMap<String,ArrayList<Integer>>>();
		
		for(LinkedHashMap<String,ArrayList<Integer>> lhm : keyPositions){
						
			for(String key : lhm.keySet()){
				
				ArrayList<Integer> positionDifferences = new ArrayList<Integer>();
				
				int i = 0;
				
				for(int x : lhm.get(key)){
					
					if(i < (lhm.get(key).size() - 1)){
						
						int difference = lhm.get(key).get(i + 1) - lhm.get(key).get(i);
						
						positionDifferences.add(difference);
					}
					
					i++;					
				}
				
				LinkedHashMap<String,ArrayList<Integer>> nlhm = new LinkedHashMap<String,ArrayList<Integer>>();
				
				nlhm.put(key, positionDifferences);
				
				klf.add(nlhm);						
			}			
		}
		
		return klf;
	}
	
	public ArrayList<Integer> getFactorsOfNumber(int factorMe){
        
		ArrayList<Integer> hs = new ArrayList<Integer>();
		
        for(int i = 2; i <= factorMe; i++){
        	
        	while(factorMe % i == 0)
        	{            	
            	hs.add(factorMe);
            	
            	factorMe = factorMe / i;
            }            
        }
        
        Collections.reverse(hs);
        
        return hs;
	}
	
	private List<LinkedHashMap<String,ArrayList<Integer>>> keyPositions(String cipherText, int min, int max){

		List<LinkedHashMap<String,ArrayList<Integer>>> patternMapsList = new ArrayList<LinkedHashMap<String,ArrayList<Integer>>>();
		
		for(int i = min; i <= max; i++){
			
			LinkedHashMap<String,ArrayList<Integer>> temp = new LinkedHashMap<String,ArrayList<Integer>>();
			
			temp = createPatternMapOfSize(i, cipherText);
			
			patternMapsList.add(temp);			
		}
				
		return patternMapsList;
	}
	
	private LinkedHashMap<String, ArrayList<Integer>> createPatternMapOfSize(int patternSize, String cipherText){
		
		LinkedHashMap<String, ArrayList<Integer>> patternMap = new LinkedHashMap<String, ArrayList<Integer>>();
		
		String ss = "";
		
		for(int i = 0; i < cipherText.length(); i++){
						
			if(i + patternSize < cipherText.length()){
				ss = cipherText.substring(i, i + patternSize);
			
				Pattern ptrn = Pattern.compile(ss);
				Matcher matcher = ptrn.matcher(cipherText);
				
				while (matcher.find()) {
					
					if(patternMap.containsKey(ss)){
						
						if(patternMap.get(ss).contains(i) == false){
							
							ArrayList<Integer> hs = null;
							
							hs = patternMap.get(ss);
							hs.add(i);
							
							patternMap.put(ss, hs);
						}
					}
					else{
						
						ArrayList<Integer> patternPositions = new ArrayList<Integer>();						
						patternPositions.add(i);
						
						patternMap.put(ss, patternPositions);						
					}
				}
			}	
		}
		
		return patternMap;
	}
	
}