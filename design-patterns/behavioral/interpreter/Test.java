// AbstractExpression (Expression): Declares an interpret() operation that all
// nodes (terminal and nonterminal) in the AST overrides.
// TerminalExpression (NumberExpression): Implements the interpret() operation
// for terminal expressions.
// NonterminalExpression (AdditionExpression, SubtractionExpression, and
// MultiplicationExpression): Implementoperations the interpret() operation for
// all nonterminal expressions.
// Context (String): Contains information that is global to the interpreter. It
// is this String expression with the Postfix notation that has to be
// interpreted and parsed.
// Client (ExpressionParser): Builds (or is provided) the AST assembled from
// TerminalExpression and NonTerminalExpression. The Client invokes the
// interpret() operation.
// Expression interface used to 
// check the interpreter. 
interface Expression 
{ 
	boolean interpreter(String con); 
} 

// meka tikak leaf eka wage interpreter lojic eka handle karanne eyta witharai
// TerminalExpression class implementing 
// the above interface. This interpreter 
// just check if the data is same as the 
// interpreter data. 
class TerminalExpression implements Expression 
{ 
	String data; 

	public TerminalExpression(String data) 
	{ 
		this.data = data; 
	} 

	public boolean interpreter(String con) 
	{ 
		if(con.contains(data)) 
		{ 
			return true; 
		} 
		else
		{ 
			return false; 
		} 
	} 
} 

//Me set ekama non terminal ewa mewala interpreter  eka eyage expression okkotama lojic eka denawa
// OrExpression class implementing 
// the above interface. This interpreter 
// just returns the or condition of the 
// data is same as the interpreter data. 
class OrExpression implements Expression 
{ 
	Expression expr1; 
	Expression expr2; 

	public OrExpression(Expression expr1, Expression expr2) 
	{ 
		this.expr1 = expr1; 
		this.expr2 = expr2; 
	} 
	public boolean interpreter(String con) 
	{		 
		return expr1.interpreter(con) || expr2.interpreter(con); 
	} 
} 

// AndExpression class implementing 
// the above interface. This interpreter 
// just returns the And condition of the 
// data is same as the interpreter data. 
class AndExpression implements Expression 
{ 
	Expression expr1; 
	Expression expr2; 

	public AndExpression(Expression expr1, Expression expr2) 
	{ 
		this.expr1 = expr1; 
		this.expr2 = expr2; 
	} 
	public boolean interpreter(String con) 
	{		 
		return expr1.interpreter(con) && expr2.interpreter(con); 
	} 
} 

// Driver class 
class Test 
{ 

	public static void main(String[] args) 
	{ 
		
        Expression n1 = new TerminalExpression("1"); 
        Expression n2 = new TerminalExpression("2"); 
        Expression n3 = new TerminalExpression("3"); 
        Expression n4 = new TerminalExpression("4"); 
        Expression complex=   new AndExpression(new OrExpression(n1,n2),new AndExpression(n3,n4) );
        
        System.out.println(complex.interpreter("134"));
        System.out.println(complex.interpreter("13"));
        System.out.println(complex.interpreter("342"));


        System.out.println("__________________");

        //Make a job qualification lojic
        Expression oLevel= new TerminalExpression("ol");
        Expression aLevel= new TerminalExpression("al");
        Expression bscLevel= new TerminalExpression("bsc");
        Expression mscLevel= new TerminalExpression("msc");


        Expression forClerk= new AndExpression(oLevel,aLevel);
        Expression forSoftwareEngineer= new OrExpression(bscLevel,mscLevel);

        System.out.println("for clerk ");
        System.out.println("jon try 1 "+forClerk.interpreter("ol,al"));
        System.out.println("jon try 2 "+forClerk.interpreter("ol"));

        System.out.println("for software engineer");
        System.out.println("jon try 3 "+forSoftwareEngineer.interpreter("ol,al"));
        System.out.println("jon try 4 "+forSoftwareEngineer.interpreter("bsc"));
        System.out.println("jon try 5 "+forSoftwareEngineer.interpreter("bsc,msc"));
	} 
} 
