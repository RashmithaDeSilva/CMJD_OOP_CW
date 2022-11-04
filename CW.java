import java.util.*;
import java.io.IOException;

class CW{
		
	public static String[] studentID = new String[0];  //  All Student ID
	public static String[] studentName = new String[0];  //  All Student name
	public static int[] PFMarks = new int[0];  //  All Programing Fundamentals Marks
	public static int[] DBMSMarks = new int[0];  //  All Database Management System Marks
	public static int[] total = new int[0];  //  All Totals
	public static int[] rank = new int[0];  //  Student Ranks
		
	public static void main(String args[]){
		do{
			int x = mainMenu();
			rank();
			switch(x){
				case -1:
					break;
				case 1:
					cls();
					addNewStudent();
					cls();
					break;
				case 2:
					cls();
					addNewStudentWithMarks();
					cls();
					break;
				case 3:
					cls();
					addMarks();
					cls();
					break;
				case 4:
					cls();
					updateStudentDetails();
					cls();
					break;
				case 5:
					cls();
					updateMarks();
					cls();
					break;
				case 6:
					cls();
					deleteStudent();
					cls();
					break;
				case 7:
					cls();
					PrintStudentDetails();
					cls();
					break;
				case 8:
					cls();
					printStudentRanks();
					cls();
					break;
				case 9:
					cls();
					bestInProgrammingFundamentals();
					cls();
					break;
				case 10:
					cls();
					bestInDatabaseManagementSystem();
					cls();
					break;
				default :
					System.out.println("This value is invalid\t..... !\n");
					break;
			}
						
		}while(true);
	}
		
	//  For clear CMD----------------------------------------------------------------------------------------------------------------------------
	public static void cls(){
		try{
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		}catch(Exception e){
			System.out.println(e);
		}
	}
		
	//  Have in Intiger Input----------------------------------------------------------------------------------------------------------------------
	public static int intInput(){
		Scanner user = new Scanner(System.in);
		int input = -1;
		try{
			input = user.nextInt();
		}catch(InputMismatchException e){
			System.out.println("Enter Intiger value\t..... !\n");
		}
		return input;
	}
		
	//  Have in String Input----------------------------------------------------------------------------------------------------------------------
	public static String strInput(){
		Scanner user = new Scanner(System.in);
		String input="";
		try{
			input = user.nextLine();
		}catch(Exception e){
			System.out.println(e);
		}
		return input;
	}
	
	//  Top Tital----------------------------------------------------------------------------------------------------------------------------------
	public static void tital(String titalName){
		int count = (titalName.length() / 2);
		count = 46 - count;
		System.out.println();
		for(int i=0;i<94;i++){System.out.print("-");}
		System.out.print("\n|");
		for(int i=0;i<count;i++){System.out.print(" ");}
		System.out.print(titalName);
		count = (titalName.length() / 2);
		count = 45 - count;
		for(int i=0;i<count;i++){System.out.print(" ");}
		System.out.print("|\n");
		for(int i=0;i<94;i++){System.out.print("-");}
		System.out.println();
		count = 0;
	}
	
	//  String Array Seter------------------------------------------------------------------------------------------------------------------------
	public static void strArrSet(String ID, String name){
			
		String[] temp1 = new String[studentID.length+1];      //  1
		String[] temp2 = new String[studentName.length+1];    //  0
			
		//  Student ID set
		for(int i=0;i<studentID.length;i++){
			temp1[i] = studentID[i].toUpperCase();
		}
		temp1[temp1.length-1] = ID.toUpperCase();
		studentID = temp1;
						
		//  Student name set
		for(int i=0;i<studentName.length;i++){
			temp2[i] = studentName[i];
		}
		temp2[temp2.length-1] = name;
		studentName = temp2;

	}
		
	//  String Array Delete----------------------------------------------------------------------------------------------------------------------
	public static void strArrDelete(int deteleValue){
			
		//  Delete student ID
		String[] temp1 = new String[studentID.length-1];   //  1
		for(int i=0;i<deteleValue;i++){
			temp1[i] = studentID[i];
		}
		for(int i=(studentID.length-1);i>deteleValue;i--){
			temp1[i-1] = studentID[i];
		}
		studentID = temp1;
										
		//  Delete student names
		String[] temp2 = new  String[studentName.length-1];  //  0
		for(int i=0;i<deteleValue;i++){
			temp2[i] = studentName[i];
		}
		for(int i=(studentName.length-1);i>deteleValue;i--){
			temp2[i-1] = studentName[i];
		}
		studentName = temp2;
	}
		
