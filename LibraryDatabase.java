import java.util.Random;

public class LibraryDatabase {

   private String itemType;
   public String avaDate;
   public LibraryDatabase[] itemList;
   private int count;
   
   public LibraryDatabase(String itemTypeIn, String avaDateIn) {
      itemType = itemTypeIn;
      avaDate = avaDateIn;
      itemList = new LibraryDatabase[20];
      count = 0;
   }
   
   public String getItemType() {
      return itemType;
   }
   
   public String getAvaDate() {
      return avaDate;
   }
   
   public void add(String itemTypeIn) {
      
   }
   
   public void remove(String itemTypeIn) {
   
   }
   
   public void edit(String itemTypeIn) {
   
   }   
   
   
}
