class User implements Cloneable {

    int id;
    String name;
    String city;

    {
        System.out.println("instance block");
    }

    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;

        System.out.println("User Constructor");
    }

    public User() {
        System.out.println("User empty Constructor");
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

    public void viewDetails() {
        System.out.println(id + "," + name + "," + city);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {    
        return super.clone();
    }

}

public class Test {

    public static void main(String[] args) {
        User u1 = new User(1, "Kamal", "Colombo");
        u1.viewDetails();

        try {
            User u2 = (User) u1.clone();
            u2.setCity("Kandy");

            u2.viewDetails();
            u1.viewDetails();

            System.out.println(u2 + "  " + u1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}