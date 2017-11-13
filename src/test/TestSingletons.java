package test;

import org.junit.Test;
import static org.junit.Assert.*;

import examples.EnumSingleton;
import examples.NoTimeProblemSingleton;
import examples.SimpleSingleton;
import examples.StandardSingleton;

public class TestSingletons {
	
	@Test
	public void testStandardSingleton() {
		String test = StandardSingleton.exampleFunktion();
		// ist der String korrekt Aufruftest
		assertTrue(test.equals("So einfach ist das!"));
		// auf gleichheit Testen 2 mal die selbe Instance ist Muss
		StandardSingleton s1 = StandardSingleton.getInstance();
		StandardSingleton s2 = StandardSingleton.getInstance();
		assertTrue(s1 == s2);
	}

	
	
	private static NoTimeProblemSingleton timeSingleton = null;
	@Test
	public void testTimeDelaySingleton() throws InterruptedException {
		// Nun lassen wir das Programm in mehereren Threads laufen (Nebenläufigkeit)
		Thread t1 = new Thread(new SingletonThreadTest());
		Thread t2 = new Thread(new SingletonThreadTest());
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}

	private static class SingletonThreadTest implements Runnable {
		public void run() {
			NoTimeProblemSingleton singleton = NoTimeProblemSingleton.getInstance();
			synchronized (NoTimeProblemSingleton.class) {
				if (timeSingleton == null) 
					timeSingleton = singleton; 
			}
			assertTrue(singleton == timeSingleton);
		}
	}
	
	@Test
	public void testSimpleSingleton() throws InterruptedException {
		String test = SimpleSingleton.INSTANCE.getTestString();
		assertTrue(test.equals("TEST"));
	}
	
	@Test
	public void testEnumSingleton(){
		String test = EnumSingleton.INSTANCE.exampleFunction();
		assertTrue(test.equals("Test"));
	}
}
