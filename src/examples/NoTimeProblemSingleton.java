package examples;

public class NoTimeProblemSingleton {
	private static NoTimeProblemSingleton instance = null;

	private NoTimeProblemSingleton() {
	}
	private static boolean first = true;
	
	public static synchronized  NoTimeProblemSingleton getInstance() {
		if (instance == null) {
			timeDelayFunction();
			instance = new NoTimeProblemSingleton();
		}
		return instance;
	}
	private static void timeDelayFunction() {
		try {
			if (first) {
				first = false;
				Thread.currentThread();
				// Verzögerung von 50 Millisekunden
				Thread.sleep(50);
			}
		} catch (InterruptedException ex) {
			System.out.println("Thread beendet");
		}
	}
}
