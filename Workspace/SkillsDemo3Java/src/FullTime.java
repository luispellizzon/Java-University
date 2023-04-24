
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
				System.out.print("\nEnter Amount Of Absent Days: ");
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
	
	/* PRINT FULLTIME TEACHER GROSS PAY DETAILS */
	protected void printGrossPayDetails() {
		System.out.print("\u250F" + "\u2501".repeat(55) + "\u2513\n");
		System.out.printf("\u2503%s%-16s%s%s%-22s\u2503\n",Styles.BLACK_BOLD,"",Styles.UNDERLINE,"GROSS PAY DESCRIPTION", Styles.RESET_STYLE );
		System.out.printf("\u2503%s%-45s%s%-10s\u2503\n%-56s\u2503\n",Styles.BLACK_BOLD,"BASIC SALARY:", Styles.RESET_STYLE, PaymentCalculator.euroFormat.format(3343.58f),"\u2503");
		getScriptsDetails();
		getScalePointsDetails();
		String middleString = absentDays + " * €62.68";
		System.out.printf("\u2503%s%-10s%-17s%-20s%-10s\u2503\n%-56s\u2503\n",Styles.BLACK_BOLD,"ABSENT DAYS:", Styles.RESET_STYLE, middleString, PaymentCalculator.euroFormat.format(-(absentDays * absentRate)), "\u2503");
	}
}

