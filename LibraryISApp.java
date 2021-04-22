import java.util.ArrayList;
import java.util.Scanner;

/** COMP 3700-002
* Group 7 Project
*
*
* This class is the driver class that will perform all necessary computations
* and calculations for the Library Information System . */
public class LibraryISApp {
   
   /** main method of the LibraryISApp */
   public static void main(String args[]) {
   
      /////////////////////////////////
      ////  OBJECT INITIALIZATIONS ////
      /////////////////////////////////
      
      InformationSystem info = new InformationSystem(null, null, null);
      InventoryItem inven = new InventoryItem("sample", "0000", null, null, 0, 0, 0);
      Account acc = new Account(null, null, null, 0);
      Customer user = new Customer(null, null, null, 0, null, null, 0, null, null);
      Employee emp = new Employee(null, null, null, 0, null, null, 0, null);
      InventoryItem[] cart = new InventoryItem[10];
      Transaction tran = new Transaction(0.0);
      InformationSystem[] userDatabase = acc.initInfoSystem();

      
      //// variables ////
      
      int cartCount = 0;
      double totalPrice = 0;
      String code = "";
      Scanner userInput = new Scanner(System.in);
      boolean registered = false;
      boolean found = false;
      
      /* Start */
      
      System.out.println("Hello! Welcome to the Group 7 Library System.\n");
      System.out.println("Library menu: \n"
         + "L - log in\n"
         + "R - register\n"
         + "Q - quit\n");
       
      /* cue login/register sequence */
      do {
         if (registered || info.loginStatus) {
            break;
         }
         System.out.print("Enter Code [L, R, Q]: ");
         code = userInput.nextLine();
         if (code.length() == 0) {
            continue;
         } 
         code = code.toUpperCase();
         char codeChar = code.charAt(0);
      
         switch (codeChar) {
            // case to log in
            case 'L':
            
             System.out.print("Are you a customer or an employee? ");
             String userType = userInput.nextLine();
             
             // will break if not either customer or employee
             if ((!userType.equalsIgnoreCase("employee")) && (!userType.equalsIgnoreCase("customer"))) {
               System.out.println("Must be either \"customer\" or \"employee\".");
               break;
             }
             System.out.println("\nEnter your username and password to get started.");
             System.out.print("Username: ");
             String username = userInput.nextLine();
             System.out.print("Password: ");
             String password = userInput.nextLine();
             
             info.login(username, password, userDatabase);
             
             // will set relevant data if login is successful
             if (info.loginStatus == true) {
               user.userType = userType;
               user.username = username;
               user.password = password;
               acc.userType = userType;
               acc.username = username;
               acc.password = password;
               user.setCreditCard();
               tran.setBalance();
               break;
             }
               break;
               
             // case to register
             case 'R':
                System.out.print("Enter your user type: ");
                userType = userInput.nextLine();
                
                // will break if not either customer or employee
                if (!userType.equalsIgnoreCase("employee") && (!userType.equalsIgnoreCase("customer"))) {
                  System.out.println("Must be either \"customer\" or \"employee\".");
                  break;
                }
                System.out.print("Enter your username: ");
                username = userInput.nextLine();
                System.out.print("Enter your password: ");
                password = userInput.nextLine();
                
                // will set relevant data if registration is successful
                if (info.register(username) == true) {
                   int id = info.setLibraryId(username);
                   user.userType = userType;
                   user.username = username;
                   user.password = password;
                   user.setAddress();
                   user.setPhoneNum();
                   user.setEmail();
                   user.setCreditCard();
                   tran.setBalance();
                   System.out.println("\nYour ID is: " + id);
                   System.out.println("\nYou are ready to start checking out.\n");
                   acc.userType = userType;
                   acc.username = username;
                   acc.password = password;
                   acc.id = id;
                   registered = true;
                }
                  break;
            
            // exit out of the program entirely   
            case 'Q':
               System.out.println("Terminating session...");
               System.exit(0);
            
            default:
               System.out.println("****Invalid code****\n");
               break;  
         }
      } while (!code.equalsIgnoreCase("Q") && registered == false && acc.loginStatus == false);
      
      // cue checkout sequence
      System.out.println("Here is a list of all available items:\n\n");
      
      // print inventory
      InventoryItem[] inventory = inven.initDatabase();
      System.out.println(inven.printInventory(inventory));
      
      System.out.println("What would you like to do?\n"
            + "A - add item\n"
            + "D - delete item\n"
            + "C - check out\n"
            + "Q - terminate session\n");

      
      do {
        inven.found = false;
        System.out.println("Here is your current cart: \n");
        System.out.println(inven.printInventory(inven.cart));
        System.out.println("Your current balance is $" + tran.balance 
                  + " and the price of your current transaction is $" + inven.calculateTotalPrice(inven.cart) + ".\n");
     
        System.out.print("Enter Code [A, D, C, or Q]: ");
        code = userInput.nextLine();
        if (code.length() == 0) {
           continue;
        } 
        code = code.toUpperCase();
        char codeChar = code.charAt(0);

        switch (codeChar) {
        
         // case to add item to cart
         case 'A':
            
            System.out.print("Select an item to check out: ");
            String search = userInput.nextLine();
            
            // will break if item not found 
            while (inven.found == false) {
               inven.add(search);
            }   
            break;
          
         // case to delete item from cart  
         case 'D':
               System.out.print("Select an item to delete: ");
               search = userInput.nextLine();
               
               inven.remove(search, inven.cart);
               break;
          
         // case to check out     
         case 'C':
               
               System.out.println("You are proceeding to checkout. Very well...\n");
               System.out.print("Your current cart is: \n");
               System.out.println(inven.printInventory(inven.cart));
               totalPrice = inven.calculateTotalPrice(inven.cart);
               if (totalPrice == 0) {
                  System.out.println("Hmmm, seems like there is nothing in your cart...");
                  System.out.println("Returning to menu...");
                  break;
               }
               tran.checkOut(totalPrice);
               break;
          
          // case to exit system entirely     
          case 'Q': 
            System.out.println("Terminating session...");
            System.exit(0);
          
          default:
            System.out.println("****Ivalid code****");
        }
      } while (!code.equalsIgnoreCase("Q") && tran.success == false); 

      // system will once again notify the user whenever checkout is successful
      System.out.println("\nThe checkout is successful.");
      
      // user will log out
       System.out.println("Press Q to terminate session...");
       do {
         code = userInput.nextLine();
         if (code.length() == 0) {
             continue;
         }
         code = code.toUpperCase();
         char codeChar = code.charAt(0);
         switch (codeChar) {
             
             default:
               System.out.println("Terminating customer session...\n");
               break;
         }
      } while (!code.equalsIgnoreCase("Q"));
      
      // cue library employee to log in and print a report
     
     System.out.println("Employee: Please log in...");
     
     // initialize employee variables
     Employee[] empDatabase = emp.initEmpDatabase();
     String empUsername;
     String empPassword;
     String empType;
     int empId;
     
     // sequence to log in to employee account
     while (emp.success == false) {
      System.out.println("Enter your user type: ");
      empType = userInput.nextLine();
      System.out.print("Enter your username: ");
      empUsername = userInput.nextLine();
      System.out.print("Enter your password: ");
      empPassword = userInput.nextLine();
      System.out.print("Enter your library ID: ");
      empId = userInput.nextInt();
      emp.login(empType, empUsername, empPassword, empId, empDatabase);
      userInput.nextLine();
     }
     
     //Employee prints a report of employee transaction
     // Including what he checked out and when it is due
     // Also will include late fees if applicable
      
     System.out.println("What would you like tdo do? \n"
      + "P - print report\n"
      + "Q - quit\n");
    
    
       do {
           System.out.print("Enter Code [P or Q]: ");
           code = userInput.nextLine();
           if (code.length() == 0) {
              continue;
           } 
           code = code.toUpperCase();
        char codeChar = code.charAt(0);
           
           switch (codeChar) {
            
            // case to print report
            case 'P':
               String report;
               report = emp.printReport(acc, tran, inven.cart);
               System.out.print(report);
               System.out.println("\nReport successfully printed. Enter Q to end session.");
               break;
             
            // case to exit session  
            case 'Q':
               System.out.println("Terminating employee session...");
               System.exit(0);
                
            default:
               System.out.println("****Invalid code****");
               break;
           }
       } while (!code.equalsIgnoreCase("Q"));
    }
}
