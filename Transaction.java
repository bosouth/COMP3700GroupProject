import java.util.Scanner;

public class Transaction {
   
   public double balance;
   public boolean success;
   public double fee;
   private Scanner scanner = new Scanner(System.in);
   
   // constructor of Transaction
   public Transaction(double balanceIn) {
      balance = balanceIn;
      success = false;
      fee = 0;
   }
   
   // sets balance of the credit card
   public void setBalance() {
      System.out.print("Set the balance of your credit card: ");
      this.balance = Double.parseDouble(scanner.nextLine());
   }
   
   // returns balance of credit card
   public double getBalance() {
      return balance;
   }
   
   // calculate late fees
   public double calculateFee() {
      return 0;
   }
   
   // checks if current funds are high enough to make the transaction. 
   // sets success to true if funds are sufficient
   public void checkOut(double priceIn) {
                  
      if (this.balance < priceIn) {
         System.out.println("Insufficient funds. Remove an item.");
      }
      else {
         System.out.print("Sufficient funds. Your new balance is $");
         this.balance -= priceIn;
         System.out.print(this.balance + ".\n");
         success = true;
      }
   }
}
