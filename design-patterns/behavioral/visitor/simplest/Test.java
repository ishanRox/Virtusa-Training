import java.util.ArrayList;
import java.util.List;

//store for all the different element types
interface Visitor {
    int visit(A a);

    int visit(B b);
}

interface Element {
    int accept(Visitor v);
}

// element types
class A implements Element {

    // accept method accepting a visitor class like x which
    // implement visit method for different types of elements types like A,B
    public int accept(Visitor v) {

        return v.visit(this);
    }

}

class B implements Element {
    public int accept(Visitor v) {

        return v.visit(this);
    }

}

class X implements Visitor {
    public int visit(A a) {
        return 10;
    }

    public int visit(B a) {
        return 20;
    }

}

/**
 * Test
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("hello");
        List<Element> list = new ArrayList<>();

        list.add(new A());
        list.add(new B());
        int total = 0;
        for (Element element : list) {
            total += element.accept(new X());
        }

        System.out.println(total);
    }

}

      
            
           

    
    
        
        
    