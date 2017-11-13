package examples;

public enum EnumSingleton {
	INSTANCE;
	private final String test = "Test";
	private EnumSingleton(){
		//Konstruktor 
	}
	public String exampleFunction(){
		return test;
	}
}
