

import java.util.*;
import java.io.File;
import java.io.FileWriter;
public class CourseRegistration{
	
	static Scanner input = new Scanner(System.in);
	static Main mainClass = new Main();   // main class object
    static String[][] courseDetails;
    static String semester;

    // public static void main(String[] args) {
    //     CourseRegistration ob = new CourseRegistration();
    //     ob.manage("SP21-BCS-066");
    // }

	static void manage(String regNumber){
		System.out.println("\n*******************************************************\n");
        System.out.println("\tCourse Registration\n");
        System.out.println("*******************************************************\n");
        

        // Checking that courses registered or not.
        try{
            File myfile = new File("students_data/"+ regNumber +".txt");
            Scanner sc = new Scanner(myfile);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                if(line.contains("Courses")){
                    System.out.print("Courses already registered!\n");
                    break;
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        // Semester Entry and vallidation
        while(true){
            try{
                System.out.print("Enter your semester(1 for first semester ..'1-8') : ");
                semester = input.next();
                if(Integer.parseInt(semester)<=8 && Integer.parseInt(semester)>0){
                    break;
                }
                else{
                    System.out.println("Invalid input, Try again!");
                    input.nextLine();
                }
            }
            catch(Exception e){
                System.out.println("Invalid input, Try again!");
                input.nextLine();
            }
        }

        File myfile = new File("courses/"+ semester +".txt");


        // finding total_courses in file 
        int total_courses = 0;
        try{
         Scanner sc = new Scanner(myfile);
         while(sc.hasNextLine()){
            String line = sc.nextLine();
            total_courses++;
         }
        }
        catch(Exception e){
         System.out.print(e);
        }



        // Declaring the array size
        courseDetails = new String[total_courses][4];



        // Stroring data in a file.
        int[] space = {15,30,15,30};
        try{
         Scanner sc = new Scanner(myfile);
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
                courseDetails[i][j] = item;
                j++;
            }
            i++;
            j=0;
            System.out.println();
         }
        }
        catch(Exception e){
         System.out.print(e);
        }


        // Course Registration 

        while(true){
            try{
                System.out.print("Enter the ID's of courses you want to register(comma separated) : ");
                String[] ids = input.next().split(",");
                for(String e:ids){
                    if(Integer.parseInt(e)>courseDetails.length-1 && Integer.parseInt(e)<0){
                        continue;
                    }
                }
                try{
                    FileWriter fileWriter = new FileWriter("students_data/"+ regNumber +".txt",true);

                    fileWriter.write("\nCourses:");
                    int j=0;
                    for(String id:ids){
                        int i=0;
                        for(String d:courseDetails[Integer.parseInt(id)]){
                            fileWriter.write(d);
                            if(i<3){
                                fileWriter.write(",");
                            }
                            i++;
                        }
                        if(j<ids.length-1){
                            fileWriter.write(" | ");
                        }
                        j++;
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

            }
        }

        // System.out.println("5. Previous Menu");
        // System.out.println();
        // System.out.print("Enter your choice : ");
        // int c = input.nextInt();

        // switch(c){
        // 	case 5 : {
        // 		mainClass.management(regNumber);
        // 		break;
        // 	}
        // }
	}
}