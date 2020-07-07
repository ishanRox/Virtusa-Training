public class Test {

    public static void main(String[] args) {

        Handler1 handler1 = new Handler1();
        Handler2 handler2 = new Handler2();

        handler1.setNext(handler2);

        System.out.println("first attempt");
        handler1.handle(new Letter("A"));

        System.out.println("second attempt");
        handler1.handle(new Letter("Aa"));

        System.out.println("third attempt");
        handler1.handle(new Letter("1"));
    }

}

// Handle karanna yana class eka
class Letter {
    private String letter;

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public Letter(String letter) {
        this.letter = letter;
    }
}

interface Handler {
    // meka succes unoth ilagata success wenna one handler
    public abstract void setNext(Handler handler);

    // handle karanna one object eka
    public abstract void handle(Letter letter);
}

// Handle karana class tika

// Letter ekakda balanawa
class Handler1 implements Handler {
    private Handler handler;

    @Override
    public void setNext(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void handle(Letter letter) {
        if (letter.getLetter().length() > 1) {
            System.out.println("Letter only no word");
        } else {
            this.handler.handle(letter);
        }
    }

}

class Handler2 implements Handler {

    private Handler handler;

    @Override
    public void setNext(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void handle(Letter letter) {
        if (letter.getLetter().matches("[0-9]")) {
            System.out.println("Only letters no number");
        } else {
            System.out.println("Okkk this is a letter");
        }
    }

}