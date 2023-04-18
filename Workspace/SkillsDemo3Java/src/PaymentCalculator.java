import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaymentCalculator {
	public static Scanner reader = new Scanner(System.in);
	public static DecimalFormat euroFormat = new DecimalFormat("€###,##0.00");
	private static char calculatePayment, menuChoice;
	private static String PPSN;

	public static void main(String[] args) {
		/* WELCOMING THE USER*/
		System.out.printf("%-20s%s%s",Styles.PURPLE_BOLD, "WELCOME TO OUR PAYMENT CALCULATOR SYSTEM!", Styles.RESET_STYLE);

		/* DOWHILE LOOP TO RUN IF USER WANTS TO DO ANOTHER PAYMENT CHECK*/
		do {
			getAndCheckPPSNInput();
			showEmployeeMenuOptionsAndGetUserInput();
			Employee employee = new Employee();
			switch(menuChoice) {
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
		System.out.printf("\n%s%s%s",Styles.PURPLE_BOLD, "THANKS FOR USING OUR PAYMENT CALCULATOR SYSTEM =).", Styles.RESET_STYLE);
	}
	
	private static void getAndCheckPPSNInput() {

		boolean PPSNInput = false;
		while (PPSNInput != true) {
			try {
				System.out.print("\nEnter PPSN: ");
				PPSN = reader.next();
				
				if(!checkPPSNPattern(PPSN)) {
					throw new Exception(Styles.ERROR_MESSAGE_COLOR + "Please, PPSN Should Be 7 Digits Followed By a Letter!\n" + Styles.RESET_STYLE);
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
		System.out.print("\nPlease, Select One Of The Choices Bellow.\nCalculate Payment For:\nA)Principal\nB)Teacher\n\n");
		boolean menuInput = false;

		/* WHILE INPUT IS NOT FALSE KEEP ASKING 
		 * USER TO ENTER THE INPUT DESIRED*/
		while (menuInput != true) {
			try {
				System.out.print("Enter Choice: ");
				menuChoice = reader.next().toLowerCase().charAt(0);
				
				if(menuChoice == 'a') {
					menuInput = true;
				} else if(menuChoice == 'b'){
					while (menuInput != true) {
						try {
							System.out.print("\nIs The Teacher Full-Time(F) Or Part-Time(P)? Enter F or P: ");
							menuChoice = reader.next().toLowerCase().charAt(0);
							if(menuChoice == 'f' || menuChoice == 'p') {
								menuInput = true;
							} else {
								throw new Exception(Styles.ERROR_MESSAGE_COLOR + "Please, Enter Only F (Full-Time) or P (Part-Time)!" + Styles.RESET_STYLE);
							}
						}catch(Exception e) {
							/* GET ERROR MESSAGE AND PRINT
							 * KEEP THE VARIABLE FALSE TO RUN AGAIN THE WHILE LOOP*/
							System.out.println(e.getMessage());
							menuInput = false;
						}
					}
				}else {
					throw new Exception(Styles.ERROR_MESSAGE_COLOR + "Please, Enter Only A (Principal) or B (Teacher)!\n" + Styles.RESET_STYLE);
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
	    return isPPSN;
	    /*if(isPPSN) {
			return true;
		} else {
			return false;
		}*/
	}
	
	private static void askAndCheckForAnotherCalculation() {
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
				System.out.println(Styles.ERROR_MESSAGE_COLOR + "Please, Enter Only Y (YES) Or N (NO)!"+ Styles.RESET_STYLE);
				reader.nextLine();
				userInput = false;
			}
		}
	}
	
}


