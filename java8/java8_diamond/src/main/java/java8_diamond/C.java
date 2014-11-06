package java8_diamond;

public interface C extends A {
	
	default public void ciao() {System.out.println("hello");};
}
