import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaymentCalculator {
	public static Scanner reader = new Scanner(System.in);
	public static DecimalFormat euroFormat = new DecimalFormat("€###,##0.00");
	private static char calculatePayment, employeeMenuChoice, menuChoice;
	private static boolean menuInput, PPSNInput;
	private static String PPSN;

	public static void main(String[] args) {
		String PURPLE_BOLD = "\033[1;35m";
		String RESET_STYLE = "\u001b[0m";
		/* WELCOMING THE USER*/
		System.out.printf("%-20s%s%s",PURPLE_BOLD, "WELCOME TO OUR PAYMENT CALCULATOR SYSTEM!", RESET_STYLE);

		/* DOWHILE LOOP TO RUN IF USER WANTS TO DO ANOTHER PAYMENT CHECK*/
		do {
			getAndCheckPPSNInput();
			showEmployeeMenuOptionsAndGetUserInput();
			Employee employee = new Employee();
			switch(employeeMenuChoice) {
			case 'a':
				employee = new Principal();
				((Principal) employee).getNumberOfTeachers();				
				break;
			case 'f':
				employee = new FullTime();
				((FullTime) employee).getAbsentDays();
				((FullTime) employee).getScalePoints();
				((FullTime) employee).getAmmountOfExamScriptsDone();
				break;
			case 'p':
				employee = new PartTime();
				((PartTime) employee).getHoursWorked();
				((PartTime) employee).getScalePoints();
				((PartTime) employee).getAmmountOfExamScriptsDone();
				break;
			}
			employee.setPPSN(PPSN);
			employee.calculateGrossPay();
			employee.calculatePRSI();
			employee.calculateTax();
			employee.calculateNetPay();
			employee.displayPaymentDetails();

			askAndCheckForAnotherCalculation();
			
		} while (calculatePayment == 'y');
		reader.close();
		/* PRINT GOODBYE MESSAGE TO USER */
		System.out.printf("\n%s%s%s",PURPLE_BOLD, "THANKS FOR USING OUR PAYMENT CALCULATOR SYSTEM =).", RESET_STYLE);
	}
	
	private static void getAndCheckPPSNInput() {
		String RED = "\u001B[31m";
		String RESET_STYLE = "\u001b[0m";
		PPSNInput = false;
		while (PPSNInput != true) {
			try {
				System.out.print("\nEnter PPSN: ");
				PPSN = reader.next();
				
				if(!checkPPSNPattern(PPSN)) {
					throw new Exception(RED + "Please, PPSN Should Be 7 Digits Followed By a Letter!\n" + RESET_STYLE);
				} else {
					PPSNInput = true;
				}
			} catch (Exception e) {
				/* GET ERROR MESSAGE AND PRINT
				 * KEEP THE VARIABLE FALSE TO RUN AGAIN THE WHILE LOOP*/
				System.out.println(e.getMessage());
				reader.nextLine();
				PPSNInput = false;
			}
		}
	}
	
	// show employee menu and get input
	private static void showEmployeeMenuOptionsAndGetUserInput() {
		String RED = "\u001B[31m";
		String RESET_STYLE = "\u001B[0m";
		System.out.print("\nPlease, Select One Of The Choices Bellow.\nCalculate Payment For:\nA)Principal\nB)Teacher\n\n");
		menuInput = false;

		/* WHILE INPUT IS NOT FALSE KEEP ASKING 
		 * USER TO ENTER THE INPUT DESIRED*/
		while (menuInput != true) {
			try {
				System.out.print("Enter Choice: ");
				menuChoice = reader.next().toLowerCase().charAt(0);
				
				if(menuChoice == 'a') {
					employeeMenuChoice = menuChoice;
					menuInput = true;
				} else if(menuChoice == 'b'){
					while (menuInput != true) {
						try {
							System.out.print("\nIs The Teacher Full-Time(F) Or Part-Time(P)? Enter F or P: ");
							menuChoice = reader.next().toLowerCase().charAt(0);
							if(menuChoice == 'f' || menuChoice == 'p') {
								employeeMenuChoice = menuChoice;
								menuInput = true;
							} else {
								throw new Exception(RED + "Please, Enter Only F (Full-Time) or P (Part-Time)!" + RESET_STYLE);
							}
						}catch(Exception e) {
							/* GET ERROR MESSAGE AND PRINT
							 * KEEP THE VARIABLE FALSE TO RUN AGAIN THE WHILE LOOP*/
							System.out.println(e.getMessage());
							menuInput = false;
						}
					}
				}else {
					throw new Exception(RED + "Please, Enter Only A (Principal) or B (Teacher)!\n" + RESET_STYLE);
				}
			} catch (Exception e) {
				/* GET ERROR MESSAGE AND PRINT
				 * KEEP THE VARIABLE FALSE TO RUN AGAIN THE WHILE LOOP*/
				System.out.println(e.getMessage());
				menuInput = false;
			}
		}
	}

	// check ppsn pattern
	private static boolean checkPPSNPattern(String ppsnInput) {
		Pattern PPSNpattern = Pattern.compile("^\\d{7}[A-Z]{1}$", Pattern.CASE_INSENSITIVE);
	    Matcher matcher = PPSNpattern.matcher(ppsnInput);
	    boolean isPPSN = matcher.find();
		if(isPPSN) {
			return true;
		} else {
			return false;
		}
	}
	
	private static void askAndCheckForAnotherCalculation() {
		String RED = "\u001B[31m";
		String RESET_STYLE = "\u001B[0m";
		boolean userInput = false;
		while(userInput != true) {
			try {
				System.out.print("\nWould You Like To Calculate Any Further Wages? (Y/N): ");
				calculatePayment = reader.next().toLowerCase().charAt(0);
				if(calculatePayment == 'y' || calculatePayment == 'n') {
					userInput = true;
				} else {
					throw new Exception();
				}
			}
			catch(Exception e) {
				System.out.println(RED + "Please, Enter Only Y (YES) Or N (NO)!"+ RESET_STYLE);
				reader.nextLine();
				userInput = false;
			}
		}
	}
	
}
