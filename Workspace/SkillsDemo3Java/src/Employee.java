
public class Employee {
		private String employeePPSN;
		private float additionalPayment, grossPay, PRSI,
		tax, netPay, firstTaxCost, secondTaxCost,firstTaxRate = 0.22f, secondTaxRate = 0.42f, PRSIRate = 0.04f;
		
		
		public void setPPSN(String ppsn) {
			//get ppsn
			System.out.println("Enter PPSN:" + ppsn);

		}
		public void setGrossPay(float employeeGrossPay) {
			this.grossPay = employeeGrossPay;
		}
		
		public void displayPaymentDetails(){
			//display details
			System.out.println("Details payment function");
		}
		
		public void displayGrossPay() {
			//display gross
			System.out.println("Gross Pay setted to:");
		}
		
		public void calculatePRSI() {
			//calc prsi
			System.out.println("PRSI function");
		}
		
		public void calculateTax() {
			//calc tax
			System.out.println("Tax function");
		}
		
		public void calculateNetPay() {
			//cal netpay
			System.out.println("NetPay function");
		}
}
