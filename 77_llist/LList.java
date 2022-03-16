//Froghats: Kevin Cheng, Salaj Rijal, Alif Rahman
//APCS pd8
//HW77 -- Insert|Remove
//2022-03-15t
//KTS Consumed: 1 (But it was ms paint not an actual KTS)
//Time spent: 1h

/***
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 
 Disco: 
 Having two pointers allows for traversing through the linked list without deleting portions of it.
 
 QCC:
 Was implementing the getNode helper method necessary?
 
 ALGO ADD:
 1. First we create tmp to be an alias to head outside of conditionals.
 2. Then we check if index is actually in bounds of linked list.
 3. We then check to see if index is 0 as it is a special case. Using the regular add method suffices
 for this case.
 4. If we reach this point, we know we are adding an item at a specified index that is not 0.
 	4a. We first make tmp point to the node right before the node @ index.
	4b. Then, we set the next of tmp to a node that contains the cargo we want to add and has a next
	of node @ index.
	4c. We increase size.

 ALGO REMOVE:
 1. First, we create a String variable to store the data that will be deleted.
 2. Then, we create tmp to be an alias to head outside of conditionals.
 3. Then we check if index is actually in bounds of linked list.
 4. We then check to see if index is 0 as it is a special case. A simpler solution can be used here: 
 oldVal is set to the cargo of _head. we just set _head to its next value.
 5. If we reach this point, we know we are removing an item at a specified index that is not 0.
 	5a. We first make tmp point to the node right before the node @ index.
	5b. We then set oldVal to the cargo of the node that will be removed.
	5c. We then set the next of tmp to the node after the node after it, therefore removing the node 
	after it.
	5d. We decrease size.
	5e. We return oldVal (the data that was removed).
 **/

public class LList implements List //interface def must be in this dir
{

  //instance vars
  private LLNode _head;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _head = null; //at birth, a list has no elements
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
  {
    LLNode tmp = new LLNode( newVal, _head );
    _head = tmp;
    _size++;
    return true;
  }

  public void add( int index, String newVal)
  {
    LLNode tmp = _head; //create alias to head

    if ( index < 0 || index >= size() ) { //check if index is in bounds
        throw new IndexOutOfBoundsException();
    } else if (index == 0) { //accounts for special case of index 0 where the regular add method will suffice
        add(newVal);
    }else {
        //make tmp point to the node right before the node @ index
        for (int i = 0; i < index - 1; i++)
            tmp = tmp.getNext();
        //set the next of tmp to a node that contains the cargo we want to add and has a next of node @ index
        tmp.setNext(new LLNode( newVal, getNode(index) ));
        _size++;
    }
  }

  public String remove( int index )
  {
    String oldVal = ""; //initialize String var to contain the data that will be removed
    LLNode tmp = _head; //create alias to head

    if ( index < 0 || index >= size() ) { //check if index is in bounds
        throw new IndexOutOfBoundsException();
    }else if (index == 0) { //accounts for special case of index 0 where a simpler solution will suffice
        oldVal = _head.getCargo();
        _head = _head.getNext();
        _size--;
    }else {
        //makes tmp point to the node right before the node @ index
        for (int i = 0; i < index - 1; i++)
            tmp = tmp.getNext();
        oldVal = tmp.getNext().getCargo(); //sets oldVal to the cargo of the node that will be removed.
	tmp.setNext(tmp.getNext().getNext()); //sets the next of tmp to the node after the node after
	    				      //it, therefore removing the node after it.
        _size--;
    }
    return oldVal; //return the data that was removed
  }

  public String get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    String retVal;
    LLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    //check target node's cargo hold
    retVal = tmp.getCargo();
    return retVal;
  }

  //helper method to get node at specific index instead of cargo
  public LLNode getNode( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    LLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    return tmp;
  }

  public String set( int index, String newVal )
  {

    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    LLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    //store target node's cargo
    String oldVal = tmp.getCargo();

    //modify target node's cargo
    tmp.setCargo( newVal );

    return oldVal;
  }


  //return number of nodes in list
  public int size() { return _size; }

  //--------------^  List interface methods  ^--------------


  // override inherited toString
  public String toString()
  {
    String retStr = "HEAD->";
    LLNode tmp = _head; //init tr
    while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
    }
    retStr += "NULL";
    return retStr;
  }


  //main method for testing
  public static void main( String[] args )
  {
    LList james = new LList();

    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("beat");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("a");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("need");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("I");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    System.out.println( "2nd item is: " + james.get(1) );

    james.set( 1, "got" );
    System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add(3,"piggy");

    System.out.println("Adding \"piggy\" to index 3...");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.remove(4);

    System.out.println("Removing index 4...");
    System.out.println( james );
    System.out.println( "size: " + james.size() );
  }

}//end class LList
