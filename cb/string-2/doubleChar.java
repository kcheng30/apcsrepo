public class doubleChar {
	public String doubleChar(String str) {
  		String doubledStr = "";
  		for (int letterAt = 0; letterAt <= str.length() - 1; letterAt++) {
    			String doubledLetter = str.substring(letterAt, letterAt + 1);
    			doubledStr += doubledLetter + doubledLetter;
  		}
  	return doubledStr;
	}
}

