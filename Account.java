public class Account extends InformationSystem {

   public int id;
    
   public Account(String userTypeIn, String usernameIn, String passwordIn, int idIn) {
      super(userTypeIn, usernameIn, passwordIn);
      id = idIn;
   }
   
   public int getId() {
      return id;
   }   
      
   public void deactivate() {
   
   }
   
   public void edit() {
   
   }
}
