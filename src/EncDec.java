import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;
import static java.lang.System.*;
import static javax.crypto.Cipher.getInstance;

class EncDec {
	
	private final Scanner scanner;
	private final String key = "TheQuickBrownFox";
	
	EncDec() {
		scanner = new Scanner(System.in);
		getChoice();
	}
	
	@SuppressWarnings("InfiniteLoopStatement")
	private void getChoice() {
		try {
			while (true) {
				out.print("\nWhat would you like to do? (e)ncrypt, (d)ecrypt, (q)uit:\n");
				var response = Character.toLowerCase(scanner.nextLine().charAt(0));
				switch (response) {
					case 'e' -> encrypt();
					case 'd' -> decrypt();
					case 'q' -> quit();
					default -> out.println("Invalid choice.");
				}
			}
		} catch (Exception e) {
			err.println("Error: " + e);
		}
	}
	
	private void decrypt() {
		out.print("\nEnter message to decrypt:\n");
		var msgToDecrypt = scanner.nextLine();
		byte[] decryptedData;
		
		try {
			SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "AES");
			Cipher cipher = getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
			decryptedData = cipher.doFinal(Base64.getDecoder().decode(msgToDecrypt));
			err.println("\nDecrypted Message:\n" + new String(decryptedData));
		} catch (Exception e) {
			err.println("Error while decrypting: " + e);
			err.println("Please try again. (d, e, q)");
		}
	}
	
	@SuppressWarnings("ReassignedVariable")
	private void encrypt() {
		out.print("\nEnter message to encrypt:\n");
		var msgToEncrypt = scanner.nextLine();
		
		String encryptedData = null;
		try {
			SecretKeySpec secretkeySpec = new SecretKeySpec(key.getBytes(), "AES");
			Cipher cipher = getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, secretkeySpec);
			byte[] encrypted = cipher.doFinal(msgToEncrypt.getBytes());
			encryptedData = Base64.getEncoder().encodeToString(encrypted);
		} catch (Exception e) {
			err.println("Error while encrypting: " + e);
			err.println("Please try again. (d, e, q)");
		}
		err.println("\nEncrypted Message:\n" + encryptedData);
	}
	
	private void quit() {
		out.println("\nGoodbye!");
		exit(0);
	}
}