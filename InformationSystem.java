import java.util.ArrayList;

public class InformationSystem {
   
   protected String userType;
   protected String username;
   protected String password;
   private InformationSystem[] userDatabase;
   
   public InformationSystem(String userTypeIn, String usernameIn, String passwordIn) {
      userType = userTypeIn;
      username = usernameIn;
      password = passwordIn;
      userDatabase = new InformationSystem[20];
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
   
   public boolean login(String usernameIn, String passwordIn) {
    return false;
   }
   
   public void logout(String usernameIn, String passwordIn) {
   
   }
   
   public void search() {
   
   }
   
   public void register(String userNameIn) {
   
   }
}
