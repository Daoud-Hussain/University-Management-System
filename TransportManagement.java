
import java.util.*;
public class TransportManagement{
	
	static Scanner input = new Scanner(System.in); 
	static Main mainClass = new Main();   // main class object
	static TMS transportObj = new TMS();

	static void manage(String regNumber){
		System.out.println("\n*******************************************************\n");
        System.out.println("\tTransport Management System\n");
        System.out.println("*******************************************************\n");

        System.out.print("1. Visit transport management system\n");
		System.out.print("2. Previous Menu\n");
		System.out.print("3. Exit\n");
		System.out.println();
		while(true){
			try{
		        System.out.print("Enter your choice : ");
		        int c = input.nextInt();
		        boolean valid = false;

		        switch(c){
		        	case 1 : {
		        		transportObj.manage(regNumber);
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
		        	}
		        }
		        if(valid){
		        	break;
		        }
			}
			catch(Exception e){
				System.out.println("Invalid input! Try again.	");
				input.nextLine();
			}
		}


	}
}