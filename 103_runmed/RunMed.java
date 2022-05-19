import java.util.Scanner; 

public class RunMed {
  //private ArrayList _list;
  private ALHeapMax lilVals; 
  private ALHeapMin bigVals; 
  
  public RunMed() {
    // _list = new 
    lilVals = new ALHeapMax();
    bigVals = new ALHeapMin(); 
  }
  
  public Integer getMedian() {
    if ( lilVals.getSize() == 0 && bigVals.getSize() == 0 ) {
      return -1;
    } 

    if ( lilVals.getSize() > bigVals.getSize() )
      return lilVals.peekMax(); 
    else if ( bigVals.getSize() > lilVals.getSize() )
      return bigVals.peekMin();
    else
      return ( lilVals.peekMax() + bigVals.peekMin() ) / 2;
  } 
  
  public Integer add(Integer newVal) {
    
    if ( lilVals.getSize() > 0 ) {
      if ( newVal<lilVals.peekMax() ) {
        lilVals.addMax(newVal);
      } else{
        bigVals.addMin(newVal);
      }
    } else{
      bigVals.addMin(newVal);
    }
    
    if(lilVals.getSize() - bigVals.getSize() > 1){ 
      //lilVals bigger
      bigVals.addMin(lilVals.removeMax()); 
    }
    if(bigVals.getSize() - lilVals.getSize() > 1){ 
      lilVals.addMax(bigVals.removeMin()); 
    } // bigVals bigger
    return newVal; 
  }
  
  public static void main( String[] args )
{

   RunMed r = new RunMed();

  int n;
  double median;
  int count = 0;
  Scanner sc = new Scanner( System.in );

  while( sc.hasNextInt() ) {
    try {
      n = sc.nextInt();
      System.out.print("read " + n + "\n");

      count++;
      System.out.print("this many ints have been seen: " + count + "\n");

       r.add(n);
       median = r.getMedian();
       System.out.print("median is now " + median + "\n");
    } catch (Exception e) {
      System.err.println("BOOP! probs w yer input:\n"+e);
    }
  }

}//end main

  
}
