import java.util.ArrayList;
import java.util.Scanner;

public class LibraryISApp {

   public static void main(String args[]) {
   
      InventoryItem inven = new InventoryItem("sample", "0000", null, null, 0, 0, 0);
      Account acc = new Account(null, null, null, 0);
      Customer user = new Customer(null, null, null, 0, null, null, 0, null, null);
      InventoryItem[] cart = new InventoryItem[10];
      Transaction tran = new Transaction(0.0);
      int cartCount = 0;
      double totalPrice = 0;
      
      String code = "";
   
      Scanner userInput = new Scanner(System.in);
      boolean registered = false;
      boolean found = false;
      
      System.out.println("Hello! Welcome to the Group 7 Library System.\n");
      System.out.println("Are you a customer or an employee?");
      
      String userType = userInput.nextLine();
      
      System.out.println("\nGreat! Here's the library menu: \n"
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
               
            default:
               System.out.println("****Invalid code****\n");
               break;  
         }
      } while (!code.equalsIgnoreCase("Q") && registered == false);
      
      
      
      System.out.println("Here is a list of all available items:\n\n");
      
      InventoryItem[] inventory = inven.initDatabase();
      System.out.println(inven.printInventory(inventory));
      
      System.out.println("What would you like to do?\n"
            + "A - add item\n"
            + "D - delete item\n"
            + "C - check out\n");

      
      do {
        System.out.println("\nHere is your current cart: \n");
        System.out.println(inven.printInventory(inven.cart));
        System.out.println("Your current balance is $" + tran.balance 
                  + " and the price of your current transaction is $" + inven.calculateTotalPrice(inven.cart) + ".\n");
     
        System.out.print("Enter Code [A, D, C]: ");
        code = userInput.nextLine();
        if (code.length() == 0) {
           continue;
        } 
        code = code.toUpperCase();
        char codeChar = code.charAt(0);

        switch (codeChar) {
         case 'A':
            
            System.out.print("Select an item to check out: ");
            String search = userInput.nextLine();
             
            while (inven.found == false) {
               inven.add(search);
            }   
            break;
            
         case 'C':
               
               System.out.print("You are proceeding to checkout. Very well...\n");
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
          default:
            System.out.println("****Ivalid code****");
        }
      } while (!code.equalsIgnoreCase("Q") && tran.success == false); 
      
       // system will notify whenever an item is added to the cart
//        if(cart.contains(search)) {
//            System.out.print("This item is added to the cart");
//        }
//        else {
//            System.out.print("This item is not added to the cart");
//        }
      // system will also keep track of all transactions to make a report later. 
      
      // user will proceed to check out -- all necessary conditions will be checked first

           System.out.print("\nPlease check out the necessary information\n");
           System.out.print("The number of item is " + cart.length + "\n");
           int i = 0;
           int overall = 0;
           while(i <= cart.length) {
               if (cart[i] == null) {
                  break;
               }
               System.out.print("The " + i + " th item is " + cart[i]);

               System.out.print("The available date of this item is " + cart[i].avaDate);
               System.out.print("The price is " + cart[i].price);
               overall += cart[i].price;
               // once checked out, the item will be taken off the database until it is returned
//                cart[i].state = 0; // the item have two state, one is active,which can be checkout, the other state is inactive ,which cannot be chekout
               i++;
           }
           System.out.println("The overall price is " + overall);
       // system will notify of anything that needs to be done before customers checking out
//        boolean ch = true;
//        do {
//            System.out.println("Please check the account information");
//            System.out.println("The User's address is " + user.address
//                    +"\nThe User's phone number is " + user.phoneNum
//                    + "\nThe User's email is " + user.email
//                    + "\n Is this true or false");
//            if(ch == false) {
//                System.out.println("The updated address is " );
//                String add = userInput.nextLine();
//                user.address = add;
//                System.out.println("The updated phone number is " );
//                int phoneN = userInput.nextInt();
//                user.phoneNum = phoneN;
//                System.out.println("The updated email is ");
//                String ema = userInput.nextLine();
//                user.email = ema;
//            }
// 
//        } while(ch == true);

      // system will once again notify the user whenever checkout is successful
      System.out.println("The checkout is successful");
      // user will log out
       System.out.println("Retun to the menu or log out from system: \n"
               + "L - log out\n"
               + "R - return to the menu\n");
       do {
         code = userInput.nextLine();
         if (code.length() == 0) {
             continue;
         }
         code = code.toUpperCase();
         char codeChar = code.charAt(0);
         switch (codeChar) {
             case 'L':
                 System.out.print("Log out the account");
                 break;
             case 'R':
                  System.out.print("Return to the menu");
                  break;
             default:
         }
      } while (!code.equalsIgnoreCase("Q"));
      // cue library employee to log in and print a report
     
     System.out.println("Employee's turn...");
      
    }
}
