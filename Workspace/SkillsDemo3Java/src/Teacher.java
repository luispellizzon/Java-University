
public class Teacher extends Employee {

	private int scalePoints, scripts;
	private float examScriptRate = 10.18f, scriptsPayment;

	protected void getScalePoints(){
		String RED = "\u001B[31m";
		String RESET_STYLE = "\u001B[0m";
		//get scale points
		boolean scalePointsInput = false;
		while(scalePointsInput != true) {
			try {
				System.out.print("\nEnter Teacher's Scale Points (1-4): ");
				scalePoints = PaymentCalculator.reader.nextInt();
				if(scalePoints < 1 || scalePoints > 4) {
					throw new Exception();
				}
				if(scalePoints == 1) {
					addAdditionalPayment(426.67f);
				}
				if(scalePoints == 2){
					addAdditionalPayment(565.75f);
				}
				if(scalePoints == 3){
					addAdditionalPayment(666.58f);
				}
				if(scalePoints == 4){
					addAdditionalPayment(750.00f);
				}
				scalePointsInput = true;
			} catch(Exception e){
				System.out.println(RED + "Please, Enter A Positive Whole Number From 1-4!" + RESET_STYLE);
				PaymentCalculator.reader.nextLine();
				scalePointsInput = false;
			}
		}
	}
	 
	protected void getAmmountOfExamScriptsDone() {
		String RED = "\u001B[31m";
		String RESET_STYLE = "\u001B[0m";
		// get scripts corrected
		boolean scriptsInput = false;
		while(scriptsInput != true) {
			try {
				System.out.print("\nEnter Ammount of Exam Scripts Corrected By The Teacher: ");
				scripts = PaymentCalculator.reader.nextInt();
				if(scripts < 0) {
					throw new Exception();
				} else {
					scriptsPayment = scripts * examScriptRate;
					addAdditionalPayment(scriptsPayment);
					scriptsInput = true;
				}
			} catch(Exception e){
				System.out.println(RED + "Please, Enter A Positive Whole Number!"+ RESET_STYLE);
				PaymentCalculator.reader.nextLine();
				scriptsInput = false;
			}
		}
	}
}
