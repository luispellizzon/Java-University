package paybyweight;
import java.text.DecimalFormat;
import java.util.*;


public class PayByWeight {

	public static void main(String[] args) {
		
		
		
		/* -- Initialize function to get user inputs and store the results in a variable that holds the ArrayList, TOP SIDE */
		ArrayList<Byte> userResults = customerWasteKg();	
		
		/* Pass the userResults variable as an argument so will be used as a parameter to calculate costs */
		/* Print calculate results for each type of waste and total per annum, BOTTOM SIDE*/
		annualResults(userResults);
	
	}
	
	/*-- Get customer weekly waste inputs,
	 *  Start printing the top of the bold border, and print types of waste with its weights aligned,
	 *  Return user inputs result as an arraylist to be easier to iterate over and output the bottom part of the table format aligned--*/
	private static ArrayList<Byte> customerWasteKg() {
		
		// Main title to tell user what needs to be the input
		System.out.println("Enter the weekly waste weights in kgs: \n");
		

		//Intantiate Scanner
		Scanner sc = new Scanner(System.in);
		
		// Create an array with each type of waste to be printed on screen asking for its value, and later to be printed inside the tabular result
		String[] types = {"General Waste:", "Recycling Waste:", "Organic Waste:", "Glass Waste:"};
		
		
		// Create empty ArrayList of the type Byte to add customer input (bytes)
		ArrayList<Byte> wasteKgs = new ArrayList<Byte>();
		
	
		// For each type of waste, ask user for its input and add the input for that type of waste, and add on empty ArrayList
		for(int i = 0; i < types.length; i++) {
			
			//Print type of waste e.g General Waste: <userInput>
			//Each type has negative number to aligned, so does not matter the size of the type printed, the input will be always 18 spaces padded to the right.
			//Type:             <userInput>
			System.out.printf("%-18s",types[i]);
			
			/* Store input as Byte Type, because the values will be a whole number no greater than 127 */
			byte waste = sc.nextByte();
			
			//Add input in the wasteKgs ArrayList.
			wasteKgs.add(waste);
		}
		
		/* CAST BYTE TO STRING, BUT WHY ? */
		/* To be more flexible with the Borders around the table, I cast each Byte data to String
		 * so we can get the data in string and concatenate with "kg" to be printed inside the bold border, 
		 * and give a fixed width to output this data + kg, so the last bold line will be always printed on the final of the width, no matter the size of the user input
		 */
		String type1 = Byte.toString(wasteKgs.get(0));
		String type2 = Byte.toString(wasteKgs.get(1));
		String type3 = Byte.toString(wasteKgs.get(2));
		String type4 = Byte.toString(wasteKgs.get(3));
		
		/*---- WHEN LOOP FINISH -----*/
		// Print blanket line to give one line space between the inputs and the table output
		System.out.println("");

		/* HEADER OUTPUT BOLD BORDERS FORMAT */
		// BLACK BORDER FIRST LINE
		System.out.println("\u250F" + "\u2501".repeat(126) + "\u2513");
		
		// Each type of waste with it is values aligned 
		System.out.printf("\u2503%-22s%-104s%s\n",types[0],type1 + " kg", "\u2503");
		System.out.printf("\u2503%-22s%-104s%s\n",types[1],type2 + " kg", "\u2503");
		System.out.printf("\u2503%-22s%-104s%s\n",types[2],type3 + " kg", "\u2503");
		System.out.printf("\u2503%-22s%-104s%s\n",types[3],type4 + " kg", "\u2503");
		System.out.printf("%s%127s\n", "\u2503", "\u2503");
	
		// Return wasteKgs array to be used to calculate all the costs;
		return wasteKgs;
		
		
		/* { RESULTS WILL GO HERE } */
		
	}
	
	
	/* Print each company with its costs and annual services aligned */
	/* Use an ArrayList that contains how much weight a user will produce for each type of waste as a parameter to calculate how much each company will charge annually */
	/* Print the bottom side of the bold border that contains the tabular format */
	private static void annualResults(ArrayList<Byte> userResults) {
		
		/* Instantiate DecimalFormat to format all the results that will be outputted inside the table to meet the documented requirements*/
		DecimalFormat euroFormat = new DecimalFormat("€#,###,##0.00");
		
		/* How many weeks a common year has */
		/* A normal year has 52 weeks + 1 day,  so 52.143 weeks,  rounded to 52.14 as a float number*/
		final float weeksPerYear = 52.14f;
		
		/* -- Green Clean services and fees */
		final String greenCleanName = "Green Clean";
		final int greenCleanFee = 180;
		final float greenCleanGeneralWaste = 0.21f;
		final byte greenCleanRecycling = 0;
		final float greenCleanOrganic = 0.10f;
		final float greenCleanGlass = 0.15f;
		
		/* -- Country Collect services and fees */
		final String countryCollectName = "Country Collect";
		final int countryCollectFee = 170;
		final float countryCollectGeneralWaste = 0.14f;
		final float countryCollectRecycling = 0.14f;
		final float countryCollectOrganic = 0.10f;
		final float countryCollectGlass = 0.12f;
		
		/* -- Enviro services and fees */
		final String enviroName = "Enviro";
		final int enviroFee = 150;
		final float enviroGeneralWaste = 0.30f;
		final int enviroRecycling = 0;
		final byte enviroOrganic = 0;
		final byte enviroGlass = 0;
		
		/* -- Waste Away services and fees */
		final String wasteAwayName = "Waste Away";
		final int wasteAwayFee = 200;
		final float wasteAwayGeneralWaste = 0.21f;
		final byte wasteAwayRecycling = 0;
		final float wasteAwayOrganic = 0.10f;
		final float wasteAwayGlass = 0.15f;
		
		
		// Create an array to loop over each company name and calculate fees and costs 
		String[] companiesName = {greenCleanName, countryCollectName, enviroName, wasteAwayName};
		
		/* TABLE HEADER WITH HEADER COLUMNS */
		System.out.printf("%s%69s%58s\n", "\u2503", "Annual Waste Charges", "\u2503" );
		System.out.printf("%s%127s\n", "\u2503", "\u2503");
		System.out.printf("%s%s%16s%19s%21s%18s%17s%21s%3s\n","\u2503","Company Name", "Annual", "General", "Recycling", "Organic", "Glass", "Total Cost","\u2503");
		System.out.printf("%s%33s%17s%13s%26s%13s%23s%2s\n", "\u2503","Service Fee", "Waste Cost", "Cost", "Waste Cost", "Cost", "(per annum)", "\u2503");
		System.out.printf("%s%127s\n", "\u2503", "\u2503");
		
		/* -- LOOP EXPLAINED */
		/* For each loop, if the if statement nested inside the loop is true it will calculate the results for the given index using its specifics variables*/
		
		for(int i = 0; i < companiesName.length ; i++) {
			
			/* -- IF STATEMENT NESTED -- */
			/* Each If statement requires the index to be equal to the given argument (Company Name) and will use the variables related to each company name to calculate the costs*/
			/* For each type of waste (General, Organic, Recycling or Glass), the total will be calculated: costsPerKg * customerWasteKg * weeksPerYear  */
			/* TOTAL COST will be calculated with the sum of all the wasteTotals + annual service fee */
			
			/*---- ALIGNMENT ----*/
			/* The alignment will be negative in each value, so each value will have more flexibility and each NEXT value will have a fixed start,and the final bold border will have its fixed place*/
			
			if( "Green Clean".equals(companiesName[i])) {
				
				float generalWasteTotal = greenCleanGeneralWaste * userResults.get(0) * weeksPerYear;
				float recyclingTotal = greenCleanRecycling * userResults.get(1)  * weeksPerYear;
				float organicTotal = greenCleanOrganic * userResults.get(2)  * weeksPerYear;
				float glassTotal = greenCleanGlass * userResults.get(3)  * weeksPerYear;
				float annualTotal = generalWasteTotal + recyclingTotal + organicTotal + glassTotal + greenCleanFee;
				
				System.out.printf("\u2503%-22s%-18s%-19s%-20s%-19s%-16s%-12s\u2503\n", companiesName[i], euroFormat.format(greenCleanFee), euroFormat.format(generalWasteTotal), euroFormat.format(recyclingTotal), euroFormat.format(organicTotal),euroFormat.format(glassTotal), euroFormat.format(annualTotal));
				
			} else if( "Country Collect".equals(companiesName[i])) {
				float generalWasteTotal = countryCollectGeneralWaste * userResults.get(0) * weeksPerYear;
				float recyclingTotal = countryCollectRecycling * userResults.get(1) * weeksPerYear;
				float organicTotal = countryCollectOrganic * userResults.get(2) * weeksPerYear;
				float glassTotal = countryCollectGlass * userResults.get(3) * weeksPerYear;
				float annualTotal = generalWasteTotal + recyclingTotal + organicTotal + glassTotal + countryCollectFee;
				
				System.out.printf("\u2503%-22s%-18s%-19s%-20s%-19s%-16s%-12s\u2503\n",companiesName[i], euroFormat.format(countryCollectFee), euroFormat.format(generalWasteTotal), euroFormat.format(recyclingTotal), euroFormat.format(organicTotal),euroFormat.format(glassTotal), euroFormat.format(annualTotal));
				
			} else if( "Enviro".equals(companiesName[i])) {
				float generalWasteTotal = enviroGeneralWaste * userResults.get(0) * weeksPerYear;
				float recyclingTotal = enviroRecycling * userResults.get(1) * weeksPerYear;
				float organicTotal = enviroOrganic * userResults.get(2) * weeksPerYear;
				float glassTotal = enviroGlass * userResults.get(3) * weeksPerYear;
				float annualTotal = generalWasteTotal + recyclingTotal + organicTotal + glassTotal + enviroFee;
				
				System.out.printf("\u2503%-22s%-18s%-19s%-20s%-19s%-16s%-12s\u2503\n", companiesName[i], euroFormat.format(enviroFee), euroFormat.format(generalWasteTotal), euroFormat.format(recyclingTotal), euroFormat.format(organicTotal),euroFormat.format(glassTotal), euroFormat.format(annualTotal));
				
			}  else {
				float generalWasteTotal = wasteAwayGeneralWaste * userResults.get(0) * weeksPerYear;
				float recyclingTotal = wasteAwayRecycling * userResults.get(1) * weeksPerYear;
				float organicTotal = wasteAwayOrganic * userResults.get(2) * weeksPerYear;
				float glassTotal = wasteAwayGlass * userResults.get(3) * weeksPerYear;
				float annualTotal = generalWasteTotal + recyclingTotal + organicTotal + glassTotal + wasteAwayFee;
				
				System.out.printf("\u2503%-22s%-18s%-19s%-20s%-19s%-16s%-12s\u2503\n", companiesName[i], euroFormat.format(wasteAwayFee), euroFormat.format(generalWasteTotal), euroFormat.format(recyclingTotal), euroFormat.format(organicTotal),euroFormat.format(glassTotal), euroFormat.format(annualTotal));
					
			}
			
			
			
		}
		
		/* LAST BOLD BOLDER TO CLOSE THE OUTPUT*/
		System.out.println("\u2517" + "\u2501".repeat(126) + "\u251B");
		
	}

}
