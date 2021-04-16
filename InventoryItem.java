public class InventoryItem extends LibraryDatabase {
   
   protected String title;
   protected String author;
   protected int callNum;
   protected int barcode;
   
   public InventoryItem(String itemTypeIn, String addDateIn, String titleIn, String authorIn, int callNumIn, int barcodeIn) {
      super(itemTypeIn, addDateIn);
      title = titleIn;
      author = titleIn;
      callNum = callNumIn;
      barcode = barcodeIn;
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
   
   public void checkOut(int barcodeIn) {
      
   }
   
   public void checkIn(int barcodeIn) {
   
   }
   
   public void add(int barcdoeIn, String titleIn) {
   
   }
   
   public void remove(int barcodeIn, String titleIn) {
   
   }
}