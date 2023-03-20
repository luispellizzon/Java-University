package policy;

public class Dependant {
	
	private String name;
	private byte age;
	private short cost;

	public Dependant(String dependantName, byte dependantAge, short dependantCost) {
		this.name = dependantName;
		this.age = dependantAge;
		this.cost = dependantCost;
	}

	public void displayData() {
		System.out.printf("%-40s%-28s%-7s€%s\n", "", this.name, this.age, this.cost);
	}

	public short getDependantCost() {
		return this.cost;
	}
}