	//  Int Array Seter---------------------------------------------------------------------------------------------------------------------------
	public static void intArrSet(int PF, int DBMS){
					
		//  Add new PF marks
		int[] temp1 = new int[PFMarks.length+1];        //  1
		for(int i=0;i<PFMarks.length;i++){
			temp1[i] = PFMarks[i];
		}
		temp1[temp1.length-1] = PF;
		PFMarks = temp1;
									
		//  Add new DBMS marks
		int[] temp2 = new int[DBMSMarks.length+1];      //  0
		for(int i=0;i<DBMSMarks.length;i++){
			temp2[i] = DBMSMarks[i];
		}
		temp2[temp2.length-1] = DBMS;
		DBMSMarks = temp2;
								
		//  Refresh Total
		int[] temp3 = new int[PFMarks.length];
		for(int i=0;i<total.length;i++){
			temp3[i] = PFMarks[i] + DBMSMarks[i];
		}
		temp3[temp3.length-1] = PFMarks[PFMarks.length-1] + DBMSMarks[DBMSMarks.length-1];
		total = temp3;
				
	}
		
	//  Int Array Delete-------------------------------------------------------------------------------------------------------------------------
	public static void intArrDelete(int deleteValue){
					
		//  Delete student ID
		int[] temp1 = new int[PFMarks.length-1];
		for(int i=0;i<deleteValue;i++){
			temp1[i] = PFMarks[i];
		}
		for(int i=(PFMarks.length-1);i>deleteValue;i--){
			temp1[i-1] = PFMarks[i];
		}
		PFMarks = temp1;
				
		//  Delete student name
		int[] temp2 = new int[DBMSMarks.length-1];
		for(int i=0;i<deleteValue;i++){
			temp2[i] = DBMSMarks[i];
		}
		for(int i=(DBMSMarks.length-1);i>deleteValue;i--){
			temp2[i-1] = DBMSMarks[i];
		}
		DBMSMarks = temp2;
		
		//  Reload total
		int[] temp3 = new int[total.length-1];
		for(int i=0;i<deleteValue;i++){
			temp3[i] = total[i];
		}
		for(int i=(total.length-1);i>deleteValue;i--){
			temp3[i-1] = total[i];
		}
		total = temp3;
	}
		
	//  Checking ID numbers-------------------------------------------------------------------------------------------------------------------
	public static boolean checkID(String IDNumber){
		boolean checkOut = false;
		for(int i=0;i<studentID.length;i++){
			if(IDNumber.toUpperCase().equals(studentID[i])){
				checkOut = true;
				break;
			}
		}
		return checkOut;
	}
		
	//  Exit or Continue-------------------------------------------------------------------------------------------------------------------------
	public static boolean exitOrContinue(){
		boolean loopBreak = true,output=false;
		String input;
		do{
			System.out.print("Do you want to try again another student (Y/N) :- ");
			input = strInput();
			if(input.toUpperCase().equals("Y")){
				output = true;
				loopBreak  = false;
			}else if(input.toUpperCase().equals("N")){
				loopBreak  = false;
			}else{
				System.out.println("Incorect anser\t..... !");
			}
			System.out.println();
		}while(loopBreak);
		return output;
	}
	
	//  Set Rank---------------------------------------------------------------------------------------------------------------------------------
	public static void rank(){
		//  Refresh total
		for(int i=0;i<total.length;i++){total[i] = PFMarks[i] + DBMSMarks[i];}
		
		int[] temp = new int[total.length];
		int[] temp2;
		int[] temp3 = new int[0];
		int count = 0;
		rank = temp3;
				
		//  Cheking same values
		for(int i=0;i<temp.length;i++){
			for(int j=0;j<temp.length;j++){
				temp[i] = (total[i] == total[j] && i != j) ? -1 : total[i];
				if(total.length>1){
					temp[0] = (total[0] == total[1]) ? -1 : total[0];
				}
			}
		}
				
		//  Count same value 
		for(int i=0;i<temp.length;i++){
			count += (temp[i] != -1) ? 0 : 1;
		}
				
		//  Sort temp array
		for(int i=0;i<temp.length;i++){
			for(int j=0;j<(temp.length-1);j++){
				if(temp[j] > temp[j+1]){
					int t = temp[j];
					temp[j] = temp[j+1];
					temp[j+1] = t;
				}
			}
		}
				
		// New rank with out same marks
		temp2 = new int[temp.length-count];
		for(int i=0;i<temp2.length;i++){
			temp2[i] = temp[i+count];
		}
		rank = temp2;
	}
		
