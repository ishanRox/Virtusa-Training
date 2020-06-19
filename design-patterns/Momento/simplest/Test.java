import Originator.Memento;

/**
 * Test
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("memento pattern");
    }
}

class CareTacker {

}

class Originator {
    int state;

    public void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public Memento saveMementoToCareTackerHistory() {
        return new Memento(this.state);
    }

    public void revertUsingCaretackerMemento(Memento memento) {
        this.state = memento.state;
    }

    public  static class Memento {
        int state;

        Memento(int state) {
            this.state = state;
        }

        private int getState() {
            return state;
        }
    }
}