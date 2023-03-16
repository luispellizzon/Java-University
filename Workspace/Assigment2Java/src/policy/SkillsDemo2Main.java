package policy;

public class SkillsDemo2Main {

	public static void main(String[] args) {
		
		HealthPolicy policy = new HealthPolicy ();
		
	//	do {
			policy.readAge();
			if (policy.getAge() > 18) {
				policy.readName();
				//etc.
			} else {
				System.out.println("\n\tError message here about age.");
			}
			System.out.print("\n\tDo you want to get another quote? Y/N ");
	//	} while (no more policies to be processed);
		
	}

}
