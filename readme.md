# AES Encryption

My initial code on encryption and decryption based on Caesar Cipher [Encoder](https://github.com/GazaliAhmad/encoder) using an array. Very easy to crack, but it's a start.
Next, still based on [Caesar Cipher](https://github.com/GazaliAhmad/caesarCipher), taking in standard input, preserving case, space, punctuation and other characters.  User inputs the key to shift the alphabet.  It's still easy to crack.
Then, I did another [EncodeDecode](https://github.com/GazaliAhmad/EncodeDecode) that only use ASCII 32 to 126. All these are fairly easy to crack, and it's a good start to learn about encryption and decryption.  I'm still learning, and I'm not a security expert.  I'm just a hobbyist.

Finally, I did AES Encryption and Decryption.

## What is AES?

AES is a symmetric encryption algorithm. It means that the same key is used for both encryption and decryption. The key must be 128, 192 or 256 bits long.
Besides AES algorithm, there are other algorithms like DES, Triple DES, Blowfish, RC4, etc. Given enough time and resources, all of these algorithms can be cracked. The key is to make it difficult to crack. 

## What's next?

- Probably a microservice to encrypt and decrypt data.