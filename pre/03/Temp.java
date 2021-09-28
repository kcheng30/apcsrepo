import java.util.Scanner;

public class Hello{
  public static void main(String[] args){
    double f, c;
    Scanner in = new Scanner(System.in);

    System.out.print("Temperature in Celsius: ");
    c = in.nextDouble();

    f = (9*c/5) + 32;
    System.out.printf("Equals %.1f degrees Fahrenheit.", f);
  }
}
