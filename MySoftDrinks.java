import java.util.*;
import java.io.*;
public class MySoftDrinks{
    public static double itemPrice;
    static int quantity;
    static int quantity_return;
	static Scanner input = new Scanner(System.in);
    static int foodItem =0;
	static int total_amount=0;
	static java.util.Date date=new java.util.Date();
    public static void main(String regNumber) {
		double runningTotal=0;
		int item_return;
		int menuOption;
		try{
			File file = new File("cafe/CafeBills/MySoftDrinks/"+regNumber+".txt");//Create object to create a txt file to write data
			boolean value = file.createNewFile();
			FileWriter bw = new FileWriter(file,true);//Write Data in the filename.txt and crete object
			bw.write("\nDate: "+date+"\n");
			File file1 = new File("cafe/CafeBills/BillFastfood.txt");
			FileWriter writer = new FileWriter(file1,true);
			boolean ordering = true;
			while(ordering){
				System.out.println();
				menu();//this method just tell user about the Juices
				System.out.println();
				try{
					System.out.println("Select your Soft Drink \n0.Nothing");
					System.out.print("Enter Your Choice: ");//used to selct which Juices user want
					menuOption = input.nextInt();
					System.out.println();
					switch(menuOption){
						case 0:break;
						case 1:
							foodItem = 1;
							System.out.println("You've ordered a Coca-Cola");
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
								bw.write("You've ordered a Coca-Cola\n"+"Quantity: "+quantity+"\n");
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
									bw.write("You've returned a Coca-Cola\n"+"Quantity: "+quantity+"\n");
										if(quantity_return>0)
											if((quantity - quantity_return)>0){
												writer.write("Coca-Cola              "+(quantity - quantity_return)+"    "+((quantity - quantity_return) *60));
												writer.write("\n");						
											}
											else if(quantity_return==quantity){
												
											}
								}
								else{
									writer.write("Coca-Cola              "+quantity+"    "+(quantity*60));
									writer.write("\n");
									break;
								}
							}
							
							break;
						case 2:
							foodItem = 2;
							System.out.println("You've ordered Pepsi");
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
								bw.write("You've ordered Pepsi\n"+"Quantity: "+quantity+"\n");
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
									bw.write("You've returned a Pepsi\n"+"Quantity: "+quantity+"\n");
									if(quantity_return>0)
										if((quantity - quantity_return)>0){
											writer.write("Pepsi                  "+(quantity - quantity_return)+"    "+((quantity - quantity_return) *60));
											writer.write("\n");						
										}
										else if(quantity_return==quantity){
											
										}
								}
								else{
									writer.write("Pepsi                  "+quantity+"    "+(quantity*60));
									writer.write("\n");
									break;
								}
							}
							break;
						case 3:
							foodItem = 3;
							System.out.println("You've ordered a Fanta");
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
								bw.write("You've ordered a Fanta\n"+"Quantity: "+quantity+"\n");
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
									bw.write("You've returned a Fanta\n"+"Quantity: "+quantity+"\n");
									if(quantity_return>0)
										if((quantity - quantity_return)>0){
											writer.write("Fanta                  "+(quantity - quantity_return)+"    "+((quantity - quantity_return) *60));
											writer.write("\n");						
										}
										else if(quantity_return==quantity){
											
										}
								}
								else{
									writer.write("Fanta                  "+quantity+"    "+(quantity*60));
									writer.write("\n");
									break;
								}
							}
							break;
						case 4:
							foodItem = 4;
							System.out.println("You've ordered a Dew");
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
								bw.write("You've ordered a Dew\n"+"Quantity: "+quantity+"\n");
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
									bw.write("You've returned a Dew\n"+"Quantity: "+quantity+"\n");
									if(quantity_return>0)
										if((quantity - quantity_return)>0){
											writer.write("Dew                    "+(quantity - quantity_return)+"    "+((quantity - quantity_return) *60));
											writer.write("\n");						
										}
										else if(quantity_return==quantity){
											
										}
								}
								else{
									writer.write("Dew                    "+quantity+"    "+(quantity*60));
									writer.write("\n");
									break;
								}
							}
							break;
						case 5:
							foodItem = 5;
							
							System.out.println("You've ordered a String");
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
								bw.write("You've ordered a String\n"+"Quantity: "+quantity+"\n");
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
									bw.write("You've returned a Sting\n"+"Quantity: "+quantity+"\n");
									if(quantity_return>0)
										if((quantity - quantity_return)>0){
											writer.write("Sting                  "+(quantity - quantity_return)+"    "+((quantity - quantity_return) *70));
											writer.write("\n");						
										}
										else if(quantity_return==quantity){
											
										}
								}
								else{
									writer.write("Sting                  "+quantity+"    "+(quantity*70));
									writer.write("\n");
									break;
								}
							}
							break;
						case 6:
							foodItem = 6;
							
							System.out.println("You've ordered a Sprite");
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
								bw.write("You've ordered a Sprite\n"+"Quantity: "+quantity+"\n");
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
									bw.write("You've returned a Sprite\n"+"Quantity: "+quantity+"\n");
									if(quantity_return>0)
										if((quantity - quantity_return)>0){
											writer.write("Sprite                 "+(quantity - quantity_return)+"    "+((quantity - quantity_return) *60));
											writer.write("\n");						
										}
										else if(quantity_return==quantity){
											
										}
								}
								else{
									writer.write("Sprite                 "+quantity+"    "+(quantity*60));
									writer.write("\n");
									break;
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
		bw.write("Total Amount: "+SoftDrinkbill()+"\n");//JuiceORPlantbill method return total bill amounts and it is write in txt file.
		bw.close();

		} 
		catch(Exception e){
			return;
		}
		
	}
    public static void menu() throws Exception{
    	File reader = new File("cafe/CafeBills/SoftDrinkMenu.txt");
    	Scanner myreader = new Scanner(reader);
    	String[] softdrinkMenu = new String[6];
    	int i =0 ;
    	while(myreader.hasNextLine()){
    		softdrinkMenu[i]=myreader.nextLine();
    		i++;
    	}
    	for (int j = 0 ;j<softdrinkMenu.length ;j++ ) {
    		System.out.println(softdrinkMenu[j]);
    	}
    	

    }

	public static double itemPrice() {
		if (foodItem == 1) {
			itemPrice = 60;
		}
		if (foodItem == 2) {
			
			itemPrice = 60;
		}
		if (foodItem == 3) {
			
			itemPrice = 60;
		}
		if (foodItem == 4) {
			
			itemPrice = 60;
		}
		if (foodItem == 5) {
			
			itemPrice = 70;
		}
		if (foodItem == 5) {
			
			itemPrice = 60;
		}
		subTotal();//this method return total amount of things selected by user.
		return itemPrice;
	}
    public static double subTotal() {
    	double subtotal;
        subtotal = quantity * itemPrice;
        total_amount+=subtotal;//subtotal is added to total amount.
        return subtotal;
    }
	public static double returnItem(){
		double returnitem;
		itemPrice();
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
	public static int SoftDrinkbill(){
		return(total_amount);//total amount of selected items.
	}
}