// Expression interface used to 
// check the interpreter. 
interface Expression 
{ 
	boolean interpreter(String con); 
} 

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
		Expression firstName = new TerminalExpression("nishi"); 
		Expression lastName = new TerminalExpression("baby"); 
		Expression fullName = new AndExpression(firstName, lastName); 
		
		Expression fName = new TerminalExpression("ishan"); 
		Expression lName = new TerminalExpression("vimukthi"); 
        Expression fnameOrlname = new OrExpression(fName, lName);	 
        
        Expression n1 = new TerminalExpression("1"); 
        Expression n2 = new TerminalExpression("2"); 
        Expression n3 = new TerminalExpression("3"); 
        Expression n4 = new TerminalExpression("4"); 
        Expression complex=   new AndExpression(new OrExpression(n1,n2),new AndExpression(n3,n4) );
        

		System.out.println(fullName.interpreter("nishi")); 
		System.out.println(fullName.interpreter("baby")); 
		System.out.println(fullName.interpreter("nishibaby")); 
		
		System.out.println(fnameOrlname.interpreter("ishan")); 
		System.out.println(fnameOrlname.interpreter("rox")); 
        System.out.println(fnameOrlname.interpreter("vimukthi")); 
       
        System.out.println("____________");
        System.out.println(complex.interpreter("134"));
        System.out.println(complex.interpreter("13"));
        System.out.println(complex.interpreter("342"));

	} 
} 
