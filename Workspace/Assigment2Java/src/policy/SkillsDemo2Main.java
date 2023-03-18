package policy;
import java.util.Scanner;

public class SkillsDemo2Main {
	
	private static char quotation;
	private static boolean quotationInput;
	public static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		
		
		
		do {
			HealthPolicy policy = new HealthPolicy ();
			policy.readAge();
			
			if (policy.getAge() >= 18) {
				policy.readName();			
				policy.readNumDependents();
				
				if(policy.getDependantNumber() > 0) {
					policy.createDependants();
					policy.getDependants();
				}
				policy.roomType();
				policy.extraCares();
				policy.printPolicyDetails();
				
			} else {
				System.out.println("\nSorry, You Must Be Over 18 to Get a Quotation.");
			}
			
			
			
			checkQuotationInput(); //QUOTATION
			
		} while (quotation == 'y');
		
		System.out.println("\nTHANKS FOR USING OUR HEALTH POLICY QUOTATION SYSTEM =).");
	}
	
	private static void checkQuotationInput() {
		quotationInput = false;
		
		while (quotationInput != true) {
			try {
				System.out.println("\n\tDo you want to get another quote? Y/N ");
				quotation = reader.next().toLowerCase().charAt(0);
				
				if(quotation == 'y' || quotation == 'n') {
					quotationInput = true;
				} else {
					throw new Exception();
				}
					
			} catch (Exception e) {
				System.out.println("Please, Enter Only Y (YES) or N (NO) to Get a Quotation!\n");
				quotationInput = false;
			}
		}
	}
}
