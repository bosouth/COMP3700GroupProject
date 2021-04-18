import java.util.ArrayList;
import java.util.Scanner;

public class LibraryISApp {


   public static void main(String args[]) {
   
      Scanner userInput = new Scanner(System.in);
      boolean registered = false;
      
      System.out.println("Hello! Welcome to the Group 7 Library System.\n");
      System.out.println("Are you a customer or an employee?");
      
      String userType = userInput.nextLine();
      
      // enter user info
      System.out.println("Great! Now enter your username and password to get started.");
      
      System.out.print("Username: ");
      String username = userInput.nextLine();
      System.out.print("Password: ");
      String password = userInput.nextLine();
      
      InformationSystem cust = new InformationSystem(userType, username, password);
      
      //check if user is in the library database
      if (!cust.login(username, password)) {
         System.out.println("\nUser is not in the system. Please register an account.\n");
         //if not, register
         // user will input username and password, will be given a 4 digit Library ID
         // system will notify user of ID assignment and whenever they are ready to check out
         if (cust.register() == true) {
            int id = cust.setLibraryId(username);
            System.out.println("\nYour ID is: " + id);
            System.out.println("\nYou are ready to start checking out.");
         }
      }
      
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
