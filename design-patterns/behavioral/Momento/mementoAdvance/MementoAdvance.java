import java.util.ArrayList;
import java.util.Stack;

/**
 * MementoAdvance
 */
public class MementoAdvance {
    public static void main(String[] args) {
        System.out.println("hello");

        CareTaker careTaker = new CareTaker();
        Cart cart = new Cart();

        cart.addItem(new Item("Book"));
        cart.addItem(new Item("pen"));

        careTaker.save(cart);
        System.out.println(cart);
        System.out.println();
        cart.addItem(new Item("pencil"));
        careTaker.save(cart);
        System.out.println(cart);
        System.out.println();

        cart.addItem(new Item("Phone"));
        careTaker.save(cart);
        System.out.println(cart);
        System.out.println();

        cart.addItem(new Item("NoteBook"));
        careTaker.save(cart);
        System.out.println(cart);

    }
}

// Care tacker that means CartHistory
class CareTaker {
    Stack<Cart.CartMemento> history = new Stack<>();

    public void save(Cart cart) {
        // In history ArrayList we are saving CartMementos but we give
        // a cart so for it we getting CartMemento
        history.push(cart.save());
    }

    public void revert(Cart cart) {
        // get the last element from history and set to Current Cart
        //stack is like Pringles potato chips thstss why u get same saved one when revert
        if (!history.empty())
            cart.revert(history.pop());
        else
            System.out.println("Cant undo");

    }
}

/**
 *  
 */
// Originator That means Current Cart
class Cart {

    ArrayList<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    // give entirely new copy of the ArrayList
    public ArrayList<Item> getItems() {
        return (ArrayList) items.clone();
    }

    // Get CartMemento actually its a copy of current Cart
    public CartMemento save() {
        return new CartMemento(getItems());
    }

    // revert Changes of CartMemento
    public void revert(CartMemento cartMemento) {
        this.items = cartMemento.gItems();
    }

    @Override
    public String toString() {
        return "Cart items list " + items;
    }

    // Make Innner class so CartMemento can only be acces with Cart
    static class CartMemento {
        private ArrayList<Item> items;

        public CartMemento(ArrayList<Item> items) {
            this.items = items;
        }

        private ArrayList<Item> gItems() {
            return items;
        }
    }

}

// Items Used By Cart These items list is the state of cart
class Item {
    String itemName;

    Item(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "This is " + this.itemName;
    }
}