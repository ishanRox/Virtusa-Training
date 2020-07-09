class Test

{
    public static void main(String[] args) {
        Handler handler1 = new Handler1();
        Handler handler2 = new Handler2();

        handler1.setHandler(handler2);
        handler1.handle(new A(3));

    }
}

class A {
    private int i;

    public A(int i) {
        this.i = i;
    }

    public int getI() {
        return this.i;
    }
}

interface Handler {

    void setHandler(Handler h);

    void handle(A a);

}

class Handler1 implements Handler {
    private Handler h;

    @Override
    public void setHandler(Handler h) {
        this.h = h;
    }

    @Override
    public void handle(A a) {
        if (a.getI() > 10) {
            System.out.println("must below 10");
        } else {
            this.h.handle(a);
        }
    }
}

class Handler2 implements Handler {
    private Handler h;

    @Override
    public void setHandler(Handler h) {
        this.h = h;
    }

    @Override
    public void handle(A a) {
        if (a.getI() % 2 == 0) {
            System.out.println("only odds allow");
        } else {
            System.out.println("ok number is a below 10 and odd");
        }
    }
}
