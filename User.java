public class User {

    protected String name;
    protected int id;
    protected String address;
    protected int phoneNum;
    protected String email;
    
    public static void main(String args[]) {

        System.out.println("Hello World");
    }
    
    public boolean verifyAcct(int id, String name) {
      
      return false;
    }
    
    public User(int idIn, String nameIn, String addressIn, int phoneNumIn, String emailIn) {
      id = idIn;
      name = nameIn;
      address = addressIn;
      phoneNum = phoneNumIn;
      email = emailIn;
    }
    
    public String getName() {
      return name;
    }
    
    public String getAddress() {
      return address;
    }
    
    public int getPhoneNum() {
      return phoneNum;
    }
    
    public String getEmail() {
      return email;
    }
}