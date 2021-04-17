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
   
   public void search() {
   
   }
   
   public boolean register(String userNameIn, String passwordIn) {
      //if username is not in info system, return warning
      
      
      return false;
   }
   
//    public void addUser(userNameIn) {
//       userDatabase[count] = userNameIn;
//       count++;
//    }
}
