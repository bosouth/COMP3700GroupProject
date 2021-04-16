public class Employee extends User {

   public Employee(String userTypeIn, String usernameIn, String passwordIn, int idIn, String nameIn, String addressIn, int phoneNumIn, String emailIn) {
      super(userTypeIn, usernameIn, passwordIn, idIn, nameIn, addressIn, phoneNumIn, emailIn);
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
