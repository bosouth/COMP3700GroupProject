public class User extends InformationSystem{

    protected String name;
    protected int id;
    protected String address;
    protected int phoneNum;
    protected String email;
    
    // constructor for User
    public User(String userTypeIn, String userNameIn, String passwordIn, int idIn, String nameIn, String addressIn, int phoneNumIn, String emailIn) {
      super(userTypeIn, userNameIn, passwordIn);
      id = idIn;
      name = nameIn;
      address = addressIn;
      phoneNum = phoneNumIn;
      email = emailIn;
    }
    
    // returns id for user
    public int getId() {
      return id;
    }
    
    // returns name for user
    public String getName() {
      return name;
    }
    
    // returns address for user
    public String getAddress() {
      return address;
    }
    
    // returns phone number for user
    public int getPhoneNum() {
      return phoneNum;
    }
    
    // returns email address for user
    public String getEmail() {
      return email;
    }
}
