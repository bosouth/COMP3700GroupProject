import java.util.Random;

public class LibraryDatabase {

   private String itemType;
   private String addDate;
   public LibraryDatabase[] itemList;
   private int count;
   
   public LibraryDatabase(String itemTypeIn, String addDateIn) {
      itemType = itemTypeIn;
      addDate = addDateIn;
      itemList = new LibraryDatabase[20];
      count = 0;
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
   
   public void edit(String itemTypeIn) {
   
   }   
   
   
}
