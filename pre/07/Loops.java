public class Loops {
  public static double squareRoot(double a) {
    double xpre=5.00;
    double xpost=1.00;
    while (xpre-xpost>=-0.0001 && xpre-xpost<=0.0001) {
      xpost=xpre;
      xpre=(xpre + a/xpre)/2;
    }
    return xpost;
  }

  public static double power(int n, double x) {
    double y=x;
    for (int c=1; c<n; c++) {
      y*=x;
    }
    return y;
  }

  public static int factorial(int x) {
    int y=1;
    for (int m=1; m<=x; m++) {
      y*=m;
    }
    return y;
  }

  public static double myexp(int n, double x) {
    double y=1.00;
    for (int c=0; c<n; c++) {
      y+=power(c,x)/factorial(c);
    }
    return y;
  }

  public static void main(String[] args) {
    System.out.println(squareRoot(9));
    System.out.println(power(5,2));
    System.out.println(myexp(10,3));
  }
}
