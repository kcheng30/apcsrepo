/*****************************************************
  * Team Turtle Hats
  * Jacob Ng Kevin Cheng Hamim Seam
  * APCS
  * HW43 -- Array of Steel
  * 2021-12-06
  * Time spent: 0.6hrs
  *****************************************************/

/***************************
 * class SuperArray
 * Wrapper class for array. Facilitates resizing,
 * getting and setting element values.
 ***************************/

/*
  Disco
  -
  QCC
  -In set(), Jacob was afraid that setting an int = _data[index] 
  would make the int point to the same memory address as _data[index] but it actually did copy the value instead.
  -We wrote one test case for get()
  -Would it be smart to set _size to the size of _data in every one of our methods so that we don't need to use data.length all the time?
  -What if we want to expand in the middle of the array?
  -How do we get rid of the comma at the end of the toString representation?
*/

public class SuperArray
{

  private int[] _data;  //underlying container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
    /* YOUR IMPLEMENTATION HERE */
    _data = new int[10];
    _size = 10;
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
    /* YOUR IMPLEMENTATION HERE */
    String result = "[";
    for(int i = 0; i < _data.length; i++){
    	result += _data[i] + ", ";
    }
    result += "]";
    return result;
  }


  //double capacity of SuperArray
  private void expand()
  {
    /* YOUR IMPLEMENTATION HERE */
    _size = 2 * _data.length;
    int[]temp = new int[_size];
    for (int i = 0; i<_data.length; i++){
    	temp[i] = _data[i];
    }
    _data = temp;
  }


  //accessor -- return value at specified index
  public int get( int index )
  {
    /* YOUR IMPLEMENTATION HERE */
    return _data[index];
  }


  //mutator -- set value at index to newVal,
  //           return old value at index
  public int set( int index, int newVal )
  {
    /* YOUR IMPLEMENTATION HERE */
    
    int oldVal = _data[index];
    _data[index] = newVal;
    return oldVal;
  }


  //main method for testing
  public static void main( String[] args )
  {
    
      SuperArray curtis = new SuperArray();
      System.out.println( "Printing empty SuperArray curtis..." );
      System.out.println( curtis );

      for( int i = 0; i < curtis._data.length; i++ ) {
      curtis.set( i, i * 2 );
      }
      System.out.println("Printing populated SuperArray curtis...");
      System.out.println(curtis);

      for( int i = 0; i < 3; i++ ) {
      curtis.expand();
      System.out.println("Printing expanded SuperArray curtis...");
      System.out.println(curtis);
      }
      
      System.out.println(curtis.get(4));
      /*~~~~~~~~move~me~down~~~~~~~~~~~~~~V~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|~~~~~~~~*/
  }//end main()


}//end class
