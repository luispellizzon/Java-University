package policy;

public class Dependant {
	
	private String name;
	private byte age;

	public Dependant(String dependantName, byte dependantAge) {
		this.name = dependantName;
		this.age = dependantAge;
	}

	public void displayData() {
		System.out.println("Name :" + this.name + "\nAge:" + this.age + "\n\n");
	}
}
