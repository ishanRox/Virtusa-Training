/**
 * simpleBuilder
 */
public class simpleBuilder {

    public static void main(String[] args) {
        new A.ABuilder().addX(100).addY(200).addZ(300).build().total();

    }
}

// Builder is a creational design pattern that lets you construct complex
// objects step by step. The
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