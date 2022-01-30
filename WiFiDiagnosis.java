/*
 * Class: CMSC203 
 * Instructor: Professor Khandan Monshi
 * Description: an application that will step through some possible problems to restore internet connectivity. 
 * Due: 2/09/2021
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Abdullah Shamsan
*/

import java.util.Scanner;
 //hi
public class WiFiDiagnosis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Defining a string called userCoice to hold the user answer.
		String userChoice;
		
		
		// Display a message showing the program description 
		System.out.println("If you have a problem with internet connectivity, this WiFi"
				+ "Diagnosis might work.\n");
		
		
		// Program will display the first step and ask if it worked or not
		
		System.out.println("First Step: reboot your computer");
		System.out.println("Are you able to connect with the internet? (yes or no)");
		
		
		// Creating a new scanner.
		Scanner userInput = new Scanner(System.in);
		
		
		// Assign the user's output to the string userChoice
		userChoice = userInput.next();
		
		
		// If the user answer was yes the program will end
		if (userChoice.equals("yes"))
		{
			System.out.println("Rebooting your computer seemed to work");
		}
		
		
		// If the user answers no the program will proceed to the next step
		else if (userChoice.equals("no"))
		{
			// Program will display the second step and ask if it worked or not
			
			System.out.println("Second step: reboot your router\n"
					+ "Now are you able to connect to the internet? (yes or no)");
			
			userChoice = userInput.next();
			
			// If the user answer was yes the program will end
			if (userChoice.equals("yes"))
			{
				System.out.println("Rebooting your router seemed to work");
			}
			
			
			// If the user answers no the program will proceed to the next question
			else if (userChoice.equals("no"))
			{
				// Program will display the third step and ask if it worked or not
				
				System.out.println("Third step: Make sure the cables to your router are plugged"
						+ "in firmly and your router is getting power\n"
						+ "Now are you able to connect to the internet? (yes or no)");
				
				userChoice = userInput.next();
				
				// If the user answer was yes the program will end
				if (userChoice.equals("yes"))
				{
					System.out.println("Checking the router's cables seemed to work");
				}
				
				
				// If the user answers no the program will proceed to the next question
				else if (userChoice.equals("no"))
				{
					// Program will display the fourth step and ask if it worked or not
					System.out.println("Fourth step: move your computer closer to your router\n"
							+ "Now are you able to connect to the internet? (yes or no)");
					
					userChoice = userInput.next();
					
					// If the user answer was yes the program will end
					if (userChoice.equals("yes"))
					{
						System.out.println("Connecting your computer seemed to work");
					}
					
					
					// If the user answers no the program will proceed to the next question
					else if (userChoice.equals("no"))
					{
						// Program will display the last step and will end
						System.out.println("Fifth step: reboot contact your ISP\n"
								+ "Make sure your ISP is hooked up to your router");
						
						
					}
				}
			}
		}
		
		userInput.close();
		
	}

}
