public class InformationSystem {
   
   protected String userType;
   protected String username;
   protected String password;
   
   public InformationSystem(String userTypeIn, String usernameIn, String passwordIn) {
      userType = userTypeIn;
      username = usernameIn;
      password = passwordIn;
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
   
   public void login(String usernameIn, String passwordIn) {
   
   }
   
   public void logout(String usernameIn, String passwordIn) {
   
   }
   
   public void search() {
   
   }
   
   public void register() {
   
   }
}
