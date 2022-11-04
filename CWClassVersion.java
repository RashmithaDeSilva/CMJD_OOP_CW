import java.util.*;
import java.io.IOException;

class Student{
	
	private String ID;
	private String name;
	private int PFMarks;
	private int DBMSMarks;
	private int total;
	
	Student(){
		ID = null;
		name = null;
		PFMarks = 0;
		DBMSMarks = 0;
		total = 0;
	}
	
	Student(String ID, String name, int PFMarks, int DBMSMarks){
		this.ID = ID;
		this.name = name;
		this.PFMarks = PFMarks;
		this.DBMSMarks = DBMSMarks;
		total = PFMarks + DBMSMarks;
	}
	
	public void setMarks(int PFMarks, int DBMSMarks){
		this.PFMarks = PFMarks;
		this.DBMSMarks = DBMSMarks;
		total = PFMarks + DBMSMarks;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public boolean checkID(String ID){
		boolean output = false;
		if(ID.toUpperCase().equals(this.ID)){
			output = true;
		}
		return output;
	}
	
	public void printStudentName(){
		System.out.println(name+"\n");
	}
	
	public String getID(){
		return ID;
	}
	
	public String getName(){
		return name;
	}
	
	public int getTotal(){
		return total;
	}
	
	public int getPFMarks(){
		return PFMarks;
	}
	
	public int getDBMSMarks(){
		return DBMSMarks;
	}
	
	public void value(){
		System.out.println(ID+"\t"+name+"\t"+PFMarks+"\t"+DBMSMarks+"\t"+total);
	}
}


class CWClassVersion{
	
	public static Student[] student = new Student[0];  //  All Students Obj Array
	
