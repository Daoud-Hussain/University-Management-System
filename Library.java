//Importing all required packages
import java.util.Scanner;
import java.util.Random;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.*;
import java.io.*;
import library.*;



public class Library {

    //Initializing and declaring required variables and arrays
    static Scanner input = new Scanner(System.in);
    static String[] borrowedbooks;
    static int[] borrowedBooksIndexes;
    static String[] books = new String[20];
    static int totalBooks=0;
    static int userChoice;
    static int dateformater;
    static String borrowedDate;
    static String returnedDate;

    public static void main(String regNumber) {
        Arrays.fill(books,"");
        boolean flag = true;
        while(flag){

            //Displaying main menu
            System.out.println("******************************************");
            System.out.println("Welcome to Library Managament System!");
            System.out.println("Enter 1 to search books ");
            System.out.println("Enter 2 to read membership criteria ");
            System.out.println("Enter 3 to borrow books ");
            System.out.println("Enter 4 to return books ");
            System.out.println("Enter 5 to previous menu");
            System.out.println("Enter 6 to exit");
            System.out.println("******************************************");

            
            //Taking user choices
            try{
                System.out.print("Enter your choice: ");
                userChoice = input.nextInt();
                if (userChoice == 3){
                    library.TermsAndConditions.displayTerms();

                    System.out.print("Do you accept the terms Press 1 to accept and 2 to reject: ");
                    int option = input.nextInt();

                    if(option==1){
                        borrowBook(regNumber);
                    }
                    else if(option==2){
                        System.out.println("You must have to accept terms and condition, otherwise you can't buy any book!.");
                    }
                    else{
                        System.out.print("Invalid Input! \n");
                        input.nextLine();
                    }   
            
                }
                else if (userChoice == 4){
                    System.out.print("");
                    returnBook(regNumber);
                }
                else if(userChoice == 2){
                    System.out.print("");
                    library.TermsAndConditions.displayTerms();

                }
                else if (userChoice == 1){
                    searchBook();
                }
                else if(userChoice == 5){
                    LibraryManagement.manage(regNumber);
                }
                else if(userChoice == 6){
                    System.exit(0);
                }
                else{
                    System.out.println("Invalid Input! ");
                }
            }
            catch(Exception e){
                System.out.println("Invalid Input Try again!\n");
                input.nextLine();
            }
        }
    }

    //Book borrowing module
    public static  void borrowBook(String regNumber) {
        System.out.println("*************************************************");
        System.out.println("Available books are: ");
        try{
            File file = new File("Library/AvailableBooks.txt");
            Scanner sc = new Scanner(file);
            int j=1;
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                if(line!=""){
                    books[j-1] = line;
                    System.out.println(j+". "+line);
                    // j++;
                    totalBooks++;
                }
                j++;
            }
            sc.close();
            System.out.println("*************************************************");

        }
        catch(Exception e){
            System.out.println("Error occurred!");
        }


