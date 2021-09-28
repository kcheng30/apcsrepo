public class Array {
  public static void printArray(int[] a) {
    System.out.print("{" + a[0]);
    for (int i = 1; i < a.length; i++) {
        System.out.print(", " + a[i]);
      }
    System.out.println("}");
  }

  public static int[] powArray(int[] a, int x) {
    for (int b=0; b<a.length; b++) {
      for (int y=1; y<x; y++) {
        a[b]*=a[b];
      }
    }
    return a;
  }

  public static int indexOfMax(int[] a) {
    int x=0;
    for (int b : a) {
      if (x<b) {
        x=b;
      }
    }
    return x;
  }

  public static boolean[] sieve(int n) {
    int[] a = new int[n];
    boolean[] ab = new boolean[n];
    for (int x=-1; x<=a.length; x++) {
      a[x]=x;
    }
    for (int b : a) {
      if 
    }
  }

  public static void main(String[] args) {
    int[] arr = new int[3];
    arr[0]=2;
    arr[1]=6;
    arr[2]=-4;
    printArray(powArray(arr, 2));
    System.out.println(indexOfMax(arr));
  }
}
