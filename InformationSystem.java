import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class InformationSystem {
   
   protected String userType;
   protected String username;
   protected String password;
   private InformationSystem[] userDatabase;
   private int count;
   private boolean registered;
   private int id;
   
   public InformationSystem(String userTypeIn, String usernameIn, String passwordIn) {
      userType = userTypeIn;
      username = usernameIn;
      password = passwordIn;
      userDatabase = new InformationSystem[20];
      count = 0;
      registered = false;
      id = 0;
   }
   
   public String getUserType() {
      return userType;
   }
   
   public String getUsername() {
      return username;
   }
   
   public String getPassword() {
      return password;
   }
   
   public int setLibraryId(String usernameIn) {
      Random rand = new Random();
      
      id = rand.nextInt(9999);
      return id;
   }
   
   public boolean login(String usernameIn, String passwordIn) {
    return false;
   }
   
   public void logout(String usernameIn, String passwordIn) {
   
   }
   
   public boolean search(String usernameIn) {
   
      for (int i = 0; i < userDatabase.length; i++) {
         if (userDatabase[i] == null) {
            return false;
         }
         else if (userDatabase[i].username == usernameIn) {
            return true;
         }
      }
      return false;
   }
   
   public boolean register() {
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter your user type: ");
      String userType = scan.nextLine();
      System.out.print("Enter your username: ");
      String username = scan.nextLine();
      System.out.print("Enter your password: ");
      String password = scan.nextLine();
      
      if (this.search(username) == false) {
         InformationSystem temp = new InformationSystem(userType, username, password);
         
         System.out.println("Success! You have successfully been registered.");
         
         userDatabase[count] = temp;
         count++;
         
         return true;
      }
      else {
         System.out.println("Username already exists in the database. Please try a different one.");
         return false;
      }
   }
   

}
