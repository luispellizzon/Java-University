package policy;

public class HealthPolicy {

	private short basicCost; // +80 if age > 50 // 0 < 18
	private byte age, dependantNumber; //dependant 1=250 2=150 3=100 4=50 5> free up to 6
	private String dependantNamem, userName; // dep name < 18
	private boolean inpatient, ageInput; // +200 euro normal + 100 for private
	
	byte getAge () {
		return age;
	}
	
	public HealthPolicy () {
		basicCost = 426;
	}
	
	public void readAge() {
		ageInput = false;
		
		while (ageInput != true) {
			try {
				System.out.print("Please, Enter Your Age:");
				age = SkillsDemo2Main.reader.nextByte();
				
				if(age < 0) {
					throw new Exception();
				} else {
					ageInput = true;	
				}
			} catch (Exception e) {
				System.out.println("Please, Enter Your Age In Positive Numbers\n");
				SkillsDemo2Main.reader.nextLine();
				ageInput = false;
			}
		}
	}
	
	public void readName () {
		System.out.print("Please, Enter Your Name:");
		userName = SkillsDemo2Main.reader.nextLine();
		
	}
	
	public void readNumDependents () {
		
	}
	
	
	void printPolicyDetails () {
		
	}
}