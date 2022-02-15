

import java.util.*;
import java.io.File;
import java.io.FileWriter;
public class Courses{
	
	static Scanner input = new Scanner(System.in);
	static Main mainClass = new Main();   // main class object
    static String[] courseDetails;
    static String semester;

    // public static void main(String[] args) {
    //     CourseRegistration ob = new CourseRegistration();
    //     ob.manage("SP21-BCS-066");
    // }

	static void manage(String regNumber){
		System.out.println("\n*******************************************************\n");
        System.out.println("\tManage Courses\n");
        System.out.println("*******************************************************\n\n");
        
        while(true){
            System.out.print("*****************************************************\n");
            System.out.print("1. Register Courses\n");
            System.out.print("2. View Registered Courses\n");
            System.out.print("3. Previous Menu\n");
            System.out.print("4. Exit\n");
            System.out.print("\nEnter your choice : ");
            try{
                int c = input.nextInt();
                switch(c){
                    case 1 : {
                        registerCourse(regNumber);
                        break;
                    }
                    case 2 : {
                        viewCourse(regNumber);
                        break;
                    }
                    case 3 : {
                        Main.management(regNumber);
                        break;
                    }
                    case 4 : {
                        System.exit(0);
                        break;
                    }
                    default : {
                        System.out.print("Invalid input! Try again!\n");
                        input.nextLine();
                    }
                }
            }
            catch(Exception e){
                System.out.print("Invalid input! Try again!\n");
                input.nextLine();
            }
        }
	}


    public static void registerCourse(String regNumber){
        int semester = 0;
        String sub = "";
        try{
            File myfile = new File("students_data/courses/"+ regNumber +".txt");
            if(myfile.exists()){
                System.out.print("Course already registered!\n");
            }
            else{
                sub = regNumber.substring(0,4);

                // Eliminating the semester from the st. ID
                if(sub.compareTo("SP18")==0){
                    semester = 8;
                }
                else if(sub.compareTo("FA18")==0){
                    semester = 7;
                }
                else if(sub.compareTo("SP19")==0){
                    semester = 6;
                }
                else if(sub.compareTo("FA19")==0){
                    semester = 5;
                }
                else if(sub.compareTo("SP20")==0){
                    semester = 4;
                }
                else if(sub.compareTo("SP20")==0){
                    semester = 3;
                }
                else if(sub.compareTo("SP21")==0){
                    semester = 2;
                }
                else if(sub.compareTo("FA21")==0){
                    semester = 1;
                }



                // finding total_courses in file 
                int total_courses = 0;
                try{
                 File file = new File("courses/"+ semester +".txt");
                 Scanner sc = new Scanner(file);
                 while(sc.hasNextLine()){
                    String line = sc.nextLine();
                    total_courses++;
                 }
                 sc.close();
                }
                catch(Exception e){
                 System.out.print(e);
                }



                // Declaring the array size
                courseDetails = new String[total_courses];



                // Stroring data in a file.
                int[] space = {15,30,15,30};
                try{
                 File file = new File("courses/"+ semester +".txt");
                 Scanner sc = new Scanner(file);
                 int i=0,j=0;
                 System.out.print("\n\n");
                 System.out.printf("%-5s%-15s%-30s%-15s%-30s%n","ID","Course_Code","Course_Title","Credit_Hours","Instructor");
                 System.out.println("------------------------------------------------------------------------------------------");
                 while(sc.hasNextLine()){
                    System.out.printf("%-5d",i);
                    String line = sc.nextLine();
                    courseDetails[i] = line;
                    String[] data = line.split(",",4);
                    for(String item:data){
                        System.out.printf(("%-"+space[j]+"s"),item);
                        j++;
                    }
                    i++;
                    j=0;
                    System.out.println();
                 }
                 sc.close();
                 System.out.print("At least register 4 courses\n");
                }
                catch(Exception e){
                 System.out.print(e);
                }


                // Course Registration 
                while(true){
                    try{
                        System.out.print("\nHow many course you want to register:");
                        int amount = input.nextInt();
                        if(amount<4){
                            System.out.print("At least registered 4 courses\n");
                            continue;
                        }
                        else if(amount>courseDetails.length){
                            System.out.print("Only "+ courseDetails.length +" courses are being offered!\n");
                            continue;
                        }


                        // Storing course ids in array..
                        int x=0;
                        int[] ids = new int[amount];
                        boolean alreadyRegristered = false;
                        while(true){
                            try{
                                alreadyRegristered = false;
                                System.out.print("\n*************course"+(x+1)+"*******************\n");
                                System.out.print("Enter choice :");
                                int choice = input.nextInt();
                                for(int z=0;z<x;z++){
                                    if(ids[z]==choice){
                                        alreadyRegristered = true;
                                        break;
                                    }
                                }
                                if(alreadyRegristered){
                                    System.out.print("Already Registered!\n");
                                    continue;
                                }
                                else if(choice<courseDetails.length && choice>=0){
                                    ids[x] = choice;
                                    x++;
                                    if(x==amount){
                                        break;
                                    }
                                }
                                else{
                                    System.out.print("Invalid Id, Try again!\n");
                                    continue;
                                }
                            }
                            catch(Exception e){
                                System.out.print("Invalid input! Try again...");
                                input.nextLine();
                            }

                        }


                        try{
                            FileWriter fileWriter = new FileWriter("students_data/courses/"+ regNumber +".txt",true);

                            int j=0;
                            for(int id:ids){
                                int i=0;
                                fileWriter.write(courseDetails[id]+"\n");
                            }
                                    
                            fileWriter.close();
                            System.out.println("Courses Registered Successfully!");
                            break;
                        }
                        catch(Exception e){
                            System.out.print(e);
                        }
                    }
                    catch(Exception e){
                        System.out.print("Invalid input! Try again");
                        input.nextLine();
                    }
                }


            }
            // else ends
        }
        catch(Exception e){
            System.out.print("Error occured!\n");
        }


    }


    public static void viewCourse(String regNumber){
        System.out.print("You are registered in following courses : \n");
        int[] space = {15,30,15,30};
        try{
         File file = new File("students_data/courses/"+ regNumber +".txt");
         Scanner sc = new Scanner(file);
         int i=0,j=0;
         System.out.print("\n\n");
         System.out.printf("%-5s%-15s%-30s%-15s%-30s%n","ID","Course_Code","Course_Title","Credit_Hours","Instructor");
         System.out.println("------------------------------------------------------------------------------------------");
         while(sc.hasNextLine()){
            System.out.printf("%-5d",i);
            String line = sc.nextLine();
            String[] data = line.split(",",4);
            for(String item:data){
                System.out.printf(("%-"+space[j]+"s"),item);
                j++;
            }
            i++;
            j=0;
            System.out.println();
         }
         sc.close();
        }
        catch(Exception e){
         System.out.print(e);
        }


    }
    //Class Brackets 
}