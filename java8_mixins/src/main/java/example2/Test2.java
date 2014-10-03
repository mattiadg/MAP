package example2;


public class Test2 {
	static X makeX() { return()-> { System.out.println("X"); }; }
	
	
	public static void main (String[] args)
	
	{
		
		 
	    X x1 = makeX();
	    X x2 = makeX();
	    x1.setName("x1");
	    x2.setName("x2");
	 
	    System.out.println(x1.getName());
	    System.out.println(x2.getName());
	}
}
