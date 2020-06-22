
/**
 * simpleBuilder
 */
public class simpleBuilder {

    public static void main(String[] args) {
        A.ABuilder builder1 = new A.ABuilder().addX(100).addY(200).addZ(300);
        A a1 = builder1.build();
        a1.total();

        A.ABuilder builder2 = new A.ABuilder().addY(200).addZ(300);
        A a2 = builder2.build();
        a2.total();

        // Builder — constructs parts of the product and provides an interface for its
        // retrieving
        // Director — constructs an object using the Builder interface
        // Product — represents the complex object under construction. This is a result
        // of cooperation a concrete Director with a concrete Builder

        // look how similer this java implementation and our one
        // StringBuilder builder = new StringBuilder("Temp");
        // String data = builder.append(1)
        // .append(true)
        // .append("friend")
        // .toString();
        // System.out.println(data);
        // Output:
        // Temp1truefriend
    }
}

// Builder is a creational design pattern that lets you construct complex
// objects step by step.

// Class A thama Director
/**
 * Class presenting a Director (orcestrates the Builder to make an airplane
 * instance)
 */
class A {
    private int x;
    private int y;
    private int z;

    public A(ABuilder build) {
        this.x = build.x;
        this.y = build.y;
        this.z = build.z;
    }

    public void total() {
        System.out.println(x + y + z);
    }

    // Builder class
    static class ABuilder {
        private int x;
        private int y;
        private int z;

        public ABuilder addX(int x) {
            this.x = x;
            return this;
        }

        public ABuilder addY(int x) {
            this.y = x;
            return this;
        }

        public ABuilder addZ(int x) {
            this.z = x;
            return this;
        }

        public A build() {
            return new A(this);
        }
    }
}