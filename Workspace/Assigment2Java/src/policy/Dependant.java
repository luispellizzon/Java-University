package policy;

public class Dependant {
	/* SETTING GLOBAL VARIABLES FOR DEPENDANT CLASS */
	private String name;
	private byte age;
	private short cost;
	
	/* DEPENDANT CLASS CONSTRUCTOR TO SET NAME, AGE AND COST */
	public Dependant(String dependantName, byte dependantAge, short dependantCost) {
		this.name = dependantName;
		this.age = dependantAge;
		this.cost = dependantCost;
	}
	
	/* DISPLAY DEPENDANT DETAILS */
	public void displayData() {
		System.out.printf("%-40s%-30s%-20s%s\n", "", this.name, this.age, SkillsDemo2Main.euroFormat.format(this.cost));
	}

	/* GETTER FUNCTION TO GET DEPENDANT COST */
	public short getDependantCost() {
		return this.cost;
	}
}
