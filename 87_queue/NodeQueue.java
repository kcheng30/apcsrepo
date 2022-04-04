//Froghats: Kevin Cheng, Salaj Rijal, Alif Rahman
//APCS pd8
//HW87 -- The English Do Not Wait In Line for Soup -- Making Queue
//2022-04-04f
//time spent: 1h

/*
DISCO:


QCC:


*/

/***
 * class NodeQueue
 * desc
 **/

public class NodeQueue<QUASAR> implements Queue<QUASAR>
{
  //instance vars
  private QUASAR _cargo;
  private NodeQueue<QUASAR> _nextNode;

  // constructor
  public NodeQueue( QUASAR value, NodeQueue<QUASAR> next )
  {
    _cargo = value;
    _nextNode = next;
  }


  //--------------v  ACCESSORS  v--------------
  public QUASAR getCargo()
  {
    return _cargo;
  }

  public NodeQueue<QUASAR> getNext()
  {
    return _nextNode;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public QUASAR setCargo( QUASAR newCargo )
  {
    QUASAR foo = getCargo();
    _cargo = newCargo;
    return foo;
  }

  public NodeQueue<QUASAR> setNext( NodeQueue<QUASAR> newNext )
  {
    NodeQueue<QUASAR> foo = getNext();
    _nextNode = newNext;
    return foo;
  }
  //--------------^  MUTATORS  ^--------------


  //--------------v  INTERFACE METHODS  v--------------

  @Override
  public QUASAR dequeue() {

    QUASAR tmp = _cargo;
    if( _nextNode == null ){
        _cargo = null;
    }
    else{
        setCargo( _nextNode.getCargo() );
        setNext( _nextNode.getNext() );
    }
    return tmp;
  }

  @Override
  public void enqueue(QUASAR x) {
    NodeQueue<QUASAR> tmp = this;
    while( tmp.getNext() != null ){
        tmp = tmp.getNext();
    }
    tmp.setNext( new NodeQueue<QUASAR>( x, null ) );
  }

  @Override
  public boolean isEmpty() {
    return _cargo == null;
  }

@Override
public QUASAR peekFront() {
    return _cargo;
}
  
  
  
  
  //--------------^  INTERFACE METHODS  ^--------------




  // override inherited toString
  public String toString()
  {
    NodeQueue<QUASAR> tmp = this;
    String result = "{";
    while( tmp != null ){
        result += tmp.getCargo() + ", ";
        tmp = tmp.getNext();
    }
    result += "}";
    return result;
  }


  //main method for testing
  public static void main( String[] args )
  {

    NodeQueue<Integer> queue = new NodeQueue<Integer>(0, null);
    for( int i = 1; i <= 12; i++){
        queue.enqueue(i);
    }
    
    System.out.println(queue);
    
    while( !queue.isEmpty() ){
        System.out.println(  queue.dequeue() );
    }


  }//end main

}//end class NodeQueue
