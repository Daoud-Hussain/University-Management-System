
// package university;

import java.util.*;
public class CafeManagement{
	
	static Scanner input = new Scanner(System.in);
	static Main mainClass = new Main();   // main class object
    static Cafe cafeObj = new Cafe();

	static void manage(String regNumber){
		System.out.println("\n*******************************************************\n");
        System.out.println("\tCafe Management System\n");
        System.out.println("*******************************************************\n");
        

        System.out.println("1. Display Menu");
        System.out.println("2. Previous Menu");
        System.out.println("3. Exit");
        System.out.println();
        
        while(true){
            try{
                System.out.print("Enter your choice : ");
                int c = input.nextInt();
                boolean valid=false;

                switch(c){
                    case 1 : {
                        cafeObj.manage(regNumber);
                        valid = true;
                        break;
                    }
                    case 2 : {
                        mainClass.management(regNumber);
                        valid = true;
                        break;
                    }
                    case 3 : {
                        System.exit(0);
                        break;
                    }
                }
                if(valid){
                    break;
                }
                else{
                    System.out.println("Invalid choice! Try Again");
                    input.nextLine();
                }
            }
            catch(Exception e){
                System.out.println("Invalid choice! Try Again");
                input.nextLine();
            }
        }


	}
}