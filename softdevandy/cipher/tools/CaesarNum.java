package softdevandy.cipher.tools;

public class CaesarNum {
	
	public String encrypt(String plaintext){
		
		StringBuilder ciphertext = new StringBuilder();
		
		int pos = 1;
		
		for(Character c : plaintext.toUpperCase().toCharArray()){			
			
			pos++;
			
			if(Character.isLetter(c)){
				
				ciphertext.append(((int)c - 64));
				
				if(pos < plaintext.length())
					 ciphertext.append(",");			
			}
		}
		
		// Foreach letter in plaintext, find the alphanumeric version. e.g A = 1
		
		return ciphertext.toString();
	}
}
