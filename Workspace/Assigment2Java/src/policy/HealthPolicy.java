package policy;
/*@author LUIS HENRIQUE DE ANDRADE PELLIZZON
 *@desc HCI HEALTHCARE POLICY CLASS TO CREATE A QUOTATION FOR THE USER
 *@date 22/03/2023
 */
public class HealthPolicy {
	/* SETTING HEALTHPOLICY CLASS VARIABLES */
	private short basicCost = 426, dependantsTotalCost = 0, roomTypeCost = 0, 
			inpatientCost = 0, extraCareTotalCost = 0, extraCareCost = 50, 
			policyTotalCostBeforeVAT = 0; 
	private float VATRate = 0.21f, VATCost, policyTotalCostAfterVAT;
	private byte age, dependantNumber, dependantAge, extraCareAmmount;
	private String dependantName, userName, extraCareChoices;
	private char inpatient, roomType, extraCareInput, extraCareChoiceType;
	private boolean userInput;
	private Dependant[] arr;
	
	/* RETURN USER AGE */
	byte getAge () {
		return age;
	}
	
	/* RETURN NUMBER OF DEPENDANTS USER WANTS TO ADD IN THE POLICY */
	byte getDependantNumber() {
		return dependantNumber;
	}
	
	/* READ USER'S AGE */ 
	public void readAge() {
		userInput = false;
		
		/* WHILE LOOP TO CHECK IF USER IS 
		 * ENTERING THE RIGHT INPUT */ 
		while (userInput != true) {
			try {
				System.out.print("Please, Enter Your Age: ");
				age = SkillsDemo2Main.reader.nextByte();
				
				/* IF USER'S AGE IS UNDER 0 THROW ERROR MESSAGE*/
				if(age < 0) {
					throw new Exception();
				} else {
					userInput = true;	
				}
			} catch (Exception e) {
				/* PRINT ERROR MESSAGE AND 
				 * ASK USER TO ENTER AGE AGAIN*/
				System.out.println("Please, Enter Your Age In Positive Numbers!\n");
				SkillsDemo2Main.reader.nextLine();
				userInput = false;
			}
		}
		/* IF USER'S AGE IS OVER 50 APPLY ADDITIONAL CHARGE OF 80 EUROS*/
		if (age > 50) {
			this.basicCost = (short) (this.basicCost + 80);
		}
		SkillsDemo2Main.reader.nextLine();
	}
	
