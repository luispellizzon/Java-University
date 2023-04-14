
public class Employee {
		private String employeePPSN;
		private float additionalPayment = 0, grossPay, PRSI, salary, averageAnnualIncome,
		tax, netPay,firstTaxRate = 0.22f, secondTaxRate = 0.42f, PRSIRate = 0.04f;
		
		// set ppsn
		protected void setPPSN(String ppsn) {
			this.employeePPSN = ppsn;
		}
		
		//set employee salary
		protected void setSalary(float employeeSalary) {
			this.salary = employeeSalary;
		}
		
		//set add payment
		protected void addAdditionalPayment(float employeeAdditionalPayment) {
			this.additionalPayment = this.additionalPayment + employeeAdditionalPayment;
		}
		
		// set grosspay
		protected void setGrossPay(float employeeGrossPay) {
			this.grossPay = employeeGrossPay;
		}
		
		protected void displayPaymentDetails(){
			final String BLACK_BOLD = "\033[1;30m";
			final String RESET_STYLE = "\u001B[0m";
			final String BLACK_UNDERLINED = "\033[4;30m";
			//display details
			System.out.print("\u250F" + "\u2501".repeat(55) + "\u2513\n");
			System.out.printf("\u2503%s%-20s%s%s%-24s\u2503\n",BLACK_BOLD,"",BLACK_UNDERLINED,"PAYMENT DETAILS", RESET_STYLE );
			System.out.printf("\u2503%s%-45s%s%-10s\u2503\n%-56s\u2503\n",BLACK_BOLD,"EMPLOYEE'S PPSN:", RESET_STYLE, this.employeePPSN,"\u2503");
			System.out.printf("\u2503%s%-45s%s%-10s\u2503\n%-56s\u2503\n",BLACK_BOLD,"GROSS PAY:", RESET_STYLE, PaymentCalculator.euroFormat.format(this.grossPay),"\u2503");
			System.out.printf("\u2503%s%-45s%s%-10s\u2503\n%-56s\u2503\n",BLACK_BOLD,"PRSI:", RESET_STYLE, PaymentCalculator.euroFormat.format(this.PRSI),"\u2503");
			System.out.printf("\u2503%s%-45s%s%-10s\u2503\n%-56s\u2503\n",BLACK_BOLD,"TAX:", RESET_STYLE, PaymentCalculator.euroFormat.format(this.tax),"\u2503");
			System.out.printf("\u2503%s%-45s%s%-10s\u2503\n",BLACK_BOLD,"NET PAY:", RESET_STYLE, PaymentCalculator.euroFormat.format(this.netPay));
			System.out.print("\u2517" + "\u2501".repeat(55)+"\u251B");
		}
		//cal grosspay
		protected void calculateGrossPay() {
			this.grossPay = salary + additionalPayment;
		}
		
		protected void calculatePRSI() {
			//calc prsi
			this.PRSI = grossPay * PRSIRate;
		}
		
		// calc tax
		protected void calculateTax() {
			averageAnnualIncome = grossPay * 12;
			if(averageAnnualIncome <= 40000) {
				tax = averageAnnualIncome * firstTaxRate;
			} else {
				tax = (40000.00f * firstTaxRate) + ((averageAnnualIncome - 40000.00f) * secondTaxRate);
			}
			tax = tax / 12;
		}
		
		// cal netpay
		protected void calculateNetPay() {
			netPay = grossPay - tax - PRSI;
		}
}
