
public class FullTime extends Teacher {
	
	private int absentDays;
	private final float absentRate = 62.68f;

	/* CONSTRUCTOR INITIALIZING FULL-TIME TEACHER'S SALARY */
	public FullTime(){
		setSalary(3343.58f);
	}
	
	/* GET DAYS THE TEACHER WAS ABSENT AND CALCULATE 
	 * HOW MUCH IN MONEY SHOULD BE DISCOUNTED */
	protected void getAbsentDays() {
		/* WHILE LOOP WITH TRY CATCH 
		 * TO RE-PROMPT USER IF THE INPUT IS INCORRECT */
		boolean absentInput = false;
		while(absentInput != true) {
			try {
				System.out.print("\nEnter Ammount Of Absent Days: ");
				absentDays = PaymentCalculator.reader.nextInt();
				if(absentDays < 0) {
					throw new Exception();
				} else {
					/* CALL discountAbsentDaysPayment FUNCTION TO SET 
					 * HOW MUCH ADDITIONAL PAYMENT THE FULL-TIME TEACHER WILL
					 * GET DISCOUNTED*/
					discountAbsentDaysPayment((absentDays * absentRate));
					absentInput = true;
				}
			} catch(Exception e){
				/* GIVE RED COLOR TO REPRESENT THAT IS A ERROR MESSAGE */
				System.out.println(Styles.ERROR_MESSAGE_COLOR + "Please, Enter 0 Or A Positive Whole Number!"+ Styles.RESET_STYLE);
				PaymentCalculator.reader.nextLine();
				absentInput = false;
			}
		}
	}
	
	/* DISCOUNT ABSENT DAYS FROM SALARY */
	protected void discountAbsentDaysPayment(float absentDaysToDiscount) {
		/* CALL setSalary FUNCTION TO SET FULL-TIME TEACHER EMPLOYEE.
		 * IT WILL NOT DISCOUNT IF THE TEACHER WAS NOT ABSENT*/
		setSalary((3343.58f - absentDaysToDiscount));
	}
}