	public static void main(String args[]){
		do{
			int x = mainMenu();
			//rank();
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
	
	//  For clear CMD---------------------------------------------------------------------------------------------------------------------------
	public static void cls(){
		try{
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	//  Have in Intiger Input--------------------------------------------------------------------------------------------------------------------
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
		
	//  Have in String Input---------------------------------------------------------------------------------------------------------------------
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
	
	//  Top Tital---------------------------------------------------------------------------------------------------------------------------------
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
	
	//  Checking ID numbers-------------------------------------------------------------------------------------------------------------------
	public static boolean checkID(String IDNumber){
		boolean checkOut = false;
		for(int i=0;i<student.length;i++){
			if(student[i].checkID(IDNumber)){
				checkOut = true;
				break;
			}
		}
		return checkOut;
	}
	
	//  Student Array Add New Obj-----------------------------------------------------------------------------------------------------------
	public static void strArrSet(String ID, String name, int PFMarks, int DBMSMarks){
		
		//  Creat temp obj array
		Student[] temp = new Student[student.length+1];
		
		//  Copy all old value
		for(int i=0;i<student.length;i++){
			temp[i] =  student[i];
		}
		temp[temp.length-1] = new Student(ID, name, PFMarks, DBMSMarks);
		student = temp;
	}
	
	//  Student Array Delete Obj--------------------------------------------------------------------------------------------------------------
	public static void strArrDel(int position){
		
		Student[] temp = new Student[student.length-1];
		
		//  Copy old value to the new temp array without student who delete
		for(int i=0;i<position;i++){
			temp[i] = student[i];
		}
		for(int i=student.length-1;i>position;i--){
			temp[i-1] = student[i];
		}
		
		//  Copy old array to new array
		student = temp;
			
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
	
	//  Main Menu-----------------------------------------------------------------------------------------------------------------------------
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
				inputID = strInput().toUpperCase();
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
			strArrSet(inputID, inputSN, -1, -1);
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
				inputID = strInput().toUpperCase();
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
			System.out.println();
			
			//  Set new student detalse in obj arry
			strArrSet(inputID, inputName, inputPF, inputDBMS);
						
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
			inputID = strInput().toUpperCase();
			if(checkID(inputID)){
							
				//  Checking student ID array position
				int count=0;
				for(int i=0;i<student.length;i++){
					if(student[i].checkID(inputID)){
						student[i].printStudentName();
						break;
					}else{count++;}
				}
								
				//  Checkin marks already have or not
				if(student[count].getTotal() != -2){
					System.out.println("This student's marks have been already added.");
					System.out.println("If you want to update the marks, please use [5] Update Marks option.\n");
				}else{
											
					//  Having PF marks
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
					student[count].setMarks(inputPF,inputDBMS);
				}
								
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
			inputID = strInput().toUpperCase();

			//  Checking student ID
			IDCheck = checkID(inputID);
			if(IDCheck){
				//  Count ID array posction
				for(int i=0;i<student.length;i++){
					if(student[i].checkID(inputID)){
						break;
					}else{count++;}
				}
				student[count].printStudentName();
								
				//  Input new student name
				System.out.print("Enter the new student name :- ");
				inputName = strInput();
								
				//  Chenge old name to new name
				student[count].setName(inputName);
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
			System.out.print("\nEnter Student ID :- ");
			inputID = strInput().toUpperCase();
			//  Checking student ID
			IDCheck = checkID(inputID);
			if(IDCheck){
				//  Count ID array pocition
				for(int i=0;i<student.length;i++){
					if(student[i].checkID(inputID)){
						break;
					}else{count++;}
				}
				student[count].getName();
								
				if(student[count].getTotal() == -2){
					System.out.println("This student's marks yet to be added.");
				}else{
									
					System.out.println("Programming Fundamentals Marks :- "+student[count]. getPFMarks());
					System.out.println("Detabase Management System Marks :- "+student[count]. getDBMSMarks()+"\n\n");
										
					//  Input new PF marks
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
													
					//  Input new DBMS marks
					loopBreak = true;
					do{
						System.out.print("Databese Management System Marks :- ");
						inputDBMS = intInput();
						if(inputDBMS >= 0 && 100 >= inputDBMS){
							System.out.println("Marks have been updated successfully.");
							loopBreak = false;
						}else if(inputDBMS == -1){
						}else{
							System.out.println("Invalid marks, please enter correct marks\t..... !\n");
						}
					}while(loopBreak);
					
					//  Cheng old marks to new marks
					student[count].setMarks(inputPF, inputDBMS);	
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
		do{
					 					
			boolean  IDCheck;
			String inputID;
			int count=0;
			
			//  Input student ID
			System.out.print("\nEnter Student ID :- ");
			inputID = strInput().toUpperCase();
						
			//  Checking ID
			IDCheck =  checkID(inputID);
			if(IDCheck){
							
				//  Count that student ID's array position
				for(int i=0;i<student.length;i++){
					if(student[i].checkID(inputID)){
						break;
					}else{count++;}
				}
								
				//  Delete student to call method
				strArrDel(count);
				System.out.println("Student has been deleted successfully.");
								
			}else{System.out.print("Invalid Student ID, ");}
						
			loopBreak = exitOrContinue();
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
			int count=0, studentArrayPosition = 0;
						
			//  Get student ID
			System.out.print("\nEnter Student ID :- ");
			inputID = strInput();
								
			//  Checking ID
			IDCheck = checkID(inputID);
			if(IDCheck != true){
				System.out.print("Invalid Student ID, ");
				loopBreak = exitOrContinue();
								
			}else{
				//  Count that student ID's array position
					count = 0;
					for(int i=0;i<student.length;i++){
						if(student[i].checkID(inputID)){
							break;
						}else{studentArrayPosition++;}
					}
					System.out.println("Student Name :- "+student[studentArrayPosition].getName());
				
				if(student[studentArrayPosition].getTotal() == (-2)){
					System.out.println("Marks yet to be added\t..... !\n");
					loopBreak = exitOrContinue();
				}else{
					//  Count all null value
					for(int i=0;i<student.length;i++){
						if(student[i].getTotal() == -2){
							count++;
						}
					}
					
					//  Creat new total array
					int[] temp = new int[student.length - count];
					
					//  Copy all totals without -2 values
					count = 0;
					for(int i=0;i<student.length;i++){
						if(student[i].getTotal() != (-2)){
							temp[count] = student[i].getTotal();
							count++;
						}
					}
					
					//  Sort temp total array
					for(int i=0;i<student.length;i++){
						for(int j=0;j<temp.length-1;j++){
							if(temp[j] < temp[j+1]){
								int tmp = temp[j];
								temp[j] = temp[j+1];
								temp[j+1] = tmp;
							}
						}
					}
					
					//  Count -2 values befor this ID
					count = 0;
					for(int i=0;i <= studentArrayPosition;i++){
						if(student[i].getTotal() == (-2)){
							count++;
						}
					}
					count = studentArrayPosition - count;
					
					// Strin rank
					String strRank;
					//if(total.length >= 3){}
					
					strRank = (student[studentArrayPosition].getTotal() == temp[0]) ? "(First)" : (student[studentArrayPosition].getTotal() == temp[1]) ? "(Second)" : (student[studentArrayPosition].getTotal() == temp[2]) ? "(Third)" : "(     )";
					System.out.println("+---------------------------------------+-----------------------+");
					System.out.println("| Programming Fundamentals Marks\t|\t\t"+student[studentArrayPosition].getPFMarks()+"\t|");
					System.out.println("| Database Management System Marks\t|\t\t"+student[studentArrayPosition].getDBMSMarks()+"\t|");
					System.out.println("| Total Marks\t\t\t\t|\t\t"+student[studentArrayPosition].getTotal()+"\t|");
					System.out.println("| Avg. Marks\t\t\t\t|\t      "+(student[studentArrayPosition].getTotal()/2.0)+"\t|");
					System.out.println("| Rank\t\t\t\t\t|\t"+(count + 1)+" "+strRank+"\t|");
					System.out.println("+---------------------------------------+-----------------------+");									
					
					loopBreak = exitOrContinue();
				}
			}
		}while(loopBreak);						
	}
	
	//  [8]  Print Student Ranks---------------------------------------------------------------------------------------------------------------
	public static void printStudentRanks(){
		//  Tital
		tital("PRINT STUDENT RANKS");
		
		int count = 0;	
		//  Count all -2 values
		for(int i=0;i<student.length;i++){
			if(student[i].getTotal() != (-2)){
				count++;
			}
		}
				
		String[] ID = new String[count];
		String[] name = new String[count];
		int[] total = new int[count];
				
		//  Copy all obj details to new temp arrs
		count = 0;
		for(int i=0;i<student.length;i++){
			if(student[i].getTotal() != (-2)){
				total[count] = student[i].getTotal();
				ID[count] = student[i].getID();
				name[count] = student[i].getName();
				count++;
			}
		}
				
		//  Soting all values by total
		for(int i=0;i<total.length;i++){
			for(int j=0;j < total.length - 1;j++){
					if(total[j] < total[j+1]){
					int tempTotal = total[j];
					String tempID = ID[j];
					String tempName = name[j];
							
					total[j] = total[j+1];
					ID[j] = ID[j+1];
					name[j] = name[j+1];
							
					total[j+1] = tempTotal;
					ID[j+1] = tempID;
					name[j+1] = tempName;
				}
			}
		}
				
		count = 1;
		System.out.println("\n+--------+-------+---------------+---------------+---------------+");
		System.out.println("| Rank\t | ID\t | Name\t\t | Total Marks\t | Avg. Marks\t |");
		System.out.println("+--------+-------+---------------+---------------+---------------+");
		for(int i=0;i<total.length;i++){
			System.out.printf("|  %-6d%-2s%-6s%-3s%-13s%-7s%-9s%-6s%-10.2f%s\n",count,"|",ID[i],"|",name[i],"|",total[i],"|",(total[i]/2.0),"|");
			count++;
		}
		System.out.println("+--------+-------+---------------+---------------+---------------+\n");
				
		boolean loopBreak = true;
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
	}
	
	//  [9]  Best in Programming Fundamentals-----------------------------------------------------------------------------------------------
	public static void bestInProgrammingFundamentals(){
		//  Tital
		tital(" BEST IN PROGRAMMING FUNDAMENTALS");
		
		int count = 0;	
		//  Count all -2 values
		for(int i=0;i<student.length;i++){
			if(student[i].getTotal() != (-2)){
				count++;
			}
		}
				
		String[] ID = new String[count];
		String[] name = new String[count];
		int[] PFMarks = new int[count];
		int[] DBMSMarks = new int[count];
				
		//  Copy all obj details to new temp arrs
		count = 0;
		for(int i=0;i<student.length;i++){
			if(student[i].getPFMarks() != (-1)){
				PFMarks[count] = student[i].getPFMarks();
				DBMSMarks[count] = student[i].getDBMSMarks();
				ID[count] = student[i].getID();
				name[count] = student[i].getName();
				count++;
			}
		}
				
		//  Soting all values by total
		for(int i=0;i<PFMarks.length;i++){
			for(int j=0;j < PFMarks.length - 1;j++){
					if(PFMarks[j] < PFMarks[j+1]){
					int tempPF = PFMarks[j];
					int tempDBMS = DBMSMarks[j];
					String tempID = ID[j];
					String tempName = name[j];
							
					PFMarks[j] = PFMarks[j+1];
					DBMSMarks[j] = DBMSMarks[j+1];
					ID[j] = ID[j+1];
					name[j] = name[j+1];
							
					PFMarks[j+1] = tempPF;
					DBMSMarks[j+1] = tempDBMS;
					ID[j+1] = tempID;
					name[j+1] = tempName;
				}
			}
		}
		
		System.out.println("\n+--------+---------------+---------------+---------------+");
		System.out.println("| ID\t | Name\t\t | PF Marks\t | DBMS Marks\t |");
		System.out.println("+--------+---------------+---------------+---------------+");
		for(int i=0;i<PFMarks.length;i++){
			System.out.printf("| %-7s%-3s%-13s%-7s%-9d%-7s%-9d%s\n",ID[i],"|",name[i],"|",PFMarks[i],"|",DBMSMarks[i],"|");
		}
		System.out.println("+--------+---------------+---------------+---------------+\n");
				
		boolean loopBreak = true;
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
	}
	
	//  [10] Best in Database Management System--------------------------------------------------------------------------------------------
	public static void bestInDatabaseManagementSystem(){
		//  Tital
		tital(" BEST IN DATABESE MANAGEMENT SYSTEM");
	
		int count = 0;	
		//  Count all -2 values
		for(int i=0;i<student.length;i++){
			if(student[i].getTotal() != (-2)){
				count++;
			}
		}
				
		String[] ID = new String[count];
		String[] name = new String[count];
		int[] PFMarks = new int[count];
		int[] DBMSMarks = new int[count];
				
		//  Copy all obj details to new temp arrs
		count = 0;
		for(int i=0;i<student.length;i++){
			if(student[i].getPFMarks() != (-1)){
				PFMarks[count] = student[i].getPFMarks();
				DBMSMarks[count] = student[i].getDBMSMarks();
				ID[count] = student[i].getID();
				name[count] = student[i].getName();
				count++;
			}
		}
				
		//  Soting all values by total
		for(int i=0;i<DBMSMarks.length;i++){
			for(int j=0;j < DBMSMarks.length - 1;j++){
					if(DBMSMarks[j] < DBMSMarks[j+1]){
						int tempDBMS = DBMSMarks[j];
						int tempPF = PFMarks[j];
						String tempID = ID[j];
						String tempName = name[j];
								
						DBMSMarks[j] = DBMSMarks[j+1];
						PFMarks[j] = PFMarks[j+1];
						ID[j] = ID[j+1];
						name[j] = name[j+1];
								
						DBMSMarks[j+1] = tempDBMS;
						PFMarks[j+1] = tempPF;
						ID[j+1] = tempID;
						name[j+1] = tempName;
					}
			}
		}
		
		System.out.println("\n+--------+---------------+---------------+---------------+");
		System.out.println("| ID\t | Name\t\t | DBMS Marks\t | PF Marks\t |");
		System.out.println("+--------+---------------+---------------+---------------+");
		for(int i=0;i<DBMSMarks.length;i++){
			System.out.printf("| %-7s%-3s%-13s%-7s%-9d%-7s%-9d%s\n",ID[i],"|",name[i],"|",DBMSMarks[i],"|",PFMarks[i],"|");
		}
		System.out.println("+--------+---------------+---------------+---------------+\n");
				
		boolean loopBreak = true;
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
	}
}
