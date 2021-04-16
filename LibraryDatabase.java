public class LibraryDatabase {

   protected String itemType;
   protected String addDate;
   
   public LibraryDatabase(String itemTypeIn, String addDateIn) {
      itemType = itemTypeIn;
      addDate = addDateIn;
   }
   
   public String getItemType() {
      return itemType;
   }
   
   public String getAddDate() {
      return addDate;
   }
   
   public void add(String itemTypeIn) {
   
   }
   
   public void remove(String itemTypeIn) {
   
   }
   
   public void edit() {
   
   }
   
   public void search() {
   
   }
   
   public int generateBarcode() {
      return 0;
   }
}