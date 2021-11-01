public class xyzThere {
	public boolean xyzThere(String str) {
		for (int letter = str.length() - 3; letter >= 0; letter--) {
			String periodCheck;
			if (letter > 0) {
				periodCheck = str.substring(letter - 1, letter);
			} else {
				periodCheck = "";
			if (periodCheck.equals(".") == false) {
				String xyzCheck = str.substring(letter, letter + 3);
				if (xyzCheck.equals("xyz") == true) {
					return true;
				}
			}
		}
		return false;
	}
}
