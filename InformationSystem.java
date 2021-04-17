import java.util.ArrayList;

public class InformationSystem {
   
   protected String userType;
   protected String username;
   protected String password;
   private InformationSystem[] userDatabase;
   private int count;
   
   public InformationSystem(String userTypeIn, String usernameIn, String passwordIn) {
      userType = userTypeIn;
      username = usernameIn;
      password = passwordIn;
      userDatabase = new InformationSystem[20];
      count = 0;
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
   
   public void setLibraryId() {
   
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
   
   public boolean register(String userTypeIn, String usernameIn, String passwordIn) {
      
      if (this.search(usernameIn) == false) {
         InformationSystem temp = new InformationSystem(userTypeIn, usernameIn, passwordIn);
         
         userDatabase[count] = temp;
         count++;
         return true;
      }
      else {
         return false;
      }
   }
   

}
