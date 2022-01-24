import java.util.*;
import java.io.*;
public class MyCoffee{
    private static double itemPrice;
    static Scanner input = new Scanner(System.in);
    static int quantity;
    static int quantity_return;
    static int foodItem =0;
	static int total_amount=0;
	static java.util.Date date=new java.util.Date();//Used to get Date
    public static void main(String regNumber) {
		input = new Scanner(System.in);
		double runningTotal=0;
		int item_return;
		int menuOption;
		try{
			boolean ordering = true;
			File file = new File("cafe/CafeBills/MyCoffee/"+regNumber+".txt");//Create object to create a txt file to write data 
			boolean value = file.createNewFile();
			File file1 = new File("cafe/CafeBills/BillFastfood.txt");
			FileWriter writer = new FileWriter(file1,true);
			FileWriter bw = new FileWriter(file,true);//Write Data in the filename.txt
			bw.write("\nDate: "+date+"\n");
			while(ordering){
				System.out.println();
				menu();//this method just tell user about the drinks.
				System.out.println();
				try{
					System.out.println("Select your Coffee\n0.Nothing");
					System.out.print("Enter Your Choice: ");
					menuOption = input.nextInt();//used to selct which coffee user want.
					System.out.println();
					switch(menuOption){
						case 0:break;
						case 1:
							foodItem = 1;
							System.out.println("You've ordered a Black Coffee");
	       					System.out.print("Enter quantity: ");
	        				while(true){
								try{
									quantity = input.nextInt();//Enter Quatity of food
									while(true){
										if(quantity>0){
											break;
										}
										else{
											System.out.println("Enter Again");
											quantity = input.nextInt();
										}
									}
									break;
								}
								catch(Exception e){
									System.out.println("Invalid! Enter Again");
									input.nextLine();
								}
							}
							if(quantity>0){
		        				runningTotal += itemPrice();//here itemPrice method called to check amount of item selected by user.and add to running total variable
								System.out.println();
								bw.write("You've ordered a Black Coffee\n"+"Quantity: "+quantity+"\n");
								System.out.println("\n1.Return\nPress any Integer except '1'");
								while(true){
										try{
											item_return = input.nextInt();//user want to return or not.}
											
											while(true){
												if(item_return>=0)
													break;
												else{
													System.out.println("Enter Again");
													item_return= input.nextInt();
												}
											}
											break;
										}
										catch(Exception e){
											System.out.println("invlaid! Enter Again");
											input.nextLine();
										}
									}
								
								if(item_return ==1){
									while(true){
											try{
												System.out.println("Enter returned quantity:");
												quantity_return = input.nextInt();
												while(true){
													if(quantity_return>0){
														break;
													}
													else{
														System.out.println("Enter Again");
														quantity_return= input.nextInt();
													}
												}
												break;
											}
											catch(Exception e){
												System.out.println("invlaid! Enter Again");
												input.nextLine();
											}
										}
									total_amount-=returnItem();//return method called and return that item and its price is also subtract from the total amount
									bw.write("You've returned a Black Coffee\n"+"Quantity: "+quantity+"\n");
									if(quantity_return>0)
											if((quantity - quantity_return)>0){
												writer.write("Black Coffee           "+(quantity - quantity_return)+"    "+((quantity - quantity_return) *120));
												writer.write("\n");						
											}
											else if(quantity_return==quantity){
												
											}
								}
								else{
									writer.write("Black Coffee           "+quantity+"    "+(quantity*120));
									writer.write("\n");
									break;
								}
							}
								
							break;
						case 2:
							foodItem = 2;
							System.out.println("You've ordered Cold Coffee");
							System.out.print("Enter quantity: ");
	        				while(true){
								try{
									quantity = input.nextInt();//Enter Quatity of food
									while(true){
										if(quantity>0){
											break;
										}
										else{
											System.out.println("Enter Again");
											quantity = input.nextInt();
										}
									}
									break;
								}
								catch(Exception e){
									System.out.println("Invalid! Enter Again");
									input.nextLine();
								}
							}
							if(quantity>0){
								runningTotal += itemPrice();//here itemPrice method called to check amount of item selected by user.and add to running total variable
								System.out.println();
								bw.write("You've ordered Cold Coffee\n"+"Quantity: "+quantity+"\n");
								System.out.println("\n1.Return\nPress any Integer except '1'");
								while(true){
										try{
											item_return = input.nextInt();//user want to return or not.}
											
											while(true){
												if(item_return>=0)
													break;
												else{
													System.out.println("Enter Again");
													item_return= input.nextInt();
												}
											}
											break;
										}
										catch(Exception e){
											System.out.println("invlaid! Enter Again");
											input.nextLine();
										}
									}
								if(item_return ==1){
									while(true){
											try{
												System.out.println("Enter returned quantity:");
												quantity_return = input.nextInt();
												while(true){
													if(quantity_return>0){
														break;
													}
													else{
														System.out.println("Enter Again");
														quantity_return= input.nextInt();
													}
												}
												break;
											}
											catch(Exception e){
												System.out.println("invlaid! Enter Again");
												input.nextLine();
											}
										}
									total_amount-=returnItem();//return method called and return that item and its price is also subtract from the total amount
									bw.write("You've returned a Cold Coffee\n"+"Quantity: "+quantity+"\n");
									if(quantity_return>0)
											if((quantity - quantity_return)>0){
												writer.write("Cold Coffee            "+(quantity - quantity_return)+"    "+((quantity - quantity_return) *100));
												writer.write("\n");						
											}
											else if(quantity_return==quantity){
												
											}
								}
								else{
									writer.write("Cold Coffee            "+quantity+"    "+(quantity*100));
									writer.write("\n");
									break;//break loop.
								}
							}
							break;
						default:
							System.out.println("Invalid option.");
					}
					if(menuOption==0){
						break;
					}

				}
				catch(Exception e){
					System.out.println("Invalid Inputs");
					input.nextLine();
				}

			}
		writer.close();
		bw.write("Total Amount: "+CoffeeBill()+"\n");//coffeeBill method return total bill amounts and it is write in txt file.
		bw.close();//object is closed

		} 
		catch(Exception e){
			return;
		}
		
	}

