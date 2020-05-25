import java.util.Stack;

class A {
    public static void main(String[] args) {
        System.out.println("programme started");

        Originator originator = new Originator();
        CareTacker careTacker = new CareTacker();

        originator.setState("born");
        careTacker.saveToHistory(originator);

        originator.setState("get a job");
        careTacker.saveToHistory(originator);

        originator.setState("marry");
        careTacker.saveToHistory(originator);

        System.out.println("Current State"+originator);
        System.out.println();
        //2 reverts because marry state also saved in stack and
        //our logic to reverting is setting  poped memento (removed object)
        //api ain karapu kenawa thama set karaganne
        careTacker.revertStateOfOriginator(originator);
        careTacker.revertStateOfOriginator(originator);
        System.out.println("After revert "+originator);
    }


}

class CareTacker {
    Stack<Originator.Memento> history = new Stack();

    public void saveToHistory(Originator originator) {
        // our stack is not originator list
        // but a memento stack thats why we made a method
        // In Originator to get its state as a memento and save
        history.push(originator.save());
    }

    //revert the state of given originator
    public void revertStateOfOriginator(Originator originator) {
        if (!history.empty())
            originator.revert(history.pop());
        else
            System.out.println("Cant undo");
    }
}

class Originator {
    // make seeters and getters for this state
    // make sure not to pass reference but a new object
    private String state;

    public String getState() {
        return new String(this.state);
    }

    // then we need 2 methods as revert and save
    // Get Memento actually its a copy of current originator State
    // to save for the CareTaker
    public Memento save() {
        return new Memento(getState());
    }

    // revert current State by providing object from CareTacker to this
    public void revert(Memento memento) {
        this.state = memento.getState();
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Originator{" +
                "state='" + state + '\'' +
                '}';
    }


    //________________________________________________________________________________________

    // only the Originator that can store and retrieve
    // state information from the Memento
    // and this act as template for Originator
    static class Memento {
        private String state;

        Memento(String state) {
            this.state = state;
        }

        // Only this can be access by the originator class
        private String getState() {
            return this.state;
        }

    }

}