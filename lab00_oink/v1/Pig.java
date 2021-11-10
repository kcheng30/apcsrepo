import java.util.Scanner;

/*
 * Team Frog Hats -- Ziying Jian, Abdullah Faruque, Kevin Cheng
 * APCS
 * L00 -- v0
 * 2021-11-08
 * time spent: 1 hr
 *
 * DISCO:
 * If the return type is boolean, you can return the boolean expression.
 * How to have the scanner check for a next line and use that next line. 
 *
 * QCC:
 * Is the Scanner method implemented in Pig.java or a new class file?
 * How are we supposed to read in.words from the file directly without copying it into the command line?
 * 
 * HOW WE UTILIZED SCANNER DEMO (v1)
 * If the program is capable of reading another line of text from the command line,
 * while (in.hasNext())
 * Then the program will print the text converted into pig latin.
 * System.out.println(engToPig(in.next()))
 * 
 * NEW IN V1:
 * A rudimentary pig latin translator that takes no special scenarios into account.
 * Input from the command line.
 */

public class Pig
{
    //Q: How does this initialization make your life easier?
    //A: Since the variable, VOWELS, has already been initialized outside of the methods, you can just directly refer to the variable in the methods.
    private static final String VOWELS = "aeiouyAEIOUY";
    private static final String CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String PUNCS = ".,:;!?";


    /*=====================================
      boolean hasA(String,String) -- checks for a letter in a String
      pre:  w != null, letter.length() == 1
      post: hasA("cat", "a") -> true
      hasA("cat", "p")       -> false
      =====================================*/
    public static boolean hasA( String w, String letter )
    {
        for(int i = 0; i < w.length()-1; i++){
            if ( w.substring(i, i+1).equals(letter) ){
                return true;
            }
        } return false;
    }//end hasA()


    /*=====================================
      boolean isAVowel(String) -- tells whether a letter is a vowel
      precondition: letter.length() == 1
      =====================================*/
    public static boolean isAVowel( String letter ) {
        return VOWELS.indexOf( letter ) != -1;
    }


    /*=====================================
      int countVowels(String) -- counts vowels in a String
      pre:  w != null
      post: countVowels("meatball") -> 3
      =====================================*/
    public static int countVowels( String w ) {
        return allVowels(w).length();
    }


    /*=====================================
      boolean hasAVowel(String) -- tells whether a String has a vowel
      pre:  w != null
      post: hasAVowel("cat") -> true
      hasAVowel("zzz")       -> false
      =====================================*/
    public static boolean hasAVowel( String w ) {
        return countVowels(w) > 0;
    }

    /*=====================================
      String allVowels(String) -- returns vowels in a String
      pre:  w != null
      post: allVowels("meatball") -> "eaa"
      =====================================*/
    public static String allVowels( String w )
    {
        String vowelStorage = "";
        for (int i = 0; i < w.length() - 1; i++){
            if ( isAVowel(w.substring(i, i+1)) ){
                vowelStorage += w.substring(i,i+1);
            }
        } return vowelStorage;
    }

    /*
     * String firstVowel(String) -- returns first vowel in a String
     * pre:  w != null
     * post: firstVowel("") --> ""
     * firstVowel("zzz") --> ""
     * firstVowel("meatball") --> "e"
     */
    public static String firstVowel( String w ) {

        String ans = "";

        if ( hasAVowel(w) ) //Q: Why this necessary?
            //
            ans = allVowels(w).substring(0,1);

        return ans;
    }

    /*
     * boolean beginsWithVowel(String) -- tells whether a String begins with a vowel
     * pre:  w != null and w.length() > 0
     * post: beginsWithVowel("apple")  --> true
     * beginsWithVowel("strong") --> false
     */
    public static boolean beginsWithVowel( String w ) {
        return isAVowel( w.substring(0,1) );
    }

    /*=====================================
      boolean isPunc(String) -- tells whether a character is punctuation
      pre:  symbol.length() == 1
      post: isPunc(".") -> true
            isPunc("b") -> false
      =====================================*/
    public static boolean isPunc( String symbol ) {
        return PUNCS.indexOf( symbol ) != -1;
    }


    /*=====================================
      boolean isUpperCase(String) -- tells whether a letter is uppercase
      pre:  letter.length() == 1
      post: isUpperCase("a") -> false
            isUpperCase("A") -> true
      =====================================*/
    public static boolean isUpperCase( String letter ) {
        return CAPS.indexOf(letter) != -1;
    }

  /*=====================================
      boolean hasPunc(String) -- tells whether a String contains punctuation
      pre:  w != null
      post: hasPunc("cat.") -> true
            hasPunc("cat") -> false
      =====================================*/

    public static boolean hasPunc( String w ) {
        for (int i = 0; i<w.length();i++) {
	    boolean test = isPunc(w.substring(i, i+1));
            if (test) {
                return test;
            }
        }
        return false;
    }

    /*=====================================
      boolean beginsWithUpper(String) -- tells whether 1st letter is uppercase
      pre:  w != null and w.length() > 0
      post: beginsWithUpper("Apple") -> true
            beginsWithUpper("apple") -> false
      =====================================*/
    public static boolean beginsWithUpper( String w ) {
        return isUpperCase(w.substring(0,1) );
    }

    /*
     * String engToPig(String) -- converts an English word to Pig Latin
     * pre:  w.length() > 0
     * post: engToPig("apple")  --> "appleway"
     * engToPig("strong") --> "ongstray"
     * engToPig("java")   --> "avajay"
     */
    public static String engToPig( String w ) {

        String ans = "";

        if ( beginsWithVowel(w) )
            ans = w + "way";

	else {
            int vPos = w.indexOf( firstVowel(w) );
            ans = w.substring(vPos) + w.substring(0,vPos) + "ay";
        }

        return ans;
    }

    public static void main(String[] args) {

	    Scanner in = new Scanner(System.in);
	    while (in.hasNext()) {
		    System.out.println(engToPig(in.next()));
	    }

//        System.out.println(isPunc(".")); /* TRUE */
//        System.out.println(isPunc("b")); /* FALSE */
//
//        System.out.println(isUpperCase("a"));/* FALSE */
//        System.out.println(isUpperCase("A")); /* TRUE */
//
//        System.out.println(hasPunc("cat.")); /* TRUE */
//        System.out.println(hasPunc("cat"));/* FALSE */
//
//        System.out.println(beginsWithUpper("Apple")); /* TRUE */
//        System.out.println(beginsWithUpper("apple"));/* FALSE */
//
//        System.out.println(hasA("cat", "p") + "...should be false");
//        System.out.println(hasA("applesauce scruffy krrish", "p") + "...should be true");
//
//        System.out.println(isAVowel("a") + "...should be true");
//        System.out.println(isAVowel("p") + "...should be false");
//
//        System.out.println(countVowels("meatball") + "...should be 3");
//        System.out.println(countVowels("many vowels here") + "...should be 5");
//
//        System.out.println(hasAVowel("meatball") + "...should be true");
//        System.out.println(hasAVowel("bcd") + "...should be false");
//
//        System.out.println(allVowels("meatball") + "...should be eaa");
//        System.out.println(allVowels("PIG LATIN") + "...should be IAI");

        System.out.println(engToPig("cat") + "...should be atcay");
        System.out.println(engToPig("apple") + "...should be appleway");
    }//end main()

}//end class Pig