	/* READ USER'S NAME */
	public void readName () {
		System.out.print("Please, Enter Your Name: ");
		userName = SkillsDemo2Main.reader.nextLine();
	}
	
	
	/* READ NUMBER OF DEPENDANTS THE USER WANTS TO ADD IN THE POLICY*/
	public void readNumDependents () {
		userInput = false;
		/* WHILE LOOP TO CHECK IF USER IS 
		 * ENTERING THE RIGHT INPUT */
		while (userInput != true) {
			try {
				System.out.print("\nHow Many Dependants Would You Like to Add On The Same Policy?(6 MAX): ");
				dependantNumber = SkillsDemo2Main.reader.nextByte();
				
				/* IF NUMBER OF DEPENDANTS IS OVER 6 THROW ERROR MESSAGE */
				if(dependantNumber > 6) {
					throw new Exception();
				} else {
					userInput = true;	
				}
			} catch (Exception e) {
				/* PRINT ERROR MESSAGE AND ASK USER AGAIN FOR THE RIGHT INPUT */
				System.out.println("Please, Enter Only Positive Numbers Up To 6 Dependants!\n");
				SkillsDemo2Main.reader.nextLine();
				userInput = false;
			}
		}
		SkillsDemo2Main.reader.nextLine();
	}
	
	
	/* CREATE DEPENDANTS USER WANTS TO ADD IN THE POLICY*/
	public void createDependants() {
		/* DECLARE NEW ARRAY OF DEPENDANTS */
		arr = new Dependant[dependantNumber];
		
		/* FOR LOOP TO ASK DEPENDANTS INFORMATION
		 * FOR EACH DEPENDANT USER WANTS TO ADD */
		for (int i = 0; i < dependantNumber; i ++) {
			System.out.print("\nName Of Dependant Number " + (i+1) + ": ");
			dependantName = SkillsDemo2Main.reader.nextLine();
			userInput = false;
			/* WHILE LOOP TO CHECK IF USER IS 
			 * ENTERING THE RIGHT INPUT */
			while (userInput != true) {
				try {
					System.out.print("Age Of Dependant Number " + (i+1) + ": ");
					dependantAge = SkillsDemo2Main.reader.nextByte();
					/* IF DEPENDANT AGE IS UNDER 0 OR OVER OR EQUAL TO 18 
					 * THROW ERROR MESSAGE*/
					if(dependantAge < 0 || dependantAge >= 18) {
						throw new Exception();
					} else {
						userInput = true;	
					}
				} catch (Exception e) {
					/* PRINT ERROR MESSAGE AND ASK USER AGAIN FOR THE RIGHT INPUT */
					System.out.println("\nPlease, Dependant Age Must Be a Positive Number And Under 18!\n");
					SkillsDemo2Main.reader.nextLine();
					userInput = false;
				}
			}
			
			/* SWITCH CASE EXPRESSION TO KNOW WHICH DEPENDANT IS 
			 * FIRST, SECOND THIRD, FORTH, FIFTH AND SIXTH.
			 * THEN CREATE DEPENDANT USING THE INFORMATION GATHERED 
			 * AND ADD DEPENDANT IN THE ARRAY
			 * APPLY COST OF EACH DEPENDANT, AS PER REQUIREMENTS*/
			switch ((i+1)) {
			case 1:
				arr[i] = new Dependant(dependantName, dependantAge, (short)250);
				break;
			case 2:
				arr[i] = new Dependant(dependantName, dependantAge, (short)150);
				break;
			case 3: 
				arr[i] = new Dependant(dependantName, dependantAge, (short)100);
				break;
			case 4:
				arr[i] = new Dependant(dependantName, dependantAge, (short)50);
				break;
			case 5,6:
				arr[i] = new Dependant(dependantName, dependantAge, (short)0);
				break;
			}
			SkillsDemo2Main.reader.nextLine();
		}
		
		/* FOR LOOP TO LOOP THROUGH EACH DEPENDANT AND
		 * GET EACH DEPENDANT COST TO CREATE DEPENDANTS TOTAL COST */
		for(int j = 0; j < arr.length; j++) {
			dependantsTotalCost = (short) (dependantsTotalCost + arr[j].getDependantCost());
		}
	}
	
	/* ASK IF USER WANTS TO ADD INPATIENT CARE.
	 * IF SO, ASK USER IF WANTS TO CHANGE TO A PRIVATE ROOM */
	public void roomType() {
		userInput = false;
		/* WHILE LOOP TO CHECK IF USER IS 
		 * ENTERING THE RIGHT INPUT */
		while(userInput != true) {
			try {
				/* ASK USER IF WANTS TO ADD INPATIENT CARE*/
				System.out.print("\nWould You Like To Add Inpatient Care? (Y/N): ");
				inpatient = SkillsDemo2Main.reader.next().toLowerCase().charAt(0);
				
				/* IF YES, SET INPATIENTCOST VARIABLE TO 200
				 * AND ASK IF USER WANTS TO CHANGE TO A PRIVATE ROOM */
				if(inpatient == 'y') {
					inpatientCost = 200;
					
					/* WHILE LOOP TO CHECK IF USER IS 
					 * ENTERING THE RIGHT INPUT */
					while(userInput !=true) {
						try {
							/* ASK USER IF WANTS TO CHANGE TO A PRIVATE ROOM */
							System.out.print("\nAdding Inpatient Care Grants You A Semi-Private Room.\nWould You Like To Change To A Private Room? Extra 200 Euros.(Y/N): ");
							roomType = SkillsDemo2Main.reader.next().toLowerCase().charAt(0);
							
							/* IF YES, SET ROOMTYPECOST VARIABLE TO 100 */
							if(roomType == 'y') {
								roomTypeCost = 100;
								userInput = true;
							} else if(roomType == 'n'){
								userInput = true;
							} else {
								/* IF INPUT IS NOT EQUAL TO Y OR N, THROW ERROR MESSAGE */
								throw new Exception("Please, Enter Only Y (YES) To Change To a Private Room Or N (NO).");
							}
						} catch (Exception e) {
							/* PRINT ERROR MESSAGE AND ASK USER AGAIN */
							System.out.println(e.getMessage());
							userInput = false;
						}
					}
				}
				/* IF NO, SKIP WHILE LOOP*/
				else if(inpatient == 'n') {
					userInput = true;
				}
				else {
					/* IF INPUT IS NOT EQUAL TO Y OR N, THROW ERROR MESSAGE */
					throw new Exception("Please, Enter Only Y for YES or N to NO\n");
				}
			} catch (Exception e) {
				/* PRINT ERROR MESSAGE AND ASK USER AGAIN */
				System.out.println(e.getMessage());
				userInput = false;
			}
		}
	}

