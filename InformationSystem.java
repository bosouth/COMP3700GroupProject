import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class InformationSystem {
   
   protected String userType;
   protected String username;
   protected String password;
   public InformationSystem[] userDatabase;
   public int infoCount;
   private boolean registered;
   public boolean loginStatus;
   
   private int id;
   
   // comstructor of InformationSystem
   public InformationSystem(String userTypeIn, String usernameIn, String passwordIn) {
      userType = userTypeIn;
      username = usernameIn;
      password = passwordIn;
      userDatabase = new Account[20];
      infoCount = 0;
      registered = false;
      loginStatus = false;
      id = 0;
   }
   
   // returns user type of the user
   public String getUserType() {
      return userType;
   }
   
   // returns username of the user
   public String getUsername() {
      return username;
   }
   
   // returns password of the user 
   public String getPassword() {
      return password;
   }
   
   // randomly generates a library id
   public int setLibraryId(String usernameIn) {
      Random rand = new Random();
      
      id = rand.nextInt(9999);
      return id;
   }
   
   // checks to make sure that the username exists in the databse the password matches
   public boolean login(String usernameIn, String passwordIn, InformationSystem[] userIn) {
      
      for (InformationSystem user : userIn) {
         if (user == null) {
            return false;
         }
         if (usernameIn.equals(user.username)) {
            if (!user.getPassword().equals(passwordIn)) {
               System.out.println("Wrong password. Try again.\n");
               return false;
            }
            else {
               loginStatus = true;
               return true;
            }
         }
         else {
            System.out.println("Username doesn't exist in the system. Please register an account.\n");
            return false;
         }
      }
      
      return false;
   }
   
   /** searches the database for input username
   * returns false if username doesn't exist
   * returns true if username exists */
   public boolean search(String usernameIn) {
   
      for (int i = 0; i < userDatabase.length; i++) {
         if (userDatabase[i] == null) {
            return false;
         }
         if (userDatabase[i].username == usernameIn) {
            return true;
         }
      }
      return false;
   }
   
   // makes sure that the usernameIn doesn't exist 
   public boolean register(String usernameIn) {
      
      if (this.search(usernameIn) == false) {
         System.out.println("Success! You have successfully been registered.\n");
         return true;
      }
      else {
         System.out.println("Username already exists in the database. Please try a different one.\n");
         return false;
      }
   } 
}
