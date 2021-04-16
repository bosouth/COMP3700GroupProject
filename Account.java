public class Account extends InformationSystem {

   protected String type;
   protected int itemsBorrowed;
   protected int itemsReserved;
   protected int itemsLost;
   
   public Account(String userTypeIn, String usernameIn, String passwordIn, String typeIn, int itemsBorrowedIn, int itemsReservedIn, int itemsLostIn) {
      super(userTypeIn, usernameIn, passwordIn);
      type = typeIn;
      itemsBorrowed = itemsBorrowedIn;
      itemsReserved = itemsReservedIn;
      itemsLost = itemsLostIn;
   } 
   
   public String getType() {
      return type;
   }
   
   public int getItemsBorrowed() {
      return itemsBorrowed;
   }
   
   public int getItemsReserved() {
      return itemsReserved;
   }
   
   public int getItemsLost() {
      return itemsLost;
   }
   
   public void register() {
   
   }
   
   public void deactivate() {
   
   }
   
   public void edit() {
   
   }
}