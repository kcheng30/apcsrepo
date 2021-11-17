
/*
Oscar Breen
APCS
HW24 -- Get It While You Can -- while loop to add limita
2021-10-25
time spent: 1 hr
DISCO --- tails count is irrelevent 
QCC -- purpose of number being 65536? 
Other uses of java.util.Random? 
Typed user input next?
POST-v0 MODS -- added counter and the reset method 
*/

public class Driver {
	static Coin mine = new Coin();
	static Coin yours = new Coin("quarter");
	static Coin wayne = new Coin("dollar");

        public static void main(String[] args) {
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
                mine.equals(yours);

                System.out.println("\nLooping for 4 heads");
		untilHead(4);
		System.out.println("\nLooping for 3 matches");
		untilMatch(3);
		//System.out.println("\nLooping for 65536+ matches");
		//untilMatchYear();
        }

	public static void untilHead(int threshold) {
		int headCount = 0;
		while (headCount < threshold) {
			yours.flip();
			if (yours.upFace == "heads") {
				headCount++;
			}
		}
	}

	public static void untilMatch(int threshold) {
		int matchCount = 0;
		while (matchCount < threshold) {
			yours.flip();
			wayne.flip();
			yours.equals(wayne);
			if (wayne.upFace == yours.upFace) {
				matchCount++;
			}
		}
	}

	public static void untilMatchYear() {
		int matchCount = 0;
		while (matchCount < 65536 || matchCount % 2005 != 0) {
			yours.flip();
			wayne.flip();
			yours.equals(wayne);
			if (wayne.upFace == yours.upFace) {
				matchCount++;
			}
		}
	}
}
