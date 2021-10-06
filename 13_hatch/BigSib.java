/*
Kevin Cheng
APCS
HW13 - Where do BigSibs Come From?
2021-10-06

DISCO
What a constructor is
You can have things work without labeling them as static

QCC
What are the alternatives to static, and what do all of them do?
What purposes do constructors serve?
Why can't they have a return value?
Why must they be public?
*/

public class BigSib {
	
	String helloMsg;

	public BigSib() {
		helloMsg = "Word up";
	}
	
	public String setHelloMsg(String s) {
		return helloMsg = s;
	}
	
	public String greet(String address) {
		return helloMsg + " " + address;
	}
}
