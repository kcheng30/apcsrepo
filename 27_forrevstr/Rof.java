/**
Kermit the Duck | Faiza Huda, Kevin Cheng, Kartik Vanjani, Frog Hat, Truthful Tom, Krrish
APCS
HW27 -- FOR the Love of Strings
2021-10-28
time spent: 0.5 hr
DISCO:
 - string.charAt() is the java method for string indexing
 - string.substring(a,b) doesnt include string[a] but it includes string[b]
QCC: 
 - Can we initialize 2 variables at once in the first section of the For loop?
**/

public class Rof {

	public static String fenceF(int posts){
		String result = "|";
		for (int i = 1; i <= posts; i++) {
			result += "--|";
		}
		return result;
	}

	public static String reverseF(String s) {
                String reverseS = "";
                for (int letterAt = s.length() - 1; letterAt >= 0; letterAt--) {
                        char letter = s.charAt(letterAt);
                        reverseS += letter;
                }
                return reverseS;
	}

	public static String reverseR(String s) {
                String reverseS = "";
                int letterAt = s.length() - 1;
                if (letterAt >= 0) {
                        char letter = s.charAt(letterAt);
                        String reducedString = s.substring(0, letterAt);
                        reverseS = letter + reverseR(reducedString);
                }
                return reverseS;
        }

	public static void main( String[] args){
		//Test for fenceF
		System.out.println(fenceF(1));
		System.out.println(fenceF(3));
		System.out.println(fenceF(5));

		System.out.println();

		//Test for reverseF
		System.out.println(reverseF("your mother"));
		System.out.println(reverseF("no u"));
		System.out.println(reverseF("rats are star"));

		System.out.println();

                //Test for reverseR
                System.out.println(reverseR("your mother"));
                System.out.println(reverseR("no u"));
                System.out.println(reverseR("rats are star"));
	}
}
