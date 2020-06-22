/**
 * Test
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("factory simple example ");

        AbstractFactory letterFactory = FactoryProducer.getFactory("letter");
        letterFactory.getA("A1").info();

    }
}

interface A {
    void info();
}

 abstract class AbstractFactory {
    abstract A getA(String aType);
}

// get common super to both factories
// give factories their own
class ALetterFactory extends AbstractFactory {
    public  A getA(String atype) {
        return (atype.equalsIgnoreCase("A1")) ? new A1()
                : (atype.equalsIgnoreCase("A2")) ? new A2() : (atype.equalsIgnoreCase("A3")) ? new A3() : null;
    }

}
class ANumberFactory extends AbstractFactory {
    public  A getA(String atype) {
        return (atype.equalsIgnoreCase("Aa")) ? new Aa()
                : (atype.equalsIgnoreCase("Ab")) ? new Ab() : (atype.equalsIgnoreCase("Ac")) ? new Ac() : null;
    }

}

// make a Factory to get factories
 class FactoryProducer {
    public static AbstractFactory getFactory(String factory) {
        if (factory.equalsIgnoreCase("letter")) {
            return new ALetterFactory();
        } else if (factory.equalsIgnoreCase("number")) {
            return new ANumberFactory();
        } else {
            return null;
        }
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

class Aa implements A {
    @Override
    public void info() {
        System.out.println("Aa info");
    }
}

class Ab implements A {
    @Override
    public void info() {
        System.out.println("Ab info");
    }
}

class Ac implements A {
    @Override
    public void info() {
        System.out.println("Ac info");
    }
}