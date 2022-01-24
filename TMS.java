
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Random;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.net.URI;

//Shahzaneer Ahmed --> SP21-BCS-087
// input fields are validated (exceptional handling)
// randomly generation Bus Registration ID
//CRUD
// file handling



public class TMS {


    public static void manage (String regNumber) {
        System.out.print("\n");
        Scanner input = new Scanner(System.in);

        String registrationNo = regNumber;
        String busID = busID(registrationNo);

        boolean isRegistered = busFileFound(regNumber);
        boolean feePaid = false;


        String busReg = "";
        while (true) {
            System.out.println("Enter Corresponding Number to Select the option :");
            System.out.println("1. Bus Routes\n2. Bus fees\n3. Bus registration\n4. Update Info\n5. fee " +
                    "Payment\n6. Bus Profile\n7. Delete Bus registration\n8. Previous Menu\n9. Exit TMS\n");
            String selection = input.next();



            if (selection.equals("9")) {
                System.out.println("Thank you for using Transport Management System !");
                System.exit(0);
            }
            else if (selection.equals("8")) {
                TransportManagement.manage(regNumber);
            }
            else if (selection.equals("1")||selection.equals("2")||selection.equals("3")||selection.equals("4")||selection.equals("5")||selection.equals("6")||selection.equals("7")){
                switch (selection) {
                    case "1" ->{
                        displayRoutesAndStops(registrationNo);
                        try {
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    case "2" ->{
                        displayBusFees(registrationNo);
                        try {
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    case "3" ->{

                        if(busFileFound(registrationNo)){
                            System.out.println("Your Account Already exists in our database !");
                            isRegistered = true;

                        }

                        else if (!busFileFound(registrationNo)){
                            busReg = busRegistration(registrationNo);
                            //        text file generation with the busID number
                            File busFile = new File("transport/TransportFiles/"+registrationNo+".txt");
                            try {
                                busFile.createNewFile();
                                isRegistered = true;
                            }
                            catch (IOException e) {
                                System.out.println("Sorry we found some issues creating your file !");
                            }
//      writing details in text file
                            try {
                                FileWriter busFileWriter = new FileWriter("transport/TransportFiles/"+registrationNo+".txt");
                                busFileWriter.write(busReg);
                                System.out.print("\n******************* Registered Successfully! ****************\n\n");
                                busFileWriter.close();
                            }
                            catch (IOException e) {
                                System.out.println("Sorry we found some issues inserting your details in the our database ");
                            }
                        }


                    }
                    case "4" ->{
//                        update your registered data!
                        if(isRegistered){
                            busReg = busRegistration(registrationNo);
                            feePaid = false;
                            try {
                                FileWriter busFileWriter = new FileWriter("transport/TransportFiles/"+registrationNo+".txt");

                                busFileWriter.write(busReg);
                                System.out.print("\n******************* Data Updated Successfully! " +
                                        "****************\n\n");
                                busFileWriter.close();
                            }
                            catch (IOException e) {
                                System.out.println("Sorry we found some issues inserting your details in the our database ");
                            }

                        }
                        else{
                            System.out.println("Kindly Register first !");
                        }
                    }
                    case "5" ->{
                        if(!feePaid){
                            paymentMethod(registrationNo,isRegistered);
                            feePaid = true;
                        }
                        else if(feePaid) System.out.println("You have already paid the fee !");
                       
                    }
//                    case "6" -> {
//                        if (!feedback && isRegistered) {
//
//                            String busReview = busReviewMessage(registrationNo);
//                            feedback = true;
////                         adding this review to the file
//                            try {
//                                FileWriter busFileWriter = new FileWriter("E:\\transport\\TransportFiles\\" + registrationNo + ".txt",
//                                        true);
//                                String busReviewFinal = String.format("\n\nYour FeedBack --->\n %s", busReview);
//                                busFileWriter.write(busReviewFinal);
//                                busFileWriter.close();
//                            } catch (IOException e) {
//                                System.out.println("Sorry we found some issues inserting your details in the our database ");
//                            }
//
//                        } else if (!isRegistered) System.out.println("You cannot give feedback without registering to TMS ");
//                        else if (busFileFound(registrationNo)) System.out.println("You have already given the " +
//                                "feedback !");
//
//
//                    }



                    case "6" ->{
//                        bus profile --
                        File busFilex = new File("transport/TransportFiles/"+registrationNo+".txt");

                        if (!busFilex.exists()) System.out.println("Your Profile doesn't exist!");

                        else if(feePaid && busFilex.exists()){
                            try {
                                File busFile = new File("transport/TransportFiles/"+registrationNo+".txt");
                                Scanner sc = new Scanner(busFile);

                                while (sc.hasNextLine()) {
                                    String profile = sc.nextLine();
                                    System.out.println(profile);
                                }
                                sc.close();
                            }


                            catch(IOException e){
                                System.out.println("We found some issues in reading your data! try again!");
                            }
                        }
                        else if (!isRegistered) System.out.println("Your profile doesn't exist! Register first!");
                        else System.out.println("Kindly pay the fee to proceed to your Profile !");

                    }
                    case "7" ->{
                        File busFile = new File("transport/TransportFiles/"+registrationNo+".txt");
                        if (busFile.delete()) {
                            System.out.println("The bus profile has been deleted successfully!");
                            isRegistered = false;
                            feePaid = false;
                        }
                        else if (!busFile.exists()) System.out.println("No record found! you haven't registered yet!");
                        else System.out.println("Something went wrong");

                    }

                }
            } else System.out.println("invalid input!");

        }


    }


    //  Methods for TMS

    //   displaying routes, stops and fees
    static void displayBusFees(String registrationNo){
        System.out.println("**************** Buses Fees ***********");
        System.out.println("Route 1 : 20,000\nRoute 2 : 15,000\nRoute 3 : 14,000\nRoute 4 : 13,000\nRoute 5 : 10,000\nRoute 6 : 22,000\nRoute 7 : 24,000\nRoute 8 : 21,000\n\n");


    }
    static void displayRoutesAndStops(String registrationNo){
        System.out.println("--------------------------------Route # 1-----------------------------------------------");
        System.out.println("Stops -->\n F-11 Markaz\nGolra more\nMargala road\nPAF Complex Gate\nShaheen " +
                "Chowk\nMadina" +
                " Market");
        System.out.println("--------------------------------Route # 2-----------------------------------------------");
        System.out.println("Stops -->\nG-11/2 Apple School\n G-11 Markaz \n G-11/3 Alladin Appartment\n G-10 Umer " +
                "market\n G-9/1 Street no 44");
        System.out.println("--------------------------------Route # 3-----------------------------------------------");
        System.out.println("Stops --> \nAskari XI\n Qasim Market \n Roomi Market \n GPO Saddar\n Kacheri Chowk");
        System.out.println("--------------------------------Route # 4-----------------------------------------------");
        System.out.println("Stops -->\n Hajj Complex \n Old Daewoo Stop \n Pirdhadhai More \n Charing Cross \n Valley" +
                " Road");
        System.out.println("--------------------------------Route # 5-----------------------------------------------");
        System.out.println("Stops -->\nChungi no 22 \n CMH \n 502 workshop \n Jinnah Park \n Jhandha Chechi");
        System.out.println("--------------------------------Route # 6-----------------------------------------------");
        System.out.println("Stops -->\nBahria Town Ace Academy\n Street no 6 Bahria More\n Al Noor Pharmacy \nRahat " +
                "Bakery\n PWD Barrier \n London Tradex");
        System.out.println("--------------------------------Route # 7-----------------------------------------------");
        System.out.println("Stops -->\nGangal East\n karal Chowk\nGangal West\nFizaya Colony\n Chatry Chowk\n Khanna " +
                "Pull");
        System.out.println("--------------------------------Route # 8-----------------------------------------------");
        System.out.println("Stops -->\nNawal Anchorage\n Bhander \n Sowan Garden\n Al Shifa Hospital\n Toyota " +
                "Motors\n\n");


    }

    //    bus registration
    static String busID(String registrationNo){
        //        busID generation
        Random randCardNum = new Random();
        int number =(int) 1000 + randCardNum.nextInt(1000);
        String busID = "" + number;
        return busID;
    }
    static String registrationTiming(String registrationNo){
        //        Registration date and timing
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy || h:m a"));

    }
    //    bus route validation
    static String busRoute(String registrationNo){
        Scanner input = new Scanner(System.in);
        String route;
        while(true){

            System.out.println("Enter your route :");
            route = input.next();
            if (route.equals("1") || route.equals("2")|| route.equals("3") || route.equals("4") || route.equals(
                    "5") || route.equals("6") || route.equals("7") || route.equals("8")){
                return route;
            }
            else System.out.println("Enter valid route no!");
        }

    }
    static boolean find(String routeName, String [] arr){
        for (int i = 0; i < arr.length;i++){
            if (routeName.equalsIgnoreCase(arr[i])){
                return true;
            }
        }
        return false;
    }
    static String [] routesNameStr(String registrationNo, String route){
        String [] route_1 = {"F-11 Markaz","Margala road","Golra More","PAF Complex Gate","Shaheen Chowk","Madina Market"};
        String [] route_2 = {"G-11/2 Apple School","G-11 Markaz","G-11/3 Alladin Market","G-10 Umer Market","G-9/1 Street no 44"};
        String [] route_3 = {"Askari XI","Qasim Market","Roomi Market","GPO Saddar","Kacheri Chowk"};
        String [] route_4 = {"Hajj Complex","Old Daewoo Stop","Pirdhadhai More","Charing Cross","Valley Road"};
        String [] route_5 = {"Chungi no 22","CMH","502 workshop","Jinnah Park","Jhandha Chechi"};
        String [] route_6 = {"Bahria Town Ace Academy","Street no 6 Bahria More","Al Noor Pharmacy","Rahat Bakery",
                "PWD Barrier","London Tradex"};
        String [] route_7 = {"Gangal East","karal Chowk","Gangal West","Fizaya Colony","Chatry Chowk","Khanna Pull"};
        String [] route_8 = {"Nawal Anchorage","Bhander","Sowan Garden","Al Shifa Hospital","Toyota Motors"};

        switch (route){
            case "1" -> {
                return route_1;
            }
            case "2" -> {
                return route_2;
            }
            case "3" -> {
                return route_3;
            }
            case "4" -> {
                return route_4;
            }
            case "5" -> {
                return route_5;
            }
            case "6" -> {
                return route_6;
            }
            case "7" -> {
                return route_7;
            }
            case "8" -> {
                return route_8;
            }
        }
        return new String[]{};
    }
    static String busStop(String registrationNo, String route){
        Scanner input = new Scanner(System.in);
        String routeName;
        while(true) {
            System.out.println("Enter the stop name :");
            routeName = input.nextLine();
            if (find(routeName,routesNameStr(registrationNo,route))){
                break;
            }
            else System.out.println("Invalid route Name!");

        }
        return routeName;
    }

    //        bus fee
    static String busFee(String registrationNo ,String route){
        String fees = "";
        switch (route) {
            case "1" -> fees = "20000";
            case "2" -> fees = "15000";
            case "3" -> fees = "14000";
            case "4" -> fees = "13000";
            case "5" -> fees = "10000";
            case "6" -> fees = "22000";
            case "7" -> fees = "24000";
            case "8" -> fees = "21000";
        }
        return fees;
    }

    //    bus timing selection

    static String busDropOff(String registrationNo){
        while(true){
            Scanner input = new Scanner(System.in);
            //            selecting the drop-off timing

            System.out.println("Enter your preferred timing for drop-off\n1. 1:30 PM\n2. 2:30 PM\n3. 5:30 PM");
            String selectionDropOff = input.next();
            String dropOffTime = "";
            if (selectionDropOff.equals("1") || selectionDropOff.equals("2") || selectionDropOff.equals("3")){
                switch (selectionDropOff){
                    case "1" -> dropOffTime = "1:30 PM";
                    case "2" -> dropOffTime = "2:30 PM";
                    case "3" -> dropOffTime = "5:30 PM";
                }
                return dropOffTime;

            }
            else System.out.println("kindly Enter valid input!");

        }

    }
    static String busPickUp(String registrationNo){
        Scanner input = new Scanner(System.in);
        while (true){
//            selecting the pick-up timing
            System.out.println("Enter your preferred timing for pick-up\n1.  8 AM\n2. 10 AM\n3. 12 AM");
            String selectionPickUp = input.next();
            String pickUpTime = "";
            if (selectionPickUp.equals("1") || selectionPickUp.equals("2") || selectionPickUp.equals("3")){
                switch (selectionPickUp){
                    case "1" -> pickUpTime = "8 AM";
                    case "2" -> pickUpTime = "10 AM";
                    case "3" -> pickUpTime = "12 AM";
                }
                return pickUpTime;

            }
            else System.out.println("kindly Enter valid input!");
        }
    }

    //    bus Review
    static String busReviewMessage(String registrationNo){

        Scanner input = new Scanner(System.in);
        System.out.println("Enter your Review for Transport Management ");
        String review = input.nextLine();
        System.out.println("Thank you for your feedback about Our Bus Management System !");
        return review;

    }
    static void busReview(String registrationNo , boolean isRegistered){

    }
//bus registration main

    static String busRegistration(String registrationNo){
        Scanner input = new Scanner(System.in);
        String busID = busID(registrationNo);
        String dateAndTime = registrationTiming(registrationNo);
        String route = busRoute(registrationNo);
        String busStop = busStop(registrationNo,route);

        String busFee = busFee(registrationNo,route);
        String pickUp = busPickUp(registrationNo);
        String dropOff = busDropOff(registrationNo);


//        All details
        String details_x = String.format("""
                Registration No                  : %s
                Bus ID                           : %s
                Route                            : %s
                Stop Name                        : %s
                Fee                              : %s
                PickUp Timing                    : %s
                DropOff Timing                   : %s
                Registered at                    : %s
                 
                """,registrationNo,busID,route,busStop,busFee,pickUp,dropOff,dateAndTime);

        return details_x;

    }

    //  payment Method

    static void paymentMethod(String registrationNo , boolean isRegistered) {

        if (isRegistered) {
            Desktop desk = Desktop.getDesktop();
            Scanner input = new Scanner(System.in);


            while (true) {
                System.out.println("Select your payment method :\n1. JazzCash\n2. HBL\n3. Bank Alfalah");
                try {
                    int option = input.nextInt();
                    if (option >= 1 && option <= 3) {
                        switch (option) {

                            case 1 -> {
                                try {
                                    desk.browse(new URI("https://www.jazzcash.com.pk"));
                                    System.out.println("Thank you for using JazzCash for paying fee");

                                } catch (IOException | URISyntaxException e) {
                                    System.out.println("Sorry we found an issue try again!");
                                }
                            }
                            case 2 -> {
                                try {
                                    desk.browse(new URI("https://www.hblibank.com.pk"));
                                    System.out.println("Thank you for using HBL for paying fee");


                                } catch (IOException | URISyntaxException e) {
                                    System.out.println("Sorry we found an issue try again!");

                                }
                            }
                            case 3 -> {
                                try {
                                    desk.browse(new URI("https://netbanking.bankalfalah.com/"));
                                    System.out.println("Thank you for using Bank Alfalah for paying fee");

                                } catch (IOException | URISyntaxException e) {
                                    System.out.println("Sorry we found an issue try again!");

                                }
                            }


                        }

                        break;
                    } else System.out.println("Enter appropriate option !");
                } catch (Exception e) {
                    System.out.println("Invalid input !");
                    input.nextLine(); //to clear the  buffer
                }

            }


        } else System.out.println("you have to register first to proceed Payment!");

    }

//    if bus file found!
    static boolean busFileFound(String registrationNo){
        File busFile = new File("transport/TransportFiles/"+registrationNo+".txt");
        if (busFile.exists()) return true;
        else return false;
    }


}