import java.util.ArrayList;
import java.util.List;

class Laptop implements Elment {

    private double price;
    private String model;

    public Laptop(double price, String model) {
        this.price = price;
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public double accept(Visitor v) {
        return v.visit(this);
    }
}

class MobilePhone implements Elment {

    private double price;
    private String model;
    private String type;

    public MobilePhone(double price, String model, String type) {
        this.price = price;
        this.model = model;
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

        ic String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public double accept(Visitor v) {
        return v.visit(this);
    }
}

class Camera implements Elment {

    private double price;
    private String model;
    private String lense;

    public Camera(double price, String model, String lense) {
        this.price = price;
        this.model = model;
        this.lense = lense;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLense() {
        return lense;
    }

    public void setLense(String lense) {
        this.lense = lense;
    }

    @Override
    public double accept(Visitor v) {
        return v.visit(this);
    }
}

interface Visitor {

    public double visit(Laptop l);

    public double visit(MobilePhone m);

    public double visit(Camera c);
}

class Shop implements Visitor {

    @Override
    public double visit(Laptop l) {
        return l.getPrice();
    }

    @Override
    public double visit(MobilePhone m) {
        double p = m.getPrice();
        if (m.getType().equals("Sony")) {
            p = m.getPrice() + 1000;
        }
        return p;
    }

    @Override
    public double visit(Camera c) {
        double p = c.getPrice();
        if (c.getPrice() > 50000) {
            p -= 5000;
        }
        return p;
    }
}

interface Elment {
    public double accept(Visitor v);
}

public class Test {

    public static void main(String[] args) {

        MobilePhone m1 = new MobilePhone(10000, "Sony XZ", "Touch");
        MobilePhone m2 = new MobilePhone(22000, "Samsung", "Normal");
        Laptop l1 = new Laptop(100000, "Dell");
        Camera c1 = new Camera(6000, "Canon", "X500");

        ArrayList<Elment> elments = new ArrayList<>();
        elments.add(m1);
        elments.add(m2);
        elments.add(l1);
        elments.add(c1);
new Object();
        Shop shop = new Shop();
        double total = 0;

        for (Elment e : elments) {
            total += e.accept(shop);
        }

        System.out.println(total);
    }
}