//FROGHATS: Salaj Rijal, Kevin Cheng, Alif Rahman
//APCS pd0
//HW88 -- BPC Kiddies Do Not Wait in Line Either
//2022-04-04m
//time spent: 1h

/***
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 **/

public class LLNode<T>
{
  //instance vars
  private T _cargo;
  private LLNode<T> _nextNode;

  // constructor
  public LLNode( T value, LLNode<T> next )
  {
    _cargo = value;
    _nextNode = next;
  }


  //--------------v  ACCESSORS  v--------------
  public T getCargo()
  {
    return _cargo;
  }

  public LLNode<T> getNext()
  {
    return _nextNode;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public T setCargo( T newCargo )
  {
    T foo = getCargo();
    _cargo = newCargo;
    return foo;
  }

  public LLNode<T> setNext( LLNode<T> newNext )
  {
    LLNode<T> foo = getNext();
    _nextNode = newNext;
    return foo;
  }
  //--------------^  MUTATORS  ^--------------


  // override inherited toString
  public String toString()
  {
    return _cargo.toString();
  }


  //main method for testing
  public static void main( String[] args )
  {
    
  }//end main

}//end class LLNode
