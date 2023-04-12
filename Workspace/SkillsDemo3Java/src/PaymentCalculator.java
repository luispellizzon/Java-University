import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaymentCalculator {
	public static Scanner reader = new Scanner(System.in);
	public static DecimalFormat euroFormat = new DecimalFormat("€#,##0.00");
	private static char calculatePayment, employeeMenuChoice, menuChoice;
	private static boolean menuInput, PPSNInput;
	private static String PPSN;

	public static void main(String[] args) {
		/* WELCOMING THE USER*/
		System.out.println("WELCOME TO OUR PAYMENT CALCULATOR SYSTEM!\n");
		
		/* DOWHILE LOOP TO RUN IF USER WANTS TO DO ANOTHER PAYMENT CHECK*/
		do {
			getPPSN();
			showEmployeeMenuOptionsAndGetUserInput();
			Employee employee = new Employee();
			employee.setPPSN(PPSN);
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
			
			
		} while (calculatePayment == 'y');
		reader.close();
		/* PRINT GOODBYE MESSAGE TO USER */
		System.out.println("\nTHANKS FOR USING OUR PAYMENT CALCULATOR SYSTEM =).");
	}
	
	private static void getPPSN() {
		PPSNInput = false;
		while (PPSNInput != true) {
			try {
				System.out.print("Enter PPSN:");
				PPSN = reader.next();
				
				if(!checkPPSNPattern(PPSN)) {
					throw new Exception("Please, PPSN Should Be 7 Digits Followed By a Letter!\n");
				} else {
					PPSNInput = true;
				}
			} catch (Exception e) {
				/* GET ERROR MESSAGE AND PRINT
				 * KEEP THE VARIABLE FALSE TO RUN AGAIN THE WHILE LOOP*/
				System.out.println(e.getMessage());
				PPSNInput = false;
			}
		}
	}
	
	// show employee menu and get input
	private static void showEmployeeMenuOptionsAndGetUserInput() {
		System.out.print("\nPlease, Select One Of The Choices Bellow.\nCalculate Payment For:\nA)Principal\nB)Teacher\n");
		menuInput = false;

		/* WHILE INPUT IS NOT FALSE KEEP ASKING 
		 * USER TO ENTER THE INPUT DESIRED*/
		while (menuInput != true) {
			try {
				System.out.print("Enter Choice:");
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
								throw new Exception("Please, Enter Only F (Full-Time) or P (Part-Time)!");
							}
						}catch(Exception e) {
							/* GET ERROR MESSAGE AND PRINT
							 * KEEP THE VARIABLE FALSE TO RUN AGAIN THE WHILE LOOP*/
							System.out.println(e.getMessage());
							menuInput = false;
						}
					}
				}else {
					throw new Exception("Please, Enter Only A (Principal) or B (Teacher)!\n");
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
	

}