	/* ASK IF USER WANTS TO ADD EXTRA CARES */
	public void extraCares() {
		userInput = false;
		/* WHILE LOOP TO CHECK IF USER IS 
		 * ENTERING THE RIGHT INPUT */
		while(userInput != true) {
			try {
				/* PRINT EXTRA CARE OPTIONS */
				System.out.println("\nWe Also Provide The Following Extra Cares:");
				System.out.println("A) Orthopaedic care\nB) Ophthalmic care\nC) Maternity care\nD) Fertility care\nE) Psychiatric care");
				/* ASK IF USER WANTS TO ADD ANY */
				System.out.print("Would You Like To Add Any Additional Extra Care? (Y/N): ");
				extraCareInput = SkillsDemo2Main.reader.next().toLowerCase().charAt(0);
				
				/* IF YES, CHECK INPUT AND 
				 * ASK HOW MANY EXTRA CARES THE USER WANTS TO ADD. UP TO 2 */
				if(extraCareInput == 'y') {
					while(userInput != true) {
						try {
							System.out.print("\nYou Can Choose Up To Two Extra Cares. How Many Extra Cares Would You Like To Add? (1 or 2): ");
							extraCareAmmount = SkillsDemo2Main.reader.nextByte();
							
							/*SWITCH CASE EXPRESSION TO CHECK AMMOUNT 
							 * OF EXTRA CARES THE USER WANTS TO ADD*/
							switch(extraCareAmmount) {
							
							/*IF 1 EXTRA CARE, ASK WHICH ONE OF THE OPTIONS AND CHECK INPUTS*/
							case 1:
								/* PRINT OPTIONS */
								System.out.println("\nPlease, Choose 1 Of The Following:");
								System.out.print("A) Orthopaedic care\nB) Ophthalmic care\nC) Maternity care\nD) Fertility care\nE) Psychiatric care\n");
								userInput = false;
								while(userInput != true) {
									try {
										System.out.print("Enter Extra Care Choice: ");
										extraCareChoiceType = SkillsDemo2Main.reader.next().toLowerCase().charAt(0);
										
										/*IF INPUT IS NOT EQUAL TO ANY OF THE OPTIONS, 
										 * THROW ERROR MESSAGE */
										if(	extraCareChoiceType != 'a' &&
											extraCareChoiceType != 'b' &&
											extraCareChoiceType != 'c' &&
											extraCareChoiceType != 'd' &&
											extraCareChoiceType != 'e') {
											throw new Exception("Please, Choose One Of The Letters A, B, C, D or E.");
										} else{
											/* SET EXTRACARECHOICES TO BE A STRING
											 * WHICH CONTAINS THE LETTERS CHOOSEN BY THE USER
											 * WHEN CHOOSING EXTRA CARE OPTIONS */
											extraCareChoices = extraCareChoices + extraCareChoiceType;
											/*SET EXTRA CARE TOTAL COST TO BE 50 
											 * BECAUSE THERE ARE ONLY ONE CHOOSEN ON CASE 1*/
											extraCareTotalCost = 50;
											userInput = true;
										}
									} catch (Exception e) {
										/* PRINT ERROR MESSAGE AND ASK USER AGAIN */
										System.out.println(e.getMessage());
										userInput = false;
									}
								};
								break;
								
							/* IF 2 EXTRA CARE, ASK FOR TWO EXTRA CARE OPTIONS
							 * ALWAYS CHECKING THE INPUTS*/
							case 2:
								/* PRINT OPTIONS */
								System.out.println("\nPlease, Choose 2 Of The Following:");
								System.out.print("A) Orthopaedic care\nB) Ophthalmic care\nC) Maternity care\nD) Fertility care\nE) Psychiatric care\n");
								
								/*SET PREVIOUS CHOICE TO BE EQUAL TO ANY LETTER 
								 * DIFFERENT FROM THE OPTIONS*/
								char prevChoice = 'x';
								
								/*FOR LOOP TO ASK FOR TWO INPUT CHOICES*/
								for(int i = 0; i < extraCareAmmount; i++) {
									userInput = false;
									/* CHECK INPUTS */
									while(userInput != true) {
										try {
											/* ASK INPUT ACCORDING TO ITS ORDER, 
											 * IF IT IS THE FIRST OPTION OR SECOND*/
											System.out.print("Enter Extra Care Choice " + (i+1) + ": ");
											extraCareChoiceType = SkillsDemo2Main.reader.next().toLowerCase().charAt(0);
											
											/*IF INPUT IS DIFFERENT FROM THE OPTIONS DISPLAYED
											 * THROW ERROR MESSAGE */
											if(	extraCareChoiceType != 'a' &&
												extraCareChoiceType != 'b' &&
												extraCareChoiceType != 'c' &&
												extraCareChoiceType != 'd' &&
												extraCareChoiceType != 'e') {
												throw new Exception("Please, Choose One Of The Letters A, B, C, D or E.\n");
												
											} else if(extraCareChoiceType != prevChoice) {
												/* CHECK IF INPUT WAS ALREADY CHOOSEN, IF NOT,
												 * SET EXTRACARECHOICES TO BE A STRING
											     * WHICH CONTAINS THE LETTERS CHOOSEN BY THE USER
											     * WHEN CHOOSING EXTRA CARE OPTIONS */
												extraCareChoices = extraCareChoices + extraCareChoiceType;
												/* SUM UP EXTRA CARE COST AND SET EXTRA CARE TOTAL COST
												 * TO BE THE TOTAL SUM */
												extraCareTotalCost = (short)(extraCareTotalCost + 50);
												/*SET PREVIOUS CHOICE TO BE INPUT */
												prevChoice = extraCareChoiceType;
												userInput = true;
											} else {
												throw new Exception("You Already Selected This Extra Care. Please, Choose A Different One.");
											}
										} catch (Exception e) {
											/* PRINT ERROR MESSAGE */
											System.out.println(e.getMessage());
											userInput = false;
										}
									}
								}
								break;
							/* IF EXPRESSION IS NOT EQUAL TO CASE 1 OR CASE 2,
							 * SET ERROR MESSAGE */
							default:
								throw new Exception();
							}
						} catch (Exception e) {
							/* PRINT ERROR MESSAGE*/
							System.out.println("Please, Enter 1 or 2 Choices.");
							SkillsDemo2Main.reader.nextLine();
						}
					}
					/* IF USER DOES NOT WANT TO ADD ANY EXTRA CARE,
					 * SET NUMBER OF EXTRA CARES TO 0
					 * SET EXTRA CARE TOTAL COST TO 0*/
				} else if(extraCareInput == 'n') {
					extraCareAmmount = 0;
					extraCareTotalCost = 0;
					userInput = true;
					/* IF USER INPUT DIFFERENT FROM Y OR N
					 * THROW ERROR MESSAGE*/
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				/* PRINT ERROR MESSAGE */
				System.out.println("Please, Enter Only Y (yes) or N (no).");
			}
		}
	}
	
	
	/*CALCULATE AND RETURN TOTAL COST BEFORE VAT*/
	public short getTotalCostBeforeVAT() {
		/*SET COST BEFORE VAT TO BE THE SUM OF ALL COSTS VARIABLES*/
		policyTotalCostBeforeVAT = (short)(basicCost + dependantsTotalCost + inpatientCost + roomTypeCost + extraCareTotalCost);
		/*SET VATCOST TO BE 21% OF THE COST BEFORE VAT */
		this.VATCost = policyTotalCostBeforeVAT * VATRate;
		return policyTotalCostBeforeVAT;
	}
	
	
	/*CALCULATE AND RETURN TOTAL COST AFTER VAT*/
	public float getTotalCostAfterVAT() {
		/*SET COST AFTER VAT TO BE THE SUM OF COST BEFORE VAT + VATCOST*/
		policyTotalCostAfterVAT = policyTotalCostBeforeVAT + VATCost ;
		return policyTotalCostAfterVAT;
	}
	
	/*PRINT POLICY DETAILS*/
	void printPolicyDetails () {
		/* PRINT QUOTATION TITLE */
		System.out.printf("\n\n%65s\n\n\n", "HCI Healthcare Policy");
		/* PRINT USER NAME */
		System.out.printf("%-40s%s\n\n", "Name", this.userName);
		/* PRINT NUMBER OF DEPENDANTS */
		System.out.printf("%-40s%s\n", "Number of dependants", this.dependantNumber);
		
		/*IF ARRAY EXISTS, AND HAS DEPENDANT OBJECT INSIDE */
		if(arr != null) {
			/* PRINT LIST OF DEPENDANTS */
			System.out.printf("\n%-40s%-28s%-7s%s\n\n", "", "NAME OF DEPENDANTS", "AGE", "COST");
			
			/* FOR EACH DEPENDANT IN THE ARRAY
			 * PRINT DEPENDANT DETAIL*/
			for(int i=0; i < arr.length; i++) {
				arr[i].displayData();
			}
		}
		
		/* PRINT BASIC COST */
		System.out.printf("\n%-75s€%s\n\n", "Basic cost (outpatient care):", this.basicCost);
		
		/* IF THERE IS INPATIENT COST THEN*/
		if(inpatient == 'y') {
			/* PRINT INPATIENT COST SAYING YES WITH COST */
			System.out.printf("%-40s%-35s€%s\n\n", "Inpatient Cost:","YES",this.inpatientCost);
		} else {
			/* PRINT INPATIENT COST SAYING NO WITH 0 COST */
			System.out.printf("%-40s%-35s€%s\n\n", "Inpatient Cost:","NO", this.inpatientCost);
		}
		
		/* IF USER ADDED PRIVATE ROOM */
		if(roomType == 'y') {
			/* PRINT PRIVATE ROOM AND COST */
			System.out.printf("%-40s%-35s€%s\n\n", "Room Type:","Private",this.roomTypeCost);
		} else if(roomType == 'n') {
			/* PRINT SEMI-PRIVATE ROOM AND COST */
			System.out.printf("%-40s%-35s%s\n\n", "Room Type:","Semi-Private","INCLUDED");
			
			/* IF ROOMTYPE VARIABLE IS NULL
			 * BECAUSE USER DOES NOT WANT INPATIENT CARE */
		} else {
			/* PRINT NA ROOM AND 0 COST */
			System.out.printf("%-40s%-35s€%s\n\n", "Room Type:","NA",this.roomTypeCost);
		}
		
		/* IF USER ADDED EXTRA CARE CHOICES */
		if(extraCareChoices != null) {
			/* PRINT ADDITIONAL EXTRAS LIST*/
			System.out.printf("%-40s%-35s%s\n\n", "Additional Extras:","EXTRA CARE TYPE","COST");
			
			/* LOOP EACH LETTER IN THE STRING,
			 * EACH LETTER REPRESENTS A EXTRA CARE CHOICE */
			for(int i = 0; i < extraCareChoices.length(); i++) {
				
				/* COMPARE EACH LETTER WITH A CASE,
				 * THEN PRINT EXTRA CARE CHOICE WITH ITS COST*/
				switch(extraCareChoices.charAt(i)) {
				case 'a':
					System.out.printf("%-40s%-35s€%s\n", "","Orthopaedic care",this.extraCareCost);
					break;
				case 'b':
					System.out.printf("%-40s%-35s€%s\n", "","Ophthalmic care",this.extraCareCost);
					break;
				case 'c':
					System.out.printf("%-40s%-35s€%s\n", "","Maternity care",this.extraCareCost);
					break;
				case 'd':
					System.out.printf("%-40s%-35s€%s\n", "","Fertility care",this.extraCareCost);
					break;
				case 'e':
					System.out.printf("%-40s%-35s€%s\n", "","Psychiatric care",this.extraCareCost);
					break;
				}
			}
		}else {
			/* PRINT NONE IF THERE IS NO EXTRA CARE ADDED*/
			System.out.printf("%-40s%-35s\n", "Additional Extras:","NONE");
		}

		/* PRINT TOTAL BEFORE VAT */
		System.out.printf("\n%-75s€%s\n\n", "Total before VAT:", getTotalCostBeforeVAT());
		/* PRINT VAT COST */
		System.out.printf("%-75s€%.2f\n\n", "VAT:",this.VATCost);
		/*PRINT TOTAL AFTER VAT*/
		System.out.printf("%-75s€%.2f\n\n", "Total:", getTotalCostAfterVAT());
	}
}