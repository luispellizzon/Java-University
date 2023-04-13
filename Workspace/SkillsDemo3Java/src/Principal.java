
public class Principal extends Employee {
	private float principalBasicSalary = 5000.00f;
	private int teachersNumber;
	
	public Principal(){
		setSalary(principalBasicSalary);
	}
	
	//get number of teachers
	protected void getNumberOfTeachers() {
		boolean teachersNumberInput = false;
		while(teachersNumberInput != true) {
			try {
				System.out.print("\nEnter Number Of Teachers In The School: ");
				teachersNumber = PaymentCalculator.reader.nextInt();
				if(teachersNumber < 0) {
					throw new Exception("\u001B[31m"+"Please, Enter A Positive Number!"+"\u001B[0m");
				}
				if(teachersNumber >= 200) {
					setAdditionalPayment(1196.67f);
				}
				else if(teachersNumber >= 100){
					setAdditionalPayment(1019.83f);
				}
				else if(teachersNumber >= 10) {
					setAdditionalPayment(869.33f);
				}
				else {
					setAdditionalPayment(775.83f);
				}
				teachersNumberInput = true;
			} catch(Exception e){
				System.out.println("\u001B[31m"+"Please, Enter A Positive Whole Number!"+"\u001B[0m");
				PaymentCalculator.reader.nextLine();
				teachersNumberInput = false;
			}
		}
	}
	
}
