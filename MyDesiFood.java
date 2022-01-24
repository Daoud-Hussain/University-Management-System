import java.util.*;
import java.io.*;
public class MyDesiFood{
    private static double itemPrice;
    static Scanner input = new Scanner(System.in);
    static int quantity;
    static int quantity_return;
    static int foodItem =0;
	static int total_amount=0;
	static java.util.Date date=new java.util.Date();
    public static void main(String regNumber) {
		input = new Scanner(System.in);
		double runningTotal=0;
		int item_return;
		boolean ordering = true;
		int menuOption;
		try{
			File file = new File("cafe/CafeBills/DesiFood/"+ regNumber +".txt");//Create object to create a txt file to write data
			boolean value = file.createNewFile();
			File file1 = new File("cafe/CafeBills/BillFastfood.txt");
			FileWriter writer = new FileWriter(file1,true);
			FileWriter bw = new FileWriter(file,true);//Write Data in the filename.txt
			bw.write("\nDate: "+date+"\n");
			while(ordering){
				System.out.println();
				menu();//this method just tell user about the desi food.
				System.out.println();
				try{
					System.out.println("Select your Desi food\n0.Nothing\n");
					System.out.print("Enter Your Choice: ");
					menuOption = input.nextInt();//used to selct which Desi food user want.
					System.out.println();
					switch(menuOption){
						case 0:break;
						case 1:
							foodItem = 1;
							System.out.println("You've ordered a Haleem");
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
								bw.write("You've ordered a Haleem\n"+"Quantity: "+quantity+"\n");
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
									bw.write("You've returned a Haleem\n"+"Quantity: "+quantity_return+"\n");
									if(quantity_return>0)
										if((quantity - quantity_return)>0){
											writer.write("Haleem                 "+(quantity - quantity_return)+"    "+((quantity - quantity_return) *120));
											writer.write("\n");						
										}
										else if(quantity_return==quantity){

										}
								}else{
									writer.write("Haleem                 "+quantity+"    "+(quantity*120));
									writer.write("\n");
									break;
								}
							}
								
								break;
						case 2:
							foodItem = 2;
							System.out.println("You've ordered Rogan Gosht");
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
								bw.write("You've ordered Rogan Gosht\n"+"Quantity: "+quantity+"\n");
								System.out.println("\n1.Return\nPress any Integer except '1'");
								while(true){
									try{
										item_return = input.nextInt();//user want to return or not.
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
									bw.write("You've returned a Rogan Gosht\n"+"Quantity: "+quantity_return+"\n");	
									if(quantity_return>0)
										if((quantity - quantity_return)>0){
											writer.write("Rogan Gosht            "+(quantity - quantity_return)+"    "+((quantity - quantity_return) *250));
											writer.write("\n");						
										}
										else if(quantity_return==quantity){

										}

								}
								else{
									writer.write("Rogan Gosht            "+quantity+"    "+(quantity*250));
									writer.write("\n");
									break;
								}
							}
								break;
							
						case 3:
							foodItem = 3;
							System.out.println("You've ordered a Matar Paneer");
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
								bw.write("You've ordered a Matar Paneer\n"+"Quantity: "+quantity+"\n");
								System.out.println("\n1.Return\nPress any Integer except '1'");
								while(true){
									try{
										item_return = input.nextInt();//user want to return or not.
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
									bw.write("You've returned a Matar Paneer\n"+"Quantity: "+quantity_return+"\n");	
									if(quantity_return>0)
										if((quantity - quantity_return)>0){
											writer.write("Matar Paneer           "+(quantity - quantity_return)+"    "+((quantity - quantity_return) *150));
											writer.write("\n");						
										}						
										else if(quantity_return==quantity){

										}
								}
								else{
									writer.write("Matar Paneer           "+quantity+"    "+(quantity*150));
									writer.write("\n");
									break;
								}
							}
								break;
							
						case 4:
							foodItem = 4;
							System.out.println("You've ordered a Aloo Ka Paratha");
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
								bw.write("You've ordered a Aloo Ka Paratha\n"+"Quantity: "+quantity+"\n");
								System.out.println("\n1.Return\nPress any Integer except '1'");
								while(true){
									try{
										item_return = input.nextInt();//user want to return or not.
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
									bw.write("You've returned a Aloo Ka Paratha\n"+"Quantity: "+quantity_return+"\n");	
									if(quantity_return>0)
										if((quantity - quantity_return)>0){
											writer.write("Aloo Ka Paratha        "+(quantity - quantity_return)+"    "+((quantity - quantity_return) *100));
											writer.write("\n");						
										}						
										else if(quantity_return==quantity){

										}
								}
								else{
									writer.write("Aloo Ka Paratha        "+quantity+"    "+(quantity*100));
									writer.write("\n");
									break;
								}
							}
								break;
							
						case 5:
							foodItem = 5;
							
							System.out.println("You've ordered a Spicy Sweet Potatoes");
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
								bw.write("You've ordered a Spicy Sweet Potatoes\n"+"Quantity: "+quantity+"\n");
								System.out.println("\n1.Return\nPress any Integer except '1'");
								while(true){
									try{
										item_return = input.nextInt();//user want to return or not.
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
									bw.write("You've returned a Spicy Sweet Potatoes\n"+"Quantity: "+quantity_return+"\n");	
									if(quantity_return>0)
										if((quantity - quantity_return)>0){
											writer.write("Spicy Sweet Potatoes   "+(quantity - quantity_return)+"    "+((quantity - quantity_return) *80));
											writer.write("\n");						
										}
										else if(quantity_return==quantity){

										}
								} 
								else{
									writer.write("Spicy Sweet Potatoes   "+quantity+"    "+(quantity*80));
									writer.write("\n");
									break;
								}
							}
								break;
							
						case 6:
							foodItem = 6;
							System.out.println("You've ordered a Chole Palak");
							
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
								bw.write("You've ordered a Chole Palak\n"+"Quantity: "+quantity+"\n");
								System.out.println("\n1.Return\nPress any Integer except '1'");
								while(true){
									try{
										item_return = input.nextInt();//user want to return or not.
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
									bw.write("You've returned a Chole Palak\n"+"Quantity: "+quantity_return+"\n");	
									if(quantity_return>0)
										if((quantity - quantity_return)>0){
											writer.write("Chole Palak            "+(quantity - quantity_return)+"    "+((quantity - quantity_return) *110));
											writer.write("\n");						
										}						
										else if(quantity_return==quantity){

										}
								}
								else{
									writer.write("Chole Palak            "+quantity+"    "+(quantity*110));
									writer.write("\n");
									break;
								}
							}
								break;
							
						case 7:
							foodItem = 7;
							System.out.println("You've ordered a Mash ki Dal");
							
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
								bw.write("You've ordered a Mash ki Dal\n"+"Quantity: "+quantity+"\n");
								System.out.println("\n1.Return\nPress any Integer except '1'");
								while(true){
									try{
										item_return = input.nextInt();//user want to return or not.
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
									bw.write("You've returned a Mash ki Dal\n"+"Quantity: "+quantity_return+"\n");	
									if(quantity_return>0)
										if((quantity - quantity_return)>0){
											writer.write("Mash Ki Dal            "+(quantity - quantity_return)+"    "+((quantity - quantity_return) *130));
											writer.write("\n");						
										}						
										else if(quantity_return==quantity){

										}
								}
								else{
									writer.write("Mash Ki Dal            "+quantity+"    "+(quantity*130));
									writer.write("\n");
									break;
								}
							}
								break;
							
						case 8:
							foodItem = 8;
							System.out.println("You've ordered a Biryani");
							
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
								bw.write("You've ordered a Biryani\n"+"Quantity: "+quantity+"\n");
								System.out.println("\n1.Return\nPress any Integer except '1'");
								while(true){
									try{
										item_return = input.nextInt();//user want to return or not.
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
									bw.write("You've returned a Biryani\n"+"Quantity: "+quantity_return+"\n");	
									if(quantity_return>0)
										if((quantity - quantity_return)>0){
											writer.write("Biryani                "+(quantity - quantity_return)+"    "+((quantity - quantity_return) *200));
											writer.write("\n");						
										}							
										else if(quantity_return==quantity){

										}
								}
								else{
									writer.write("Biryani                "+quantity+"    "+(quantity*200));
									writer.write("\n");
									break;
								}
							}
								break;
							
						case 9:
							foodItem = 9;
							System.out.println("You've ordered a Chicken Quorma");
							
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
								bw.write("You've ordered a Chicken Quorma\n"+"Quantity: "+quantity+"\n");
								System.out.println("\n1.Return\nPress any Integer except '1'");
								while(true){
									try{
										item_return = input.nextInt();//user want to return or not.
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
									bw.write("You've returned a Chicken Quorma\n"+"Quantity: "+quantity_return+"\n");
									if(quantity_return>0)
										if((quantity - quantity_return)>0){
											writer.write("Chicken Quorma         "+(quantity - quantity_return)+"    "+((quantity - quantity_return) *180));
											writer.write("\n");						
										}
										else if(quantity_return==quantity){

										}
								}
								else{
									writer.write("Chicken Quorma         "+quantity+"    "+(quantity*180));
									writer.write("\n");
									break;
								}
							}
								break;
							
						case 10:
							foodItem = 10;
							System.out.println("You've ordered a Samosa");
							
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
								bw.write("You've ordered a Samosa\n"+"Quantity: "+quantity+"\n");
								System.out.println("\n1.Return\nPress any Integer except '1'");
								while(true){
									try{
										item_return = input.nextInt();//user want to return or not.
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
									bw.write("You've returned a Samosa\n"+"Quantity: "+quantity_return+"\n");
									if(quantity_return>0)
										if((quantity - quantity_return)>0){
											writer.write("Samosa                 "+(quantity - quantity_return)+"    "+((quantity - quantity_return) *25));
											writer.write("\n");						
										}
										else if(quantity_return==quantity){

										}
								}else{
									writer.write("Samosa                 "+quantity+"    "+(quantity*25));
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
		bw.write("Total Amount: "+DesifoodBill()+"\n");//DesifoodBill method return total bill amounts and it is write in txt file.
		bw.close();

		} 
		catch(Exception e){
			return;
		}
		
		
	}
    public static void menu() throws Exception{
    	File reader = new File("cafe/CafeBills/DesiFoodMenu.txt");
    	Scanner myreader = new Scanner(reader);
    	String[] desiFoodMenu = new String[10];
    	int i =0 ;
    	while(myreader.hasNextLine()){
    		desiFoodMenu[i]=myreader.nextLine();
    		i++;
    	}
    	for (int j = 0 ;j<desiFoodMenu.length ;j++ ) {
    		System.out.println(desiFoodMenu[j]);
    	}


    }
	public static double itemPrice() {
		if (foodItem == 1) {
			itemPrice = 120;
		}
		if (foodItem == 2) {
			
			itemPrice = 250;
		}
		if (foodItem == 3) {
			
			itemPrice = 150;
		}
		if (foodItem == 4) {
			
			itemPrice = 100;
		}
		if (foodItem == 5) {
			
			itemPrice = 80;
		}
		if (foodItem == 6) {
			
			itemPrice = 110;
		}
		if (foodItem == 7) {
			
			itemPrice = 130;
		}
		if (foodItem == 8) {
			
			itemPrice = 200;
		}
		if (foodItem == 9) {
			
			itemPrice = 180;
		}
		if (foodItem == 10) {
			
			itemPrice = 25;
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
	public static int DesifoodBill(){
		return(total_amount);//total amount of selected items.
	}
}