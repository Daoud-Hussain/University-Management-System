import java.util.*;
import java.io.*;
public class MyFinalBill{
	static java.util.Date date=new java.util.Date();
	static String name;
	public static int finalBill(String regNumber,int amount) throws Exception{
		File file = new File("students_data/"+ regNumber +".txt");
		try{
			Scanner sc = new Scanner(file);
			String[] line = sc.nextLine().split(":");
			name = line[1];
		}
		catch(Exception e){
			System.out.print("Error occured!");
		}

		MyFastFood fastfoodobject = new MyFastFood();//Create an object to call methods from class MyFastFood
		int num = fastfoodobject.FastfoodBill();//method FastfoodBill is caled and its value is stored in num variable

		MyDesiFood desifoodobject = new MyDesiFood();//Create an object to call methods from class MyDesiFood
		int num2 = desifoodobject.DesifoodBill();//method DesifoodBill is caled and its value is stored in num2 variable

		MySoftDrinks softDrinkobject = new MySoftDrinks();//Create an object to call methods from class MySoftDrinks
		int num3 = softDrinkobject.SoftDrinkbill();//method SoftDrinkbill is caled and its value is stored in num3 variable

		MyCoffee coffeeobject = new MyCoffee();//Create an object to call methods from class MyCoffee
		int num4 =coffeeobject.CoffeeBill();//method CoffeeBill is caled and its value is stored in num4 variable

		MyJuiceOrPlantDrink juiceOrPlantDrinkobject = new MyJuiceOrPlantDrink();//Create an object to call methods from class MyJuiceOrPlantDrink
		int num5 = juiceOrPlantDrinkobject.JuiceORPlantbill();//method JuiceORPlantbill is caled and its value is stored in num5 variable
		int TotalAmount= num+num2+num3+num4+num5;
		if(amount>=TotalAmount&& TotalAmount !=0){// check the amount in student account is enough to pay Total amount.
			System.out.println("\n\n\n");
			System.out.println("\t\t\t-----------------------------------");
			System.out.println("\t\t\tDate: "+date);
			System.out.println("\t\t\tName: "+name);
			System.out.println("\t\t\tStudent ID: "+regNumber);
			System.out.println("\t\t\t---------Thanks For Coming---------");
			System.out.println("\t\t\t-----------Your Bill Is------------\n");
			File file2 = new File("cafe/CafeBills/BillFastfood.txt");
			Scanner myReader = new Scanner(file2);
			int count = 0;//to create size of array
			while(myReader.hasNextLine()) {
				myReader.nextLine();
				count+=1;
			}
			Scanner reader = new Scanner(file2);
			String[] array = new String[count];
			int index = 0;
			//Read the data in file as well as input the data in the String Array.
			while (reader.hasNextLine()){
				array[index] = reader.nextLine();//read data from file.
				index++;
			}
			System.out.println("\t\t\tItems           Quantity   Prices\n");
			for (int i = 0 ;i<array.length ;i++ ) {
				System.out.print("\t\t\t"+array[i]+"\n");
			}
			System.out.printf("\t\t\tTotal Bill                  %d  \n",(num+num2+num3+num4+num5));//Total Bill is formed here.
			try{
				File file1 = new File("cafe/CafeBills/FinalBills/"+ regNumber +".txt");
				boolean value = file1.createNewFile();
				FileWriter billObj = new FileWriter(file1,true);
				billObj.write("Date: "+date+"\n");
				billObj.write("-----------------------------------\n");
				billObj.write("Name : "+ name +"\n");
				billObj.write("Student ID : "+ regNumber +"\n");
				billObj.write("-----------------------------------\n");
				billObj.write("---------Thanks For Coming---------\n");
				billObj.write("-----------Your Bill Is------------\n");
				billObj.write("\t\t\tItems            Quantity   Prices\n");
				for (int i = 0 ;i<array.length ;i++ ) {
					billObj.write(""+array[i]+"\n");//Write the data
				}
				billObj.write("Total Bill                 "+TotalAmount+"\n");
				billObj.write("-----------------------------------\n");
				billObj.write("-----------------------------------\n\n\n");
				billObj.close();
			PrintWriter writer = new PrintWriter(file2);
			writer.print("");
			writer.close();
			}
			catch(Exception e){
				System.out.println("invalid");
			}
		}
		else{
			if (TotalAmount==0) {
				System.out.println("");
				return amount;
			}
			System.out.println("Sir, You don't have enough Account Balance");
			return amount;
		}
		return 0;
	}

}