	//  Main Menu-------------------------------------------------------------------------------------------------------------------------------
	public static int mainMenu(){
		//  Tital
		tital("WELCOME TO GDSE MARKS MANAGEMENT SYSTEM");
		
		//  Menu
		System.out.println("\n[1]  Add New Student \t\t\t\t [2]  Add New Student With Marks");
		System.out.println("[3]  Add Marks \t\t\t\t\t [4]  Update Student Details");
		System.out.println("[5]  Update Marks \t\t\t\t [6]  Delete Student");
		System.out.println("[7]  Print Student Details \t\t\t [8]  Print Student Ranks");
		System.out.println("[9]  Best in Programing Fundamentals \t\t [10] Best in Database Management System\n");
		System.out.print("Enter an option to continue > ");
		int input = intInput();
		return input;
	}
		
	//  [1]   Add new Student------------------------------------------------------------------------------------------------------------------
	public static void addNewStudent(){
		//  Tital
		tital("ADD NEW STUDENT");
				
		do{
			String inputID,inputSN;
			boolean loopBreak = true;
						
			//  Having student ID and checking
			do{
				System.out.print("\nEnter Student ID :- ");
				inputID = strInput();
				boolean IDCheck = checkID(inputID);
				if(IDCheck){
					System.out.println("This Student ID already exists\t..... !\n");
					loopBreak = true;
				}else{
					loopBreak = false;
				}

			}while(loopBreak);
						
			//  Having student name
			System.out.print("Enter Student Name :- ");
			inputSN = strInput();
			strArrSet(inputID,inputSN);
						
			//  Alocat defalte value to that student Pro and DBMS marks
			intArrSet(-1,-1);
			System.out.print("\nStudent has been added successfuliy, ");
				
		}while(exitOrContinue());
	}
		
	//  [2]   Add New Student With Marks----------------------------------------------------------------------------------------------------
	public static void addNewStudentWithMarks(){
		//  Tital
		tital(" ADD NEW STUDENT WITH MARKS");
				
		do{
			String inputID,inputName;
			int inputPF,inputDBMS;
			boolean loopBreak = true;
						
			//  Having student ID and checking
			do{
				System.out.print("\nEnter Student ID :- ");
				inputID = strInput();
				boolean IDCheck = checkID(inputID);
				if(IDCheck){
					System.out.println("This Student ID already exists\t..... !\n");
					loopBreak = true;
				}else{
					loopBreak = false;
				}
			}while(loopBreak);
						
			//  Having student name
			System.out.print("Enter Student Name :- ");
			inputName = strInput();
			strArrSet(inputID,inputName);
			System.out.println();
						
			//  Having PF marks
			loopBreak =true;
			do{
				System.out.print("Programming Fundementals Marks :- ");
				inputPF = intInput();
				if(inputPF >= 0 && 100 >= inputPF){
					loopBreak = false;
				}else if(inputPF == -1){
				}else{
					System.out.println("Invalid marks, please enter correct marks\t..... !\n");
				}
			}while(loopBreak);
						
			//  Having DBMS marks
			loopBreak = true;
			do{
				System.out.print("Databese Management System Marks :- ");
				inputDBMS = intInput();
				if(inputDBMS >= 0 && 100 >= inputDBMS){
					loopBreak = false;
				}else if(inputDBMS == -1){
				}else{
					System.out.println("Invalid marks, please enter correct marks\t..... !\n");
				}
			}while(loopBreak);
			intArrSet(inputPF,inputDBMS);
			System.out.println();
						
		}while(exitOrContinue());
	}		
		
