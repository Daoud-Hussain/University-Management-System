/**********************************
 * 
 * For Admin
 * registration Number: admin
 * password : admin
 * 
 * *******************************/

import java.util.regex.*;
import java.util.*;
import java.io.File;  
import java.io.FileWriter;

public class Main {
	static Scanner input = new Scanner(System.in);

	// Management System objects
	static TransportManagement transport = new TransportManagement();
	static CafeManagement cafe = new CafeManagement();
	static LibraryManagement library = new LibraryManagement();



	// Registration form variables
	static String name;
	static String password;
	static String dateOfBirth;
	static String regNumber;
	static String studentCnic;
	static String gmail;
	static String degree;
	static String gender;
	static String contactNumber;
	static String fatherCnic;
	static String fatherName;

	// Login form variables
	static String stdName;


	// Registration Method..
    public static void registration(){

    	System.out.println("\n*******************************************************\n");
        System.out.println("\tRegistration Form\n");
        System.out.println("*******************************************************\n");
        input.nextLine();

    	// Student name validation
    	while(true){
    		System.out.print("Enter Your Name : ");
			name = input.nextLine().toUpperCase();
			if(name.length()>=3 && name.matches("^[a-zA-Z ]*$")){
				break;
			}
			else{
				System.out.println("\tTry again! Invalid data ");
			}
    	}

    	// Password validation
		while(true){
			System.out.print("Enter Your Password(at least 8 characters) : ");
			password = input.nextLine();
			if(password.length()>=8){
				break;
			}
			else{
				System.out.println("\tTry again! your password must contain at least 8 characters ");
			}
		}

		// Degree validation
		while(true){
			System.out.print("Enter your Degree(BSCS) : ");
			degree = input.nextLine().toUpperCase();
			if(degree.toUpperCase().compareTo("BSCS")==0){
				break;
			}
			else{
				System.out.println("\tTry again! Enter valid degree name!");
			}
		}

		// Gender validation
		while(true){
			System.out.print("Enter Your Gender(Male/Female) : ");
			gender = input.nextLine().toUpperCase();
			if(gender.compareTo("MALE")==0 || gender.compareTo("FEMALE")==0){
				break;
			}
			else{
				System.out.println("\tTry Again! Enter valid data!");
			}
		}

		// Date of Birth Validation
		while(true){
			System.out.print("Enter Your Date of Birth(DD-MM-YYYY) : ");
			dateOfBirth = input.nextLine();
			if(Pattern.matches("^(0[1-9]|[12][0-9]|3[01])[-/.](0[1-9]|1[012])[-/.](19|20)\\d\\d$",dateOfBirth)){
				break;
			}
			else{
				System.out.println("\tTry Again! Enter date in valid format!");
			}
		}

		// Student CNIC Validation 
		while(true){
			System.out.print("Enter Your CNIC number : ");
			studentCnic = input.nextLine();
			if(Pattern.matches("\\d{5}-\\d{7}-\\d{1}",studentCnic)){
				break;
			}
			else{
				System.out.println("\tTry Again! Enter valid CNIC!");
			}
		}

		// Gmail Validation
		while(true){
			System.out.print("Enter Your Email Address(xxxx@gmail.com) : ");
			gmail = input.nextLine();
			if(Pattern.matches("^[\\w.+\\-]+@gmail\\.com$",gmail)){
				break;
			}
			else{
				System.out.println("\tTry Again! Enter valid email ID.");
			}
		}

		// contact Number Validation
		while(true){
			System.out.print("Enter Your contact Number(03xx-xxxxxxx) : ");
			contactNumber = input.nextLine();
			if(Pattern.matches("03\\d{2}-\\d{7}",contactNumber) && contactNumber.length()==12){
				break;
			}
			else{
				System.out.println("\tTry Again! Enter valid contact Number!");
			}
		}

		// Father Name.
		while(true){
			System.out.print("Enter Your Father's Name : ");
			fatherName = input.nextLine().toUpperCase();
			if(fatherName.length()>=3 && fatherName.matches("^[a-zA-Z ]*$")){
				break;
			}
			else{
				System.out.println("\tTry Again! Enter valid data.");
			}
		}

		// Father CNIC Validation
		while(true){
			System.out.print("Enter Your Father CNIC number : ");
			fatherCnic = input.nextLine();
			if(Pattern.matches("\\d{5}-\\d{7}-\\d{1}",fatherCnic)){
				break;
			}
			else{
				System.out.println("\tTry Again! Enter valid CNIC number.");
			}
		}

		// Random Registration Number Generation
		String[] system  = {"FA","SP"}; 
		int r = ((int)(Math.random()*150));
		String regNumber = system[(int)(Math.random()*2)]  + ((int)(Math.random()*4)+18) + "-BCS-" + (r<10?("00"):(r<100)?("0"):(""))+r;
		while(true){
			try{
				File file = new File("roll_numbers/ids.txt");
				Scanner sc = new Scanner(file);
				while(sc.hasNextLine()){
					String line = sc.nextLine();
					if(line.compareTo(regNumber)==0){
						continue;
					}
				}
				sc.close();
				FileWriter fileWriter = new FileWriter("roll_numbers/ids.txt",true);
				fileWriter.write(regNumber+"\n");
				fileWriter.close();
				break;
			}
			catch(Exception e){
				System.out.print(e);
			}
		}

		// Storing data to the file
		
		try{
			File file = new File("students_data/"+regNumber+".txt");
			boolean value = file.createNewFile();
			if(value){
				try{
					FileWriter fileWriter = new FileWriter("students_data/"+regNumber+".txt");
					fileWriter.write("name:"+name);
					fileWriter.write("\npassword:"+password);
					fileWriter.write("\nregNumber:"+regNumber);
					fileWriter.write("\ndegree:"+degree);
					fileWriter.write("\ngender:"+gender);
					fileWriter.write("\ndateOfBirth:"+dateOfBirth);
					fileWriter.write("\ngmail:"+gmail);
					fileWriter.write("\nstudentCnic:"+studentCnic);
					fileWriter.write("\ncontactNumber:"+contactNumber);
					fileWriter.write("\nfatherName:"+fatherName);
					fileWriter.write("\nfatherCnic:"+fatherCnic);
					fileWriter.close();
					System.out.println("\n*******************************************************\n");
					System.out.println("Hi! "+name+", Your Registration number is "+regNumber);
			        System.out.println("\tRegistered Successfully!\n");
			        System.out.println("*******************************************************\n");

				}
				catch(Exception e){
					System.out.println("Errored occured!");
				}
			}
			else{
				System.out.println(regNumber+" already exists!");
			}
		}
		catch(Exception e){
			System.out.println("Errored occured!");
		}

		// Storing balance in student cafe module on first time registration
		// try{
		// 	File file = new File("cafe/balance/"+regNumber+".txt");
		// 	file.createNewFile();
		// 	FileWriter writer = new FileWriter(file);
		// 	writer.write(4000);
		// 	writer.close();
		// }
		// catch(Exception e){
		// 	System.out.print("Exception occured!");
		// }
		Choices();

		

    }


