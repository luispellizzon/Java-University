
public class PartTime extends Teacher{
	private float hours;
	private final float hourRate = 34.03f;
	
	/* GET HOW MANY HOURS THE PART-TIME TEACHER WORKED
	 * AND CALCULATE ITS SALARY */
	protected void getHoursWorked() {
		/* WHILE LOOP WITH TRY CATCH 
		 * TO RE-PROMPT USER IF THE INPUT IS INCORRECT */
		boolean hoursInput = false;
		while(hoursInput != true) {
			try {
				System.out.print("\nEnter Amount Of Hours Worked: ");
				hours = PaymentCalculator.reader.nextFloat();
				if(hours < 0) {
					throw new Exception();
				} else {
					/* CALL setSalary FUNCTION TO SET SALARY
					 * TO BE PAID THAT MONTH*/
					setSalary((hours * hourRate));
					hoursInput = true;
				}
			} catch(Exception e){
				/* GIVE RED COLOR TO REPRESENT THAT IS A ERROR MESSAGE */
				System.out.println(Styles.ERROR_MESSAGE_COLOR + "Please, Enter 0 Or A Positive Number!" + Styles.RESET_STYLE);
				PaymentCalculator.reader.nextLine();
				hoursInput = false;
			}
		}
	}
	
	/* PRINT PARTIME TEACHER GROSS PAY DETAILS */
	protected void printGrossPayDetails() {
		System.out.print("\u250F" + "\u2501".repeat(55) + "\u2513\n");
		System.out.printf("\u2503%s%-16s%s%s%-22s\u2503\n",Styles.BLACK_BOLD,"",Styles.UNDERLINE,"GROSS PAY DESCRIPTION", Styles.RESET_STYLE );
		System.out.print("\u2503" + " ".repeat(55) + "\u2503\n");
		String middleString = hours + " * €34.03";
		System.out.printf("\u2503%s%-10s%-19s%-20s%-10s\u2503\n%-56s\u2503\n",Styles.BLACK_BOLD,"HOURS:", Styles.RESET_STYLE, middleString, PaymentCalculator.euroFormat.format((hours * hourRate)), "\u2503");
		getScriptsDetails();
		getScalePointsDetails();
	}
	
}
