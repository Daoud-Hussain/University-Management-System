// package university;

import java.util.*;

public class LibraryManagement{

	static Scanner input = new Scanner(System.in);
	static Main mainClass = new Main(); // main class object
    static Library libraryObj = new Library();


	static void manage(String regNumber){
		System.out.println("\n*******************************************************\n");
        System.out.println("\tLibrary Management System\n");
        System.out.println("*******************************************************\n");
        
        System.out.print("1. Visit Library\n");
        System.out.print("2. Previous Menu\n");
        System.out.print("3. Exit\n");
        System.out.println();
        boolean flag = false;
        while(true){
            try{
                System.out.print("Enter your choice : ");
                int c = input.nextInt();

                switch(c){
                    case 1:{
                        flag = true;
                        libraryObj.main(regNumber);
                        break;
                    }
                    case 2 : {
                        flag = true;
                        mainClass.management(regNumber);
                        break;
                    }
                    case 3 : {
                        System.exit(0);
                        break;
                    }
                }
                if(flag){
                    break;
                }
                else{
                    System.out.print("\nInvalid input, Try Again...\n");
                    input.nextLine();
                }
            }
            catch(Exception e){
                System.out.print("\nInvalid input, Try Again...\n");
                input.nextLine();
            }
        }
	}
}