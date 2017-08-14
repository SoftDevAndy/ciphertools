public class RotCipher {

	private final int ASCII_UPPER_MIN = 64; 
	private final int ASCII_UPPER_MAX = 91;
	private final int ASCII_LOWER_MIN = 96;
	private final int ASCII_LOWER_MAX = 123;
	
	public RotCipher(){}
	
	public String encrypt(String cipherText){
		
		StringBuffer sb = new StringBuffer();
		
		for(Character c : cipherText.toCharArray()){
			
			if(isAlpha(c)){
				
				if(Character.isLowerCase(c)){
					
					if(c < (ASCII_LOWER_MIN + 14))				
						sb.append((char)(c + 13));		
					else
						sb.append((char)(c - 13));
				}
				else{
					if(c < (ASCII_UPPER_MIN + 14))				
						sb.append((char)(c + 13));		
					else
						sb.append((char)(c - 13));		
				}		
			}
			else{
				sb.append((char)c);
			}
		}
				
		return sb.toString();
	}
	
	private boolean isAlpha(Character c){
		if(c < ASCII_LOWER_MAX && c > ASCII_LOWER_MIN || c < ASCII_UPPER_MAX && c > ASCII_UPPER_MIN)	
			return true;
		else
			return false;
	}
}
