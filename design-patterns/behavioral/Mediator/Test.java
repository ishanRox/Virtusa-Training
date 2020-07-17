 class A {

    Mediator m;

    public void m(String msg) {
        System.out.println("A m " + msg);
        // m.b.p();
        m.callP(msg);
    }

    public void n(String msg) {
        System.out.println("A n");
        m.callQ(msg);
    }
}

class B {

    Mediator m;

    public void p(String msg) {
        System.out.println("B p");
        // m.callR();
    }
}

class C {

    Mediator m;

    public void q(String msg) {
        System.out.println("C q");
        // m.callR();
    }

    public void r(String msg) {
        System.out.println("C r");
        // m.callR();
    }
}

class Mediator {

    B b;
    C c;

    public void callP(String messaage) {
        b.p(messaage);
    }

    public void callQ(String msg) {
        c.q(msg);
    }

    public void callR(String msg) {
        c.r(msg);
    }
}

class Test {

    public static void main(String[] args) {
        Mediator m1 = new Mediator();

        A a = new A();
        B b = new B();
        C c = new C();

        m1.b = b;
        m1.c = c;

        a.m = m1;
        b.m = m1;
        c.m = m1;

        a.m("hello");

    }
}