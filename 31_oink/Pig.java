/*
 * Team Frog Hats -- Kevin Cheng, Marcus Wu, Neil Lin
 * APCS
 * HW31 -- Otnay Ybay ethay Airhay Onway Ymay Inneechay Inchay Inchay
 * 2021-11-9
 *
 * DISCO: 
 * A recursion format that works for these kinds of methods
 *
 * QCC:
 * How are these going to be used in a pig latin translator?
 * What extra rules are going to be in the pig latin translator that aren't accounted for with these methods?
 */


public class Pig {
	private static final String vowels = "aeiou";

	public static boolean hasA(String w, String letter) {
		if (w.length() > 0) {
			if (w.substring(0,1).equals(letter) == true) {
				return true;
			}
			return hasA(w.substring(1), letter);
		}
	return false;
	}

	public static boolean isAVowel(String letter) {
		if (hasA(vowels, letter) == true) {
			return true;
		}
		return false;
	}

	public static int countVowels(String w) {
		int vowelCount = 0;
		if (w.length() > 0) {
			String wFirst = w.substring(0,1);
			if (isAVowel(wFirst) == true) {
				vowelCount++;
			}
			vowelCount += countVowels(w.substring(1));
		}
		return vowelCount;
	}

	public static boolean hasAVowel(String w) {
		if (w.length() > 0) {
			String wFirst = w.substring(0,1);
			if (isAVowel(wFirst) == true) {
				return true;
			}
			return hasAVowel(w.substring(1));
		}
		return false;
	}

	public static String allVowels(String w) {
		String vowelList = "";
		if (w.length() > 0) {
			String wFirst = w.substring(0,1);
			if (isAVowel(wFirst) == true) {
				vowelList += wFirst;
			}
			vowelList += allVowels(w.substring(1));
		}
		return vowelList;
	}

	public static void main(String[] args) {
		System.out.println(hasA("scrumptious", "t"));
		System.out.println(isAVowel("v"));
		System.out.println(countVowels("toomany"));
		System.out.println(hasAVowel("cnsjd"));
		System.out.println(allVowels("toomanyand3extra"));
		System.out.println("\nShould return true, false, 2, false, ooaaea");
	}
}
