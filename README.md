# ciphertools

Inspired by cryptology and in particial the vigenere cipher I created a bunch of simple tools for encrypting and decrypting these common ciphers. Some of the implementation is pretty simple and I will give example files on how to use them.

# Help

```
C:\>java -jar cipher.jar -help

---------- Help & Usage ----------
-ENCODEBASE64 plaintext
-DECODEBASE64 ciphertext
-ENCODEVIGENERE key plaintext
-DECODEVIGENERE key ciphertext
-SUBENCODE mixedalpha plaintext
-SUBDECODE mixedalpha plaintext
-ATBASH cipherorplaintext
-CAESAR 13 plaintext
-CAESARNUM plaintext
-FRIEDKEY ciphertext
-IOC ciphertext
-FACTORS 15
-POLY plaintext
-POLY plaintext startletter
-FREQ plaintext
----------------------------------
```

# Usage

## Base64 Encode/Decode

```
C:\>java -jar cipher.jar -ENCODEBASE64 "So this is really something strange."

U28gdGhpcyBpcyByZWFsbHkgc29tZXRoaW5nIHN0cmFuZ2Uu

C:\>java -jar cipher.jar -DECODEBASE64 "U28gdGhpcyBpcyByZWFsbHkgc29tZXRoaW5nIHN0cmFuZ2Uu"

So this is really something strange.
```

## Vigenere Encode/Decode
```
C:\>java -jar cipher.jar -encodevigenere key "This is my phrase that will get encoded."

RFGQGQKWNFPYQCRFYRUGJJECRCLAMBCB

C:\>java -jar cipher.jar -decodevigenere key "RFGQGQKWNFPYQCRFYRUGJJECRCLAMBCB"

THISISMYPHRASETHATWILLGETENCODED
```

## AtBash Encode/Decode
```
C:\>java -jar cipher.jar -ATBASH "Atbash is a pretty simple cipher."

ZGYZHSRHZKIVGGBHRNKOVXRKSVI

C:\>java -jar cipher.jar -ATBASH "ZGYZHSRHZKIVGGBHRNKOVXRKSVI"

ATBASHISAPRETTYSIMPLECIPHER
```

## Caesar Encode/Decode
```
C:\>java -jar cipher.jar -CAESAR 13 "The quick brown fox jumps over the lazy dog."

GUR DHVPX OEBJA SBK WHZCF BIRE GUR YNML QBT

C:\>java -jar cipher.jar -CAESAR 13 "GUR DHVPX OEBJA SBK WHZCF BIRE GUR YNML QBT"

THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG

C:\>java -jar cipher.jar -CAESARNUM "The quick brown fox jumps over the lazy dog."

20,8,5,17,21,9,3,11,2,18,15,23,14,6,15,24,10,21,13,16,19,15,22,5,18,20,8,5,12,1,26,25,4,15,7
```

## Subsitution Cipher

```
C:\>java -jar cipher.jar -SUBENCODE "BHAJWKMYFVSXRNPZEQLUGIDCOT" "The quick brown fox jumps over the lazy dog."

UYW EGFAS HQPDN KPC VGRZL PIWQ UYW XBTO JPM

C:\>java -jar cipher.jar -SUBDECODE "BHAJWKMYFVSXRNPZEQLUGIDCOT" "UYW EGFAS HQPDN KPC VGRZL PIWQ UYW XBTO JPM"

```

## Polybius Encode/Decode
```
C:\>java -jar cipher.jar -POLY JUICE

2445241315

C:\>java -jar cipher.jar -POLY "THE QUICK BROWN FOX AB" A

442214414523122511423452331534531111 // <- Notice instead of using I & J as the same value it's now shifted to A & B
```

## Extras
```
C:\>java -jar cipher.jar -IOC "RFGQGQKWNFPYQCRFYRUGJJECRCLAMBCB"

Index of coincidence: 0.048387095

Close to 0.070         = Possible Monoalphabetic or Subsitution Cipher.
Close to 0.045 to 0.05 = Possible Vigenere Cipher.
Close to 0.0385        = Possible Polyalphabetic Cipher.

C:\>java -jar cipher.jar -FRIEDKEY "RFGQGQKWNFPYQCRFYRUGJJECRCLAMBCB"

Friedman IOC:     0.048387095
Friedman Keysize: 2.4756446

C:\>java -jar cipher.jar -FREQ "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG"

{A=1, B=1, C=1, D=1, E=3, F=1, G=1, H=2, I=1, J=1, K=1, L=1, M=1, N=1, O=4, P=1, Q=1, R=2, S=1, T=2, U=2, V=1, W=1, X=1, Y=1, Z=1}
```
