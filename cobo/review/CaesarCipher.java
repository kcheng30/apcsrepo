public class CaesarCipher {

	final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	final String CAPSALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static String encrypt ( String message, int shift ) {
		String encrypted = "";
		for ( int i = 0; i < message.length(); i++ ) {
			String letter = message.substring( i, i + 1 );
			int LetterNumber = ALPHABET.indexOf( letter ) + CAPSALPHABET.indexOf( letter ) + 1;
			int NewLetterNumber = ( LetterNumber + shift ) % 26;
			if ( LetterNumber != -1 && CAPSALPHABET.indexOf( letter ) == -1 )
				encrypted += ALPHABET.substring( NewLetterNumber, NewLetterNumber + 1 );
			else if ( LetterNumber != -1 )
				encrypted += CAPSALPHABET.substring( NewLetterNumber, NewLetterNumber + 1 );
			else
				encrypted += letter;
		}
		return encrypted;
	}
}
