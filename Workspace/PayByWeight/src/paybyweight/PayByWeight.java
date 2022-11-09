package paybyweight;
import java.util.Arrays;

public class PayByWeight {

	public static void main(String[] args) {
		
//		int[] companies = annualServices();
//		
//		for(int i = 0; i < companies.length; i++) {
//			System.out.println(companies[i]);
//		}
		
		
		tableFormat();
		
	}
	
	
	private static int[] annualServices() {
		
		int greenClean = 180;
		int countryCollect = 170;
		int enviro = 150;
		int wasteAway = 200;
		
		int[] companiesArray = {greenClean, countryCollect, enviro, wasteAway};
		
		return companiesArray;
		
		
		
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
