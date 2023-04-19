
public class Principal extends Employee {
	private int teachersNumber;
	
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
					addAdditionalPayment(1196.67f);
				}
				else if(teachersNumber >= 100){
					addAdditionalPayment(1019.83f);
				}
				else if(teachersNumber >= 10) {
					addAdditionalPayment(869.33f);
				}
				else {
					addAdditionalPayment(775.83f);
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
}