    public static void menu() throws Exception{
    	File reader = new File("cafe/CafeBills/CoffeeMenu.txt");
    	Scanner myreader = new Scanner(reader);
    	String[] coffeMenu = new String[2];
    	int i =0 ;
    	while(myreader.hasNextLine()){
    		coffeMenu[i]=myreader.nextLine();
    		i++;
    	}
    	for (int j = 0 ;j<coffeMenu.length ;j++ ) {
    		System.out.println(coffeMenu[j]);
    	}
    	

    }
	public static double itemPrice() {
		if (foodItem == 1) {
			itemPrice = 120;
		}
		if (foodItem == 2) {
			
			itemPrice = 100;
		}
		subTotal();//this method return amount of things selected by user.
		return itemPrice;
	}
    public static double subTotal() {
    	double subtotal;
        subtotal = quantity * itemPrice;
        total_amount+=subtotal;//subtotal is added to total amount.
        return subtotal;
    }
	public static double returnItem(){
		itemPrice();
		double returnitem;
		boolean ordering= true;
		while(ordering){
			if(quantity_return<0 || quantity_return>quantity){
				System.out.println("Wrong Quantity.");
				System.out.print("Enter Again");
				input.nextLine();
				try{
					quantity_return= input.nextInt();
				}
				catch(Exception e){
					System.out.println("Invalid! input");

				}
			}
			else if(quantity_return>=0&&quantity_return<=quantity){
				returnitem = (quantity_return * itemPrice);
				ordering=false;
				return returnitem;//it return the amount of returned item.

				
			}
			//continue;
		}
		return 0;
	}
	public static int CoffeeBill(){
		return(total_amount);//total amount of selected items.
	}
}

	