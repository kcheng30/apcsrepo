/***
 * class ListTester
 * ...for putting your LList through its paces
 *
 * Assumes local List.java (interface),
 *  overriding List interface from standard Java library
 **/

public class ListTester
{
  public static void main( String[] args )
  {

    //instantiate... var type List, obj type LList
    List<Integer> wu = new LList<Integer>();

    System.out.println(wu);
    wu.add( 10 );

    System.out.println(wu);
    wu.add( 11);

    System.out.println(wu);
    wu.add( 12 );

    System.out.println(wu);
    wu.add( 13);

    System.out.println(wu);
    wu.add( 16 );

    System.out.println(wu);
    wu.add( 17 );

    System.out.println(wu);
    wu.add( 18 );

    System.out.println(wu);
    wu.add( 19 );

    System.out.println(wu);

    for( int i=0; i<7; i++ ) {
      int n = (int)( wu.size() * Math.random() );
      Integer imposter = 69;
      System.out.println("adding imposter at index " + n + "...");
      wu.add( n, imposter );
      System.out.println("Updated list: " + wu);
    }

    while( wu.size() > 0 ) {
      int n = (int)( wu.size() * Math.random() );
      System.out.println("deleting node "+ n + "...");
      wu.remove(n);
      System.out.println("Updated list: " + wu);
    }
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class
