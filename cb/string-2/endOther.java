public class endOther {
	public boolean endOther(String a, String b) {
		String longStr, shortStr;
		if (a.length() > b.length()) {
			longStr = a;
			shortStr = b;
		} else {
			longStr = b;
			shortStr = a;
		}
		lowLong = longStr.toLowerCase();
		lowShort = shortStr.toLowerCase();
		
		int checkLetters = lowShort.length();
		String longEnd = lowLong.substring(longStr.length() - checkLetters);
		if (longEnd.equals(lowShort) == true) {
			return true;
		}
		return false;
	}
}
