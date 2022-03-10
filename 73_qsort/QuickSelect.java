// Computer Attackers: Salaj Rijal, Alif Rahman
// APCS pd8
// HW72 -- So So Fast
// 2022-03-08
// Time spent: .5 hrs

/*
DISCO:
- the algorithm is similar to binarySearch
- once partition is run on a certain pivot, the value of that pivot
is guarenteed to be at its sorted position

QCC:
-what is the time complexity?
-is there way to do this with recursion?
-is there a better algorightm?

ALGO:
1- Start is 0 and End is last index of the array. The Pivot value is the mean of the Start and End.
2- Put all values that are less than arr[Pivot] on to its left side and vice-versa. Then check whether or not
the new position of the Pivot value == y.
3- If it does, then return arr[y]. If it is less, then make Start = Pivot+1 and Pivot = mean of Start and End. 
If it is more, then make End = Pivot-1 and Pivot = mean of Start and End. Repeat steps 2 to 3. 

BEST CASE:
O(n): the best case is that partition (which has complexity of O(n) ) has to only be run once.
This is the case when the new position of the original value for pivot == y. 

WORST CASE:
O(n*n): this is the worst case because the last pivot partitioned is the one that is at position y.

*/
public class QuickSelect {

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
  
    public static int find( int arr[], int y) {
      y--;
      int start = 0; //start index
      int end = arr.length-1; //end index
      int pivot = (start+end)/2; //midpoint
      pivot = Partition.partition( arr, start, end); //initial pivo
      while( pivot != y ){
      	if( pivot < y ){
        		start = pivot;
        		pivot = start + 1;
      	}
      	else{
        		end = pivot;
        		pivot = end - 1;
      	}
        pivot = Partition.partition( arr, start, end);
      }
        return arr[y];
    }
  
      public static void main(String[] args) {
        int[] arr = new int[]{ 1, 2, 3, 4, 5, 6, 7};
        System.out.println( find(arr, 7) );
        int[] arr1 = new int[]{ 9823, 47, 326, 920, 7436, 234, 69};
        System.out.println( find(arr1, 7) );
      }
  
  } // end of class FastSelect
