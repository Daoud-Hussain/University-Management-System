import java.io.*;
import java.util.*;
public class DrinkSelection{
	static Scanner input = new Scanner(System.in);
	public static void myDrink(String regNumber){
		int drinks;
		MySoftDrinks drinkSoftobject = new MySoftDrinks();//Create object for class MySoftDrinks . so to call method from class. 
		MyJuiceOrPlantDrink drinkJuiceOrPlantoOject = new MyJuiceOrPlantDrink();//Create object for class MyJuiceOrPlantDrink . so to call method from class.
		MyCoffee drinkCoffeeobject = new MyCoffee();//Create object for class MyCoffee . so to call method from class.
		while(true){	
			System.out.println("Please Select a Drink you want to drink.\n1.Soft drinks\n2.Coffee\n3.Juice or Plant drinks\n0.Nothing \n");
			try{//used try Exception to handles Errors such as MisMatch Inputs etc...
				System.out.print("Enter Your Choice: ");
				drinks = input.nextInt();//Input by user
				System.out.println();
				if(drinks==1){
					drinkSoftobject.main(regNumber);//called method main from Class MySoftDrinks and pass Registration number 
					System.out.println("********************************************");
				}
				else if(drinks == 2){
					System.out.println("Please select your Coffee you want to drink");
					drinkCoffeeobject.main(regNumber);//called method main from Class MyJuiceOrPlantDrink and pass Registration number
					System.out.println("********************************************");
				}
				else if(drinks == 3){
					drinkJuiceOrPlantoOject.main(regNumber);//called method main from Class MyCoffee and pass Registration number
					System.out.println("********************************************");
				}
				else if(drinks == 0){//if user enter 0 then no Drink he want.
					System.out.println("********************************************");
					break;
				}
				else
					System.out.println("Please Choose Correct Option");
					System.out.println("********************************************");
			}catch(Exception e){
				System.out.println("Invalid Inputs");
				input.nextLine();//Use to cancel Enter key remove from keyBoard buffer.
				continue;
			}
		}
	}	
}