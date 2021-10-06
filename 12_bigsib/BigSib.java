/*
Kevin Cheng
APCS
HW12 - On Elder Individuality and the Elimination of Radio Fuzz
2021-10-05

DISCO
Variables can also have a static descriptor.

QCC
What does BigSib <name> = new BigSib(); do?
Why does it matter that the instance variable is static?
*/

public class BigSib {

	static String helloMsg;

	public static String setHelloMsg(String s) {
		return helloMsg = s;
	}

	public static String greet(String s) {
		return helloMsg + " " + s;
	}
}
