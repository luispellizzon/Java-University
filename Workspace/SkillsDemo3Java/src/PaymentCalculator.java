import java.text.DecimalFormat;
import java.util.Scanner;

public class PaymentCalculator {
	public static Scanner reader = new Scanner(System.in);
	public static DecimalFormat euroFormat = new DecimalFormat("€#,##0.00");
	private static char calculatePayment, employeeMenuChoice, menuChoice;
	private static boolean menuInput;
	private static String PPSN;

	public static void main(String[] args) {
		/* WELCOMING THE USER*/
		System.out.println("WELCOME TO OUR PAYMENT CALCULATOR SYSTEM!\n");
		
		/* DOWHILE LOOP TO RUN IF USER WANTS TO DO ANOTHER PAYMENT CHECK*/
		do {
			getPPSN();
			employeeMenu();
			
		} while (calculatePayment == 'y');
		reader.close();
		/* PRINT GOODBYE MESSAGE TO USER */
		System.out.println("\nTHANKS FOR USING OUR PAYMENT CALCULATOR SYSTEM =).");
	}
	
	private static void getPPSN() {
		System.out.print("Enter PPSN:");
		PPSN = reader.next();
		
		checkPPSNPattern(PPSN);
	}
	
	private static void employeeMenu() {
		System.out.print("\nPlease, Select One Of The Choices Bellow.\nCalculate Payment For:\nA)Principal\nB)Teacher\n");
		menuInput = false;

		/* WHILE INPUT IS NOT FALSE KEEP ASKING 
		 * USER TO ENTER THE INPUT DESIRED*/
		while (menuInput != true) {
			try {
				System.out.print("Enter Choice:");
				menuChoice = reader.next().toLowerCase().charAt(0);
				
				if(menuChoice == 'a' || menuChoice == 'b') {
					employeeMenuChoice = menuChoice;
					menuInput = true;
				} else {
					throw new Exception("Please, Enter Only A (Pricipal) or B (Teacher)!\n");
				}
			} catch (Exception e) {
				/* GET ERROR MESSAGE AND PRINT
				 * KEEP THE VARIABLE FALSE TO RUN AGAIN THE WHILE LOOP*/
				System.out.println(e.getMessage());
				menuInput = false;
			}
		}
		System.out.println(employeeMenuChoice);
		
		
	}

	
	private static void checkPPSNPattern(String ppsnInput) {
		
	}
	

}
