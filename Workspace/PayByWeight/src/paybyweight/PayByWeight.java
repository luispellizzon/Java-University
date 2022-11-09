package paybyweight;
import java.text.DecimalFormat;
import java.util.*;


public class PayByWeight {

	public static void main(String[] args) {
		
//		int[] companies = annualServices();
//		
//		for(int i = 0; i < companies.length; i++) {
//			System.out.println(companies[i]);
//		}
		
		
		ArrayList<Float> userResults = customerWasteKg();
//		Object[] annualFeesPerCompany = annualServicesFee(); 
		
		tableFormat();
//		
		annualResults(userResults);
		
	
	}
	
	private static void annualResults(ArrayList<Float> userResults) {
		
		DecimalFormat euroFormat = new DecimalFormat("€#,###,##0.00");
		
		String greenCleanName = "Green Clean";
		int greenCleanFee = 180;
		float greenCleanGeneralWaste = 0.21f;
		int greenCleanRecycling = 0;
		float greenCleanOrganic = 0.10f;
		float greenCleanGlass = 0.15f;
		
		String countryCollectName = "Country Collect";
		int countryCollectFee = 170;
		float countryCollectGeneralWaste = 0.14f;
		float countryCollectRecycling = 0.14f;
		float countryCollectOrganic = 0.10f;
		float countryCollectGlass = 0.12f;
		
		String enviroName = "Enviro";
		int enviroFee = 150;
		float enviroGeneralWaste = 0.30f;
		int enviroRecycling = 0;
		int enviroOrganic = 0;
		int enviroGlass = 0;
		
		String wasteAwayName = "Waste Away";
		int wasteAwayFee = 200;
		float wasteAwayGeneralWaste = 0.21f;
		int wasteAwayRecycling = 0;
		float wasteAwayOrganic = 0.10f;
		float wasteAwayGlass = 0.15f;
		
		int[] companiesFee = {greenCleanFee, countryCollectFee, enviroFee, wasteAwayFee};
		String[] companiesName = {greenCleanName, countryCollectName, enviroName, wasteAwayName};
		
		
		
		for(int i = 0; i < companiesName.length ; i++) {
			
			if( "Green Clean".equals(companiesName[i])) {
				float generalWasteTotal = greenCleanGeneralWaste * userResults.get(0);
				float recyclingTotal = greenCleanGeneralWaste * userResults.get(1);
				float organicTotal = greenCleanGeneralWaste * userResults.get(2);
				float glassTotal = greenCleanGeneralWaste * userResults.get(3);
				float annualTotal = generalWasteTotal + recyclingTotal + organicTotal + glassTotal + greenCleanFee;
				
				System.out.printf("%s %21s %23s %22s %22s %21s %21s \n", companiesName[i], euroFormat.format(companiesFee[i]), euroFormat.format(generalWasteTotal), euroFormat.format(recyclingTotal), euroFormat.format(organicTotal),euroFormat.format(glassTotal), euroFormat.format(annualTotal));
				
			} else if( "Country Collect".equals(companiesName[i])) {
				System.out.printf("%s %17s \n", companiesName[i], euroFormat.format(companiesFee[i]));
				
			} else if( "Enviro".equals(companiesName[i])) {
				System.out.printf("%s %26s \n", companiesName[i], euroFormat.format(companiesFee[i]));
				
			}  else {
				System.out.printf("%s %22s \n", companiesName[i], euroFormat.format(companiesFee[i]));
					
			}

			
		}
		
		
//		
		
		
		
	}
	
	private static ArrayList<Float> customerWasteKg() {
		Scanner sc = new Scanner(System.in);
		
		String[] types = {"General Waste", "Recycling Waste", "Organic Waste", "Glass Waste"};
		String title ="Weekly Amount of Waste";
		
		
		
		ArrayList<Float> wasteKgs = new ArrayList<Float>();
		
		for(int i = 0; i < types.length; i++) {
			System.out.print(types[i] + ": ");
			float waste = sc.nextFloat();
			
			
			wasteKgs.add(waste);
		}
		
		System.out.println("\n".repeat(5));
		System.out.printf("%80s\n\n",title);
		
		for(int i = 0; i < types.length; i++) {
			System.out.printf("%s : %.2f kg \n",types[i],wasteKgs.get(i));
		}
		
		return wasteKgs;
		
		
	}
	
	private static void tableFormat() {
//		String[] header = {"Company Name", "Annual Service", "General Waste Cost", "Recycling Cost", "Organic Waste Cost", "Glass Cost", "Total Cost (per annum)"};
		String title = "Annual Waste Charges";
		String companyName = "Company Name";
		String annualService= "Annual Service Fee";
		String generalCost = "General Waste Cost";
		String recyclingCost = "Recycling Cost";
		String organicCost = "Organic Waste Cost";
		String glassCost = "Glass Cost";
		String totalCost = "Total Cost (per annum)";
		
		System.out.printf("%80s\n\n", title);
		System.out.printf("%10s%25s%25s%22s%25s%18s%28s\n\n",companyName, annualService, generalCost, recyclingCost, organicCost, glassCost, totalCost);

				
	}
}
