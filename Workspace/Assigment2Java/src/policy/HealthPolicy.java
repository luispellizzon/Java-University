package policy;

public class HealthPolicy {

	private short basicCost, roomTypeCost, inpatientCost, extraCareCost; // +80 if age > 50 // 0 < 18
	private byte age, dependantNumber, dependantAge, extraCareAmmount; //dependant 1=250 2=150 3=100 4=50 5> free up to 6
	private String dependantName, userName, extraCareChoices; // dep name < 18
	private char inpatient, roomType, extraCareInput, extraCareChoiceType;
	private boolean userInput; // +200 euro normal + 100 for private
	private Dependant[] arr;
	
	byte getAge () {
		return age;
	}
	
	byte getDependantNumber() {
		return dependantNumber;
	}
	
	Dependant[] getDependants() {
		return arr;
	}
	
	char getRoomType(){
		return roomType;
	}

	short getRoomTypeCost() {
		return roomTypeCost;
	}
	
	short getInpatientCost() {
		return inpatientCost;
	}

	public HealthPolicy () {
		basicCost = 426;
	}
	
	public void readAge() {
		userInput = false;
		
		while (userInput != true) {
			try {
				System.out.print("Please, Enter Your Age:");
				age = SkillsDemo2Main.reader.nextByte();
				
				if(age < 0) {
					throw new Exception();
				} else {
					userInput = true;	
				}
			} catch (Exception e) {
				System.out.println("Please, Enter Your Age In Positive Numbers\n");
				SkillsDemo2Main.reader.nextLine();
				userInput = false;
			}
		}
		SkillsDemo2Main.reader.nextLine();
	}
	
	public void readName () {
		System.out.print("Please, Enter Your Name:");
		userName = SkillsDemo2Main.reader.nextLine();
		
		
	}
	
	public void readNumDependents () {
		userInput = false;
		
		while (userInput != true) {
			try {
				System.out.print("How Many Dependants Would You Like to Add On The Same Policy? (6 MAX)");
				dependantNumber = SkillsDemo2Main.reader.nextByte();
				
				if(dependantNumber > 6) {
					throw new Exception();
				} else {
					userInput = true;	
				}
				
				
			} catch (Exception e) {
				System.out.println("Please, Enter Only Positive Numbers Up To 6 Dependants\n");
				SkillsDemo2Main.reader.nextLine();
				userInput = false;
			}
		}
		SkillsDemo2Main.reader.nextLine();
		
	}
	
	public void createDependants() {
		
		arr = new Dependant[dependantNumber];
		
		for (int i = 0; i < dependantNumber; i ++) {
			System.out.print("\nName Of Dependant Number " + (i+1) + ":");
			dependantName = SkillsDemo2Main.reader.nextLine();
			
			userInput = false;
			
			while (userInput != true) {
				try {
					System.out.print("Age Of Dependant Number " + (i+1) + ":");
					dependantAge = SkillsDemo2Main.reader.nextByte();
					
					
					if(dependantAge < 0 || dependantAge > 18) {
						throw new Exception();
					} else {
						userInput = true;	
					}
				} catch (Exception e) {
					System.out.println("Please, Dependant Age Must Be a Positive Number And Under 18\n");
					SkillsDemo2Main.reader.nextLine();
					userInput = false;
				}
			}
			
			arr[i] = new Dependant(dependantName, dependantAge);
			SkillsDemo2Main.reader.nextLine();
		}
		
	}
	
	public void roomType() {
		userInput = false;
		while(userInput != true) {
			try {
				System.out.println("Would You Like To Add Inpatient Care? (Y/N):");
				inpatient = SkillsDemo2Main.reader.next().toLowerCase().charAt(0);
				if(inpatient == 'y') {
					inpatientCost = 200;
					
					//while
					while(userInput !=true) {
						try {
							System.out.println("Would You Like PRIVATE or SEMIPRIVATE? (P/S):");
							roomType = SkillsDemo2Main.reader.next().toLowerCase().charAt(0);
							if(roomType == 'p') {
								roomTypeCost = 100;
								userInput = true;
							} else if(roomType == 's'){
								roomType = 0;
								userInput = true;
							} else {
								throw new Exception();
							}
						} catch (Exception e) {
							System.out.println("Please Enter Only P for PRIVATE ROOM or S for SEMI-PRIVATE ROOM.");
							userInput = false;
						}
					}
					//
					
				}
				else if(inpatient == 'n') {
					inpatientCost = 0;
					userInput = true;
				}
				else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Please, Enter Only Y for Yes or N to No\n");
				userInput = false;
			}
		}
	
	}

