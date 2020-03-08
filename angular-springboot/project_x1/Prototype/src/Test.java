
 class User implements Cloneable{
  int id;
  String name;
  String city;

   public User(int id, String name, String city) {
     this.id = id;
     this.name = name;
     this.city = city;
   }

   public int getId() {
     return id;
   }

   public void setId(int id) {
     this.id = id;
   }

   public String getName() {
     return name;
   }

   public void setName(String name) {
     this.name = name;
   }

   public String getCity() {
     return city;
   }

   public void setCity(String city) {
     this.city = city;
   }

   //override the clone
   //but exception occure java.lang.CloneNotSupportedException: User
   //
   @Override
   protected Object clone() throws CloneNotSupportedException {
     return super.clone();
   }

   public void viewDetails(){
     System.out.println(id+"  "+name);
   }
 }

public class Test {
  public static void main(String[] args) {

    User u= new User(1,"ishan","gampaha");
    u.viewDetails();
    System.out.println(u+"what is this");

   try {
     User u1=(User)u.clone();
     u1.viewDetails();
     System.out.println(u1);
   }catch (Exception e){
     e.printStackTrace();
   }

  }

}