	//  [3]   Add Marks--------------------------------------------------------------------------------------------------------------------------
	public static void addMarks(){
		//  Tital
		tital("ADD MARKS");
				
		boolean loopBreak = true;
		do{	
			
			String inputID;
			int inputPF, inputDBMS;
						
			System.out.print("\nEnter Student ID :- ");
			inputID = strInput();
			if(checkID(inputID)){
							
				//  Checking student ID array position
				int count=0;
				for(int i=0;i<studentID.length;i++){
					if(inputID.toUpperCase().equals(studentID[i])){
						break;
					}else{count++;}
				}
				System.out.println(studentName[count]+"\n");
								
				//  Checkin marks already have or not
				if(total[count] != -2){
					System.out.println("This student's marks have been already added.");
					System.out.println("If you want to update the marks, please use [5] Update Marks option.\n");
				}else{
											
					//  Having PF marks
					do{
						System.out.print("Programming Fundementals Marks :- ");
						inputPF = intInput();
						if(inputPF >= 0 && 100 >= inputPF){
							PFMarks[count] = inputPF;
							loopBreak = false;
						}else if(inputPF == -1){
						}else{
							System.out.println("Invalid marks, please enter correct marks\t..... !\n");
						}
					}while(loopBreak);
											
					//  Having DBMS marks
					loopBreak = true;
					do{
						System.out.print("Databese Management System Marks :- ");
						inputDBMS = intInput();
						if(inputDBMS >= 0 && 100 >= inputDBMS){
							DBMSMarks[count] = inputDBMS;
							loopBreak = false;
						}else if(inputDBMS == -1){
						}else{
							System.out.println("Invalid marks, please enter correct marks\t..... !\n");
						}
					}while(loopBreak);
				}
				//  Reset total
				int[] temp = new int[total.length];
				for(int i=0;i<temp.length;i++){
					temp[i] = PFMarks[i] + DBMSMarks[i];
				}
				total = temp;
								
				loopBreak = exitOrContinue();
			}else{
				System.out.print("Invalid Student ID, ");
				loopBreak = exitOrContinue();
			}
		}while(loopBreak);
	}
		
	//  [4]   Update Student Details------------------------------------------------------------------------------------------------------------
	public static void updateStudentDetails(){
		//  Tital
		tital(" UPDATE STUDENT DETAILS");
				
		boolean loopBreak = true;
		do{
			
			boolean IDCheck = false;
			String inputID, inputName;
			int count=0;
			
			//  Having student ID
			System.out.print("\nEnter Student ID :-");
			inputID = strInput();

			//  Checking student ID
			IDCheck = checkID(inputID);
			if(IDCheck){
				//  Count ID array pocition
				for(int i=0;i<studentID.length;i++){
					if(inputID.toUpperCase().equals(studentID[i])){
						break;
					}else{count++;}
				}
				System.out.println(studentName[count]+"\n");
								
				//  Input new student name
				System.out.print("Enter the new student name :- ");
				inputName = strInput();
								
				//  Chenge old name to new name
				studentName[count] = inputName;
				System.out.println("\nStudent details has been update successfully.");
				loopBreak = exitOrContinue();

			}else{
				System.out.print("Invalid Student ID, ");
				loopBreak = exitOrContinue();
			}
		}while(loopBreak);
	}
		
	//  [5]   Update Marks----------------------------------------------------------------------------------------------------------------------
	public static void updateMarks(){
		//  Tital
		tital(" UPDATE MARKS");
				
		boolean loopBreak = true;
		do{
					
			String inputID;
			int count=0, inputPF, inputDBMS;
			boolean IDCheck = false;
					
			//  Having student ID
			System.out.print("Enter Student ID :- ");
			inputID = strInput();
			//  Checking student ID
			IDCheck = checkID(inputID);
			if(IDCheck){
				//  Count ID array pocition
				for(int i=0;i<studentID.length;i++){
					if(inputID.toUpperCase().equals(studentID[i])){
						break;
					}else{count++;}
				}
				System.out.println(studentName[count]+"\n");
								
				if(total[count] == -2){
					System.out.println("This student's marks yet to be added.");
				}else{
									
					System.out.println("Programming Fundamentals Marks :- "+PFMarks[count]);
					System.out.println("Detabase Management System Marks :- "+DBMSMarks[count]+"\n\n");
										
					//  Input new PF marks
					do{
						System.out.print("Programming Fundementals Marks :- ");
						inputPF = intInput();
						if(inputPF >= 0 && 100 >= inputPF){
							//  Cheng old marks to new marks
							PFMarks[count] = inputPF;
							loopBreak = false;
						}else if(inputPF == -1){
						}else{
							System.out.println("Invalid marks, please enter correct marks\t..... !\n");
						}
					}while(loopBreak);			
													
					//  Input new DBMS marks
					loopBreak = true;
					do{
						System.out.print("Databese Management System Marks :- ");
						inputDBMS = intInput();
						if(inputDBMS >= 0 && 100 >= inputDBMS){
							//  Cheng old marks to new marks
							DBMSMarks[count] = inputDBMS;
							System.out.println("Marks have been updated successfully.");
							loopBreak = false;
						}else if(inputDBMS == -1){
						}else{
							System.out.println("Invalid marks, please enter correct marks\t..... !\n");
						}
					}while(loopBreak);
										
					//  Reset total
					int[] temp = new int[total.length];
					for(int i=0;i<temp.length;i++){
						temp[i] = PFMarks[i] + DBMSMarks[i];
					}
					total = temp;
				}
								
				loopBreak = exitOrContinue();

			}else{
				System.out.print("Invalid Student ID, ");
				loopBreak = exitOrContinue();
			}
		}while(loopBreak);
	}
		
