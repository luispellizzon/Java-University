package formatting;
import java.text.DecimalFormat;
import java.util.Scanner;

public class FormattingValues {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		/* -- Exercise 1 --*/
//		grossPay(20, 15.27f);
		
		
		/* -- Exercise 2 --*/
//		milesToKm( 10f);
		
		/* -- Exercise 3 --*/	
//		setPin();

		/* -- Exercise 4 --*/	
	marathonNumber();
	}
	
	public static void marathonNumber() {
		Scanner sc = new Scanner(System.in);
		DecimalFormat numberFormat = new DecimalFormat("EE00000");
		
		System.out.println("Please, enter the marathon number:");
		int number =  sc.nextInt();
		System.out.printf("The participant number is: %s", numberFormat.format(number));
	}
	
	
	public static void setPin() {
		Scanner sc = new Scanner(System.in);
		DecimalFormat pinFormat = new DecimalFormat("0000");
		
		System.out.println("Please, register a PIN up to 4 digits:");
		int pinInput = sc.nextInt();
		
		int pinNumber;
		
		if(pinInput > 9999) {
			System.out.println("Sorry, your PIN number needs to be less than 4 digits\n\n");
			setPin();
		} else {
			
			pinNumber = pinInput;
					
			System.out.printf("Your new pin is: %s",pinFormat.format(pinNumber));
		}
			 
;		
	}

	/* -- Exercise 1 --*/
	public static void grossPay(int hours, float wages) {
		//instantiate DecimalFormat and pass the format way in String
		DecimalFormat euroFormat = new DecimalFormat("€#,###,##0.00");
		
		float grossPay = hours * wages;
		
		
		//Call the variable we instantiate DecimalFormat and call .format method and pass the variable
		System.out.printf("Gross Pay: %s", euroFormat.format(grossPay));
	}
	
	
	/* -- Exercise 2 --*/
	private static void milesToKm(float miles) {
		DecimalFormat threeDecimal = new DecimalFormat("#,###,###.000");
		
		float kmConvert = 1.609f;
		
		float result = miles * kmConvert ;
		
		
//		System.out.println(miles +" in Miles is " + result + " in km");
		System.out.printf("%f in miles is %s in KM", miles, threeDecimal.format(result));
		
	}


}
