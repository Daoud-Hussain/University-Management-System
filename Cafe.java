import java.util.*;
public class Cafe{
	static Scanner input = new Scanner(System.in);
	public static void manage(String regNumber) throws Exception{
		int amount =5000;

		Displaymenu menuObj = new Displaymenu();//create obj to call method from class Display menu
		menuObj.displayMenu(); //Method which is being called.
		
		System.out.println("\n");
		SelectionMethod selectObj = new SelectionMethod();//Create  an object for class SelectionMethod
		selectObj.chooseMethod(regNumber);//Called chooseMethod from class SelectionMethod
		System.out.println();
		
		// MyFinalBill billobj = new MyFinalBill();//Create an Object for Class MyFinalBills
		// int returnedValue= billobj.finalBill(regNumber,amount);//Called finalBill Method into the returned value..and Parameter are passed such as registration number and Amount.
	}
}