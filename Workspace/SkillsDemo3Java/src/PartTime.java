
public class PartTime extends Teacher{
	private float hours, hourRate = 34.03f;

	protected void getHoursWorked() {
		//get hours 
		boolean hoursInput = false;
		while(hoursInput != true) {
			try {
				System.out.print("\nEnter Ammount Of Hours Worked: ");
				hours = PaymentCalculator.reader.nextFloat();
				if(hours < 0) {
					throw new Exception();
				} else {
					setSalary((hours * hourRate));
					hoursInput = true;
				}
			} catch(Exception e){
				System.out.println(Styles.ERROR_MESSAGE_COLOR + "Please, Enter 0 Or A Positive Number!" + Styles.RESET_STYLE);
				PaymentCalculator.reader.nextLine();
				hoursInput = false;
			}
		}
	}

}
