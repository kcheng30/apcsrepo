// Team Frog Hats - Jacob Ng, Kevin Cheng, Hamim Seam
// APCS pd8
// HW51 -- implementing bubblesort
// 2022-01-04t
// time spent: 1 hrs

/******************************
 * class BubbleSort -- implements bubblesort algorithm (vanilla)
 *
 * ALGO:
 * For an array of length n,
 * There should be n-1 passes. In each pass:
 * Starting from the rightmost thing, if it's less than the thing to the left, swap the two and repeat for every element up to and including the second to last one from the left.
 * 
 * DISCO
 * Because of the attributes of Bubble Sort (in the questions below), for the mth pass of an array of length n, only n-m comparisons need to be made.
 *
 * QCC
 * q0: If a pass requires no swaps, what do you know?
 * a0: The array is already sorted
 * q1: After pass p, what do you know?
 * a1: p elements are guaranteed to be sorted in the array, starting from the left
 * q2: How many passes are necessary to completely sort?
 * a2: 1 less than the length of the array being sorted
 * 
 ******************************/

import java.util.ArrayList;

public class BubbleSort
{

  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond:  lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi ) {
    ArrayList<Integer> retAL = new ArrayList<Integer>();
    while( size > 0 ) {
      //     offset + rand int on interval [lo,hi]
      retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
      size--;
    }
    return retAL;
  }

  //randomly rearrange elements of an ArrayList
  public static void shuffle( ArrayList al )
  {
    int randomIndex;
    //setup for traversal fr right to left
    for( int i = al.size()-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of bubbleSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void bubbleSortV( ArrayList<Comparable> data )
  {
		for ( int i = 0; i < data.size() - 1; i++ ) {
			for ( int j = data.size() - 1; j > 0; j-- ) {
				if ( data.get(j).compareTo( data.get(j - 1) ) < 0 ) {
					Comparable temp = data.get(j);
					data.set( j, data.get(j - 1) );
					data.set( j - 1, temp );
				}
			}
		}
  }

  // ArrayList-returning bubbleSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input )
  {
	ArrayList<Comparable> retArray = new ArrayList<Comparable>();
		for ( int i = 0; i < input.size(); i++ ) {
			for ( int j = input.size() - 1; j > 0; j-- ) {
				if ( input.get(j).compareTo( input.get(j - 1) ) < 0 ) {
					Comparable temp = input.get(j);
					input.set( j, input.get(j - 1) );
					input.set( j - 1, temp );
				}
			}
			retArray.add( input.get(i) );
		}
	return retArray;
  }


  public static void main( String [] args )
  {

    /*===============for VOID methods=============
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      bubbleSortV(glen);
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      bubbleSortV(coco);
      System.out.println( "ArrayList coco after sorting:\n" + coco );
      ============================================*/

      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      ArrayList glenSorted = bubbleSort( glen );
      System.out.println( "sorted version of ArrayList glen:\n" 
      + glenSorted );
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = bubbleSort( coco );
      System.out.println( "sorted version of ArrayList coco:\n" 
      + cocoSorted );
      System.out.println( "ArrayList coco after sorting:\n" + coco );
      System.out.println( coco );

  }//end main

}//end class BubbleSort
