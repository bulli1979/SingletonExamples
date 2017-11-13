package examples;

public class TimeProblemSingleton {
	private static TimeProblemSingleton instance = null;

	private TimeProblemSingleton() {
	}
	private static boolean first = true;
	public static TimeProblemSingleton getInstance() {
		if (instance == null) {
			timeDelayFunction();
			instance = new TimeProblemSingleton();
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
