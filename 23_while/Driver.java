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

                System.out.println("\nLooping");
                mine.headsLimit();
                mine.matchLimit();
                mine.matchYears();
        }

	public static void untilHead(int threshold) {
		int headCount;
		while (headCount < threshold) {
			yours.flip();
			if (yours.upFace == "heads") {
				headCount++;
			}
		}
	}

	public static void untilMatch(int threshold) {
		int matchCount;
		while (matchCount < threshold) {
			yours.equal();
}
