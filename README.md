# ciphertools

Inspired by cryptology and in particial the vigenere cipher I created a bunch of simple tools for encrypting and decrypting these common ciphers. Some of the implementation is pretty simple and I will give example files on how to use them.

## Help and Usage

```
C:\>java -jar cipher.jar -help

---------- Help & Usage ----------
-ENCODEBASE64 plaintext
-DECODEBASE64 ciphertext
-ENCODEVIGENERE key plaintext
-DECODEVIGENERE key ciphertext
-ATBASH cipherorplaintext
-CAESAR 13 plaintext
-FRIEDKEY ciphertext
-IOC ciphertext
-FACTORS 15
----------------------------------

C:\>java -jar cipher.jar -encodevigenere key "This is my phrase that will get encoded."

RFGQGQKWNFPYQCRFYRUGJJECRCLAMBCB

C:\>java -jar cipher.jar -decodevigenere key "RFGQGQKWNFPYQCRFYRUGJJECRCLAMBCB"

THISISMYPHRASETHATWILLGETENCODED

C:\>java -jar cipher.jar -ENCODEBASE64 "So this is really something strange."

U28gdGhpcyBpcyByZWFsbHkgc29tZXRoaW5nIHN0cmFuZ2Uu

C:\>java -jar cipher.jar -DECODEBASE64 "U28gdGhpcyBpcyByZWFsbHkgc29tZXRoaW5nIHN0cmFuZ2Uu"

So this is really something strange.

C:\>java -jar cipher.jar -ATBASH "Atbash is a pretty simple cipher."

ZGYZHSRHZKIVGGBHRNKOVXRKSVI

C:\>java -jar cipher.jar -ATBASH "ZGYZHSRHZKIVGGBHRNKOVXRKSVI"

ATBASHISAPRETTYSIMPLECIPHER

C:\>java -jar cipher.jar -CAESAR 13 "The quick brown fox jumps over the lazy dog."

GUR DHVPX OEBJA SBK WHZCF BIRE GUR YNML QBT

C:\>java -jar cipher.jar -CAESAR 13 "GUR DHVPX OEBJA SBK WHZCF BIRE GUR YNML QBT"

THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG

C:\>java -jar cipher.jar -CAESARNUM "The quick brown fox jumps over the lazy dog."

20,8,5,17,21,9,3,11,2,18,15,23,14,6,15,24,10,21,13,16,19,15,22,5,18,20,8,5,12,1,26,25,4,15,7

C:\>java -jar cipher.jar -IOC "RFGQGQKWNFPYQCRFYRUGJJECRCLAMBCB"

Index of coincidence: 0.048387095

Close to 0.070         = Possible Monoalphabetic or Subsitution Cipher.
Close to 0.045 to 0.05 = Possible Vigenere Cipher.
Close to 0.0385        = Possible Polyalphabetic Cipher.

C:\>java -jar cipher.jar -ENCODEBASE64 "The quick brown fox jumps over the lazy dog."

VGhlIHF1aWNrIGJyb3duIGZveCBqdW1wcyBvdmVyIHRoZSBsYXp5IGRvZy4=

C:\>java -jar cipher.jar -DECODEBASE64 "VGhlIHF1aWNrIGJyb3duIGZveCBqdW1wcyBvdmVyIHRoZSBsYXp5IGRvZy4="

The quick brown fox jumps over the lazy dog.

C:\>java -jar cipher.jar -FRIEDKEY "RFGQGQKWNFPYQCRFYRUGJJECRCLAMBCB"

Friedman IOC:     0.048387095
Friedman Keysize: 2.4756446

C:\>java -jar cipher.jar -POLY JUICE

2445241315

C:\>java -jar cipher.jar -POLY "THE QUICK BROWN FOX AB" A

442214414523122511423452331534531111 // <- Notice instead of using I & J as the same value it's now shifted to A & B

```
