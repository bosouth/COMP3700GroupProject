public class Employee extends User {

   public Employee[] empList;
   public int empCount;
   public boolean success;

   public Employee(String userTypeIn, String usernameIn, String passwordIn, int idIn, String nameIn, String addressIn, int phoneNumIn, String emailIn) {
      super(userTypeIn, usernameIn, passwordIn, idIn, nameIn, addressIn, phoneNumIn, emailIn);
      empList = new Employee[20];
      empCount = 0;
      success = false;
   } 
   
   public void login(String userTypeIn, String usernameIn, String passwordIn, int idIn, Employee[] empListIn) {
      
      
      for (Employee emp : empListIn) {
         if (emp == null) {
            return;
         }
         if (usernameIn.equals(emp.username)) {
            if (emp.getPassword().equals(passwordIn)) {
               if (emp.getId() == idIn) {
                  System.out.println("Success...");
                  success = true;
                  return;
               }
               else {
                  System.out.println("Wrong id. Try again...");
                  return;
               }
            }
            else {
               System.out.println("Wrong password. Try again...");
               return;
            }
         }
      }
      
      return;
   }
   
   public boolean search(String usernameIn) {
      initEmpDatabase();
   
      for (int i = 0; i < empList.length; i++) {
         if (empList[i] == null) {
            return false;
         }
         if (empList[i].username == usernameIn) {
            return true;
         }
      }
      return false;
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
   
   public String printReport() {
      return "";
   }
   
   public Employee[] initEmpDatabase() {
      Employee bart = new Employee("employee", "bart", "bart330", 1324, "Bart Smith", "102 Bart Lane", 4376849, "bart330@bart.com");
      empList[empCount] = bart;
      empCount++;
      Employee jessica = new Employee("employee", "jessica", "jess33", 3376, "Jessica Simpson", "1121 Hickory Lane", 2435644, "jess222@jess.com");
      empList[empCount] = jessica;
      empCount++;
      
      return empList;
   }
}
