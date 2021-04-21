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
   
   public InformationSystem[] initInfoSystem() {
      Account molly = new Account("Customer", "molly", "molly375", 3333);
      userDatabase[infoCount] = molly;
      infoCount++;
      InformationSystem jacob = new Account("Customer", "jacob", "jacob112233", 2345);
      userDatabase[infoCount] = jacob;
      infoCount++;
      InformationSystem billy = new Account("Customer", "billy", "billy28375", 9375);
      userDatabase[infoCount] = billy;
      infoCount++;
      
      return userDatabase;
      
   }
}
