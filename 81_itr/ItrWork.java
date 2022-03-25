//Froghats: Kevin Cheng, Salaj Rijal, Alif Rahman
//APCS pd8
//HW81 -- Thank You, Next -- twerking w/ iterators
//2022-03-24r
//time spent: 1h

/***
 * 
 *  SKELETON
 *  Facilitates familiarization with iterators
 **/

/***
    DISCO:
    - An object that implements Iterator cannot be initialized from a constructor since Iterator is an interface. You have to use a method
    called iterator() that is in all collection classes.
  
    QCC:
    - What exactly is an Iterator? Is it it's own object? How is it related to the collection it is iterating? Modifying it in the removeEvens() 
    method also modifies List<Integer> L.

    SUMMARY THE FIRST:
    all classes that implement the iterator interface must have these method signatures:
    - public boolean hasNext()
    - public Object next()
    - public void remove()

    SUMMARY THE SECOND:
    create methods that find a key in a list of integers, returns list of odd numbers and removes all even numbers in a 
    list. For the ones where we check if a key is in a list, and return a odd number list, we have to create implementations with
    for each as well.

**/


import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ItrWork
{

  //using FOREACH loop
  //returns a boolean to indicate whether key is present in L
  public static boolean foundA( Integer key, List<Integer> L )
  {
    for (Integer i : L) {
        if( i.equals(key) ){
            return true;
        }
    }
    return false;
}

  //explicitly using an iterator
  //returns a boolean to indicate whether key is present in L
  public static boolean foundB( Integer key, List<Integer> L )
  {
    Integer current;
    Iterator<Integer> i = L.iterator();
    while ( i.hasNext() ) {
      current = i.next();
      if (current.equals(key)) {
        return true;
      }
    }
    return false;
  }

  //using FOREACH loop
  //returns a list containing the odd numbers in L
  public static List<Integer> oddsA( List<Integer> L )
  {
    List<Integer> result = new ArrayList<Integer>();
    for( Integer i: L ){
      if( i%2==1 ) result.add(i);
    }
    return result;
  }

  //explicitly using an iterator
  //returns a list containing the odd numbers in L
  public static List<Integer> oddsB( List<Integer> L )
  {
    List<Integer> result = new ArrayList<Integer>();
    Iterator<Integer> i = L.iterator();
    Integer element;
    while ( i.hasNext() ){
      element = i.next();
      if ( element%2==1 ) {
        result.add(element);
      }
    }
    return result;
  }

  //explicitly using an iterator
  //modifies L s.t. it contains no evens
  public static void removeEvens( List<Integer> L )
  {
    Iterator<Integer> itr = L.iterator();
    while( itr.hasNext() ){
      if( itr.next()%2==0 ) itr.remove(); 
    }
  }

  public static void main( String [] args )
  {
    
    //var type: List   obj type: ?
    List<Integer> L = new ArrayList<Integer>();
    for( int i = 0; i < 10; i++ )
    L.add(i);
    
    // TASK: write code to print the contents of L...
    // a) using a FOREACH loop
    for( Integer i: L) System.out.println(i);
    System.out.println();
    // b) explicitly using an iterator
    Iterator<Integer> itr = L.iterator();
    while( itr.hasNext() ){
      System.out.println( itr.next() );
    }

    
    System.out.println("\nTesting foundA...");
    System.out.println("9 in L? -> " + foundA(9,L) );
    System.out.println("13 in L? -> " + foundA(13,L) );
    
    System.out.println("\nTesting foundB...");
    System.out.println("9 in L? -> " + foundB(9,L) );
    System.out.println("13 in L? -> " + foundB(13,L) );
    
    System.out.println("\nTesting oddsA...");
    List<Integer> A = oddsA(L);
    for( int n : A ) System.out.println(n);
    
    System.out.println("\nTesting oddsB...");
    List<Integer> B = oddsB(L);
    for( int n : B ) System.out.println(n);
    
    System.out.println("\nTesting removeEvens...");
    removeEvens(L);
    for( int n : L ) System.out.println(n);
    /*~~~~~~~~~~ ~~~~~m~o~v~e~~m~e~~d~o~w~n~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class ItrWork
