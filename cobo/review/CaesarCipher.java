/* Activity 5
 * 
 * A Caesar Cipher takes a message, and shifts every letter in the same amount. For example, "holy"
 * shifted 23 gives a message of "eliv" after moving every letter down 23 spaces.
 *
 * 1.
 * We chose to implement this because it's not too hard and the concept is similar to finding sentiment
 * values for every word. 
 *
 * 2.
 * The main problem in this program is finding what letter to replace the old letter. We got the idea to
 * put the alphabet into a string, and using indexOf to find the "numerical value" of every letter in the
 * initial message (a -> 1, b -> 2... ). To allow capitalized letter to also get shifted, we made a second
 * string with all the capital letters and combined that with the LetterNumber because the letters would
 * maintain the same numerical value.
 *
 * 3.
 * public static String
 * There needed to be a message and the change to that message, which is a string and an int required as
 * parameters. The method needs to be static to work with the main method.
 */

public class CaesarCipher {

	final static String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	final static String CAPSALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	
	public static String encrypt ( String message, int shift ) {
		String encrypted = "";
		for ( int i = 0; i < message.length(); i++ ) {
			String letter = message.substring( i, i + 1 );
			//If the letter is lowercase, CAPSALPHABET.indexOf( letter ) will be -1 regardless
			//of the letter and vice versa.
			int LetterNumber = ALPHABET.indexOf( letter ) + CAPSALPHABET.indexOf( letter ) + 1;
			//If the numerical value and the shift sum to greater than 26, it must be reduced
			//in order to take the substring from ALPHABET.
			int NewLetterNumber = ( LetterNumber + shift ) % 26;
			//CAPSALPHABET.indexOf( letter ) == -1 tells if the letter is capitalized or not,
			//which allows us to replace it accordingly. 
			if ( LetterNumber != -1 && CAPSALPHABET.indexOf( letter ) == -1 )
				encrypted += ALPHABET.substring( NewLetterNumber, NewLetterNumber + 1 );
			else if ( LetterNumber != -1 )
				encrypted += CAPSALPHABET.substring( NewLetterNumber, NewLetterNumber + 1 );
			//For when the character isn't alphabetical
			else
				encrypted += letter;
		}
		return encrypted;
	}
	
	public static void main( String[] args ) {
		String message = "hOlY, HoLy";
		System.out.println( encrypt( message, 23 ) );
		System.out.println( "Should return eLiV, ElIv" );
	}
}
