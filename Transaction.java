import java.util.Scanner;

public class Transaction {
   
   public double balance;
   public boolean success;
   private Scanner scanner = new Scanner(System.in);
   
   public Transaction(double balanceIn) {
      balance = balanceIn;
      success = false;
   }
   
   public void setBalance() {
      System.out.println("Set the balance of your credit card...\n");
      this.balance = Double.parseDouble(scanner.nextLine());
   }
   
   public double getBalance() {
      return balance;
   }
   
   public void checkOut(double priceIn) {
      System.out.println("Your current balance is $" + this.balance 
                  + " and the price of your transaction is $" + priceIn + ".");
                  
      if (this.balance < priceIn) {
         System.out.println("Insufficient funds. Remove an item.");
      }
      else {
         System.out.print("Sufficient funds. Your new balance is $");
         this.balance -= priceIn;
         System.out.print(this.balance);
         success = true;
      }
   }
      
   
}
