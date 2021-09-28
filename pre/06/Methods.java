public class Methods {
  public static boolean isDivisible(int m, int n) {
    if (m%n == 0) {
      return true;
    }
    return false;
  }

  public static boolean triangle(int a, int b, int c) {
    if (a>=b+c || b>=a+c || c>=a+b) {
      return false;
    }
    return true;
  }

  public static int ack(int m, int n) {
    if (m<0 && n<0) {
      System.out.println("Choose non-negative integers.");
    } else if (m>0 && n>0) {
      ack(m-1,ack(m,n-1));
    } else if (m!=0 && n==0) {
      ack(m-1,1);
    }
    return n+1;
  }
  public static void main(String[] args) {
    System.out.println(isDivisible(72,6));
    System.out.println(triangle(3,4,5));
    System.out.println(ack(2,3));
  }
}
