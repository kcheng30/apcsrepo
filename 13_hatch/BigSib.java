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
