package examples;

public class SimpleSingleton {
	public static final SimpleSingleton INSTANCE = new SimpleSingleton(); 
	private static final String FINALSTRING = "TEST";
	private SimpleSingleton(){}
	public String getTestString(){
		return FINALSTRING;
	}
}
