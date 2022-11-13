package paybyweight;
import java.text.DecimalFormat;
import java.util.*;


public class PayByWeight {

	public static void main(String[] args) {
		
		
		
		/* -- Initialize function to get user inputs and store the results in a variable as ArrayList */
		ArrayList<Float> userResults = customerWasteKg();
	
		/* Print table headers and shape */
		tableFormat();
		
		
		/* Print calculate results for each type of waste and total per annum*/
		annualResults(userResults);
	
	}
	
	private static void annualResults(ArrayList<Float> userResults) {
		
		DecimalFormat euroFormat = new DecimalFormat("€#,###,##0.00");
		
		float weeksPerYear = 52.14f;
		/* -- Green Clean services and fees */
		String greenCleanName = "Green Clean";
		int greenCleanFee = 180;
		float greenCleanGeneralWaste = 0.21f;
		int greenCleanRecycling = 0;
		float greenCleanOrganic = 0.10f;
		float greenCleanGlass = 0.15f;
		
		/* -- Country Collect services and fees */
		String countryCollectName = "Country Collect";
		int countryCollectFee = 170;
		float countryCollectGeneralWaste = 0.14f;
		float countryCollectRecycling = 0.14f;
		float countryCollectOrganic = 0.10f;
		float countryCollectGlass = 0.12f;
		
		/* -- Enviro services and fees */
		String enviroName = "Enviro";
		int enviroFee = 150;
		float enviroGeneralWaste = 0.30f;
		int enviroRecycling = 0;
		int enviroOrganic = 0;
		int enviroGlass = 0;
		
		/* -- Waste Away services and fees */
		String wasteAwayName = "Waste Away";
		int wasteAwayFee = 200;
		float wasteAwayGeneralWaste = 0.21f;
		int wasteAwayRecycling = 0;
		float wasteAwayOrganic = 0.10f;
		float wasteAwayGlass = 0.15f;
		
		
		// Create an array to loop over each company name and calculate fees and costs 
		String[] companiesName = {greenCleanName, countryCollectName, enviroName, wasteAwayName};
		
		
		/* -- LOOP EXPLAINED */
		/* For each loop, if the if statement nested inside the loop is true it will calculate the results for the given index using its specifics variables*/
		
		for(int i = 0; i < companiesName.length ; i++) {
			
			/* -- IF STATEMENT NESTED -- */
			/* Each If statement requires the index to be equal to the given argument (Company Name) and will use the variables related to each company name to calculate the costs*/
			/* For each type of waste (General, Organic, Recycling or Glass), the total will be calculated: costsPerKg * customerWasteKg * weeksPerYear  */
			/* A normal year has 52 weeks + 1 day,  so 52.143 weeks,  rounded to 52.14 as a float number*/
			/* TOTAL COST will be calculated with the sum of all the wasteTotals + annual service fee */
			
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
		
		System.out.println("\u2517" + "\u2501".repeat(126) + "\u251B");
		
	}
	
	/*-- Get customer weekly waste inputs and Return user inputs result as an arraylist--*/
	private static ArrayList<Float> customerWasteKg() {
		
		// Title for this section
	
		
		//Intantiate Scanner
		Scanner sc = new Scanner(System.in);
		
		// Create an array with each type of waste
		String[] types = {"General Waste", "Recycling Waste", "Organic Waste", "Glass Waste"};
		
		
		// Create empty ArrayList to add customer inputs later
		ArrayList<Float> wasteKgs = new ArrayList<Float>();
	
		// For each type of waste, ask user for its input and add the input for that type of waste in an ArrayList
		for(int i = 0; i < types.length; i++) {
			
			//Print type of waste e.g General Waste: <userInput>
			System.out.print(types[i] + ": ");
			float waste = sc.nextFloat();
			
			//Add input in the wasteKgs ArrayList
			wasteKgs.add(waste);
		}
		
		/*---- WHEN LOOP FINISH -----*/
		// Print blanket lines so the customer old inputs will go under the console
		System.out.println("\n".repeat(2));
		System.out.printf("%s%127s\n", "\u2503", "\u2503");
		
		System.out.printf("\u2503%s: %.2f kg \n",types[0],wasteKgs.get(0));
		System.out.printf("\u2503%s: %.2f kg \n",types[1],wasteKgs.get(1));
		System.out.printf("\u2503%s: %.2f kg \n",types[2],wasteKgs.get(2));
		System.out.printf("\u2503%s: %.2f kg \n",types[3],wasteKgs.get(3));
		
//		// For each type of waste, print a line with its name and user input for that type, and add kg in the end.
//		// e.g. General Waste: 200 kg
//		for(int i = 0; i < types.length; i++) {
//			System.out.printf("\u2503%-s: %.2f kg \n",types[i],wasteKgs.get(i));
//		}
//		
		// Return wasteKgs array to be used to calculate all the costs;
		return wasteKgs;
		
		
	}
	
	/* Shape and format of table */
	
	/* -- Table Header Format -- */
	
	private static void tableFormat() {
		
		System.out.printf("%s%69s%58s\n", "\u2503", "Annual Waste Charges", "\u2503" );
		System.out.printf("%s%127s\n", "\u2503", "\u2503");
		System.out.printf("%s%s%16s%19s%21s%18s%17s%21s%3s\n","\u2503","Company Name", "Annual", "General", "Recycling", "Organic", "Glass", "Total Cost","\u2503");
		System.out.printf("%s%33s%17s%13s%26s%13s%23s%2s\n", "\u2503","Service Fee", "Waste Cost", "Cost", "Waste Cost", "Cost", "(per annum)", "\u2503");
		System.out.printf("%s%127s\n", "\u2503", "\u2503");

		
	}
}
