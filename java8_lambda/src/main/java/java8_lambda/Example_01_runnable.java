package java8_lambda;



public class Example_01_runnable {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out
						.println("Before Java8, too much code for too little to do");
			}
		}).start();
		// Java 8 way:
		new Thread(
				() -> System.out
						.println("In Java8, Lambda expression rocks !!"))
				.start();
		
		
		Runnable r =() -> System.out.println("Hello Lambda Expressions");
		
		
	}
}
