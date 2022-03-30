/***
 * class LatKtS
 * SKELETON
 * driver class for Latkes
 * Uses a stack to reverse a text string, check for sets of matching parens.
 **/
/*

FROGHATS: Salaj Rijal, Kevin Cheng, ALif Rahman
APCS
2022-03-29

DISCO:
- stack is helpful

QCC:
- how can we improve our code?
- how is this useful to us?

*/
public class LatKtS
{

  /***
   * precondition:  input string has length > 0
   * postcondition: returns reversed string s
   *                flip("desserts") -> "stressed"
   **/
  public static String flip( String s )
  {
    Latkes stack = new Latkes(s.length());
    for ( int i = 0; i < s.length(); i++ ) {
      String letter = s.substring( i, i+1 );
      stack.push(letter);
    }
    String reversed = "";
    while( !stack.isEmpty())
      reversed += stack.pop();
    return reversed;
  }


  /***
   * precondition:  s contains only the characters {,},(,),[,]
   * postcondition: allMatched( "({}[()])" )    -> true
   *                allMatched( "([)]" )        -> false
   *                allMatched( "" )            -> true
   **/
   
  public static boolean allMatched( String s )
  {    
    final String open = "{([";
    final String close = "})]";
    Latkes stack = new Latkes( s.length() );
    for( int i = 0; i < s.length(); i++ ){
      //iterate through every character in String s
      String current = s.substring(i,i+1);
      //if open then put in stack
      if( open.indexOf(current) > -1 ) stack.push(current);
      //if closed then check with stack
      else {
        /*
        CHECK 1:
        if the stack is empty and there's a closed bracket on the way,
        then there must be no open bracket in the stack to pair with that closed bracket.
        
        CHECK 2:
        paired brackets have the same index in the two lists of brackets.
        ex. "(" has index 0 in open and ")" has index 0 in close
        if the closed bracket we have pairs with the most recent open bracket (the top bracket in the stack),
        then their indexes in close and open must be the same.
        the most recent open bracket gets popped from the stack after the check to make way for the other brackets.
        */
        if (  stack.isEmpty() 
           || close.indexOf(current) != open.indexOf( stack.pop() ) )
          return false;
      }
    }
    return stack.isEmpty();
  }
  //main method to test
  public static void main( String[] args )
  {
    System.out.println(flip("desserts")); //"stressed"
    System.out.println(allMatched( "({}[()])" )); //true
    System.out.println(allMatched( "([)]" ) ); //false
    System.out.println(allMatched( "(){([])}" ) ); //true
    System.out.println(allMatched( "](){([])}" ) ); //false
    System.out.println(allMatched( "(){([])}(" ) ); //false
    System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
    System.out.println(allMatched("[]")); //true
  }
}//end class
