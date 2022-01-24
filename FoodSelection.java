

import java.util.*;
public class FoodSelection{
	static Scanner input = new Scanner(System.in);
	public static void food(String regNumber){
		int food;
		MyFastFood foodFastobj = new MyFastFood();//Create Object to call Class MyFastFood methods in this class
		MyDesiFood foodDesiobj = new MyDesiFood();//Create Object to call Class MyDesiFood methods in this class
		while(true){	
			System.out.println("1.Fast Food\n2.for Desi Food \n0.Nothing\n");
			try{
				System.out.print("Enter Your Choice: ");
				food  = input.nextInt();
				System.out.println();
				if(food==1){
					foodFastobj.main(regNumber);// main method of class MyFastFood is being called here and a parameter is passed
					System.out.println("********************************************");
				}
				else if(food == 2){			
					foodDesiobj.main(regNumber);// main method of class MyDesiFood is being called here and a parameter is passed
					System.out.println("********************************************");

				}
				else if(food == 0){//No food for User If it enter 0.
					System.out.println("********************************************");
					break;
				}
				else
					System.out.println("Please Choose Correct Option");	
					System.out.println("********************************************");
			}catch(Exception e){
				System.out.println("Invalid Inputs");
				input.nextLine();
				continue;
			}
		}
	}	
}