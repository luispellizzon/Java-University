
public class PartTime extends Teacher{
	private float hours, hourRate = 34.03f;

	
	protected void getHoursWorked() {
		String RED = "\u001B[31m";
		String RESET_STYLE = "\u001B[0m";
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
				System.out.println(RED + "Please, Enter 0 Or A Positive Number!" + RESET_STYLE);
				PaymentCalculator.reader.nextLine();
				hoursInput = false;
			}
		}
	}

}
