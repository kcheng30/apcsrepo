public class catDog {
	public boolean catDog(String str) {
	int matchCount = 0;
	for (int letter = str.length() - 3; letter >= 0; letter--) {
		String catDogCheck = str.substring(letter, letter + 3);
		if (catDogCheck.equals("cat") == true) {
			matchCount++;
		} else if (catDogCheck.equals("dog") == true) {
			matchCount--;
		}
	}
	if (matchCount == 0) {
		return true;
	} else {
		return false;
	}
}
