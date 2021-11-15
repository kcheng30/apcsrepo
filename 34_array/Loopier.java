/**
Team Frog Hats
Jacob Ng, Kevin Cheng, and Hamim Seam
APCS
HW34 -- A Pirate's Life for Me
2021-11-14
time spent: 2 hours
**/

/**
Disco
-When you System.out.print an array, java prints the memory code.
-When you create an array while also putting elements in it at initilization, you don't need new.
QCC
-Why would we make a recursive version of an indexOf() method?
-Is there a way to get a subarray of an array without using Arrays.copyOfRange?
-java visualizers are very helpful for recursions.
**/

import java.util.Random;
import java.util.Arrays;

public class Loopier {

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
		if ( a.length > 0 ) {
			if ( a[0] == target ) return index;
			if ( linSearchR(Arrays.copyOfRange(a, 1, a.length), target) != -1 ) {
				index++;
				return index += linSearchR(Arrays.copyOfRange(a, 1, a.length), target);
			}
		}
		return -1;
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
		targetCount += freqR(Arrays.copyOfRange(a, 1, a.length), target);
		return targetCount;
	}

	public static void main(String[] args) {
		int[] a = new int[500];
		int[] b = {7,7,7,7,7,7,7,7,7,7};
		randomPopulate(a);
		printArr(a);
		System.out.println(linSearchR(a, 0));
		System.out.println(linSearchR(b, 0));
		System.out.println(freqR(a, 0));
		System.out.println(freqR(b, 0));
	}
}
