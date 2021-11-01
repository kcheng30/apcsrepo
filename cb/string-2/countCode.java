public class countCode {
	public int countCode(String str) {
		int codeCount = 0;
		for (int letter = str.length() - 4; letter >= 0; letter--) {
			String codeCheck1 = str.substring(letter, letter + 2);
			String codeCheck2 = str.substring(letter + 3, letter + 4);
			if (codeCheck1.equals("co") == true && codeCheck2.equals("e") == true) {
				codeCount++;
			}
		}
		return codeCount;
	}
}