    // LOGIN-FORM
    public static void login(){
        System.out.println("\n*******************************************************\n");
		System.out.println("\tLOGIN FORM\n");
        System.out.println("*******************************************************");
        input.nextLine();

        // Password validation
        boolean userExisted = false;
		while(true){
			// RegNumber validation checking..
			while(true){
				System.out.print("Enter Registration Number(XXXX-XXX-XXX) : ");
				regNumber = input.nextLine().toUpperCase();
				if(Pattern.matches("SP\\d{2}-\\w{3}-\\d{3}|FA\\d{2}-\\w{3}-\\d{3}",regNumber) || regNumber.compareTo("ADMIN")==0){
					break;
				}
				else{
					System.out.print("Invalid ID! Try Again....\n");
				}
			}
			
			System.out.print("Enter Your Password : ");
			password = input.nextLine();
			if(regNumber.compareTo("ADMIN")==0 && password.compareTo("admin")==0){
				Admin.admin();
				break;
			}
			else{
				File myfile = new File("students_data/"+regNumber+".txt");

				if(myfile.exists()){
					try{
						Scanner sc = new Scanner(myfile);
						while(sc.hasNextLine()){
							String line = sc.nextLine();
							String key = line.substring(0,line.indexOf(":"));
							String value = line.substring(line.indexOf(":")+1,line.length());
							if(key.compareTo("password")==0 && value.compareTo(password)==0){
								userExisted = true;
								break;
							} 
							if(key.compareTo("name")==0){
								stdName = value;
							}
						}
						sc.close();
					}
					catch(Exception e){
						System.out.print(e);
					}

					if(userExisted){
						System.out.println("\n*******************************************************\n");
						System.out.println("\tWelcome "+stdName);
		        		System.out.println("\n*********************************************************");
		        		management(regNumber);
						break;
					}
					else{
						System.out.println("\nInvalid Credientials! Try Again!");
					}
				}
				else{
					System.out.println("\nThat user didn't exists!");
					continue;
				}

			}

			
		}
    }
    // LOGIN-FORM ENDS



    // AFTER-LOGIN
    public static void management(String regNum){
    	System.out.println("\n1. Manage Courses");
    	System.out.println("2. Transport Management");
    	System.out.println("3. Library Management");
    	System.out.println("4. Cafe Management");
    	System.out.println("5. Previous Menu");
    	System.out.println();
    	
    	while(true){
    		try{
    			System.out.print("Enter your choice : ");
		    	int choice = input.nextInt();
		    	boolean valid = false;

		    	switch(choice){
		    		case 1:{
		    				Courses.manage(regNumber);
		    				valid = true;
		    				break;
		    		}
		    		case 2:{
		    				transport.manage(regNumber);
		    				valid = true;
		    				break;
		    		}
		    		case 3:{
		    				library.manage(regNumber);
		    				valid = true;
		    				break;
		    		}
		    		case 4:{
		    				cafe.manage(regNumber);
		    				valid = true;
		    				break;
		    		}
		    		case 5:{
		    				Choices();
		    				valid = true;
		    				break;
		    		}
		    	}
		    	if(valid){
		    		break;
		    	}
		    	else{
		    		System.out.println("Invalid input! Try Again..");
    				input.nextLine();
		    	}
    		}
    		catch(Exception e){
    			System.out.println("Invalid input! Try Again..");
    			input.nextLine();
    		}
    	}

    }



    // Intial Choices
    public static void Choices(){
    	System.out.println("*******************************************************\n");
        System.out.println("\tUniversity Management System\n");
        System.out.println("*******************************************************");
        
    	boolean b=true;
        while(b){
            try{
            	System.out.println("\n1. Registration");
	            System.out.println("2. Login ");
	            System.out.println("3. Exit");
	            System.out.print("Enter choice : ");
	            int c = input.nextInt();
	            switch(c){
	            	case 1 : {
		            		registration();
		            		b=false;
		            		break;
	            			}
	            	case 2 : {
		            		login();
		            		b=false;
		            		break;
	            			}
	            	case 3 : {
	            				System.out.println("\n*********Thanks**********");
	            				System.exit(0);
	            				break;
	            			}
	            	default:{
	            		System.out.println("invalid input... Try again");
	            		continue;
	            	}
	            }
            }
            catch(Exception e){
            	System.out.println("Invalid input.. Try again");
            	input.nextLine();
            }
        }
    }

    public static void main(String[] args) {

        Choices();

    }
}