/*
 * Class: CMSC203 
 * Instructor: Professor Khandan Monshi
 * Description: (Give a brief description for each Class)
 * Due: 2/23/2021
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: __________
*/

/**
 * @author Abdullah Shamsan
 */

import java.util.Scanner;

public class MovieDriver {

	public static void main(String[] args) {
		
		
		// Create a new object of type Scanner that reads from the keyboard
		Scanner keyboard=new Scanner(System.in);
	
		// Defining strings and variables that will be used
		String movieName, movieRating, userChoice;
		int soldTickets;
		
		// Create a new movie object
		Movie m1 = new Movie();

		
		// Start a do-while loop
		do
		{
			
			/* Prompt the user to enter the title of a movie 
			 * Read in the line that the user types
			 * Set the title in the movie object
			 */
			System.out.println("Enter the name of a movie");
			movieName=keyboard.nextLine();
			m1.setTitle(movieName);
			
			
			/*Prompt the user to enter the movie’s rating
			Read in the line that the user types
			Set the rating in the movie object
			 */
			System.out.println("Enter the rating of the movie");
			movieRating=keyboard.nextLine();
			m1.setRating(movieRating);
			
			
			/*Prompt the user to enter the number of tickets sold at a (unnamed) theater
     			Read in the integer that the user types
				Set the number of tickets sold in the movie object
			 */
			System.out.println("Enter the number of tickets sold for this movie");
			soldTickets=keyboard.nextInt();
			m1.setSoldTickets(soldTickets);
			
			// consume line
			keyboard.nextLine();
			
			
			// Print out the information using the movie’s toString method
			System.out.println(m1.toString());
			
			// prompt the user to know if they want to enter more movie names
			System.out.println("do you want to enter another? (y or n)");
			userChoice=keyboard.nextLine();
			
		}while(userChoice.equalsIgnoreCase("y") || (userChoice.equalsIgnoreCase("yes")) );
		//end of do-while loop
		
		System.out.println("Goodbye");
	}

}
