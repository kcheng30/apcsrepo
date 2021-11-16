/**
Team Frog Hats
Jacob Ng, Kevin Cheng, and Hamim Seam
APCS
HW35 --
2021-11-15
time spent:  0.5 hours
**/

/**
Disco
-You don't need to import java.util.Random to use Math.random()
-To copy an array without the 0 index element, just create a new array of the same length - 1 and copy the old array starting from index 1.
-In a for loop, you can initilize multiple variables

QCC
-What does java.util.Random give you?
-
**/


//import java.util.Random;
//import java.util.Arrays;

public class Loopier {

  public static int[] shorten(int[] a){
      int[]subArray = new int[a.length - 1];
      for(int i = 1, y = 0; i < a.length; i++, y++){
          subArray[y] = a[i];
      }
      return subArray;
  }

  public static void printArr(int[] a) {
		System.out.print("{");
		for ( int num : a ) System.out.print(num + ", ");
		System.out.println("}");
	}

	public static void randomPopulate(int[] a) {
		for ( int i = 0; i < a.length; i++ ) a[i] = (int) (Math.random()*10);
	}

	public static String arrayToStr(int[] a) {
		String sList = "{";
		for ( int num : a ) sList += num + ", ";
		return sList + "}";
	}

	public static int linSearch(int[] a, int target) {
		int index = 0;
		for ( int num : a ) {
			if ( num == target ) return index;
			index++;
	  }
    return -1;
  }

	public static int linSearchR(int[] a, int target) {
		int index = 0;
		if ( a.length == 0 ) return -1;
		int recurse = linSearchR(shorten(a), target);
		if ( a[0] == target ) return index;
		if ( recurse != -1 ) return index += recurse + 1;
		else return -1;
	}

	public static int freq(int[] a, int target) {
		int targetCount = 0;
		for ( int num : a ) if ( num == target ) targetCount++;
		return targetCount;
	}

	public static int freqR(int[] a, int target) {
		int targetCount = 0;
		if ( a.length == 0 ) return 0;
		if ( a[0] == target ) targetCount++;
		targetCount += freqR(shorten(a), target);
		return targetCount;
	}

  	public static void main(String[] args){
     		int[] Bob;
      	Bob = new int[5];
        int[] George = {1,2,3,4,5,6};
        randomPopulate(Bob);
      //  for(int i = 0; i < Bob.length; i++){
      //    	System.out.println(Bob[i]);
      //  }
      	System.out.println(arrayToStr(Bob));
        System.out.println(linSearch(George, 5));
        System.out.println(linSearch(George, 17));
        System.out.println(linSearchR(George, 5));
        System.out.println(linSearchR(George, 17));
        int[] a = new int[500];
        int[] b = {7,7,7,7,7,7,7,7,7,7};
        randomPopulate(a);
        //printArr(a);
        //System.out.println(linSearchR(a, 0));
        //System.out.println(linSearchR(b, 0));
        System.out.println(freqR(a, 0));
        System.out.println(freqR(b, 0));
/**
        int[] list = new int[500];
		    randomPopulate(list);
		    printArr(list);
		    System.out.println(linSearchR(list, 0));
**/
    }
}
