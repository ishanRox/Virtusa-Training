import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class A {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTacker careTacker = new CareTacker();
        originator.setState(1);
        careTacker.saveState(originator);

        originator.setState(2);
        careTacker.saveState(originator);

        originator.setState(3);
        careTacker.saveState(originator);

        System.out.println(originator.getState());
        careTacker.restore(originator);
        System.out.println(originator.getState());
        careTacker.restore(originator);
        System.out.println(originator.getState());
        careTacker.undo(originator);
        System.out.println(originator.getState());
        careTacker.undo(originator);
        System.out.println(originator.getState());
    }
}

class CareTacker {
    List<Originator.Memento> history = new ArrayList();
    int pointer = 0;

    public void restore(Originator originator) {
        pointer = (history.size() == pointer) ? pointer - 2 : pointer - 1;
        originator.redo(history.get(pointer));
    }

    public void undo(Originator originator) {
        pointer++;
        originator.redo(history.get(pointer));
    }

    public void saveState(Originator originator) {
        pointer++;
        history.add(originator.save());
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

    public Memento save() {
        return new Memento(this.state);
    }

    public void redo(Memento memento) {
        this.state = memento.state;
    }

    static class Memento {
        private int state;

        Memento(int state) {
            this.state = state;
        }

        private int getState() {
            return this.state;
        }
    }
}