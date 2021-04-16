import java.util.ArrayList;

public class LibraryISApp {


   public static void main(String args[]) {
   
      ArrayList<String> database = new ArrayList<String>(5);
      
      // if registered, Bob will be in the database
      InformationSystem Bob = new InformationSystem("Customer", "bob123", "12345678");
      
      // check if Bob is in the library database
      if (!database.contains(Bob)) {
         System.out.println("You are not in the system. Please make an account.");
      }
      
      while (!database.contains(Bob)) {
         
      }
      // if not, register
      
      // user will input username and password, will be given a 4 digit Library ID
      // system will notify user of ID assignment and whenever they are ready to check out
      
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
