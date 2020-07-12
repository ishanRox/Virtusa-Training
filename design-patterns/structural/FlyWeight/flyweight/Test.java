import java.util.HashMap;

/**
 * Test
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("Flyweight pattern\n");

        ShapeFactory.getCircle("red", 12);
        ShapeFactory.getCircle("red", 12);

    }
}

interface Shape {
    void draw();
}

class Circle implements Shape {
    private String color;
    private int radius;

    public Circle(String color, int radius) {
        this.color = color;
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void draw() {
        System.out.println("This is a circle with color " + this.color + " and radius " + this.radius);

    }
}

class ShapeFactory {
    private static final HashMap<String, Shape> circleMap = new HashMap();

    public static Shape getCircle(String color, int radius) {
        Circle circle = (Circle) circleMap.get(color);
        System.out.println("Already created ");
        if (circle == null) {
            circle = new Circle(color, radius);
            System.out.println("Creating circle of color " + color);
            circleMap.put(color, circle);
        }
        return circle;
    }
}