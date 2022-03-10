// Froghats: Kevin Cheng, Alif Rahman, Salaj Rijal
// APCS pd8
// HW72 -- All About Face
// 2022-03-09
// Time spent: .6 hr

/**
class QuickSort
Implements quicksort algo to sort an array of ints in place
 
PIVOT CHOICES:
- start of the region (n^2) 1061 941 531
- end of the region (n^2) 855 655 879
- midpoint of the region (n^2) 931 457 888
- random (n^2) 891 699 966


1. Summary of QuickSort algorithm:
- if start == end, then return the array
- partition the array
- QuickSort the left side of teh array
- QuickSort the right side of the array

2a. Worst pivot choice and associated run time: 
start of the region: 1061

2b. Best pivot choice and associated run time: 
midpoint of the region: 457

3. Approach to handling duplicate values in array:
nothing it just works (we made robust code lmao)

**/

public class QuickSort
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o )
  {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  //print input array
  public static void printArr( int[] a )
  {
    for ( int o : a )
      System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
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

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal )
  {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
      retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }
  //--------------^  HELPER METHODS  ^--------------

  /**
   * void qsort(int[])
   * @param d -- array of ints to be sorted in place
   */
  public static void qsort( int[] d )
  {
    sort(d, 0, d.length-1);
  }

  //you may need a helper method...
  public static int[] sort( int[] d, int start, int end) {
    //base case only one item
    if ( end-start < 1) {
      return d;
    }

    //rescursive reduction
    int pointBlank = Partition.partition( d, start, end);
    sort( d, start, pointBlank-1);
    sort( d, pointBlank+1, end);    
    return d;
  }

  //main method for testing
  public static void main( String[] args )
  {


    /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
    //get-it-up-and-running, static test case:
    int[] arr1 = {7,1,5,12,3};
    System.out.println("\narr1 init'd to: " );
    printArr(arr1);

    double start = System.currentTimeMillis();

    qsort( arr1 );
    System.out.println("arr1 after qsort: " );
    printArr(arr1);

    System.out.println( "Time: " + (System.currentTimeMillis() - start) );

    // randomly-generated arrays of n distinct vals
    int[] arrN = new int[10];
    for( int i = 0; i < arrN.length; i++ )
    arrN[i] = i;

    System.out.println("\narrN init'd to: " );
    printArr(arrN);

    shuffle(arrN);
    System.out.println("arrN post-shuffle: " );
    printArr(arrN);

    qsort( arrN );
    System.out.println("arrN after sort: " );
    printArr(arrN);



    //get-it-up-and-running, static test case w/ dupes:
    int[] arr2 = {7, 17 ,8,12, 6, 4354, 54456 ,545, 2232, 5435, 1343, 121, 32423, 23423};
    System.out.println("\narr2 init'd to: " );
    printArr(arr2);


    qsort( arr2 );
    System.out.println("arr2 after qsort: " );
    printArr(arr2);

    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    // arrays of randomly generated ints
    int[] arrMatey = new int[999999999];
    for( int i = 0; i < arrMatey.length; i++ )
    arrMatey[i] = (int)( 1000 * Math.random() );


    System.out.println("\narrMatey init'd to: " );
    //printArr(arrMatey);

    double start = System.currentTimeMillis();
    //shuffle(arrMatey);
    qsort( arrMatey );
    System.out.println("arrMatey post-shuffle: " + ( System.currentTimeMillis() - start ) );
    //printArr(arrMatey);



    /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)

    qsort( arrMatey );
    System.out.println("arrMatey after sort: " );
    printArr(arrMatey);
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class QuickSort
