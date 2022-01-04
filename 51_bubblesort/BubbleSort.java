/*
 * Team Frog Hats - Jacob Ng, Kevin Cheng, Hamim Seam
 * APCS
 * HW51 - Dat Bubbly Tho
 * 2021-1-3
 *
 * DISCO:
 * For an array of length n, you need at most n-1 passes to fully sort it with Bubble Sort.
 * The "bubble" of sorted nums becomes 1 bigger for every completed pass.
 * This means that the mth pass requires only n-m comparisons. 
 *
 * QCC:
 * How should we have the program stop when the passes become redundant?
 * How can we implement the "mth pass requires n-m comparisons"?
 */

public class BubbleSort {
	
	public static void sort( int[] array ) {
		for ( int i = 0; i < array.length - 1; i++ ) {
			for ( int j = array.length - 1; j > 0; j-- ) {
				if ( array[j] < array[j - 1] ) {
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}
	}

	public static String arrayString( int[] array ) {
		String arrayS = "[ ";
		for ( int num : array )
			arrayS += num + ", ";
		arrayS += "]";
		return arrayS;
	}

	public static void main( String[] args ) {
		int[] sample1 = { 5, 4, 3, 2, 1 };
		sort(sample1);
		System.out.println(arrayString(sample1));
	}
}
