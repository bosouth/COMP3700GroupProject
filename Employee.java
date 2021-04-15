public class Employee extends User {

   public Employee(int idIn, String nameIn, String addressIn, int phoneNumIn, String emailIn) {
      super(idIn, nameIn, addressIn, phoneNumIn, emailIn);
   } 
   
   public String addItem(String itemIn) {
      return "";
   }
   
   public int checkIn(int barcodeIn) {
      return 0;
   }
   
   public int checkOut(int barcodeIn) {
      return 0;
   }
}