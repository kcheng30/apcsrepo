public class countHi {
	public int countHi(String str) {
	int hiCount = 0;
	for (int letter = str.length() - 2; letter >= 0; letter--) {
		String hiCheck = str.substring(letter, letter + 2);
		if (hiCheck.equals("hi") == true) {
			hiCount++;
			}
		}
	return hiCount;
	}
}
