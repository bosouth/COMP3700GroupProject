import java.util.Random;

public class LibraryDatabase {

   private String itemType;
   public String avaDate;
   public LibraryDatabase[] itemList;
   private int count;
   
   // constructor for LibraryDatabase
   public LibraryDatabase(String itemTypeIn, String avaDateIn) {
      itemType = itemTypeIn;
      avaDate = avaDateIn;
      itemList = new LibraryDatabase[20];
      count = 0;
   }
   
   // returns item type for item
   public String getItemType() {
      return itemType;
   }
   
   // returns due date for item
   public String getAvaDate() {
      return avaDate;
   }
}
