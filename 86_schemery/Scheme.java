/***
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Steal underpants.
 *   2. ...
 *   5. Profit!
 *
 * STACK OF CHOICE: LLStack by FROGHATS
 * b/c LLStack is much nicer, also we think our implementation is correct
 **/

public class Scheme
{
  /***
   * precond:  Assumes expr is a valid Scheme (prefix) expression,
   *           with whitespace separating all operators, parens, and 
   *           integer operands.
   * postcond: Returns the simplified value of the expression, as a String
   * eg,
   *           evaluate( "( + 4 3 )" ) -> 7
   *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
   **/
  public static String evaluate( String expr )
  {
    //list of operands that will be useful
    final String operands = " +-*";

    //split out useless spaces
    String[] items = expr.split("\\s+");

    //create the stacks
    Stack<Integer> ops = new LLStack<Integer>();
    Stack<String> others = new LLStack<String>();

    //loop through each item
    for( int i = items.length-1; i >= 0; i-- ){
      String item = items[i];
      //if operand push into ops in its int form
      if (operands.indexOf( item ) > -1) ops.push( operands.indexOf(item) );

      //if it is ), then start evaluating until you reach (, then push that result into others
      else if ( item.equals("(") ) others.push( unload(ops.pop(), others) );

      //if it is neither op or ), just add it to others
      else others.push( item );
    }

    //return the last element
    return others.pop();

  }//end evaluate()

  /***
   * precond:  Assumes top of input stack is a number.
   * postcond: Performs op on nums until closing paren is seen thru peek().
   *           Returns the result of operating on sequence of operands.
   *           Ops: + is 1, - is 2, * is 3
   **/
  public static String unload( int op, Stack<String> numbers )
  {
    //get the latest number
    int result = Integer.parseInt( numbers.pop() );
    
    //check if reached we reached (
    while( !numbers.peekTop().equals( ")" ) ){
      
      //pop latest value
      int current = Integer.parseInt( numbers.pop() );
      
      //calculate depending on operation
      if( op == 1) result+= current;
      if( op == 2) result-= current;
      if( op == 3) result*= current;
    }
  
    //get rid of the (
    numbers.pop();   
    
    //return result as string
    return Integer.toString( result );

  }//end unload()


  
  //optional check-to-see-if-its-a-number helper fxn:
  public static boolean isNumber( String s ) {
  try {
  Integer.parseInt(s);
  return true;
  }
  catch( NumberFormatException e ) {
  return false;
  }
  }



  //main method for testing
  public static void main( String[] args )
  {

    String zoo1 = "( + 4 3 )";
    System.out.println(zoo1);
    System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
    //...7
    
    String zoo2 = "( + 4 ( * 2 5 ) 3 )";
    System.out.println(zoo2);
    System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
    //...17
    
    String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
    System.out.println(zoo3);
    System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
    //...29
    
    String zoo4 = "( * 1 3 5 6 7 5 6 7 8 9 ( - 1 2 3 ) ( - 1 2 3 ) ( - 1 2 3 ) ( - 1 2 3 ) 0 )";
    System.out.println(zoo4);
    System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
    //... 0
    
    String zoo5 = "( + ( * ( - 1 2 3 4 5 6 7 8 9 10 ) 1 3 5 6 0 ) 60 9 )";
    System.out.println(zoo5);
    System.out.println("zoo5 eval'd: " + evaluate(zoo5) );
    //...-69
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
    ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }//main()

}//end class Scheme
