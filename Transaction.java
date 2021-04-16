public class Transaction {
   
   protected String type;
   protected String date;
   
   public Transaction(String typeIn, String dateIn) {
      type = typeIn;
      date = dateIn;
   }
   
   public String getType() {
      return type;
   }
   
   public String getDate() {
      return date;
   }
   
   public String checkOut() {
      return "";
   }
   
   public String checkIn() {
      return "";
   }
   
   public String payment(String typeIn) {
      return "";
   }  
   
   public String search(String typeIn) {
      return "";
   }
}