package vig.enere.breaker;

import java.util.ArrayList;
import java.util.Collections;

public class Kasiski {
	
	public String getFactorsOfNumber(int factorMe){
        
		ArrayList<Integer> hs = new ArrayList<Integer>();
		
        for(int i = 2; i <= factorMe; i++){
        	
        	while(factorMe % i == 0)
        	{            	
            	hs.add(factorMe);
            	
            	factorMe = factorMe / i;
            }            
        }
        
        Collections.reverse(hs);
        
        return hs.toString();
	}
	
}