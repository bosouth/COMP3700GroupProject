public class Customer extends User {

   protected String creditCard;
   
   public Customer(int idIn, String nameIn, String addressIn, int phoneNumIn, String emailIn, String creditCardIn) {
      super(idIn, nameIn, addressIn, phoneNumIn, emailIn);
      creditCard = creditCardIn;
   }
   
   public String getCreditCard() {
      return creditCard;
   }
   
   public int register(int idIn) {
      return 0;
   }
   
   public void payFees() {
      
   }
}