import java.util.Scanner;

public class Customer extends User {

   protected String creditCard;
   private Scanner scanner = new Scanner(System.in);
   
   public Customer(String userTypeIn, String usernameIn, String passwordIn, int idIn, String nameIn, String addressIn, int phoneNumIn, String emailIn, String creditCardIn) {
      super(userTypeIn, usernameIn, passwordIn, idIn, nameIn, addressIn, phoneNumIn, emailIn);
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
   
   public void setAddress() {
      System.out.println("Please enter a valid address: ");
      this.address = scanner.nextLine();
   }
   
   public void setPhoneNum() {
      System.out.println("Please enter a phone number (7 digits): ");
      this.phoneNum = Integer.parseInt(scanner.nextLine());
   }
   
   public void setEmail() {
      System.out.println("Please enter a valid email address: ");
      this.email = scanner.nextLine();
   }
   
   public void setCreditCard() {
      System.out.println("Please enter a valid credit card number: ");
      this.creditCard = scanner.nextLine();
   }
}
