
public class Test {

    public static void main(String[] args) {
        System.out.println("factory simple example ");
        // in Factory pattern, we create object without exposing the creation logic to
        // the client and refer to newly created object using a common interface.
        AFactory aFactory = new AFactory();
        A a1 = aFactory.getA("a1");
        a1.info();
        A a2 = aFactory.getA("a2");
        a2.info();
        A a3 = aFactory.getA("a3");
        a3.info();
    }
}

interface A {
    void info();
}

class AFactory {
    public A getA(String atype) {
        return (atype.equalsIgnoreCase("A1")) ? new A1()
                : (atype.equalsIgnoreCase("A2")) ? new A2() : (atype.equalsIgnoreCase("A3")) ? new A3() : null;
    }

}

class A1 implements A {
    @Override
    public void info() {
        System.out.println("A1 info");
    }
}

class A2 implements A {
    @Override
    public void info() {
        System.out.println("A2 info");
    }
}

class A3 implements A {
    @Override
    public void info() {
        System.out.println("A3 info");
    }

}

    