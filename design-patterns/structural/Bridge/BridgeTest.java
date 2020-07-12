/**
 * BridgeTest
 */
// Bridge is used when we need to decouple an abstraction from its
// implementation so that the two can vary independently.
public class BridgeTest {
    public static void main(String[] args) {
        System.out.println("bridge pattern");
        // if we hardcode colors and shapes
        // it will need more code and repetetion
        // but with this we can decouple it

        Shape circle = new Circle();
        Color red = new Red();
        circle.color = red;
        circle.info();

        Color blue = new Blue();
        circle.color = blue;
        circle.info();

        Shape triangle = new Triangle();
        triangle.color = red;
        triangle.info();
    }
}

abstract class Shape {
    Color color;

    public void info() {
        System.out.println(" color is " + color.getColor() + " shape is " + this.getShapeName());
    }

    public abstract String getShapeName();
}

interface Color {
    String getColor();
}

class Red implements Color {
    public String getColor() {
        return "red";
    }
}

class Blue implements Color {
    public String getColor() {
        return "blue";
    }
}

class Circle extends Shape {

    @Override
    public String getShapeName() {
        return "Circle";
    }

}

class Triangle extends Shape {

    @Override
    public String getShapeName() {
        return "Triangle";
    }
}
