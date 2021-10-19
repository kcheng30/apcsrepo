public class Teller {

	public static void main(String[] args) {

		BankAccount harrison = new BankAccount();

		harrison.setFullName("Harrison Gore");
		harrison.setPassword("pencilfacedpendexter");
		harrison.setPin(1);
		harrison.setAccNumber(1);

		//If we don't set a pin, the pin will automatically be set to 9999
		//Likewise for the account number
		
		
