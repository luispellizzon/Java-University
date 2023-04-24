
public class Principal extends Employee {
	private int teachersNumber;
	private float principalBonus;
	/* CONSTRUCTOR INITIALIZING PRINCIPAL'S SALARY */
	public Principal(){
		setSalary(5000.00f);
	}
	
	/* GET NUMBER OF TEACHERS AND CALCULATE ADDITIONAL PAYMENT */
	protected void getNumberOfTeachers() {
		/* WHILE LOOP WITH TRY CATCH 
		 * TO RE-PROMPT USER IF THE INPUT IS INCORRECT */
		boolean teachersNumberInput = false;
		while(teachersNumberInput != true) {
			try {
				System.out.print("\nEnter Number Of Teachers In The School: ");
				teachersNumber = PaymentCalculator.reader.nextInt();
				/* CALL addAdditionalPayment FUNCTION TO SET 
				 * HOW MUCH ADDITIONAL PAYMENT THE PRINCIPAL WILL
				 * GET ACCORDING TO THE AMOUNT OF TEACHERS WORKING */
				if(teachersNumber < 0) {
					throw new Exception();
				}
				if(teachersNumber >= 200) {
					principalBonus = 1196.67f;
					addAdditionalPayment(principalBonus);
				}
				else if(teachersNumber >= 100){
					principalBonus = 1019.83f;
					addAdditionalPayment(principalBonus);
				}
				else if(teachersNumber >= 10) {
					principalBonus = 869.33f;
					addAdditionalPayment(principalBonus);
				}
				else {
					principalBonus = 775.83f;
					addAdditionalPayment(principalBonus);
				}
				teachersNumberInput = true;
			} catch(Exception e){
				/* GIVE RED COLOR TO REPRESENT THAT IS A ERROR MESSAGE */
				System.out.println(Styles.ERROR_MESSAGE_COLOR + "Please, Enter 0 Or A Positive Whole Number!" + Styles.RESET_STYLE);
				PaymentCalculator.reader.nextLine();
				teachersNumberInput = false;
			}
		}
	}
	
	/* PRINT PRINCIPAL GROSS PAY DETAILS */
	protected void printGrossPayDetails() {
		System.out.print("\u250F" + "\u2501".repeat(55) + "\u2513\n");
		System.out.printf("\u2503%s%-16s%s%s%-22s\u2503\n",Styles.BLACK_BOLD,"",Styles.UNDERLINE,"GROSS PAY DESCRIPTION", Styles.RESET_STYLE );
		System.out.printf("\u2503%s%-45s%s%-10s\u2503\n%-56s\u2503\n",Styles.BLACK_BOLD,"BASIC SALARY:", Styles.RESET_STYLE, PaymentCalculator.euroFormat.format(5000.00f),"\u2503");
		System.out.printf("\u2503%s%-45s%s%-10s\u2503\n%-56s\u2503\n",Styles.BLACK_BOLD,"TEACHERS EMPLOYED:", Styles.RESET_STYLE, PaymentCalculator.euroFormat.format(this.principalBonus),"\u2503");
	}
}