        if(totalBooks==0){
            System.out.println("!!!!!!! No Record Found !!!!!!!\n");
        }
        else{
            boolean flag = false;
            while(true){
                try{
                    //TAking number of books purchased from user
                    Scanner input = new Scanner(System.in);
                    System.out.print("How many books you want to borrow: ");
                    int numberOfPurchasedBooks = input.nextInt();
                    borrowedbooks = new String[numberOfPurchasedBooks];
                    borrowedBooksIndexes = new int[numberOfPurchasedBooks + 1];
                    

                    //Validating the input
                    if(numberOfPurchasedBooks <= totalBooks && numberOfPurchasedBooks > 0){

                        for(int i=0; i<numberOfPurchasedBooks; i++) {
                            System.out.println("*************************************");
                            System.out.printf("Record Book %d \n", i+1);
                            int previousBook = 0;
                            System.out.print("Which book you want to borrow, Enter its number: ");
                            int bookNumber = input.nextInt();



                            try{
                                if(bookNumber<=20 && bookNumber > 0){

                                    //Displaying available books
                                    File ff = new File("Library/AvailableBooks.txt");
                                    Scanner sc = new Scanner(ff);
                                    int index = 1;
                                    while(sc.hasNextLine()){
                                        String line = sc.nextLine();
                                        if(index==bookNumber){
                                            borrowedbooks[i] = line;
                                            if(bookNumber==previousBook){
                                                System.out.println("This book is booked. Try Any other");
                                            }
                                            previousBook= bookNumber;
                                            break;
                                        }
                                        index++;


                                    }
                                sc.close();
                                }
                                else{
                                    System.out.println("Invalid Book Number");
                                    i-=1;
                                }
                                
                            }
                            catch(Exception ex){
                                System.out.println("Invalid Input! Try Again");
                                i-=1;
                            }
                        }
                        System.out.println("Successfully Borrowed " + numberOfPurchasedBooks+ " books");
                        flag = true;
                    }
                    else{
                        System.out.print("Invalid Input! Only books "+totalBooks+ " are available.\n");
                    }
                }
                catch(Exception e){
                    System.out.print("Invalid input! Try Again\n");
                }

                if(flag){
                    break;
                }
            }


            //Calcualating date of borrowing
            try{
                SimpleDateFormat dateAndTimeFormatter = new SimpleDateFormat("dd/MM/yyyy"); 
                Date date = new Date(); 
                borrowedDate = dateAndTimeFormatter.format(date);
 

                File myFile = new File("Library/BorrowedBooks/"+regNumber+".txt");
                boolean value = myFile.createNewFile();
                FileWriter fileWriter = new FileWriter("Library/BorrowedBooks/"+regNumber+".txt",true);
                fileWriter.write("Borrowed at: " + dateAndTimeFormatter.format(date) + "\n");

                for(String book : borrowedbooks){
                    fileWriter.write(book+"\n");
                }
                fileWriter.close();
            }
            catch(Exception e){
                System.out.print(e+"\n");
            }

            for(int n=0;n<books.length;n++){
                for(int m=0;m<borrowedbooks.length;m++){
                    if(borrowedbooks[m].compareTo(books[n])==0){
                        books[n] = "";
                        break;
                    }
                }
            }



            //Writing available file as empty
            try{
                File myFF = new File("Library/AvailableBooks.txt");
                FileWriter fileWriter = new FileWriter(myFF);
                fileWriter.write("");
                fileWriter.close();
            }
            catch(Exception e){
                System.out.print(e+"\n");
            }


            //Creating new file with same name to store available books after borrowing
            try{
                File myFF = new File("Library/AvailableBooks.txt");
                boolean value = myFF.createNewFile();
                FileWriter fileWriter = new FileWriter(myFF,true);
                for(String bk:books){
                    if(bk!=""){
                        fileWriter.write(bk+"\n");
                    }
                }
                fileWriter.close();
            }
            catch(Exception e){
                System.out.print(e+"\n");
            }

            Arrays.fill(borrowedbooks,"");
            Arrays.fill(books,"");
            totalBooks=0;
        }
    }

    // Book returning module
    public static void returnBook(String regNumber){
        //Checking date to return book
        SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();  
        returnedDate = formatter2.format(date);

        int choice=0;
        try{
            //Displaying borrowed books
            File fileObj = new File("Library/BorrowedBooks/"+regNumber+".txt");
            if(fileObj.exists()){
                try{    
                System.out.print("\nYou have borrowed following books : \n");
                File file = new File("Library/BorrowedBooks/"+regNumber+".txt");
                Scanner data = new Scanner(file);
                int i=0;
                while(data.hasNextLine()){
                    String line = data.nextLine();
                    System.out.print(line+"\n");
                    books[i] = line;
                    i++;
                }
                data.close();


            }
            catch(Exception e){

            }

            // choice Menu
            System.out.print("\n************************************\n");
            System.out.print("\n1. Return books\n");
            System.out.print("2. Previous menu\n");

            boolean flag = false;
            while(true){
                try{
                    System.out.print("Enter your choice : ");
                    choice = input.nextInt();
                    if(choice==1){
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date date1 = sdf.parse(borrowedDate);
                Date date2 = sdf.parse(returnedDate);

                System.out.println("Borrowed date : " + sdf.format(date1));
                System.out.println("Returned date : " + sdf.format(date2));

                int result = date1.compareTo(date2);

                if (result == 0) {
                    System.out.println("No fine is declared to " + regNumber);
                } else if (result > 30) { //Declaring fine for late submission
                    int fine = 50;
                    System.out.println("You have to pay 50 rupees fine per day!");
                } else {
                    System.out.println("Correct your calendar");
                }

                        flag = true;
                        FileWriter writer = new FileWriter("Library/AvailableBooks.txt",true);
                        for(int a=0;a<books.length;a++){
                            writer.write(books[a]+"\n");
                        }
                        writer.close();

                        File myObj = new File("Library/BorrowedBooks/"+regNumber+".txt");
                        if(myObj.delete()){
                            System.out.println("Books has been returned Successfully!");
                        }
                        else{
                            System.out.println("Some error occured in deleting your data!\n");
                        }



                        

                    }
                    else if(choice==2){
                        flag = true;
                        System.out.println("Return to previous menu..");
                    }
                    else{
                        System.out.println("Invalid choice... Try again!\n");
                    }
                }
                catch(Exception e){
                    System.out.println("Invalid choice... Try again!"+"\n");
                    input.nextLine();
                }
                if(flag){
                    break;
                }
            }
            }
            else{
                System.out.println("You have not borrowed any book!\n");
            }


            

        }
        catch(Exception e){
            System.out.println("Error Occurred!");
        }





    }

//Book searching module
    public static String searchBook(){
        boolean process = false;
        Scanner input = new Scanner(System.in);
        //Taking book name from user
        System.out.print("Enter book name you want to search: ");
        String searchBookName = input.nextLine().toLowerCase();
        String line= " ";

        try{
            //Specifying file to search book
            File file = new File("Library/AvailableBooks.txt");
            Scanner console = new Scanner(file);


            //Searching book name from available files
            int i=0;
            while(console.hasNextLine()){
                line = console.nextLine().toLowerCase();
                if(line.contains(searchBookName)){
                    System.out.println(i+1 +". " + line);
                    process = true;

                }
                i++;
            }
        }
        catch(Exception e){
            System.out.println("Any Error while reading the Available file");
            input.nextLine();
        }

        //No matched input case
        if(!process){
            System.out.printf("No book available with name \"%s\" Try Any other! \n", searchBookName);
        }
        return line;
    }

}