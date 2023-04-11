
public class FullTime extends Teacher {
	
	private static float teacherFullTimeBasicSalary = 3343.58f;
	private float absentDays;
	private float absentRate = 62.68f;

	public void getAbsentDays() {
		//get absent days
		System.out.println("Get Absent Days Fulltime function");
	}
	public void calculateGrossPay() {
		setGrossPay(teacherFullTimeBasicSalary);
	}

}
