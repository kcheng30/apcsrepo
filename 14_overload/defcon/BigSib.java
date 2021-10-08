public class BigSib {
	
	String helloMsg;

	public BigSib() {
		helloMsg = "defaultConstructorMessage";
	}

	public BigSib(String s) {
		helloMsg = s;
	}

	public String greet(String address) {
		return helloMsg + " " + address;
	}
}
