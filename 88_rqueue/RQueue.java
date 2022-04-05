import java.util.NoSuchElementException;

/***
 * class RQueue
 * SKELETON
 * A node-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 **/

/*
FROGHATS: Salaj Rijal, Kevin Cheng, Alif Rahman
APCS pd0
HW88 -- BPC Kiddies Do Not Wait in Line Either
2022-04-04m
time spent: 1h
DISCO:
-We can just dequeue and enqueue to randomize
-It does not matter that the elements are still in order, but to the
end user it seems to be random
QCC:
-Where should we put the sample method?
-Since we put sample() in enqueue, does that make our sample O(n)?
*/


public class RQueue<SWASHBUCKLE> implements Queue<SWASHBUCKLE>
{
  //instance variables
  private LLNode<SWASHBUCKLE> _front, _end;
  private int _size;


  // default constructor creates an empty queue
  public RQueue()
  {
    _front = _end = null;
    _size = 0;
  }


  public void enqueue( SWASHBUCKLE enQVal )
  {
    if( isEmpty() ){
      _front = _end = new LLNode<SWASHBUCKLE>(enQVal, null);
    }
    else{
      _end.setNext( new LLNode<SWASHBUCKLE>( enQVal, null)  );
      _end = _end.getNext();
    }
    _size++;
    sample();
  }//O(1)


  // remove and return thing at front of queue
  // assume _queue ! empty
  public SWASHBUCKLE dequeue()
  {
    if( isEmpty() ) throw new NoSuchElementException();
    SWASHBUCKLE tmp = _front.getCargo();
    _front = _front.getNext();
    _size--;
    return tmp;

  }//O(1)


  public SWASHBUCKLE peekFront()
  {
    return _front.getCargo();
  }//O(1)


  /***
   * void sample() -- a means of "shuffling" the queue
   * Algo:
   * 1. generate a random number from 0-size and call it random
   * 2. dequeue and enqueue (but wihtout enquueeu method) the result of dequeue random number of times
   *   
   **/

  public void sample ()
  {
    int random = (int) (Math.random() * _size);
    for (int i = 0; i < random; i++){
      SWASHBUCKLE tmp = dequeue();
      _end.setNext( new LLNode<SWASHBUCKLE>(tmp, null) );
      _end = _end.getNext();
    };

  }//O(n)


  public boolean isEmpty()
  {
    return _front == null;
  } //O(1)


  // print each node, separated by spaces
  public String toString()
  {
    LLNode<SWASHBUCKLE> tmp = _front;
    String result = "";

    while( tmp != null ){
      result += tmp.getCargo().toString() + " ";
      tmp = tmp.getNext();
    }

    return result;
  }//end toString()



  //main method for testing
  public static void main( String[] args )
  {

    
    Queue<String> PirateQueue = new RQueue<String>();
    
    System.out.println("\nnow enqueuing..."); 
    PirateQueue.enqueue("Dread");
    PirateQueue.enqueue("Pirate");
    PirateQueue.enqueue("Roberts");
    PirateQueue.enqueue("Blackbeard");
    PirateQueue.enqueue("Peter");
    PirateQueue.enqueue("Stuyvesant");
    
    System.out.println("\nnow testing toString()..."); 
    System.out.println( PirateQueue ); //for testing toString()...
    
    System.out.println("\nnow dequeuing..."); 
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    
    System.out.println("\nnow dequeuing fr empty queue...\n" +
    "(expect NPE)\n"); 
    System.out.println( PirateQueue.dequeue() );
    
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
    ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main

}//end class RQueue