	public void extraCares() {
		userInput = false;
		while(userInput != true) {
			try {
				System.out.println("We Also Provide The Following Extra Cares:");
				System.out.println("A) Orthopaedic care\nB) Ophthalmic care\nC) Maternity care\nD) Fertility care\nE) Psychiatric care");
				System.out.println("Would You Like To Add Any Additional Extra Care? (Y/N)");
				extraCareInput = SkillsDemo2Main.reader.next().toLowerCase().charAt(0);
				
				if(extraCareInput == 'y') {
					while(userInput != true) {
						try {
							System.out.println("You Can Choose Up To Two Extra Cares. How Many Extra Cares Would You Like To Add? (0, 1 or 2)");
							extraCareAmmount = SkillsDemo2Main.reader.nextByte();
							
							switch(extraCareAmmount) {
							case 0:
								extraCareCost = 0;
								userInput = true;
							case 1:
								;
							case 2:
								System.out.println("Please, Choose 2 Of The Following:");
								System.out.println("A) Orthopaedic care\nB) Ophthalmic care\nC) Maternity care\nD) Fertility care\nE) Psychiatric care\n");
								char prevChoice = 'x';
								for(int i = 0; i < extraCareAmmount; i++) {
									userInput = false;
									while(userInput != true) {
										try {
											System.out.println("Choice " + (i+1) + ": ");
											extraCareChoiceType = SkillsDemo2Main.reader.next().toLowerCase().charAt(0);
											
											
											if(	extraCareChoiceType != 'a' &&
												extraCareChoiceType != 'b' &&
												extraCareChoiceType != 'c' &&
												extraCareChoiceType != 'd' &&
												extraCareChoiceType != 'e') {
												throw new Exception("Please, Choose One Of The Letters A, B, C, D or E.");
											} else if(extraCareChoiceType != prevChoice) {
												extraCareChoices = extraCareChoices + extraCareChoiceType;
												prevChoice = extraCareChoiceType;
												userInput = true;
											} else {
												throw new Exception("You Already Selected This Extra Care. Please, Choose A Different One.");
											}
										} catch (Exception e) {
											System.out.println(e.getMessage());
											userInput = false;
										}
									}
								}
								break;
							default:
								throw new Exception();
							}
						} catch (Exception e) {
							System.out.println("Please, Enter 0, 1 or 2 Choices.");
							SkillsDemo2Main.reader.nextLine();
						}
					}
				} else if(extraCareInput == 'n') {
					extraCareAmmount = 0;
					extraCareCost = 0;
					userInput = true;
				} else {
					throw new Exception();
				}
				
			} catch (Exception e) {
				System.out.println("Please, Enter Only Y (yes) or N (no).");
			}
		}
	}
	void printPolicyDetails () {
		System.out.printf("%65s\n\n\n", "HCI Healthcare Policy");
		System.out.printf("%-40s%s\n\n", "Name", "Luis Pellizzon");
		System.out.printf("%-40s%s\n\n", "Number of dependants", "212");
		
		System.out.printf("%-40s%-28s%-6s%s\n\n", "", "Name of dependants", "Age", "Cost");
		System.out.printf("%-40s%-28s%-7s%s\n", "", "Luis Pellizzon", "20", "300");
		System.out.printf("%-40s%-28s%-7s%s\n", "", "Luis Pellizzon", "20", "300");
		System.out.printf("%-40s%-28s%-7s%s\n", "", "Luis Pellizzon", "20", "300");
	
		
		System.out.printf("\n%-75s%s\n\n", "Basic cost (outpatient care):", "212");
		System.out.printf("%-40s%-35s%s\n\n", "Inpatient Cost:","YES","250");
		System.out.printf("%-40s%-35s%s\n\n", "Room Type:","Private","250");
		System.out.printf("%-40s%-35s%s\n\n", "Additional Extras:","Ortophedic care","250");
		System.out.printf("%-75s%s\n\n", "Total before VAT:","250");
		System.out.printf("%-75s%s\n\n", "VAT:","250");
		System.out.printf("%-75s%s\n\n", "Total:","250");
		
	}
}