	//  [6]   Delete Student---------------------------------------------------------------------------------------------------------------------
	public static void deleteStudent(){
		//  Tital
		tital(" DELETE STUDENT");
				
		boolean loopBreak = true;
		//  Input student ID
		do{
					 					
			boolean  IDCheck;
			String inputID;
			int count=0;
						
			System.out.print("\nEnter Student ID :- ");
			inputID = strInput();
						
			//  Checking ID
			IDCheck =  checkID(inputID);
			if(IDCheck){
							
				//  Count that student ID's array pocition
				for(int i=0;i<studentID.length;i++){
					if(inputID.toUpperCase().equals(studentID[i])){
						break;
					}else{count++;}
				}
								
				//  Delete student to coll method
				strArrDelete(count);
				intArrDelete(count);
				System.out.println("Student has been deleted successfully.");
								
			}else{System.out.print("Invalid Student ID, ");}
						
			loopBreak = exitOrContinue();
			System.out.println();
						
		}while(loopBreak);
	}
		
	//  [7]   Print Student Details--------------------------------------------------------------------------------------------------------------
	public static void PrintStudentDetails(){
		//  Tital
		tital("PRINT STUDENT DETAILS");
				
		boolean loopBreak = true;
		do{
						
			String inputID;
			boolean IDCheck;
						
			do{
				int count=0;
								
				//  Get student ID
				System.out.print("\nEnter Student ID :- ");
				inputID = strInput();
								
				//  Checking ID
				IDCheck = checkID(inputID);
				if(IDCheck != true){
					System.out.print("Invalid Student ID, ");
					loopBreak = exitOrContinue();
										
				}else{
					for(int i=0;i<studentID.length;i++){
						if(inputID.toUpperCase().equals(studentID[i])){
													
							//  Calculat rank
							int studentRank = 1;
							for(int j=0;j<rank.length;j++){
								if(rank[j] == total[count]){
									studentRank += j;
									break;
								}
							}
														
							// Strin rank
							String strRank;
							strRank = ((rank.length - studentRank) + 1 == 1) ? "(First)" : ((rank.length - studentRank) + 1 == 2) ? "(Second)" : ((rank.length - studentRank) + 1 == 3) ? "(Third)" : "(     )";
														
							System.out.println("Student Name :- "+studentName[count]);
							if(total[count] != (-2)){
								System.out.println("+---------------------------------------+-----------------------+");
								System.out.println("| Programming Fundamentals Marks\t|\t\t"+PFMarks[count]+"\t|");
								System.out.println("| Database Management System Marks\t|\t\t"+DBMSMarks[count]+"\t|");
								System.out.println("| Total Marks\t\t\t\t|\t\t"+total[count]+"\t|");
								System.out.println("| Avg. Marks\t\t\t\t|\t      "+(total[count]/2.0)+"\t|");
								System.out.println("| Rank\t\t\t\t\t|\t"+((rank.length - studentRank) + 1)+" "+strRank+"\t|");
								System.out.println("+---------------------------------------+-----------------------+");
								
							}else{
								System.out.println("\nMarks yet to be added\t..... !\n");
							}
							break;
						}else{
							count++;
						}
					}
					loopBreak = exitOrContinue();
				}
			}while(loopBreak);
		}while(loopBreak);	
	}
		
