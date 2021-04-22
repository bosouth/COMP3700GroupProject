import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Employee extends User {

   public Employee[] empList;
   public int empCount;
   public boolean success;
   
   // constructor of Employee
   public Employee(String userTypeIn, String usernameIn, String passwordIn, int idIn, String nameIn, String addressIn, int phoneNumIn, String emailIn) {
      super(userTypeIn, usernameIn, passwordIn, idIn, nameIn, addressIn, phoneNumIn, emailIn);
      empList = new Employee[20];
      empCount = 0;
      success = false;
   } 
   
   // makes sure that username exists in empListIn and that the password and id match
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
      
      System.out.println("Could not find username...");
      return;
   }
   
   // searches for specifc user in the employee database
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
   
   // prints thecustomer report in string form
   public String printReport(Account accIn, Transaction tranIn, InventoryItem[] cartIn) {
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMdd");
      LocalDateTime now = LocalDateTime.now();
      String currentDate = dtf.format(now);
      
      String result = "";
      result += "User " + accIn.getUsername();
      result += " has checked out: \n";
      
      for (InventoryItem item : cartIn) {
         if (item == null) {
            break;
         }
         result += item.getTitle() + ", by " + item.getAuthor() + " on " + currentDate + "\n";
         result += item.getTitle() + "'s due date is " + item.getAvaDate() + "\n\n"; 
      }
         result += "User's current overdue late fee is: $" + tranIn.calculateFee() + "\n";
      return result;
   }
   
   // initialize the employee account database
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
