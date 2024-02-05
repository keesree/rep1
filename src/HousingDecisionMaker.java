// the new change
// changes
import java.util.Scanner;
// this is the change
public class HousingDecisionMaker {

	static double points = 0;

	public static void main(String[] args) {
		// Initiate scanner
		Scanner scnr = new Scanner(System.in);

		// this is the change 
		// Initiate variables

		String distanceToCampus;

		// Ask user a multiple-choice question
		System.out.println("How far do you live from campus? (Choose A, B, or C)");
		System.out.print("(A) Out of State or Further\n" + "(B) Out of Local County\n" + "(C) Within Local County\n");

		// Scan user's input
		loop: while (true) {
			// System.out.print("Your Answer: ");
			distanceToCampus = scnr.next();

			// Add points according to answer
			switch (distanceToCampus) {
			case "A":
				points += 5;
				break loop;
			case "B":
				points += 3;
				break loop;

			case "C":
				points += 1;
				break loop;

			// If user does not input A, B, or C, make them input a letter again
			default:
				System.out.println("Invalid input. Please input 'A', 'B', or 'C.'");
				continue loop;
			}

		}

		boolean disabledOrNot = false;

		// Ask question to user
		System.out.print("\nDo you have a disability? ");
		System.out.println("Answer Yes or No.");

		// Get user input
		String answer = scnr.next();

		// Make sure user answers yes or no
		while (!(answer.equalsIgnoreCase("Yes") || answer.equalsIgnoreCase("No"))) {
			System.out.println("Invalid input. Please enter Yes or No.");
			answer = scnr.next();
		}

		// Check if user said yes or no and assign boolean value
		if (answer.equalsIgnoreCase("Yes")) {
			disabledOrNot = true;
		} else if (answer.equalsIgnoreCase("No")) {
			disabledOrNot = false;
		}

		// If user said yes then points increase by 4, otherwise points do not increase
		if (disabledOrNot) {
			points += 4;
		} else {
			points += 0;
		}

		System.out.println("\nWhat is your income? (Input a number)");

		while (true) {
			try {
				int income = scnr.nextInt();
				// add a minimum range of 17?
				if (income <= 30000) {
					points += 4;
				}

				else if (income <= 65000) {
					points += 3;
				}

				else if (income > 90000) {
					points += 2;
				} else {

					points += 1;

				}
				break;
			} catch (Exception e) {
				System.out.println("Invalid Input. Please input a valid integer.");
				scnr.next();
				continue;
			}
		}

		boolean hasJob = false;

		// Ask question to user
		System.out.println("\nDo you have an on campus job? Answer Yes or No.");

		// Get user input
		answer = scnr.next();

		// Make sure user answers yes or no
		while (!(answer.equalsIgnoreCase("Yes") || answer.equalsIgnoreCase("No"))) {
			System.out.println("Invalid input. Please enter Yes or No.");
			answer = scnr.next();
		}

		// Check if user said yes or no and assign boolean value
		if (answer.equalsIgnoreCase("Yes")) {
			hasJob = true;
		} else if (answer.equalsIgnoreCase("No")) {
			hasJob = false;
		}
		// If user said yes then points increase by 2.5, otherwise points do not
		// increase
		if (hasJob) {
			points += 2.5;
		} else {
			points += 0;
		}

		System.out.println("\nWhat is your age? (Input a number)");

		while (true) {
			try {
				int age = scnr.nextInt();
				// add a minimum range of 17?
				if (age <= 20) {
					points += 3;
				}

				else if (age <= 30) {
					points += 2;
				}

				else if (age > 30) {
					points += 1;
				}
				break;
			} catch (Exception e) {
				System.out.println("Invalid Age. Please input a valid integer.");
				scnr.next();
				continue;
			}
		}

		// add a minimum range of 17?

		double firstYearPoint = 2;
		double secondYearPoint = 1.5;
		double thirdYearPoint = 1;
		double fourthYearPoint = 0.5;

		// ask user for current Student year

		System.out.println("\nCurrently what college year are you in? (Input a number)");

		while (true) {
			try {
				int output = scnr.nextInt();
				// add a minimum range of 17?
				if (output == 1) {

					points += firstYearPoint;

				}

				else if (output == 2) {
					points += secondYearPoint;

				} else if (output == 3) {
					points += thirdYearPoint;

				} else if (output >= 4) {

					points += fourthYearPoint;
				}
				break;
			} catch (Exception e) {
				System.out.println("Invalid Input. Please input a valid integer.");
				scnr.next();
				continue;
			}
		}

		System.out.println("\nYou have a total of " + points + " housing points.");

	}

}
