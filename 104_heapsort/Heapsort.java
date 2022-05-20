/**
Team BrainForked: Gloria Lee, Jack Chen, Kevin Cheng
APCS pd08
HW104
2022-05-20F
time spent: 1 hrs

DISCO:
* time complexity of heapsort is O(nlogn)
* heapsort doesn't require you to create another array that is sorted bc it sorts "in place"
* Java hates us and we hate java

QCC:
* why no work?
* what's the purpose of overwriting the last leaf with old root value? isn't that done during swap?
* something wrong with the algo? or our perception of the algo? why if i am > least child, swap with that child
  why not instead if i am < greatest child, swap with that child
* When you heapify, does one use maxHeap or minHeap?


 * class Heapsort
 * SKELETON
 * sorts in-place by heapifying data, then repeatedly pulling from heap
 */

public class Heapsort
{

  /**
   * int[] sort( int[] data )  --- returns sorted input array
   * Applies heapsort algorithm (in place)
   */
  public int[] sort( int[] data )
  {
    System.out.print( "Input array: \t" );
    printArr( data );
  
  
    //STEP 1: heapify array contents
    //slot 0 will contain root
    //(heap will grow from L to R)

    maxHeapify(data); 
    System.out.println( "Array heapified. Root at index 0" );
    printArr( data );
  
  
    //STEP 2: repeatedly pull from heap until empty
    //(Sorted region will grow from R to L)
    for( int lastLeaf = data.length - 1; lastLeaf > 0; lastLeaf -- ) {
      //set aside root val
      int tmp = data[0];
  
      //swap last leaf (rightmost on bottom level) into root pos
      swap(0, lastLeaf, data );
  
      //walk now-out-of-place root node down the tree...
      int pos = 0; 
      int minChildPos; 
      int maxChildPos;

      while( pos < lastLeaf ) {
        System.out.println("1");
  printArr( data );
        //choose child w/ max value, or check for child 
        maxChildPos = maxChildPos(pos, lastLeaf, data); 
        minChildPos = minChildPos(pos, lastLeaf, data);
        
        //if no children, then i've walked far enough
        if ( maxChildPos == -1 )
          break;
        //if i am greater than my greatest child, i've walked far enough
        else if ( data[pos] > data[maxChildPos] )
          break;
        //if i am < greatest child, swap with that child
        else {
          
            swap(pos, maxChildPos, data);
            pos = maxChildPos;
              printArr( data );  
            
          
          
        }
      
        
      }
          
      
      
      
      //overwrite last leaf with old root val
      data[lastLeaf] = tmp;
      
    }

  
    //STEP teh LAST: return modified array
    return data;
  
  }//end sort() -- O(?)



  private void minHeapify( int[] a )
  {

    for( int i=1; i<a.length; i++ ) { //i = partition
      //add a[i] as leaf
      int addValPos = i; //val to add is next non-heap element

      //now must percolate up
      while( addValPos > 0 ) { //potentially swap until reach root

        //pinpoint parent
        int parentPos = (addValPos - 1) / 2;

        if ( a[addValPos] < (a[parentPos])) { //if parent is larger
          swap( addValPos, parentPos, a);
          addValPos = parentPos;
        }
        else
          break;
      }
    }
  }//end minHeapify() -- O(nlogn)



  private void maxHeapify( int[] a )
  {
    
    for( int i=1; i<a.length; i++ ) {
      //add a[i] as leaf
      int addValPos = i; //val to add is next non-heap element
    
      //now must percolate up
      while( addValPos > 0 ) { //potentially swap until reach root
    
        //pinpoint parent
        int parentPos = (addValPos - 1) / 2;
    
        if ( a[addValPos] > (a[parentPos])) {
          swap( addValPos, parentPos, a);
          addValPos = parentPos;
        }
        else
          break;
      }
    }
  }//end maxHeapify() -- O(nlogn)



  //return position of child with least value in input array
  private int minChildPos( int pos, int last, int[] a )
  {
    int retVal;
    int lc = 2*pos + 1; //index of left child
    int rc = 2*pos + 2; //index of right child

    //pos is not in the heap or pos is a leaf position
    if ( pos < 0 || pos >= last || lc >= last )
      retVal = -1;
    //if no right child, then left child is only option for min
    else if ( rc > last )
      retVal = lc;
    //have 2 children, so compare to find least
    else if ( a[lc] < (a[rc]))
      retVal = lc;
    else
      retVal = rc; 
    return retVal;
  }



  //return position of child with greatest value in input array
  private int maxChildPos( int pos, int last, int[] a )
  {
    int retVal; 
    int lc = 2*pos + 1; //index of left child
    int rc = 2*pos + 2; //index of right child

    //pos is not in the heap or pos is a leaf position
    if ( pos < 0 || pos >= last || lc >= last )
      retVal = -1; 
    //if no right child, then left child is only option for min
    else if ( rc >= last )
      retVal = lc;
    //have 2 children, so compare to find least
    else if ( a[lc] > (a[rc]))
      retVal = lc;
    else
      retVal = rc; 
    return retVal;
  }



  //--------------v- HELPER METHODS -v--------------
  private int minOf( int a, int b ) { return (a<b)?a:b; } 

  public static void swap( int x, int y, int[] o )
  {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  public static void printArr( int[] a )
  {
    for ( int o : a )
      System.out.print( o + " " );
    System.out.println();
  }

  public static void shuffle( int[] d )
  {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
      tmp = d[i];
      swapPos = i + (int)( (d.length - i) * Math.random() );
      swap( i, swapPos, d );
    }
  }

  public static int[] buildArray( int size, int hi )
  {
    int[] retArr = new int[size];
    for( int i = 0; i < retArr.length; i++ )
      retArr[i] = (int)( hi * Math.random() );
    return retArr;
  }
  //--------------^- HELPER METHODS -^--------------




  //main method for testing
  public static void main( String[] args )
  {
  
    int[] a = buildArray( 10, 10 );

    printArr(a);

    Heapsort h = new Heapsort();

    h.sort(a);

    printArr(a);
      /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main()

}//end class
