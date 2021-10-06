public class Greet {

	public static void main( String[] args ) {
		String greeting;

		BigSib richard = new BigSib();
		richard.setHelloMsg("Word up");
		greeting = richard.greet("freshman");
		System.out.println(greeting);

		BigSib samuel = new BigSib();
		samuel.setHelloMsg("Salutations");
		System.out.println(samuel.greet("Dr. Spaceman"));

		BigSib james = new BigSib();
		james.setHelloMsg("Hey ya");
		System.out.println(james.greet("Kong Fooey"));

		BigSib ying = new BigSib();
		ying.setHelloMsg("Sup");
		System.out.println(ying.greet("mom"));
	}
}
