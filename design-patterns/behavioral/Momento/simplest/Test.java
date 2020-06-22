import java.util.Stack;

/**
 * Test
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("memento pattern");
        Originator originator = new Originator();
        CareTacker careTacker = new CareTacker();

        originator.setState(100);
        careTacker.save(originator);

        originator.setState(200);
        careTacker.save(originator);

        originator.setState(300);
        careTacker.save(originator);

        System.out.println(originator.getState() + " current state ");
        careTacker.revert(originator);
        System.out.println(originator.getState() + " previouse state ");
        careTacker.revert(originator);
        System.out.println(originator.getState() + " prviouse state ");

        ;

    }
}

class CareTacker {
    private Stack<Originator.Memento> history = new Stack();

    public void save(Originator originator) {
        history.add(originator.saveMementoToCareTackerHistory());
    }

    public void revert(Originator originator) {
        history.pop();
        originator.revertUsingCareTackerMemento(history.lastElement());
    }
}

class Originator {
    private int state;

    public void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public Memento saveMementoToCareTackerHistory() {
        return new Memento(this.state);
    }

    public void revertUsingCareTackerMemento(Memento memento) {
        this.state = memento.state;
    }

    public static class Memento {
        private int state;

        Memento(int state) {
            this.state = state;
        }

        private int getState() {
            return state;
        }
    }
}