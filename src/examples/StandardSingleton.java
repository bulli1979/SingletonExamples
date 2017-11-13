package examples;
public class StandardSingleton {
	private static StandardSingleton instance = null;
	private static final String TEXT = "So einfach ist das!";
	private StandardSingleton(){}
	public static StandardSingleton getInstance(){
		if(instance == null){
			instance = new StandardSingleton();
			//hier können noch einmalige Aktionen beim Erstellen ausgeführt werden. 
		}
		return instance;
	}
	public static String exampleFunktion(){
		return TEXT;
	}
}
