import java.util.Scanner;

public class RoomArea {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//Worked Example 
//		roomArea(sc);
		
		
		/*Exercise 1
		
//		Example 1 
//		float[] numbers  = {8.2f, 50.4f, -8.6f};
		
		
//		Example 2
//		float[] numbers  = {65.3f, -87.256f, 3.24f};
		
//		Example 3 
//		float[] numbers  = {3.57f, 2.45f, 8.56f};
		 
		float result = numberAverage(numbers);
		
		System.out.print(result);
		
		*/
		
		/* Exercise 2 */
//		euroToSterlingAndDollar(euros in float, ex: 200f);
		
		/*Exercise 3 */
//		milesToKm(put float number here ex: 18.659f);
		
		/*Exercise 4*/
		
//		gardenLawnArea(lenght in float, width in float ex: 3.5f, 4.5f);
		
		/*Exercise 5 */
//		costInMeter(metres in float ex: 3.6f);
		
		/*Exercise 6 */
//		personDetails(sc);
		
		/*Exercise 7 */
		personWages(452783.88f);
		
	}
	
	private static void personWages(float grossPay) {
		float tax = 0.29f;
		float prsi = 0.07f;
		
		float totalTax = grossPay * tax;
		float totalPrsi = grossPay * prsi;
		
		float net = grossPay - totalTax - totalPrsi;
		
		System.out.printf("Gross Pay: %.2f \nTotal Tax: %.2f \nTotal PRSI: %.2f \nNet Pay: %.2f", grossPay, totalTax, totalPrsi, net);
	}
	
	private static void personDetails(Scanner sc) {
		
		
//		Global variables for results
		float inchesToCm = 2.54f;
		float stonesToKg = 6.364f;
		
		System.out.println("Enter your first name:");
		String firstName = sc.next();
		
		System.out.println("Enter your height in feet  (whole number approximatelly):");
		float heightInFeet = sc.nextFloat();
		
		System.out.println("Enter your height in inches (the remainer number from the complete height in feet):");
		float heightInInches = sc.nextFloat();
		
		
		System.out.println("Enter your weight in stones  (whole number approximatelly):");
		float weightInStones = sc.nextFloat();
		
		System.out.println("Enter your weight in pounds (the remainer number from the complete weight in stones):");
		float weightInPounds = sc.nextFloat();
		
		
//		Convert Feet to Inches and get Total inches and convert to Centimeters
		float totalHeight = ((heightInFeet * 12) + heightInInches ) * inchesToCm ;
		
		
//		Convert remainer Pounds to Stone and get Total Stones and convert to Kg
		
		float totalWeight = ((weightInPounds / 14) + weightInStones) * stonesToKg ;
		
		
		
		System.out.printf("Your name is %s and you are %.2f tall and weight %.2f kgs",firstName, totalHeight, totalWeight);
	}

	private static void costInMeter(float size) {
		float meterToYard = 1.196f;
		float costPerYard = 12.99f;
		
		float yard = size * meterToYard;
		
		float result = costPerYard * yard;
		
		System.out.printf("The cost per %.2f metres is %.2f euros", size, result);
		
	}
	
	private static void gardenLawnArea(float gardenLength, float gardenWidth) {
		 float pricePerSquareUnit = 3.75f;
		 
		 float gardenArea = gardenLength * gardenWidth;
		 
		 float fullPrice = pricePerSquareUnit * gardenArea;
		 
		 System.out.printf("The total cost for reseeding the lawn for %.2f square units is: %.2f euros", gardenArea, fullPrice);
		
	}

	private static void milesToKm(float miles) {
		float kmConvert = 1.609f;
		
		float result = miles * kmConvert ;
		
		System.out.println(miles +" in Miles is " + result + " in km");
		
	}

	private static void roomArea ( Scanner sc) {
		
		System.out.println("Enter length of the room:");
		
		float roomLength = sc.nextFloat();
		
		System.out.println("Enter width of the room");
		
		float roomWidth = sc.nextFloat();
		
		float roomSum  = roomLength * roomWidth;
		
		System.out.println("The room area is: " + roomSum + "square units");
	}
	
	private static float numberAverage (float[] numbers) {
		
		float sum = 0f;
				
		for (int i = 0 ; i < numbers.length; i ++) {
			
			sum += numbers[i];
			
		}
		
		float average = sum / numbers.length ; 
		
		return average ;
		
	}
	
	private static void euroToSterlingAndDollar (float euro) {
		
		float dollarConvert = 1.3469f;
		float sterlingConvert = 0.851713671f;
		
		float[] result = {(euro*dollarConvert), (euro*sterlingConvert)};
		
		float dollar = result[0];
		float sterling = result[1];
		
		System.out.println(euro + " Euro is equal to :");
		System.out.println("Dollar: $" + dollar);
		System.out.print("Sterling: £ " + sterling);
	}
	
	

}
