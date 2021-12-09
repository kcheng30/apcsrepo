/*****************************************************
  * Team Turtle Hats
  * Jacob Ng Kevin Cheng Hamim Seam
  * APCS
  * HW45 -- Array of Titanium
  * 2021-12-07
  * Time spent: 2hrs
  *****************************************************/


public interface ListInt{

    public boolean add(int x);// Adds an element to the end of the array
    public int get(int index);
    public int set(int index, int o);
    public int size(); //returns size of the array
    public boolean add( int index, int newVal );//adds an element at an index while shifting all
                                                //elements originally at that index and that came after it
                                                //one space to the right or up one index
    public void remove( int index );// removes an element at an index and shifts all elements that come after
                                    // that index one space to the left or down one index



}
