
/**
Team BrainForked: Gloria Lee, Jack Chen, Kevin Cheng
APCS pd08
HW101: Heap o'Trouble
2022-05-16T
time spent: 0.5 hrs
 DISCO:
 * very important to always keep track of indexes to prevent index out of bounds error
 * Use the resources provided, the minTree visualization was very useful :) (we used it)
 * Always draw intended outcome out before running. 
 
 QCC:
 * It works but why does it keep giving us an index out of bounds error im going to lose my mind 
 * Is there a way to prevent index out of bounds error without 10000 checks
 * Might have been problem with findMin child but we've gone over it one too many times. 
 
 * class ALHeap
 * SKELETON
 * Implements a min heap using an ArrayList as underlying container
 */

import java.util.ArrayList;

public class ALHeap
{

  //instance vars
  private ArrayList<Integer> _heap;

  /**
   * default constructor  ---  inits empty heap
   */
  public ALHeap()
  {
    _heap = new ArrayList<Integer>();
  }



  /**
   * toString()  ---  overrides inherited method
   * Returns either
   * a) a level-order traversal of the tree (simple version)
   * b) ASCII representation of the tree (more complicated, more fun)
   */
  public String toString()
  {
    String mice = "";
    for (int num : _heap) {
      mice += num + " ";  
    }
    return mice; 
  }//O(n)


  /**
   * boolean isEmpty()
   * Returns true if no meaningful elements in heap, false otherwise
   */
  public boolean isEmpty()
  {
    return _heap.size() == 0;
  }//O(1)


  /**
   * Integer peekMin()
   * Returns min value in heap
   * Postcondition: Heap remains unchanged.
   */
  public Integer peekMin()
  {
    return _heap.get(0);
  }//O(1)


  /**
   * add(Integer)
   * Inserts an element in the heap
   * Postcondition: Tree exhibits heap property.
   * ALGO:
   * addPos tracks current position of addVal
   * parentPos tracks parent index 
   * While addVal is < get(parentPos), swap indexes addPos and parentPos 
   * set addPos to parent index. set parentPos to (addPos - 1)/2
   */
  public void add( Integer addVal )
  {
    //original position addPos initialized to where addVal will be added
    int addPos = _heap.size();
    int parentPos = (addPos - 1) / 2; 
    
    _heap.add(addVal);
  

    while (addVal < _heap.get(parentPos)) {
      swap(addPos, parentPos); 
      addPos = parentPos; 
      parentPos = (addPos - 1)/2;
    } 
  
  }//O(logn) 

  /**
   * removeMin()  ---  means of removing an element from heap
   * Removes and returns least element in heap.
   * Postcondition: Tree maintains heap property.
   * ALGO:
   * Use currentPos to keep track of current position. This is initialized to 0
   * To remove min, first swap indexes 0 (root) and size - 1. Remove value at size -1.
   * Next, check right and left child of currentPos and swap with least child, updating currentPos to that child's index
   * Continue until left/right child have value 0, indicated leaf is reached.
   */
  public Integer removeMin()
  {
    if(_heap.isEmpty()){
      return -1;
    }
    int removedInt = _heap.get(0);
      swap(0, _heap.size() - 1);
        _heap.remove(_heap.size() - 1);
    int currentPos = 0;
    int nextPos = minChildPos(currentPos); 
      
    // while ( minChildPos(currentPos) > 0 ) {
    //   int nextPos = minChildPos(currentPos);
    //   swap(currentPos, nextPos);
    //   currentPos = nextPos; 
    // } where is nextpos from good question
  if (nextPos == -1 || nextPos == 0) {
    return removedInt;
  }
  
    while ( _heap.get(currentPos) > _heap.get(nextPos)) {
    
      swap (currentPos, nextPos);
      currentPos = nextPos; 
      nextPos = minChildPos(currentPos); 
      if (nextPos == -1) {
        break; 
      }
    }
    if(_heap.size()<=0){
      return -1;
    }
    return removedInt; 
  }//O(logn) 

  /**
   * minChildPos(int)  ---  helper fxn for removeMin()
   * Returns index of least child, or
   * -1 if no children, or if input pos is not in ArrayList
   * Postcondition: Tree unchanged
   */
  private int minChildPos( int pos )
  {
    int leftPos = (pos * 2) + 1;
    int rightPos = (pos * 2) + 2; 
    
    if (pos >= _heap.size() || (leftPos>=_heap.size() && rightPos >= _heap.size()) ) {
      return -1; 
    }
    else if( leftPos >= _heap.size() ){
      return rightPos;
    }
    else if (rightPos >= _heap.size()){
      return leftPos;
    }

    else if (leftPos > _heap.size()) {
      return rightPos;
    }
    else if (rightPos > _heap.size()) {
      return leftPos; 
    }
    else if (_heap.get(leftPos) > _heap.get(rightPos)) {
      return rightPos; 
    }
    else if (_heap.get(rightPos) > _heap.get(leftPos)) {
      return leftPos; 
    }
    else {
      return -1; 
    }
  }//O(1)


  //~~~~~~~~~~~~~ aux helper fxns ~~~~~~~~~~~~~~
  private Integer minOf( Integer a, Integer b )
  {
    if ( a.compareTo(b) < 0 )
      return a;
    else
      return b;
  }

  //swap for an ArrayList
  private void swap( int pos1, int pos2 )
  {
    _heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



  //main method for testing
  public static void main( String[] args )
  {
    
      ALHeap pile = new ALHeap();

      pile.add(2);
      System.out.println(pile);
      pile.add(4);
      System.out.println(pile);
      pile.add(6);
      System.out.println(pile);
      pile.add(8);
      System.out.println(pile);
      pile.add(10);
      System.out.println(pile);
      pile.add(1);
      System.out.println(pile);
      pile.add(3);
      System.out.println(pile);
      pile.add(5);
      System.out.println(pile);
      pile.add(7);
      System.out.println(pile);
      pile.add(9);
      System.out.println(pile);

      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class ALHeap
