
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
}
