# Java Vigenere Cipher

Inspired by cryptology and in particial the vigenere cipher I created a bunch of simple tools for encrypting and decrypting these common ciphers. Some of the implementation is pretty simple and I will give example files on how to use them.

### Vigenere Cipher - VigenereEncrypter.java

What is it? [Click here to read about it](https://en.wikipedia.org/wiki/Vigen%C3%A8re_cipher)
The above link can explain the cipher technique in a far better way then I could. I only implemented it!

**TL;DR** It takes a Vigenere Square and a keyword. If you know the keyword you can also unencrypt it quite easily. This cipher was secure in the past but in recent years statistical analysis such as the **Kasiski** method and the **Friedman** method helped later to guess the keyword length thus making cracking the encrypted text a lot more easier.

Using this the my implementation for this is quite easy.

**Encrypting**
````Java
String knownKey = "BLUES";
VigenereEncrypter vigenereEncrypter = new VigenereEncrypter();						
String cipherText = vigenereEncrypter.encryptText(knownKey, "THEQUICKBROWNFOXJUMPSOVERTHELAZYDOG");		
System.out.println(cipherText);
````
**Output**
````
USYUMJNEFJPHHJGYUOQHTZPIJUSYPSAJXSY    
````
**Decrypting**
````Java
String knownKey = "BLUES";
VigenereEncrypter vigenereEncrypter = new VigenereEncrypter();						
String cipherText = vigenereEncrypter.decryptText(knownKey, "USYUMJNEFJPHHJGYUOQHTZPIJUSYPSAJXSY");		
System.out.println(cipherText);
````
**Output**
````
THEQUICKBROWNFOXJUMPSOVERTHELAZYDOG    
````

# Vigenere Friedman Analysis - Friedman.java

Read more about it [here](https://en.wikipedia.org/wiki/Vigen%C3%A8re_cipher#Friedman_test)

In short its a method of roughly guessing the key length of the cipher text, thus making it easier to crack.

**Analysis**
````Java
String knownKey = "KEY";
VigenereEncrypter vigenereEncrypter = new VigenereEncrypter();						
String cipherText = vigenereEncrypter.encryptText(knownKey, "FROMVIGENERECIPHERANALYSISITISGENERALLYGOODTOHAVEALARGEMESSAGETOANALYZE");	

Friedman fried = new Friedman();
float ic = fried.getIndexOfCoincidence(cipherText);
float keySize = fried.getKeysizeUsingFriedman(ic, cipherText);
		
System.out.println("ic: " + ic + " \nkeySize: " + keySize);
````
**Output**
````
ic: 0.047082495 
keySize: 2.8923855
````	

# Vigenere Kasiski Analysis - Friedman.java

Read more about it [here](https://en.wikipedia.org/wiki/Vigen%C3%A8re_cipher#Kasiski_examination)

Another method of determining key length which furthermore can be used to determine what the key is later on using factors etc

**Usage**

````Java
String knownKey = "KEY";
		VigenereEncrypter vigenereEncrypter = new VigenereEncrypter();						
		String cipherText = vigenereEncrypter.encryptText(knownKey, "FROMVIGENERECIPHERANALYSISITISGENERALLYGOODTOHAVEALARGEMESSAGETOANALYZE");		

System.out.println(cipherText + "\n");

Kasiski ki = new Kasiski();
List<LinkedHashMap<String,ArrayList<Integer>>> klf = ki.getKeyDifferences(cipherText,2,5);

for(LinkedHashMap<String,ArrayList<Integer>> lhm : klf){

	for(String pattern : lhm.keySet()){

		if(lhm.get(pattern).size() > 1)
		{
			System.out.println(pattern + " " + lhm.get(pattern) + "\n");

			for(int x : lhm.get(pattern)){

				System.out.println("[" + x + "] Factors: " + ki.getFactorsOfNumber(x));
			}	

			System.out.println();
		}
	}
}
````

**Output**
````
PVMWZGQILOVCMMNRIPKRYVCQSWGDMQQILOVYVPWQSMNXMRETOEJKVEOQCCWYQIRYELKPWJI

QI [24, 30]

[24] Factors: [3, 6, 12, 24]
[30] Factors: [5, 15, 30]  
````


# Rot13 Cipher - RotCipher.java

[Rot13 Cipher Explained](https://en.wikipedia.org/wiki/ROT13) a very simple cipher.

**Encrypting & Decrypting**

````Java
RotCipher rot13 = new RotCipher();
String plainText = "Why did the chicken cross the road?";

String encrypted = rot13.encrypt(plainText);
System.out.println(encrypted);

// Reverse the encryption by simply passing it back through the encryption method again

encrypted = rot13.encrypt(encrypted);
System.out.println(encrypted);

````
**Output**
````
Jul qvq gur puvpxra pebff gur ebnq?
Why did the chicken cross the road?   
````
