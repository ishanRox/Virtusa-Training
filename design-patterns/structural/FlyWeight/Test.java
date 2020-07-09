import java.util.HashMap;

/**
 * Test
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("FlyWeight pattern");
        CircleFactory.getCircle("red", 12);

        CircleFactory.getCircle("red", 122);

    }
}

interface Shape {
    void draw();
}

class Circle implements Shape {
    private String color;
    private int size;

    public Circle(String color, int size) {
        this.color = color;
        this.size = size;
    }

    public void draw() {
        System.out.println(this.color + "color size" + this.size);
    }

}

class CircleFactory {
    private static final HashMap map = new HashMap();

    public static Circle getCircle(String color, int size) {
        Circle circle = (Circle) map.get(color);
        if (circle == null) {
            System.out.println("creating new circle ");
            circle = new Circle(color, size);
            map.put(color, circle);
        } else {
            System.out.println("already created");
        }
        return circle;
    }
}