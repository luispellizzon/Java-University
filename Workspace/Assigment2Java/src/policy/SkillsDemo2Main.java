package policy;
/*@author LUIS HENRIQUE DE ANDRADE PELLIZZON
 *@desc HCI HEALTHCARE POLICY QUOTATION SYSTEM MAIN PROGRAM
 *@date 22/03/2023
 */
import java.util.Scanner;
import java.text.DecimalFormat;
public class SkillsDemo2Main {
	/* SETTING GLOBAL VARIABLES */
	private static char quotation;
	private static boolean quotationInput;
	public static Scanner reader = new Scanner(System.in);
	public static DecimalFormat euroFormat = new DecimalFormat("€#,##0.00");
			
	public static void main(String[] args) {
		/* WELCOMING THE USER*/
		System.out.println("WELCOME TO OUR HEALTH POLICY QUOTATION SYSTEM!\n");
		
		/* DOWHILE LOOP TO RUN IF USER WANTS TO DO ANOTHER QUOTATION*/
		do {
			/* INSTANTIATE NEW POLICY*/
			HealthPolicy policy = new HealthPolicy ();
			/*CALL READAGE() TO READ USER'S AGE*/
			policy.readAge();
			
			/* CALL GETAGE() TO GET USER'S AGE 
			 * AND COMPARE WITH IT IS GREATER THAN OR EQUAL TO 18*/
			if (policy.getAge() >= 18) {
				
				/* CALL READNAME() TO READ USER'S NAME */
				policy.readName();
				
				/* CALL READNUMDEPENDANTS() TO READ AMMOUNT OF 
				 * DEPENDANTS THE USER WANTS TO ADD IN THE POLICY */
				policy.readNumDependents();
				
				/* CALL GETDEPENDANTNUMBER() TO GET AMMOUNT OF 
				 * DEPENDANTS THE USER WANTS TO ADD IN THE POLICY */
				if(policy.getDependantNumber() > 0) {
					/* CALL CREATEDEPENDANTS() TO READ USER'S DEPENDANTS 
					 * INFORMATION AND CREATE EACH DEPENDANT */
					policy.createDependants();
				}
				
				/* CALL ROOMTYPE() TO ASK IF THE USER WANTS 
				 * TO ADD INPATIENT CARE AND CHANGE TO A PRIVATE ROOM */
				policy.roomType();
				
				/* CALL EXTRACARES() TO ASK IF THE USER WANTS 
				 * TO ADD ADDITIONAL EXTRA CARES */
				policy.extraCares();
				
				/* CALL PRINTPOLICYDETAILS() TO PRINT USER'S POLICY DETAILS 
				 * GATHERED DURING THE QUOTATION */
				policy.printPolicyDetails();
				
			} else {
				/* PRINT FOLLOWING IF GETAGE() RETURNS A NUMBER UNDER 18 */
				System.out.println("\nSorry, You Must Be Over 18 to Get a Quotation!");
			}
			
			
			/* CALL CHECKQUOTATIONINPUT() TO ASK 
			 * IF USER WANTS TO DO ANOTHER QUOTATION */
			checkQuotationInput(); 
			
			/* IF USER INPUT IS EQUAL TO y 
			 * KEEP RUNNING THE CODE */
		} while (quotation == 'y');
		reader.close();
		/* PRINT GOODBYE MESSAGE TO USER */
		System.out.println("\nTHANKS FOR USING OUR HEALTH POLICY QUOTATION SYSTEM =).");
	}
	
	/* CHECK USER'S INPUT TO BE ALWAYS 'y' OR 'n'*/
	private static void checkQuotationInput() {
		quotationInput = false;
		
		/* WHILE INPUT IS NOT FALSE KEEP ASKING 
		 * USER TO ENTER THE INPUT DESIRED*/
		while (quotationInput != true) {
			try {
				/* ASK IF USER WANTS TO DO ANOTHER QUOTATION */
				System.out.print("\nDo you want to get another quote? Y/N : ");
				quotation = reader.next().toLowerCase().charAt(0);
				
				/* IF INPUT IS ONE OF THE FOLLOWING, 
				 * CHANGE VARIABLE TO BE TRUE AND SKIP WHILE LOOP 
				 * ELSE PRINT A WARNING MESSAGE */
				if(quotation == 'y' || quotation == 'n') {
					quotationInput = true;
				} else {
					throw new Exception("Please, Enter Only Y (YES) or N (NO) to Get a Quotation!\n");
				}
			} catch (Exception e) {
				/* GET ERROR MESSAGE AND PRINT
				 * KEEP THE VARIABLE FALSE TO RUN AGAIN THE WHILE LOOP*/
				System.out.println(e.getMessage());
				quotationInput = false;
			}
		}
	}
}
