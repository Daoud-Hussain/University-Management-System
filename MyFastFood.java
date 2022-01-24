
import java.util.*;
import java.io.*;
public class MyFastFood{
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
		int menuOption;
		boolean ordering = true;
		try{
			File file = new File("cafe/CafeBills/FastFood/"+ regNumber +".txt");//Create object to create a txt file to write data
			File file1 = new File("cafe/CafeBills/BillFastfood.txt");
			FileWriter writer = new FileWriter(file1,true);
			boolean value = file.createNewFile();
			FileWriter bw = new FileWriter(file,true);//Write Data in the filename.txt and crete object
			bw.write("\nDate: "+date+"\n");
			while(ordering){
				System.out.println();
				menu();//this method just tell user about the Fast food.
				System.out.println();
				try{
					System.out.print("Enter Your Choice: ");
					menuOption = input.nextInt();//used to selct which Fast food user want
					System.out.println();
					switch(menuOption){
						case 0:break;
						case 1:
							foodItem = 1;
							System.out.println("You've ordered a burger");
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
								bw.write("You've ordered a burger\n"+"Quantity: "+quantity+"\n");
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
									bw.write("You've returned a burger\n"+"Quantity: "+quantity_return+"\n");
									if(quantity_return>0)
										if((quantity - quantity_return)>0){
											writer.write("Burger                 "+(quantity - quantity_return)+"    "+((quantity - quantity_return) *80));
											writer.write("\n");						
										}
										else if(quantity_return==quantity){
											
										}

								}
								else{
									writer.write("Burger                 "+quantity+"    "+(quantity*80));
									writer.write("\n");
									break;
								}
							}
								
								break;
							case 2:
								foodItem = 2;
								System.out.println("You've ordered Zinger Burger");
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
									bw.write("You've ordered Zinger Burger\n"+"Quantity: "+quantity+"\n");
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
										bw.write("You've returned a Zinger Burger\n"+"Quantity: "+quantity_return+"\n");
										if(quantity_return>0)
										if((quantity - quantity_return)>0){
											writer.write("Zinger Burger          "+(quantity - quantity_return)+"    "+((quantity - quantity_return) *250));
											writer.write("\n");						
										}
										else if(quantity_return==quantity){
											
										}

									}
									else{
										writer.write("Zinger Burger          "+quantity+"    "+(quantity*250));
										writer.write("\n");
										break;
									}
								}
							break;
						case 3:
							foodItem = 3;
							System.out.println("You've ordered a Shawarma");
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
								bw.write("You've ordered a Shawarma\n"+"Quantity: "+quantity+"\n");
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
									bw.write("You've returned a Sharwarma\n"+"Quantity: "+quantity_return+"\n");
									if(quantity_return>0)
										if((quantity - quantity_return)>0){
											writer.write("Sharwarma              "+(quantity - quantity_return)+"    "+((quantity - quantity_return) *120));
											writer.write("\n");						
										}
										else if(quantity_return==quantity){
											
										}

								}
								else{
									writer.write("Sharwarma	             "+quantity+"    "+(quantity*120));
									writer.write("\n");
									break;
								}
							}
							break;
						case 4:
							foodItem = 4;
							System.out.println("You've ordered a Pizza");
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
								bw.write("You've ordered a Pizza\n"+"Quantity: "+quantity+"\n");
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
									bw.write("You've returned a Pizza\n"+"Quantity: "+quantity_return+"\n");
									if(quantity_return>0)
										if((quantity - quantity_return)>0){
											writer.write("Pizza                  "+(quantity - quantity_return)+"    "+((quantity - quantity_return) *350));
											writer.write("\n");						
										}
										else if(quantity_return==quantity){
											
										}

								}
								else{
									writer.write("Pizza                  "+quantity+"    "+(quantity*350));
									writer.write("\n");
									break;
								}
							}
							break;
						case 5:
							foodItem = 5;
							
							System.out.println("You've ordered a Sandwich");
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
								bw.write("You've ordered a Sandwich\n"+"Quantity: "+quantity+"\n");
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
									bw.write("You've returned a Sandwich\n"+"Quantity: "+quantity+"\n");
									if(quantity_return>0)
										if((quantity - quantity_return)>0){
											writer.write("Sandwich               "+(quantity - quantity_return)+"    "+((quantity - quantity_return) *70));
											writer.write("\n");						
										}
										else if(quantity_return==quantity){
											
										}
								}
								else{
									writer.write("Sandwich               "+quantity+"    "+(quantity*70));
									writer.write("\n");
									break;
								}
							}
							break;
						case 6:
							foodItem = 6;
							System.out.println("You've ordered a Fries");
							
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
								bw.write("You've ordered a Fries\n"+"Quantity: "+quantity+"\n");
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
									bw.write("You've returned a Fries\n"+"Quantity: "+quantity_return+"\n");
									if(quantity_return>0)
										if((quantity - quantity_return)>0){
											writer.write("Fries                  "+(quantity - quantity_return)+"    "+((quantity - quantity_return) *50));
											writer.write("\n");						
										}
										else if(quantity_return==quantity){
											
										}

								}
								else{
									writer.write("Fries                  "+quantity+"    "+(quantity*50));
									writer.write("\n");
									break;
								}
							}
							break;
						case 7:
							foodItem = 7;
							System.out.println("You've ordered a Deal A");
							
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
								bw.write("You've ordered a Deal A\n"+"Quantity: "+quantity+"\n");
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
									bw.write("You've returned a Deal A\n"+"Quantity: "+quantity_return+"\n");
									if(quantity_return>0)
										if((quantity - quantity_return)>0){
											writer.write("Deal A                 "+(quantity - quantity_return)+"    "+((quantity - quantity_return) *550));
											writer.write("\n");						
										}
										else if(quantity_return==quantity){
											
										}

								}
								else{
									writer.write("Deal A                 "+quantity+"    "+(quantity*550));
									writer.write("\n");
									break;
								}
							}
							break;
						case 8:
							foodItem = 8;
							System.out.println("You've ordered a Deal B");
							
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
								bw.write("You've ordered a Deal B\n"+"Quantity: "+quantity+"\n");
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
									bw.write("You've returned a Deal B\n"+"Quantity: "+quantity_return+"\n");
									if(quantity_return>0)
										if((quantity - quantity_return)>0){
											writer.write("Deal B                 "+(quantity - quantity_return)+"    "+((quantity - quantity_return) *850));
											writer.write("\n");						
										}
										else if(quantity_return==quantity){
											
										}

								}
								else{
									writer.write("Deal B                 "+quantity+"    "+(quantity*850));
									writer.write("\n");
									break;
								}
							}
							break;
						case 9:
							foodItem = 9;
							System.out.println("You've ordered a Deal C");
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
								bw.write("You've ordered a Deal C\n"+"Quantity: "+quantity+"\n");
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
									bw.write("You've returned a Deal C\n"+"Quantity: "+quantity_return+"\n");

									if(quantity_return>0)
										if((quantity - quantity_return)>0){
											writer.write("Deal C                 "+(quantity - quantity_return)+"    "+((quantity - quantity_return) *1050));
											writer.write("\n");						
										}
										else if(quantity_return==quantity){
											
										}
								}
								else{
									writer.write("Deal C                 "+quantity+"    "+(quantity*1050));
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
		bw.write("Total Amount: "+FastfoodBill()+"\n");//FastfoodBill method return total bill amounts and it is write in txt file.
		bw.close();

		} 
		catch(Exception e){
			System.out.println(e);
		}
		
	}

    public static void menu() throws Exception{
    	File reader = new File("cafe/CafeBills/FastFoodMenu.txt");
    	Scanner myreader = new Scanner(reader);
    	String[] fastfoodMenu = new String[13];
    	int i =0 ;
    	while(myreader.hasNextLine()){
    		fastfoodMenu[i]=myreader.nextLine();
    		i++;
    	}
    	for (int j = 0 ;j<fastfoodMenu.length ;j++ ) {
    		System.out.println(fastfoodMenu[j]);
    	}
    	

    }
	public static double itemPrice() {
		if (foodItem == 1) {
			itemPrice = 80;
		}
		if (foodItem == 2) {
			
			itemPrice = 250;
		}
		if (foodItem == 3) {
			
			itemPrice = 120;
		}
		if (foodItem == 4) {
			
			itemPrice = 350;
		}
		if (foodItem == 5) {
			
			itemPrice = 70;
		}
		if (foodItem == 6) {
			
			itemPrice = 50;
		}
		if (foodItem == 7) {
			
			itemPrice = 550;
		}
		if (foodItem == 8) {
			
			itemPrice = 850;
		}
		if (foodItem == 9) {
			
			itemPrice = 1050;
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
	public static int FastfoodBill(){
		return(total_amount);//total amount of selected items.
	}
}

	