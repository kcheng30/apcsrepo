public class Driver {
	public static void main(String[] args) {
		Coin mine = new Coin();
		Coin yours = new Coin("quarter");
		Coin wayne = new Coin("dollar");

		System.out.println("mine: " + mine.name + " -- " + mine.upFace);
		System.out.println("yours: " + yours.name + " -- " + yours.upFace);
		System.out.println("wayne: " + wayne.name + " -- " + wayne.upFace);
		
		System.out.println("\nBegin flipping");

		System.out.print("mine: ");
		mine.flip();
		System.out.print("yours: ");
		yours.flip();
		System.out.print("wayne: ");
		wayne.flip();
		
		System.out.println("\nComparing mine");

		mine.equals();
	}
}
