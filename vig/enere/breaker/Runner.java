package vig.enere.breaker;

import java.util.Base64;

public class Runner {

	public static void main(String[] args) {
		
		if(args.length == 1){
			if(args[0].toUpperCase().equals("-HELP")){
				System.out.println("\n---------- Help & Usage ----------");
				System.out.println("-ENCODEBASE64 plaintext");	
				System.out.println("-DECODEBASE64 ciphertext");
				System.out.println("-ENCODEVIGENERE key plaintext");
				System.out.println("-DECODEVIGENERE key ciphertext");
				System.out.println("-ATBASH cipherorplaintext");
				System.out.println("-CAESAR 13 plaintext");
				System.out.println("-FRIEDKEY ciphertext");
				System.out.println("-IOC ciphertext");
				System.out.println("-FACTORS 15");
				System.out.println("-POLY plaintext");
				System.out.println("----------------------------------");
			}
		}
		
		int count = -1;
		int iocPos = -1;
		int friedKeySizePos = -1;
		int rotPos = -1;
		int encryptPos = -1;
		int uncencryptPos = -1;
		int factorsPos = -1;
		int base64EncodePos = -1;
		int base64DecodePos = -1;
		int atbashPos = -1;
		int polyPos = -1;
				
		if(args.length != 0){
			
			for(String arg : args){
				
				count++;
				
				if(arg.toUpperCase().equals("-DECODEVIGENERE"))
					uncencryptPos = count + 1;
				
				if(arg.toUpperCase().equals("-ENCODEVIGENERE"))
					encryptPos = count + 1;
				
				if(arg.toUpperCase().equals("-IOC"))
					iocPos = count + 1;
				
				if(arg.toUpperCase().equals("-FRIEDKEY"))
					friedKeySizePos = count + 1;
				
				if(arg.toUpperCase().equals("-CAESAR"))
					rotPos = count + 1;
				
				if(arg.toUpperCase().equals("-FACTORS"))
					factorsPos = count + 1;
				
				if(arg.toUpperCase().equals("-ENCODEBASE64"))
					base64EncodePos = count + 1;
				
				if(arg.toUpperCase().equals("-DECODEBASE64"))
					base64DecodePos = count + 1;
				
				if(arg.toUpperCase().equals("-ATBASH"))
					atbashPos = count + 1;
				
				if(arg.toUpperCase().equals("-POLY"))
					polyPos = count + 1;
				
				if(iocPos == count){							
					Friedman f = new Friedman();	
					System.out.println();
					System.out.println("Index of coincidence: " + f.getIndexOfCoincidence(arg) + "\n");
					System.out.println("Close to 0.070         = Possible Monoalphabetic or Subsitution Cipher.");					
					System.out.println("Close to 0.045 to 0.05 = Possible Vigenere Cipher.");
					System.out.println("Close to 0.0385        = Possible Polyalphabetic Cipher.");
				}	
				
				if(friedKeySizePos == count){			
										
					Friedman f = new Friedman();	
					float indexOfCoincidence = f.getIndexOfCoincidence(arg);
					
					System.out.println();
					System.out.println("Friedman IOC:     " + indexOfCoincidence);
					System.out.println("Friedman Keysize: " + f.getKeysizeUsingFriedman(indexOfCoincidence, arg));
				}	
				
				if(rotPos == count){			
					
					Caesarian  c = new Caesarian();	
					
					if(count + 1 <= args.length){
						
						String result =  c.encrypt(Integer.parseInt(arg), args[count + 1]);
						
						System.out.println();
						System.out.println(result);
					}
				}
				
				if(encryptPos == count){				
					
					if(count + 1 <= args.length){
						VigenereEncrypter v = new VigenereEncrypter();
						
						String result = v.encryptText(arg, args[count + 1]);
						
						System.out.println();
						System.out.println(result);
					}
				}
				
				if(uncencryptPos == count){		
					
					if(count + 1 <= args.length){
						VigenereEncrypter v = new VigenereEncrypter();
						String result = v.decryptText(arg, args[count + 1]);
						
						System.out.println();
						System.out.println(result);						
					}					
				}
				
				if(factorsPos == count){		
					
					if(count + 1 <= args.length){
						Kasiski k = new Kasiski();
						String result = k.getFactorsOfNumber(Integer.parseInt(arg));
						
						System.out.println();
						System.out.println(result);						
					}					
				}
				
				if(base64EncodePos == count){				
					
					if(count + 1 <= args.length){
						
						Base64.Encoder encoder = Base64.getEncoder();
						String result = encoder.encodeToString(arg.getBytes());  
						
						System.out.println();
						System.out.println(result);
					}
				}
				
				if(base64DecodePos == count){				
					
					if(count + 1 <= args.length){
						
						Base64.Decoder decoder = Base64.getDecoder();  
						String result = new String(decoder.decode(arg));    
						
						System.out.println();
						System.out.println(result);
					}
				}
				
				if(atbashPos == count){				
					
					if(count + 1 <= args.length){
						  
						String result = new String(AtBash.encrypt(arg));    
						
						System.out.println();
						System.out.println(result);
					}
				}
				
				if(polyPos == count){				
					
					if(count + 1 <= args.length){
						Polybius p = new Polybius();
						
						String result = p.encrypt(arg);
						
						System.out.println();
						System.out.println(result);
					}
				}
			}			
		}		

	}// main

}// class
