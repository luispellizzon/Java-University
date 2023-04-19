import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaymentCalculator {
	/*Instantiate Scanner and DecimalFormat*/
	public static Scanner reader = new Scanner(System.in);
	public static DecimalFormat euroFormat = new DecimalFormat("€###,##0.00");
	private static char calculatePayment, menuChoice;
	private static String PPSN;

	public static void main(String[] args) {
		/* WELCOMING THE USER*/
//		System.out.printf("%-20s%s%s",Styles.PURPLE_BOLD, "WELCOME TO OUR PAYMENT CALCULATOR SYSTEM!", Styles.RESET_STYLE);
		System.out.println("\u2503");
		System.out.println("\u2503");
		System.out.println("\u2503");
		System.out.println("\u2503");

		/* DOWHILE LOOP TO RUN IF USER WANTS TO DO ANOTHER PAYMENT CHECK*/
		do {
			/*ASK USER FOR PPSN AND CHECK*/
			getAndCheckPPSNInput();
			/*DISPLAY A MENU WITH OPTIONS TO CHOOSE PRINCIPAL OR TEACHER
			 * AND GET INPUT FROM USER */
			showEmployeeMenuOptionsAndGetUserInput();
			/*INSTANTIATE A NEW EMPLOYEE*/
			Employee employee = new Employee();
			/*SWITCH CASE TO DECIDE IF EMPLOYEE IS 
			 * PRINCIPAL, TEACHER FULL-TIME OR PART-TIME*/
			switch(menuChoice) {
			case 'a':
				/*MAKE EMPLOYEE TO BE PRINCIPAL*/
				employee = new Principal();
				/*USE "DOWNCASTING" WHEN CALLING A METHOD SO THE COMPILER WILL
				 * RECOGNIZE THAT THE employee VARIABLE IS A PRINCIPAL CLASS
				 * EXTENDING FROM EMPLOYEE. THIS WAY WE CAN USE
				 * ITS METHODS*/
				/*GET NUMBER OF TEACHERS THE PRINCIPAL HAS WORKING FOR HIM*/
				((Principal) employee).getNumberOfTeachers();	
				break;
			case 'f':
				/*MAKE EMPLOYEE TO BE FULLTIME TEACHER*/
				employee = new FullTime();
				/*USE "DOWNCASTING" WHEN CALLING A METHOD SO THE COMPILER WILL
				 * RECOGNIZE THAT THE employee VARIABLE IS A FULLTIME TEACHER
				 * CLASS EXTENDING FROM EMPLOYEE. THIS WAY WE CAN USE
				 * ITS METHODS*/
				/*GET DAYS TEACHER WERE ABSENT*/
				((FullTime) employee).getAbsentDays();
				/*GET POINTS ON SCALE*/
				((FullTime) employee).getScalePoints();
				/*GET AMOUNT OF EXAMS CORRECTED BY TEACHER*/
				((FullTime) employee).getAmountOfExamScriptsDone();
				break;
			case 'p':
				/*MAKE EMPLOYEE TO BE PART-TIME TEACHER*/
				employee = new PartTime();
				/*USE "DOWNCASTING" WHEN CALLING A METHOD SO THE COMPILER WILL
				 * RECOGNIZE THAT THE employee VARIABLE IS A PART-TIME TEACHER 
				 * CLASS EXTENDING FROM EMPLOYEE. THIS WAY WE CAN USE
				 * ITS METHODS*/
				/*GET HOURS WORKED BY THE TEACHER*/
				((PartTime) employee).getHoursWorked();
				/*GET POINTS ON SCALE*/
				((PartTime) employee).getScalePoints();
				/*GET AMOUNT OF EXAMS CORRECTED BY TEACHER*/
				((PartTime) employee).getAmountOfExamScriptsDone();
				break;
			}
			/*SET EMPLOYEE'S PPSN*/
			employee.setPPSN(PPSN);
			/*CALCULATE EMPLOYEE'S GROSSPAY*/
			employee.calculateGrossPay();
			/*CALCULATE EMPLOYEE'S PRSI*/
			employee.calculatePRSI();
			/*CALCULATE EMPLOYEE'S TAX*/
			employee.calculateTax();
			/*CALCULATE EMPLOYEE'S TAKE-HOME PAY (NETPAY)*/
			employee.calculateNetPay();
			/*DISPLAY PROFESSIONAL PAYMENT DETAILS (PAYSLIP)*/
			employee.displayPaymentDetails();

			/*ASK IF USER WANTS TO SEE ANY FURTHER PAYMENTS*/
			askAndCheckForAnotherCalculation();
			
			/*RUN THE LOOP IF USER INPUT MEETS THE EXPRESSION IN PARENTHESIS*/
		} while (calculatePayment == 'y');
		/* CLOSE SCANNER TO PREVENT MEMORY LEAK */
		reader.close();
		/* PRINT GOODBYE MESSAGE TO USER */
		System.out.printf("\n%s%s%s",Styles.PURPLE_BOLD, "THANKS FOR USING OUR PAYMENT CALCULATOR SYSTEM =).", Styles.RESET_STYLE);
	}
	
	/* GET PPSN INPUT FROM USER AND CHECK IF MEETS THE REQUIREMENTS*/
	private static void getAndCheckPPSNInput() {
		/* WHILE LOOP WITH TRY CATCH 
		 * TO RE-PROMPT USER IF THE INPUT IS INCORRECT */
		boolean PPSNInput = false;
		while (PPSNInput != true) {
			try {
				System.out.print("\nEnter PPSN: ");
				PPSN = reader.next();
				
				/* CALL chackPPSNPattern FUNCTION, AND PASS PPSN INPUT TO CHECK
				 * IF IT MEETS THE REQUIREMENTS (7 DIGITS FOLLOWED BY A LETTER*/
				if(!checkPPSNPattern(PPSN)) {
					/* GIVE RED COLOR TO REPRESENT THAT IS A ERROR MESSAGE */
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
	
	/* SHOW MENU OPTIONS AND CHECK IF USER INPUT IS CORRECT */
	private static void showEmployeeMenuOptionsAndGetUserInput() {
		System.out.print("\nPlease, Select One Of The Choices Bellow.\nCalculate Payment For:\nA)Principal\nB)Teacher\n\n");
		/* WHILE LOOP WITH TRY CATCH 
		 * TO RE-PROMPT USER IF THE INPUT IS INCORRECT */
		boolean menuInput = false;
		while (menuInput != true) {
			try {
				System.out.print("Enter Choice: ");
				menuChoice = reader.next().toLowerCase().charAt(0);
				
				if(menuChoice == 'a') {
					menuInput = true;
				} else if(menuChoice == 'b'){
					/* IF FIRST INPUT IS CORRECT, RUN THE SECOND
					 * WHILE LOOP WITH TRY CATCH TO RE-PROMPT 
					 * USER IF THE INPUT IS INCORRECT */
					while (menuInput != true) {
						try {
							System.out.print("\nIs The Teacher Full-Time(F) Or Part-Time(P)? Enter F or P: ");
							menuChoice = reader.next().toLowerCase().charAt(0);
							if(menuChoice == 'f' || menuChoice == 'p') {
								menuInput = true;
							} else {
								/* GIVE RED COLOR TO REPRESENT THAT IS A ERROR MESSAGE */
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
					/* GIVE RED COLOR TO REPRESENT THAT IS A ERROR MESSAGE */
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

	/* PPSN PATTERN CHECKER USING REGEX  */
	private static boolean checkPPSNPattern(String ppsnInput) {
		/* CREATE THE REQUIREMENT'S PPSN PATTERN (7 DIGITS FOLLOWED BY A LETTER) */
		Pattern PPSNpattern = Pattern.compile("^\\d{7}[A-Z]{1}$", Pattern.CASE_INSENSITIVE);
		/* MATCHER OBJECT TO USE THE ppsnInput */
	    Matcher matcher = PPSNpattern.matcher(ppsnInput);
	    /* VARIABLE TO RETURN TRUE OR FALSE ACCORDING TO 
	     * ppsnInput PARAMETER */
	    boolean isPPSN = matcher.find();
	    return isPPSN;
	}
	
	/* CHECK IF USER WANTS TO CALCULATE ANY FURTHER PAYMENT  */
	private static void askAndCheckForAnotherCalculation() {
		/* WHILE LOOP WITH TRY CATCH 
		 * TO RE-PROMPT USER IF THE INPUT IS INCORRECT */
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
				/* GIVE RED COLOR TO REPRESENT THAT IS A ERROR MESSAGE */
				System.out.println(Styles.ERROR_MESSAGE_COLOR + "Please, Enter Only Y (YES) Or N (NO)!"+ Styles.RESET_STYLE);
				reader.nextLine();
				userInput = false;
			}
		}
	}
}


