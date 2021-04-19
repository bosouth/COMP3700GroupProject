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
      this.initInfoSystem();
   
      if (this.search(usernameIn)) {
         if (this.getPassword() != passwordIn) {
            System.out.println("Wrong password. Try aagin.");
            return false;
         }
         else {
            return true;
         }
      }
      else {
         System.out.println("Username doesn't exist in the system. Please register an account.\n");
         return false;
      }
   }
   
   public void logout(String usernameIn, String passwordIn) {
   
   }
   
   /** searches the database for input username
   * returns false if username doesn't exist
   * returns true if username exists */
   public boolean search(String usernameIn) {
   
      if (this.getUsername() == usernameIn) {
         return true;
      }
   
      return false;
   }
   
   public boolean register() {
      this.initInfoSystem();
      
      if (this.search(username) == false) {
         InformationSystem temp = new InformationSystem(userType, username, password);
         
         System.out.println("Success! You have successfully been registered.");
         
         userDatabase[count] = temp;
         count++;
         
         return true;
      }
      else {
         System.out.println("Username already exists in the database. Please try a different one.\n");
         return false;
      }
   }
   
   public void initInfoSystem() {
      InformationSystem molly = new InformationSystem("Customer", "molly", "molly375");
      userDatabase[count] = molly;
      count++;
      InformationSystem jacob = new InformationSystem("Customer", "jacob", "jacob112233");
      userDatabase[count] = jacob;
      count++;
      InformationSystem billy = new InformationSystem("Customer", "billy", "billy28375");
      userDatabase[count] = billy;
      count++;
   }
   

}
