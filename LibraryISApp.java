import java.util.ArrayList;
import java.util.Scanner;

public class LibraryISApp {


   public static void main(String args[]) {
   
      LibraryDatabase db = new LibraryDatabase("book", "0721");
      String code = "";
   
      Scanner userInput = new Scanner(System.in);
      boolean registered = false;
      
      System.out.println("Hello! Welcome to the Group 7 Library System.\n");
      System.out.println("Are you a customer or an employee?");
      
      String userType = userInput.nextLine();
      
      System.out.println("Great! Here's the library menu: \n"
         + "L - log in\n"
         + "R - register\n"
         + "Q - quit");
         
      
      do {
         if (registered) {
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
            case 'L':
             System.out.println("Enter your username and password to get started.");
      
             System.out.print("Username: ");
             String username = userInput.nextLine();
             System.out.print("Password: ");
             String password = userInput.nextLine();
             
             InformationSystem temp = new InformationSystem(userType, username, password);
             
             boolean loginStatus = temp.login(username, password);
             
             if (loginStatus == true) {
               registered = true;
             }
               break;
      
             case 'R':
                System.out.print("Enter your user type: ");
                userType = userInput.nextLine();
                System.out.print("Enter your username: ");
                username = userInput.nextLine();
                System.out.print("Enter your password: ");
                password = userInput.nextLine();
                
                temp = new InformationSystem(userType, username, password);
                temp.initInfoSystem();

                if (temp.register() == true) {
                   int id = temp.setLibraryId(username);
                   System.out.println("\nYour ID is: " + id);
                   System.out.println("\nYou are ready to start checking out.");
                   registered = true;
                }
                  break;
               
            default:
               System.out.println("****Invalid code****\n");
               break;  
         }
      } while (!code.equalsIgnoreCase("Q") && registered == false);
      // user will search for an item -- syatem will notify them whether or not it is available
      
      // system will notify whenever an item is added to the cart
      // system will also keep track of all transactions to make a report later. 
      
      // user will proceed to check out -- all necessary conditions will be checked first
      
      // system will notify of anything that needs to be done before checking out
      
      // once checked out, the item will be taken off the database until it is returned
      // system will once again notify the user whenever checkout is successful
      
      // user will log out
      
      // cue library employee to log in and print a report
     
      
    }
}
