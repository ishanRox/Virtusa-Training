

/**
 * MementoTest
 */
public class MementoTest {

    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTacker careTacker = new CareTacker();

        originator.setState("2010/10/1 accountMoney-0$");
        // if not add to careTacker originater current state get overriden by another
        // setState
        originator.setState("2012/10/1 accountMoney-100$");
        careTacker.add(originator.saveStateToMemento());

        originator.setState("2014/10/1 accountMoney-500$");
        careTacker.add(originator.saveStateToMemento());

        originator.setState("2018/10/1 accountMoney-1100$");
        careTacker.add(originator.saveStateToMemento());

        System.out.println("Current State " + originator.getState());
        originator.getStateFromMemento(careTacker.get(0));
        System.out.println("First State " + originator.getState());
        originator.getStateFromMemento(careTacker.get(1));
        System.out.println("Second State " + originator.getState());
    }
}