
public class Principal extends Employee {
	private float principalBasicSalary = 5000.00f;
	private int teachersNumber;
	
	public Principal(){
		setSalary(principalBasicSalary);
	}
	
	//get number of teachers
	protected void getNumberOfTeachers() {
		String RED = "\u001B[31m";
		String RESET_STYLE = "\u001B[0m";
		boolean teachersNumberInput = false;
		while(teachersNumberInput != true) {
			try {
				System.out.print("\nEnter Number Of Teachers In The School: ");
				teachersNumber = PaymentCalculator.reader.nextInt();
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
				System.out.println(RED + "Please, Enter 0 Or A Positive Whole Number!" + RESET_STYLE);
				PaymentCalculator.reader.nextLine();
				teachersNumberInput = false;
			}
		}
	}
}
