
public class FullTime extends Teacher {
	
	private float teacherFullTimeBasicSalary = 3343.58f;
	private int absentDays;
	private float absentRate = 62.68f;

	public FullTime(){
		setSalary(teacherFullTimeBasicSalary);
	}
	
	protected void getAbsentDays() {
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
				System.out.println(Styles.ERROR_MESSAGE_COLOR + "Please, Enter 0 Or A Positive Whole Number!"+ Styles.RESET_STYLE);
				PaymentCalculator.reader.nextLine();
				absentInput = false;
			}
		}
	}
	
	protected void discountAbsentDaysPayment(float absentDaysToDiscount) {
		setSalary((teacherFullTimeBasicSalary - absentDaysToDiscount));
	}
	
}

