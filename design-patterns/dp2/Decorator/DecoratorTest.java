/**
 * DecoratorTest
 */
public class DecoratorTest {

    public static void main(String[] args) {
        System.out.println("Decorator a structural pattern");
        System.out.println("____________________________________________________");
        IceCream vanillIceCream = new Vanilla();
        vanillIceCream.setPrice(200);
        // adding condiments are also is-a IceCream
        // funny thing is we put icecream into oreo not oreo into vanilla icecream
        // object but its just a terminology works fine
        IceCream oreoBiscutIceCream = new Oreo(vanillIceCream);
        oreoBiscutIceCream.setPrice(50);
        System.out.println(oreoBiscutIceCream.getDescription());
        System.out.println("Price is "+oreoBiscutIceCream.getPrice());
    }
}

abstract class IceCream {
    private int price;

    abstract String getDescription();

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}

class Vanilla extends IceCream {

    @Override
    String getDescription() {
        return "Vanilla ice cream with ";
    }

}

// Decorator class
abstract class IceCreamDecorator extends IceCream {
    // ice cream eka methanata awa kiyanne decorate wela
    IceCream decoratedIceCream;
    // IceCreamDecorator eke price eka (decoratedIceCream eke neme)
    private int decoratorPrice;

    IceCreamDecorator(IceCream iceCream) {
        this.decoratedIceCream = iceCream;
    }

    @Override
    public int getPrice() {
        return decoratedIceCream.getPrice() + this.decoratorPrice;
    }

    @Override
    public void setPrice(int price) {
        this.decoratorPrice = price;
    }

}

class Oreo extends IceCreamDecorator {

    Oreo(IceCream iceCream) {
        super(iceCream);
    }

    @Override
    String getDescription() {

        return decoratedIceCream.getDescription() + " oreo,";
    }

}
