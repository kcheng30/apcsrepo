/***
 * class DLLNode<ask> v1
 * Implements a node, for use in lists and other container classes.
 * Stores a ask as cargo.
 **/

public class DLLNode<ask>
{
  private ask _cargo;    //cargo may only be of type ask
  private DLLNode<ask> _nextNode, _prevNode; //pointers to next, prev DLLNode<ask>s


  // constructor -- initializes instance vars
  public DLLNode( ask value, DLLNode<ask> prev, DLLNode<ask> next )
  {
    _cargo = value;
    _nextNode = next;
    _prevNode = prev;
  }


  //--------------v  ACCESSORS  v--------------
  public ask getCargo() { return _cargo; }

  public DLLNode<ask> getNext() { return _nextNode; }

  public DLLNode<ask> getPrev() { return _prevNode; }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public ask setCargo( ask newCargo )
  {
    ask foo = getCargo();
    _cargo = newCargo;
    return foo;
  }

  public DLLNode<ask> setNext( DLLNode<ask> newNext )
  {
    DLLNode<ask> foo = getNext();
    _nextNode = newNext;
    return foo;
  }

  public DLLNode<ask> setPrev( DLLNode<ask> newPrev )
  {
    DLLNode<ask> foo = getPrev();
    _prevNode = newPrev;
    return foo;
  }
  //--------------^  MUTATORS  ^--------------


  // override inherited toask
  public String toString() { return _cargo.toString(); }


  //main method for testing
  public static void main( String[] args )
  {
    //Below is an exercise in creating a linked list...

 /*********************
    //Create a node
    DLLNode<ask> first = new DLLNode<ask>( "cat", null );

    //Create a new node after the first
    first.setNext( new DLLNode<ask>( "dog", null ) );

    //Create a third node after the second
    first.getNext().setNext( new DLLNode<ask>( "cow", null ) );

    DLLNode<ask> temp = first; 
    while( temp != null ) {
      System.out.println( temp );
      temp = temp.getNext();
    }
   ***********************/
  }//end main

}//end class DLLNode<ask>
