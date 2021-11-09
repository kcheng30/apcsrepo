import java.util.Scanner;

public class Pig
{
   private static final String VOWELS = "aeiouAEIOU";
    private static final String CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String PUNCS = ".,:;!?";


   public static boolean hasA( String w, String letter )
    {
        for(int i = 0; i < w.length()-1; i++){
            if ( w.substring(i, i+1).equals(letter) ){
                return true;
            }
        } return false;
    }//end hasA()


   public static boolean isAVowel( String letter ) {
        return VOWELS.indexOf( letter ) != -1;
    }


   public static int countVowels( String w ) {
        return allVowels(w).length();
    }


   public static boolean hasAVowel( String w ) {
        return countVowels(w) > 0;
    }

   public static String allVowels( String w )
    {
        String vowelStorage = "";
        for (int i = 0; i < w.length() - 1; i++){
            if ( isAVowel(w.substring(i, i+1)) ){
                vowelStorage += w.substring(i,i+1);
            }
        } return vowelStorage;
    }

   public static String firstVowel( String w ) {
        String ans = "";
        if (hasAVowel(w)) ans = allVowels(w).substring(0,1);
        return ans;
   }

   public static boolean beginsWithVowel( String w ) {
        return isAVowel( w.substring(0,1) );
    }

   public static boolean isPunc( String symbol ) {
        return PUNCS.indexOf( symbol ) != -1;
    }

   public static boolean isUpperCase( String letter ) {
        return CAPS.indexOf(letter) != -1;
    }

    public static boolean hasPunc( String w ) {
        for (int i = 0; i<w.length();i++) {
	    boolean test = isPunc(w.substring(i, i+1));
            if (test) {
                return test;
            }
        }
        return false;
    }

       public static boolean beginsWithUpper( String w ) {
        return isUpperCase(w.substring(0,1) );
    }

       public static String engToPig( String w ) {

        String ans = "";

        if ( beginsWithVowel(w) || ((w.substring(0,1).equals("y") || w.substring(0,1).equals("Y")) && w.substring(1,2).indexOf(VOWELS) != -1))
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
