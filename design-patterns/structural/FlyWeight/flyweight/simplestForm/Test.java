
public class Test {
    public static void main(String[] args) {
        
        String text = "10 + 6 - 3";
        Number n1 = new Number(10);
        Number n2 = new Number(6);
        Number n3 = new Number(3);
        
        Plus p1 = new Plus(n1, n2);
        Minus m1 = new Minus(p1, n3);
        int ans = m1.interpret();
        System.out.println(ans);
    }
}

interface Expression{
   
    int interpret();
}
class Plus implements Expression{ 
    Expression e1;
    Expression e2;

    public Plus(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }
    
    @Override
    public int interpret() {
        return e1.interpret()+e2.interpret(); 
    }
}

class Minus implements Expression{
    Expression e1;
    Expression e2;

    public Minus(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }
    
    @Override
    public int interpret() {
        return e1.interpret()-e2.interpret();
    }
}

class Number implements Expression{

    private int number;

    public Number(int number) {
        this.number = number;
    }
    
    @Override
    public int interpret() {
        return this.number; 
    }
}