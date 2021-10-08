/*
Kevin Cheng + Frog Hat
APCS
HW14 - Customize Your Creation
2021-10-07

DISCO
All static variables can only interact with static methods in an instance.
The default state is for variables and methods to be non-static, or to only be callable in an instance of the class.

QCC
How are we supposed to differentiate between the various instances of BigSib that don't have any arguments?
Why are constructors better than normal methods in some cases?
*/

public class BigSib {
	
	String helloMsg;

	public BigSib() {
		helloMsg = "Word up";
	}
	// How are we supposed to differentiate between the various instances of BigSib that don't have any arguments?

	public String greet(String address) {
		return helloMsg + " " + address;
	}
}	
