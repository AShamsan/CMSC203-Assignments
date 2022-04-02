/*
 * Class: CMSC203 
 * Instructor: Professor Khandan Monshi
 * Description: program to encrypt and decrypt a phrase using two similar approaches (Caesar method and Bellaso method)
 * Due: 4/1/2021
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Abdullah Shamsan
*/

/**
 * 
 * @author Abdullah Shamsan
 *
 */

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		//Define character variable c 
		char c;
		
		//A for-loop to save each character in the string plainText into c
		for(int i = 0; i < plainText.length(); i++) 
			{
				c = plainText.charAt(i);
				//An if-statement to check if each character in the string string is out of bounds
				if(c < LOWER_BOUND || c > UPPER_BOUND) 
					{
						//return false if the any character in the string is out of the bounds
						return false;
					}
			}
		//return true all characters in the string are within the bounds
		return true;

	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		//Define string encryptCaesarText and initialize to nothing, define an integer variable 
		String encryptedCaesarText = "";
		int asciiNum;
		
		//An if-statement that will run if the written string is in bounds
		if(stringInBounds(plainText) == true) 
		{
			//A for loop that assign the ascii value of each character plus the key value within the given plainText length
			for(int i = 0; i < plainText.length(); i++) 
			{
				 // asciiNum will be initialized to the ascii value of each character plus the value of the key
				asciiNum =  plainText.charAt(i) + key;
				
				// A while loop to keep the value of asciiNum within the required RANGE if it's value exceeded the UPPER_BOUND
				while(asciiNum > UPPER_BOUND) 
				{
					asciiNum -= RANGE;
				}
				
				//encryptCaesarText will be initialized with the char cast of asciiNum and the previous encryptCaesarText value
				encryptedCaesarText += (char)asciiNum;
			}
		}
		//return the value encryptCaesarText
		return encryptedCaesarText;

	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		/*Define a string encryptBellasoText and initialize to nothing, define an integer variable ,
		and define an integer variable strLength to hold bellasoStr length */
		String encryptedBellasoText = "";
		int asciiNum;
		int strLength =  bellasoStr.length();
		
		//An if-statement that will run if the written string is in bounds
		if(stringInBounds(plainText) == true) 
		{
			/*A for loop that assign the ascii value of each character in plainText plus  the reminder of 
			each character and strLength of bellasoStr value within the given plainText length*/
			for(int i = 0; i < plainText.length(); i++) 
			{	
				 /* asciiNum will be initialized to the ascii value of each character in plainText plus the reminder 
				   of each character and strLength of bellasoStr value within the given plainText length*/
				asciiNum = plainText.charAt(i) + bellasoStr.charAt(i % strLength); //Using modulus here ensures the program does not go outside the bellasoStr length
			
				// A while loop to keep the value of asciiNum within the required RANGE if it's value exceeded the UPPER_BOUND
				while(asciiNum > UPPER_BOUND) 
				{
					asciiNum -= RANGE;
				}
			
				//encryptCaesarText will be initialized with the char cast of asciiNum and the previous encryptBellasoText value
				encryptedBellasoText += (char)asciiNum;
			}
		}
		//return the value of encryptBellasoText
		return encryptedBellasoText;

	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		//Define string decryptedCaesarText and initialize to nothing, define an integer variable 
		String decryptedCaesarText = "";
		int ascciNum;
		
		//A for loop that assign the ascii value of each character minus the key value within the given plainText length
		for(int i = 0; i < encryptedText.length(); i++) 
		{
			 // asciiNum will be initialized to the ascii value of each character minus the value of the key
			ascciNum = encryptedText.charAt(i) - key;
			
			// A while loop to keep the value of asciiNum within the required RANGE if it's value if it's less than LOWER_BOUND
			while(ascciNum < LOWER_BOUND) 
			{
				ascciNum += RANGE;
			}
			
			//decryptedCaesarText will be initialized with the char cast of asciiNum and the previous encryptCaesarText value
			decryptedCaesarText += (char)ascciNum;
		}
		//return the value of decryptedCaesarText
		return decryptedCaesarText;

	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		/*Define a string encryptBellasoText and initialize to nothing, define an integer variable ,
		and define an integer variable strLength to hold bellasoStr length */
		String decryptedBellasoText = "";
		int asciiNum;
		int strLength =  bellasoStr.length();

		/*A for loop that assign the ascii value of each character in plainText minus the reminder of 
		each character and strLength of bellasoStr value within the given plainText length*/
		for(int i = 0; i < encryptedText.length(); i++) 
		{
			/* asciiNum will be initialized to the ascii value of each character in plainText plus the reminder 
			   of each character and strLength of bellasoStr value within the given plainText length*/
			asciiNum = encryptedText.charAt(i) - bellasoStr.charAt(i %strLength); //Using modulus here ensures the program does not go outside the bellasoStr length
			
			 /* asciiNum will be initialized to the ascii value of each character in plainText plus the reminder 
			  * of each character and strLength of bellasoStr value within the given plainText length*/
			while(asciiNum < LOWER_BOUND) 
			{
				asciiNum += RANGE;
			}
			
			//decryptedBellasoText will be initialized with the char cast of asciiNum and the previous encryptBellasoText value
			decryptedBellasoText += (char)asciiNum;
		}
		//return the value of decryptedBellasoText
		return decryptedBellasoText;
	}
	}
