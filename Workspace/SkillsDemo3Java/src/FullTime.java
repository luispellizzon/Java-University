
public class FullTime extends Teacher {
	
	private static float teacherFullTimeBasicSalary = 3343.58f;
	private int absentDays;
	private float absentRate = 62.68f;

	public FullTime(){
		setSalary(teacherFullTimeBasicSalary);
	}
	
	protected void getAbsentDays() {
		String RED = "\u001B[31m";
		String RESET_STYLE = "\u001B[0m";
		//get absent days
		boolean absentInput = false;
		while(absentInput != true) {
			try {
				System.out.print("\nEnter Ammount Of Absent Days: ");
				absentDays = PaymentCalculator.reader.nextInt();
				if(absentDays < 0) {
					throw new Exception();
				} else {
					discountAbsentDaysPayment((absentDays * absentRate));
					absentInput = true;
				}
			} catch(Exception e){
				System.out.println(RED + "Please, Enter 0 Or A Positive Whole Number!"+ RESET_STYLE);
				PaymentCalculator.reader.nextLine();
				absentInput = false;
			}
		}
	}
	
	protected void discountAbsentDaysPayment(float absentDaysToDiscount) {
		setSalary((teacherFullTimeBasicSalary - absentDaysToDiscount));
	}
	
}

