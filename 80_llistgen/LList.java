/***
 * class LList v3
 * Implements a linked list of DLLNode<ask>s, each containing String data
 **/

public class LList<ask> implements List<ask> //your List.java must be in same dir
{

  //instance vars
  private DLLNode<ask> _head, _tail; //pointers to first and last nodes
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _head = _tail = null; //at birth, a list has no elements
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  //add a node to end of list
  public boolean add( ask newVal )
  {
    addLast( newVal );
    return true; //per Java API spec
  }


  //insert a node containing newVal at position index
  public void add( int index, ask newVal )
  {
    if ( index < 0 || index > size() )
      throw new IndexOutOfBoundsException();

    else if ( index == size() )
      addLast( newVal );

    DLLNode<ask> newNode = new DLLNode<ask>( newVal, null, null );

    //if index==0, insert node before head node
    if ( index == 0 )
      addFirst( newVal );
    else {
      DLLNode<ask> tmp1 = _head; //create alias to head

      //walk tmp1 to node before desired node
      for( int i=0; i < index-1; i++ )
        tmp1 = tmp1.getNext();

      //init a pointer to node at insertion index
      DLLNode<ask> tmp2 = tmp1.getNext(); 

      //insert new node
      newNode.setNext( tmp2 );
      newNode.setPrev( tmp1 );
      tmp1.setNext( newNode );
      tmp2.setPrev( newNode );

      //increment size attribute
      _size++;
    }
  }//end add-at-index


  //remove node at pos index, return its cargo
  public ask remove( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    if ( index == 0 )
      return removeFirst();
    else if ( index == size()-1 )
      return removeLast();
    else {
      DLLNode<ask> tmp1 = _head; //create alias to head

      //walk to node before desired node
      for( int i=0; i < index-1; i++ ) {
        tmp1 = tmp1.getNext();
        System.out.println( "tmp1: " + tmp1.getCargo() );
      }
      //check target node's cargo hold
      ask retVal = tmp1.getNext().getCargo();

      //remove target node
      tmp1.setNext( tmp1.getNext().getNext() );
      System.out.println( "tmp1.getNext: " + tmp1.getNext().getCargo() );
      tmp1.getNext().setPrev( tmp1 );

      _size--;

      return retVal;
    }
  }


  public ask get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    ask retVal;
    DLLNode<ask> tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    //check target node's cargo hold
    retVal = tmp.getCargo();
    return retVal;
  }


  public ask set( int index, ask newVal )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    DLLNode<ask> tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    //store target node's cargo
    ask oldVal = tmp.getCargo();

    //modify target node's cargo
    tmp.setCargo( newVal );

    return oldVal;
  }


  //return number of nodes in list
  public int size() { return _size; }

  //--------------^  List interface methods  ^--------------


  //--------------v  Helper methods  v--------------

  public void addFirst( ask newFirstVal )
  {
    //insert new node before first node (prev=null, next=_head)
    _head = new DLLNode<ask>( newFirstVal, null, _head );

    if ( _size == 0 )
      _tail = _head;
    else
      _head.getNext().setPrev( _head );
    _size++;
  }


  public void addLast( ask newLastVal )
  {
    //insert new node after last node (prev=_last, next=null)
    _tail = new DLLNode<ask>( newLastVal, _tail, null );

    if ( _size == 0 )
      _head = _tail;
    else
      _tail.getPrev().setNext( _tail );
    _size++;
  }


  public ask getFirst() { return _head.getCargo(); }

  public ask getLast() { return _tail.getCargo(); }


  public ask removeFirst()
  {
    ask retVal = getFirst();
    if ( size() == 1 ) {
      _head = _tail = null;
    }
    else {
      _head = _head.getNext();
      _head.setPrev( null );
    }
    _size--;
    return retVal;
  }

  public ask removeLast()
  {
    ask retVal = getLast();
    if ( size() == 1 ) {
      _head = _tail = null;
    }
    else {
      _tail = _tail.getPrev();
      _tail.setNext( null );
    }
    _size--;
    return retVal;
  }
  //--------------^  Helper methods  ^--------------


  // override inherited toString
  public String toString()
  {
    String retStr = "HEAD->";
    DLLNode<ask> tmp = _head; //init tr
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
    LList<String> james = new LList<String>();

    System.out.println("initially: " );
    System.out.println( james + "\tsize: " + james.size() );

    james.add("beat");
    System.out.println( james + "\tsize: " + james.size() );

    james.add("a");
    System.out.println( james + "\tsize: " + james.size() );

    james.add("need");
    System.out.println( james + "\tsize: " + james.size() );

    james.add("I");
    System.out.println( james + "\tsize: " + james.size() );

    System.out.println( "2nd item is: " + james.get(1) );

    System.out.println( "...and now 2nd item is: " + james.set(1,"got") );
    System.out.println( james + "\tsize: " + james.size() );

    james.add(0,"whut");
    System.out.println( "...after add(0,whut): " );
    System.out.println( james + "\tsize: " + james.size() );

    james.add(4,"phat");
    System.out.println( "...after add(4,phat): " );
    System.out.println( james + "\tsize: " + james.size() );

    System.out.println( "...after remove last: "
                        + james.remove( james._size-1) );
    System.out.println( james + "\tsize: " + james.size() );

    System.out.println( "...after remove(0): " + james.remove(0) );
    System.out.println( james + "\tsize: " + james.size() );

    System.out.println( "...after remove(0): " + james.remove(0) );
    System.out.println( james + "\tsize: " + james.size() );

    System.out.println( "...after remove(0): " + james.remove(0) );
    System.out.println( james + "\tsize: " + james.size() );
  }//end main()

}//end class LList