	//  [8]  Print Student Ranks---------------------------------------------------------------------------------------------------------------
	public static void printStudentRanks(){
		//  Tital
		tital("PRINT STUDENT RANKS");
				
		boolean loopBreak = true;
		do{
			
			String[] ID = new String[0];
			String[] name = new String[0];
			int[] tot = new int[0];
						
			//  Reset all values without emty marks 
			for(int i=0;i<studentID.length;i++){
				if(total[i] != (-2)){
					int[] temp = new int[tot.length+1];
					String[] temp2 = new String[ID.length+1];
					String[] temp3 = new String[name.length+1];
										
					//  Reset toatl  
					for(int j=0;j<tot.length;j++){
						temp[j] = tot[j];
					}
					temp[temp.length-1] = total[i];
					tot = temp;
										
					//  Reset ID
					for(int j=0;j<ID.length;j++){
						temp2[j] = ID[j];
					}
					temp2[temp2.length-1] = studentID[i];
					ID = temp2;
										
					//  Reset name
					for(int j=0;j<name.length;j++){
						temp3[j] = name[j];
					}
					temp3[temp3.length-1] = studentName[i];
					name = temp3;
				}
			}
						
			//  Sort all values
			for(int i=0;i<tot.length;i++){
				for(int j=0;j<(tot.length-1);j++){
					if(tot[j] > tot[j+1]){
						int temp = tot[j];
						tot[j] = tot[j+1];
						tot[j+1] = temp;
												
						String temp2 = ID[j];
						ID[j] = ID[j+1];
						ID[j+1] = temp2;
												
						temp2 = name[j];
						name[j] = name[j+1];
						name[j+1] = temp2;
												
					}
				}
			}
						
			System.out.println("\n+--------+-------+---------------+---------------+---------------+");
			System.out.println("| Rank\t | ID\t | Name\t\t | Total Marks\t | Avg. Marks\t |");
			System.out.println("+--------+-------+---------------+---------------+---------------+");
			for(int i=(tot.length-1);i>=0;i--){System.out.printf("|  %-6d%-2s%-6s%-3s%-13s%-7s%-9s%-6s%-10.2f%s\n",(tot.length - i),"|",ID[i],"|",name[i],"|",tot[i],"|",(tot[i]/2.0),"|");}
			System.out.println("+--------+-------+---------------+---------------+---------------+\n");
				
			do{
				System.out.print("Do you want to back to Main menu (Y/N) :- ");
				String ans = strInput();
				if(ans.toUpperCase().equals("Y")){
					loopBreak = (ans.toUpperCase().equals("Y")) ? false : true;
				}else if(ans.toUpperCase().equals("N")){
				}else{
					System.out.println("Invalid Input \t..... !\n");
				}
			}while(loopBreak);
		}while(loopBreak);
	}
		
	//  [9]  Best in Programming Fundamentals-----------------------------------------------------------------------------------------------
	public static void bestInProgrammingFundamentals(){
		//  Tital
		tital(" BEST IN PROGRAMMING FUNDAMENTALS");
		
		boolean loopBreak = true;
		do{
			
			String[] ID = new String[0];
			String[] name = new String[0];
			int[] PF = new int[0];
			int[] DBMS = new int[0];
								
			//  Reset all values without emty marks 
			for(int i=0;i<studentID.length;i++){
				if(total[i] != (-2)){
					int[] temp = new int[PF.length+1];
					int[] temp4 = new int[DBMS.length+1];
					String[] temp2 = new String[ID.length+1];
					String[] temp3 = new String[name.length+1];
												
					//  Reset PF
					for(int j=0;j<PF.length;j++){
						temp[j] = PF[j];
					}
					temp[temp.length-1] = PFMarks[i];
					PF = temp;
												
					//  Reset DBMS
					for(int j=0;j<DBMS.length;j++){
						temp4[j] = DBMS[j];
					}
					temp4[temp4.length-1] = DBMSMarks[i];
					DBMS = temp4;
												
					//  Reset ID
					for(int j=0;j<ID.length;j++){
						temp2[j] = ID[j];
					}
					temp2[temp2.length-1] = studentID[i];
					ID = temp2;
												
					//  Reset name
					for(int j=0;j<name.length;j++){
						temp3[j] = name[j];
					}
					temp3[temp3.length-1] = studentName[i];
					name = temp3;
				}
			}
								
			//  Sort all values
			for(int i=0;i<PF.length;i++){
				for(int j=0;j<(PF.length-1);j++){
					if(PF[j] > PF[j+1]){
						int temp = PF[j];
						PF[j] = PF[j+1];
						PF[j+1] = temp;
														
						temp = DBMS[j];
						DBMS[j] = DBMS[j+1];
						DBMS[j+1] = temp;
														
						String temp2 = ID[j];
						ID[j] = ID[j+1];
						ID[j+1] = temp2;
														
						temp2 = name[j];
						name[j] = name[j+1];
						name[j+1] = temp2;
														
					}
				}
			}
				
			System.out.println("\n+--------+---------------+---------------+---------------+");
			System.out.println("| ID\t | Name\t\t | PF Marks\t | DBMS Marks\t |");
			System.out.println("+--------+---------------+---------------+---------------+");
			for(int i=(PF.length-1);i>=0;i--){System.out.printf("| %-7s%-3s%-13s%-7s%-9d%-7s%-9d%s\n",ID[i],"|",name[i],"|",PF[i],"|",DBMS[i],"|");}
			System.out.println("+--------+---------------+---------------+---------------+\n");
				
			do{
				System.out.print("Do you want to back to Main menu (Y/N) :- ");
				String ans = strInput();
				if(ans.toUpperCase().equals("Y")){
					loopBreak = (ans.toUpperCase().equals("Y")) ? false : true;
				}else if(ans.toUpperCase().equals("N")){
				}else{
					System.out.println("Invalid Input \t..... !\n");
				}
			}while(loopBreak);
		}while(loopBreak);
	}
		
