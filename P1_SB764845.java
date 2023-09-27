/* 
 * ICSI 201 -Introduction to Computer Science
 * Fall 2023
 * CSI 201- 8878
 * Samantha Bosch
 * SB764845
 * sbosch@albany.edu
 * 
 * This project will ask the user for input and convert the inputed integers into the date in the 21st century. It is a while loop that contains several do-while loops that holds the validation process.
 * 
 * The program was tested with
 * <1 9 20>
 * <13 32 99>
 * <0 0 0>
 * <2 29 20>
 * <2 29 19>
 * <   ...    >
 * 
*/
import java.util.Scanner;
public class P1_SB764845 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		boolean restart = true; 			// boolean for restarting the loop

		while (restart) 				// while loop for the dates
		{
			boolean dateCheck = false; 	// to validateCheck the input
			int day, month, year; 		// day month and year variables
			int numOfDays = 0; 			// initializes the number of days for each month
			String more; 				// string for repeating the loop
			
			do // do-while loop for getting the dateCheck, encloses entire loop

			{
				do // do-while loop for getting the month within the range
				{
					System.out.print("Enter a month from 1 to 12: "); // Prompts user for month
					month = scan.nextInt(); // gets month integer
					if (month >= 1 && month <= 12) // if statement that validates month
						dateCheck = true;
					else
						System.out.print("Invalid month. "); // Error message

				} while (!dateCheck);
					// if statement for number of days of each month
				if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)// months with 31 days																																											// days
				{
					numOfDays = 31; // number of days set to 31
				} 
				else if (month == 2) // statement for when month is February
				{
					numOfDays = 29; // number of days set to 29
				}
				else if (month == 4 || month == 6 || month == 9 || month == 11) // months with 30 days
				{
					numOfDays = 30; // number of days set to 30
				}
				
				do // do-while loop for when validating the day is in range of the month
				{
					System.out.print("Enter a day from 1 to " + numOfDays + ": "); // asking user for input
					day = scan.nextInt(); // gets day integer
					if (day >= 1 && day <= numOfDays) // if statement to validate the day is in range
					{
						dateCheck = true;
					} 
					else 
					{
						System.out.print("Invalid day. "); // Error message for day
						dateCheck = false;
					}

				} while (!dateCheck);
				dateCheck = false;
				
				if (month == 2 && day == 29) // if statement for February 29th 
				{
					System.out.println(" * We will be checking for a leap year in the next step* ");
					System.out.print("Enter a year from 1 to 99. ");
					year = scan.nextInt();
					do // do-while loop for leap year in February
					{
						if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) //validates the year is a leap year
						{
							dateCheck = true;
							System.out.println( "\n" + monthName(month) + " " + day + ", " + (2000 + year)+ "\n"); // outputs the date
							System.out.print("More? (Y/N) "); // asks user if they want to continue
							more = scan.next(); // get input
							System.out.print("\n");
							restart = false;
							if (more.equalsIgnoreCase("Y")) // restarts if input equals Y

								restart = true;

							else
								restart = false;

						} 
						else // for when it is not a leap year
						{
							
							dateCheck = false;
							do {			// do-while loop created for when it is not a leap year
									System.out.print("Not a leap year. So, enter a new day from 1 to 28. "); // Error message and re-prompts user
									day = scan.nextInt(); // gets new day input
									
									if (day >= 1 && day <= 28) // if statement for when day is in range of 1-28
									{
										dateCheck = true;
						
										do { // do-while loop to output the new date with day from 1-28
												if (dateCheck = true)  // if statement used to print new date when validated
												{
													String monthName = monthName(month); // calls the monthName function to get month name
													System.out.println("\n" + monthName + " " + day + ", " + (2000 + year)+ "\n"); // output of the date
													System.out.print("More? (Y/N) "); // prompts user to restart
													more = scan.next(); // get answer
													System.out.print("\n");
													restart = false;
													
													if (more.equalsIgnoreCase("Y")) // restart when answer equals Y or y
														restart = true;
													else
														restart = false;
												}				
											}while(!dateCheck);
									}
									else 
										dateCheck = false; // for when date is not valid
										
								
							  }while(!dateCheck); 
							
						}
						
					} while (!dateCheck);
					
					
				}
				else 
				{
						do { // do while loop to validateCheck the year
								System.out.print("Enter a year from 1 to 99: "); // prompts user for year
								year = scan.nextInt(); // gets year integer
								if (year >= 1 && year <= 99) // if statement to validate the year is in range
									dateCheck = true;
								else
									System.out.print("Invalid year. "); // Error message

							} while (!dateCheck);

						dateCheck = false;

						if (dateCheck = true) // prints the date when date is validated
						{
							String monthName = monthName(month); // calls monthName function to get name of month
							System.out.println("\n" + monthName + " " + day + ", " + (2000 + year) + "\n"); // outputs the formatted date
					
							System.out.print("More? (Y/N) "); // prompts user to restart
							more = scan.next(); // gets answer
							System.out.print("\n");
							restart = false;
							
							if (more.equalsIgnoreCase("Y")) // if statement to restart loop if answer equals yes
								restart = true;
							else
								restart = false;
						}
				} // end of else statement for when month and day is not equal to February 29th 

			} while (!dateCheck); // end of do-while loop

		} // end of while loop

	} // end of class

	public static String monthName(int month)// Function used to convert month integer to the name of the month
	{
		String[] nameOfMonth = // array of the months in the year
				{ "January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
						"November", "December" };
		if (month >= 1 && month <= 12) {
			return nameOfMonth[month - 1];
		}
		return "Invalid Month";
	} // end of class
}
