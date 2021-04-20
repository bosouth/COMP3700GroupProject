import java.util.Scanner;

public class InventoryItem extends LibraryDatabase {
   
   protected String title;
   protected String author;
   protected int callNum;
   protected int barcode;
   public InventoryItem[] itemList;
   public InventoryItem[] cart;
   public boolean found;
   private int count;
   private int cartCount;
   public double price;
   
   public InventoryItem(String itemTypeIn, String avaDateIn, String titleIn, String authorIn, int callNumIn, int barcodeIn, double priceIn) {
      super(itemTypeIn, avaDateIn);
      title = titleIn;
      author = authorIn;
      callNum = callNumIn;
      barcode = barcodeIn;
      itemList = new InventoryItem[20];
      cart = new InventoryItem[20];
      count = 0;
      found = false;
      price = priceIn;
   }
   
   public String getTitle() {
    return title;
   }
   
   public String getAuthor() {
      return author;
   }
   
   public int getCallNum() {
      return callNum;
   }
   
   public int getBarcode() {
      return barcode;
   }
   
   public double getPrice() {
      return price;
   }
   
   public void checkOut(int barcodeIn) {
      
   }
   
   public void checkIn(int barcodeIn) {
   
   }
   
   public void add(String titleIn) {
      Scanner userInput = new Scanner(System.in);
      cart[cartCount] = this.search(titleIn);       
      
      while (this.found == false) {
         System.out.println("Could not find item. Try a different title.\n");
         System.out.print("Select an item to check out: ");
         titleIn = userInput.nextLine();
         cart[cartCount] = this.search(titleIn);
      }  
      cartCount++;
   
   }
   
   public void remove(String titleIn) {
   
   }
   
   public InventoryItem search(String titleIn) {
      for (InventoryItem item : itemList) {
         if (item == null) {
            return null;
         }
         if (item.getTitle().equals(titleIn)) {
            System.out.println("Item added to cart.");
            found = true;
            return item;
         }
      }
      return null;
   }
   
   public InventoryItem[] initDatabase() {
   
      InventoryItem book1 = new InventoryItem("book", "0721", "1984", "George Orwell", 000001, 395385, 9.99); 
      itemList[count] = book1;
      count++;
      InventoryItem book2 = new InventoryItem("book", "1112", "Lord of the Flies", "William Golding", 000002, 511076, 13.50);
      itemList[count] = book2;
      count++;
      
      return itemList;
   }

   
   public String printInventory(InventoryItem[] inventoryIn) {
      String result = "";
   
      for (InventoryItem item : inventoryIn) {
         if (item != null) {
            result += item.getTitle() + ", by " + item.getAuthor() + "\n";
         }
         else {
            break;
         }
      }
      
      return result;
   }
   
   public double calculateTotalPrice(InventoryItem[] inventoryIn) {
      double result = 0;
   
      for (InventoryItem item : inventoryIn) {
         if (item == null) {
            break;
         }
         result += item.price;
      }
      
      return result;
   }
}
