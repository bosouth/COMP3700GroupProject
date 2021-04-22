import java.util.Scanner;

public class Customer extends User {

   protected String creditCard;
   private Scanner scanner = new Scanner(System.in);
   
   // constructor for Customer
   public Customer(String userTypeIn, String usernameIn, String passwordIn, int idIn, String nameIn, String addressIn, int phoneNumIn, String emailIn, String creditCardIn) {
      super(userTypeIn, usernameIn, passwordIn, idIn, nameIn, addressIn, phoneNumIn, emailIn);
      creditCard = creditCardIn;
   }
   
   // returns credit card number
   public String getCreditCard() {
      return creditCard;
   }
   
   // sets address for customer
   public void setAddress() {
      System.out.print("Please enter a valid address: ");
      this.address = scanner.nextLine();
   }
   
   // sets phone number for customer
   public void setPhoneNum() {
      System.out.print("Please enter a phone number (7 digits): ");
      this.phoneNum = Integer.parseInt(scanner.nextLine());
   }
   
   // sets email address for customer
   public void setEmail() {
      System.out.print("Please enter a valid email address: ");
      this.email = scanner.nextLine();
   }
   
   // sets credit card number for customer
   public void setCreditCard() {
      System.out.print("Please enter a valid credit card number: ");
      this.creditCard = scanner.nextLine();
   }
}
