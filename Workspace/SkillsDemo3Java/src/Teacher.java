
public class Teacher extends Employee {

	private int scalePoints, scripts;
	private float scriptsPayment, scriptBonus;
	private final float examScriptRate = 10.18f;
	/* GET TEACHER'S POINT ON SALARY SCALE  */
	protected void getScalePoints(){
		/* WHILE LOOP WITH TRY CATCH 
		 * TO RE-PROMPT USER IF THE INPUT IS INCORRECT */
		boolean scalePointsInput = false;
		while(scalePointsInput != true) {
			try {
				System.out.print("\nEnter Teacher's Scale Points (1-4): ");
				scalePoints = PaymentCalculator.reader.nextInt();
				/* CALL addAdditionalPayment FUNCTION TO SET 
				 * HOW MUCH ADDITIONAL PAYMENT THE TEACHER WILL
				 * GET ACCORDING TO POINTS ON SALARY SCALE*/
				if(scalePoints < 1 || scalePoints > 4) {
					throw new Exception();
				}
				if(scalePoints == 1) {
					scriptBonus = 426.67f;
					addAdditionalPayment(scriptBonus);
				}
				if(scalePoints == 2){
					scriptBonus = 565.75f;
					addAdditionalPayment(scriptBonus);
				}
				if(scalePoints == 3){
					scriptBonus = 666.58f;
					addAdditionalPayment(scriptBonus);
				}
				if(scalePoints == 4){
					scriptBonus = 750.00f;
					addAdditionalPayment(scriptBonus);
				}
				scalePointsInput = true;
			} catch(Exception e){
				/* GIVE RED COLOR TO REPRESENT THAT IS A ERROR MESSAGE */
				System.out.println(Styles.ERROR_MESSAGE_COLOR + "Please, Enter A Positive Whole Number From 1-4!" + Styles.RESET_STYLE);
				PaymentCalculator.reader.nextLine();
				scalePointsInput = false;
			}
		}
	}
	 
	/* GET HOW MANY SCRIPTS WERE CORRECTED BY THE TEACHER
	 * AND CALCULATE ADDITIONAL PAYMENT PER SCRIPT  */
	protected void getAmountOfExamScriptsDone() {
		/* WHILE LOOP WITH TRY CATCH 
		 * TO RE-PROMPT USER IF THE INPUT IS INCORRECT */
		boolean scriptsInput = false;
		while(scriptsInput != true) {
			try {
				System.out.print("\nEnter Amount of Exam Scripts Corrected By The Teacher: ");
				scripts = PaymentCalculator.reader.nextInt();
				if(scripts < 0) {
					throw new Exception();
				} else {
					/*CALCULATE IN MONEY HOW MUCH THE TEACHER SHOULD BE 
					 * PAID BECAUSE OF THE SCRIPTS CORRECTED*/
					scriptsPayment = scripts * examScriptRate;
					/* CALL addAdditionalPayment FUNCTION TO SET 
					 * HOW MUCH ADDITIONAL PAYMENT THE TEACHER WILL
					 * GET ACCORDING TO POINTS ON SALARY SCALE*/
					addAdditionalPayment(scriptsPayment);
					scriptsInput = true;
				}
			} catch(Exception e){
				/* GIVE RED COLOR TO REPRESENT THAT IS A ERROR MESSAGE */
				System.out.println(Styles.ERROR_MESSAGE_COLOR + "Please, Enter A Positive Whole Number!"+ Styles.RESET_STYLE);
				PaymentCalculator.reader.nextLine();
				scriptsInput = false;
			}
		}
	}
	
	/*PRINT SCRIPT BONUS DETAILS*/
	protected void getScriptsDetails() {
		String middleString = (scripts + " * €10.18");
		System.out.printf("\u2503%s%-10s%-19s%-20s%-10s\u2503\n%-56s\u2503\n",Styles.BLACK_BOLD,"SCRIPTS:", Styles.RESET_STYLE, middleString, PaymentCalculator.euroFormat.format(scriptsPayment), "\u2503");
	}
	
	/*PRINT SCALE BONUS DETAILS*/
	protected void getScalePointsDetails() {
		System.out.printf("\u2503%s%-10s%-19s%-17d%-10s\u2503\n%-56s\u2503\n",Styles.BLACK_BOLD,"SCALE POINTS:", Styles.RESET_STYLE, scalePoints, PaymentCalculator.euroFormat.format(scriptBonus), "\u2503");
	}
}