	//  [10] Best in Database Management System--------------------------------------------------------------------------------------------
	public static void bestInDatabaseManagementSystem(){
		//  Tital
		tital(" BEST IN DATABESE MANAGEMENT SYSTEM");
		
		boolean loopBreak = true;
		do{
			
			String[] ID = new String[0];
			String[] name = new String[0];
			int[] PF = new int[0];
			int[] DBMS = new int[0];
								
			//  Reset all values without emty marks 
			for(int i=0;i<studentID.length;i++){
				if(total[i] != (-2)){
					int[] temp = new int[PF.length+1];
					int[] temp4 = new int[DBMS.length+1];
					String[] temp2 = new String[ID.length+1];
					String[] temp3 = new String[name.length+1];
												
					//  Reset PF
					for(int j=0;j<PF.length;j++){
						temp[j] = PF[j];
					}
					temp[temp.length-1] = PFMarks[i];
					PF = temp;
												
					//  Reset DBMS
					for(int j=0;j<DBMS.length;j++){
						temp4[j] = DBMS[j];
					}
					temp4[temp4.length-1] = DBMSMarks[i];
					DBMS = temp4;
												
					//  Reset ID
					for(int j=0;j<ID.length;j++){
						temp2[j] = ID[j];
					}
					temp2[temp2.length-1] = studentID[i];
					ID = temp2;
												
					//  Reset name
					for(int j=0;j<name.length;j++){
						temp3[j] = name[j];
					}
					temp3[temp3.length-1] = studentName[i];
					name = temp3;
				}
			}
								
			//  Sort all values
			for(int i=0;i<DBMS.length;i++){
				for(int j=0;j<(DBMS.length-1);j++){
					if(DBMS[j] > DBMS[j+1]){
						int temp = PF[j];
						PF[j] = PF[j+1];
						PF[j+1] = temp;
														
						temp = DBMS[j];
						DBMS[j] = DBMS[j+1];
						DBMS[j+1] = temp;
														
						String temp2 = ID[j];
						ID[j] = ID[j+1];
						ID[j+1] = temp2;
														
						temp2 = name[j];
						name[j] = name[j+1];
						name[j+1] = temp2;
														
					}
				}
			}
				
			System.out.println("\n+--------+---------------+---------------+---------------+");
			System.out.println("| ID\t | Name\t\t | DBMS Marks\t | PF Marks\t |");
			System.out.println("+--------+---------------+---------------+---------------+");
			for(int i=(PF.length-1);i>=0;i--){System.out.printf("| %-7s%-3s%-13s%-7s%-9d%-7s%-9d%s\n",ID[i],"|",name[i],"|",DBMS[i],"|",PF[i],"|");}
			System.out.println("+--------+---------------+---------------+---------------+\n");
				
			do{
				System.out.print("Do you want to back to Main menu (Y/N) :- ");
				String ans = strInput();
				if(ans.toUpperCase().equals("Y")){
					loopBreak = (ans.toUpperCase().equals("Y")) ? false : true;
				}else if(ans.toUpperCase().equals("N")){
				}else{
					System.out.println("Invalid Input \t..... !\n");
				}
			}while(loopBreak);
		}while(loopBreak);
	}	
}
