import java.util.Scanner;

public class InventoryItem extends LibraryDatabase {
   
   protected String title;
   protected String author;
   protected int callNum;
   protected int barcode;
   public InventoryItem[] itemList;
   public InventoryItem[] cart;
   public boolean found;
   public boolean removed;
   private int count;
   private int cartCount;
   public double price;
   
   // constructor of InventoryItem
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
      removed = false;
      price = priceIn;
   }
   
   // returns the title of the given item
   public String getTitle() {
    return title;
   }
   
   // returns the author of given item
   public String getAuthor() {
      return author;
   }
   
   // returns call number of given type 
   public int getCallNum() {
      return callNum;
   }
   
   // returns barcode of given item
   public int getBarcode() {
      return barcode;
   }
   
   // returns price of given item
   public double getPrice() {
      return price;
   }
   
   // add an item to the cart
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
   
   // removes an item from the cart
   public void remove(String titleIn, InventoryItem[] cartIn) {
      int index = 0;
      
      if (cartIn[0] == null) {
         System.out.println("Seems there is nothing in your cart...:");
         removed = false;
         return;
      }
      
      for (InventoryItem item : cartIn) {
         if (item == null) {
            System.out.println("Could not find item...");
            removed = false;
            return;
         }
         if (titleIn.equals(item.getTitle())) {
            System.out.println("Item successfully removed.");
            cartIn[index] = null;
            cartCount--;
            removed = true;
            shiftLeft(cartIn);
            return;
         }
         index++;  
      }
         
   }
   
   // searches for an item in the current inventory
   public InventoryItem search(String titleIn) {
      for (InventoryItem item : itemList) {
         if (item == null) {
            return null;
         }
         if (item.getTitle().equals(titleIn)) {
            System.out.println("Item added to cart.\n");
            found = true;
            return item;
         }
      }
      return null;
   }
   
   // initializes the library database for items to check out
   public InventoryItem[] initDatabase() {
   
      InventoryItem book1 = new InventoryItem("book", "0721", "1984", "George Orwell", 000001, 395385, 9.99); 
      itemList[count] = book1;
      count++;
      InventoryItem book2 = new InventoryItem("book", "1112", "Lord of the Flies", "William Golding", 000002, 511076, 13.50);
      itemList[count] = book2;
      count++;
      
      return itemList;
   }

   // prints the inventory in question in String format
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
   
   // calculate total price of the cart
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
   
   // mainly used by the delete() method. Used for organization
   public static void shiftLeft(InventoryItem[] itemIn) {
      int i = 0;
   
      for (i = 0; i < itemIn.length; i++) {
         if (itemIn[i] == null) {
            if (itemIn[i + 1] == null) {
               return;
            }
            else {
               break;
            }
         }
         
      }
      
      while (itemIn[i + 1] != null) {
         itemIn[i] = itemIn[i + 1];
         itemIn[i + 1] = null;
      }
   }  
}
