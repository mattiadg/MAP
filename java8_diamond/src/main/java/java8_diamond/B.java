package java8_diamond;

public interface B extends A {
	
	default public void ciao() {System.out.println("ciao");};
}
