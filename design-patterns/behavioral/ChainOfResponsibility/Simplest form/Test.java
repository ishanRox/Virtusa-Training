public class Test {

    public static void main(String[] args) {

        Handler1 handler1 = new Handler1();
        Handler2 handler2 = new Handler2();

        handler1.setNext(handler2);

        System.out.println("first attempt");
        handler1.handle("A");

        System.out.println("second attempt");
        handler1.handle("Aa");

        System.out.println("third attempt");
        handler1.handle("i");
    }

}

// for simplicity added a abstract class
abstract class Handler {

    protected Handler handler;

    public void setNext(Handler handler) {
        this.handler = handler;
    }

    public abstract void handle(String vowel);
}

class Handler1 extends Handler {

    @Override
    public void handle(String vowel) {
        if (vowel.length() > 1) {
            System.out.println("Letter only no word");
        } else {
            this.handler.handle(vowel);
        }
    }

}

class Handler2 extends Handler {

    @Override
    public void handle(String vowel) {
        if (vowel.matches("^[^aeiouAEIOU]$")) {
            System.out.println("Only vowels not other letters");
        } else {
            System.out.println("Okkk this is a vowel");
        }
    }

}
