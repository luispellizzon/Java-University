
public class Employee {
		private String employeePPSN;
		private float additionalPayment = 0, grossPay, PRSI, monthSalary, averageAnnualIncome,
		tax, netPay;
		/* SET VARIABLES TO FINAL AS THEY WILL NOT CHANGE */
		private final float firstTaxRate = 0.22f, secondTaxRate = 0.42f, PRSIRate = 0.04f;

		
		/* SETTER TO SET PPSN FOR EMPLOYEE */
		protected void setPPSN(String ppsn) {
			this.employeePPSN = ppsn;
		}
		
		/* SETTER TO SET SALARY FOR EMPLOYEE */
		protected void setSalary(float employeeSalary) {
			this.monthSalary = employeeSalary;
		}
		
		/* SETTER TO SET ADDITIONAL PAYMENT FOR EMPLOYEE */
		protected void addAdditionalPayment(float employeeAdditionalPayment) {
			this.additionalPayment += employeeAdditionalPayment;
		}
		
		/* SETTER TO SET GROSS PAY FOR EMPLOYEE */
		protected void setGrossPay(float employeeGrossPay) {
			this.grossPay = employeeGrossPay;
		}
		
		/* CALCULATE EMPLOYEE'S GROSS PAY */
		protected void calculateGrossPay() {
			this.grossPay = monthSalary + additionalPayment;
		}
		
		/* CALCULATE EMPLOYEE'S PRSI */
		protected void calculatePRSI() {
			//calc prsi
			this.PRSI = grossPay * PRSIRate;
		}
		
		/* CALCULATE EMPLOYEE'S TAX */
		protected void calculateTax() {
			/* CALCULATE ANNUAL INCOME AVERAGE */
			averageAnnualIncome = grossPay * 12;
			/* TAX IF INCOME IS LESS OR EQUAL TO 40000 */
			if(averageAnnualIncome <= 40000) {
				tax = averageAnnualIncome * firstTaxRate;
			} else {
				/* TAX IF INCOME IS GREATER THAN 40000 */
				tax = (40000.00f * firstTaxRate) + ((averageAnnualIncome - 40000.00f) * secondTaxRate);
			}
			/* DIVIDE THE AVERAGE YEARLY TAX BY 12, REPRESENTING
			 * THE TAX TO BE PAID MONTHLY*/
			tax = tax / 12;
		}
		
		/* CALCULATE EMPLOYEE'S NET PAY*/
		protected void calculateNetPay() {
			netPay = grossPay - tax - PRSI;
		}
		
		/* DISPLAY EMPLOYEE'S DETAILS */
		protected void displayPaymentDetails(){
			/* DISPLAY PROFESSIONAL OUTPUT 
			 * BOLD BORDER, BOLD FONTS AND CURRENCY FORMAT*/
			System.out.print("\u250F" + "\u2501".repeat(55) + "\u2513\n");
			System.out.printf("\u2503%s%-20s%s%s%-24s\u2503\n",Styles.BLACK_BOLD,"",Styles.UNDERLINE,"PAYMENT DETAILS", Styles.RESET_STYLE );
			System.out.printf("\u2503%s%-45s%s%-10s\u2503\n%-56s\u2503\n",Styles.BLACK_BOLD,"EMPLOYEE'S PPSN:", Styles.RESET_STYLE, this.employeePPSN,"\u2503");
			System.out.printf("\u2503%s%-45s%s%-10s\u2503\n%-56s\u2503\n",Styles.BLACK_BOLD,"GROSS PAY:", Styles.RESET_STYLE, PaymentCalculator.euroFormat.format(this.grossPay),"\u2503");
			System.out.printf("\u2503%s%-45s%s%-10s\u2503\n%-56s\u2503\n",Styles.BLACK_BOLD,"PRSI:", Styles.RESET_STYLE, PaymentCalculator.euroFormat.format(this.PRSI),"\u2503");
			System.out.printf("\u2503%s%-45s%s%-10s\u2503\n%-56s\u2503\n",Styles.BLACK_BOLD,"TAX:", Styles.RESET_STYLE, PaymentCalculator.euroFormat.format(this.tax),"\u2503");
			System.out.printf("\u2503%s%-45s%s%-10s\u2503\n",Styles.BLACK_BOLD,"NET PAY:", Styles.RESET_STYLE, PaymentCalculator.euroFormat.format(this.netPay));
			System.out.print("\u2517" + "\u2501".repeat(55)+"\u251B");
		}
}
