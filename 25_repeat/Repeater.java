/*
 * Kevin Cheng
 * APCS
 * HW25 -- Do I Repeat Myself?
 * 26-10-2021
 * Time Spent: 38 minutes
 * 
 * DISCO:
 * Instance variables are awful for recursion
 * In recusrion, the base case must be added first then built on 
 *
 * QCC:
 * What are the advantages of recusion over while loops?
 */

public class Repeater {
	public static String fenceW(int numPosts) {
		String fence = "|";
		while (numPosts > 1) {
			fence += "--|";
			numPosts--;
		}
		return fence;
	}

	public static String fenceR(int numPosts) {
		String fence = "";
		if (numPosts > 1) {
			fence += fenceR(numPosts - 1) + "--|";
		} else {
			fence += "|";
		}
		return fence;
	}

	public static void main(String[] args) {
		System.out.println(fenceW(1) + "\n" + fenceW(2));
		System.out.println(fenceR(1) + "\n" + fenceR(2) + "\n" + fenceR(4));
	}
}
