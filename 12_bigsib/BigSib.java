public class BigSib {

	static String helloMsg;

	public static String setHelloMsg(String s) {
		return helloMsg = s;
	}

	public static String greet(String s) {
		return helloMsg + " " + s;
	}
}
