/*****************************************************
  * Team Turtle Hats
  * Jacob Ng Kevin Cheng Hamim Seam
  * APCS
  * HW42 -- Be More Rational
  * 2021-12-04
  * Time spent: hrs
  *****************************************************/

  /*
  Disco
  -we don't need accessor methods.
  QCC
  -Jacob forgot constructors are public.
  -Still confused about when to use static or not. br() did not work when non static. Same issue with gcd.
  -for reduce(), you don't need parameters since you are changing this Rationals own variables.
  */

public class Rational{

    private int numerator, denominator;

    public Rational(){
        numerator = 0;
        denominator = 1;
    }

    public Rational( int n, int d){
    	this();
        if(d == 0){
            System.out.println("Why you... Why you do this :(");
        }else{
            numerator = n;
            denominator = d;
        }
    }

    public double floatValue(){
        double n, d;
        n = numerator;
        d = denominator;
        return n/d;
    }

    public String toString(){
        return "The rational number is " + numerator + "/" + denominator;
    }

    public void multiply(Rational other){
            numerator = numerator * other.getNum();
            denominator = denominator * other.getDenom();
    }

    public void divide(Rational other){
    	    numerator = numerator * other.getDenom();
            denominator = denominator * other.getNum();
    }

    public void add(Rational other){
            numerator = numerator * other.denominator + other.numerator * denominator;
            denominator = denominator * other.denominator;
    }

    public void subtract(Rational other){
            numerator = numerator * other.denominator - other.numerator * denominator;
            denominator = denominator * other.denominator;
    }

    public static int gcd(int n, int d){
        while (n != d){
            if(n > d){
                n -= d;
            }else{
                d -= n;
            }
        }
        return n;
    }

    public void reduce(){
        int gcd = gcd(numerator,denominator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;
    }

    public int compareTo(Rational other){
        other.reduce();
        this.reduce();
        if(this.numerator == other.numerator && this.denominator == other.denominator){
            return 0;
        }else if(this.floatValue() > other.floatValue()){
            return 9001;
        }else{
            return -1;
        }
    }

    public int getNum(){
        return this.numerator;
    }

    public int getDenom(){
        return this.denominator;
    }

    public static void br(){
        System.out.println();
    }

    public static void main( String[] args ){
        Rational number1 = new Rational(3,4);
        Rational number2 = new Rational(4,6);

        System.out.println(number1);
        System.out.println(number2);
        br();

 	      System.out.println(number1.floatValue());
 	      System.out.println(number2.floatValue());
        br();

        System.out.println("This is the gcd of number2: " + gcd(number2.numerator, number2.denominator));
        br();

 	      number1.multiply(number2);
 	      System.out.println(number1);
 	      System.out.println(number2);
 	      System.out.println(number1.floatValue());
        br();

 	      number1.divide(number2);
 	      System.out.println(number1);
 	      System.out.println(number2);
	      System.out.println(number1.floatValue());
        br();

        number1.add(number2);
 	      System.out.println(number1);
 	      System.out.println(number2);
	      System.out.println(number1.floatValue());
        br();

        number1.subtract(number2);
 	      System.out.println(number1);
 	      System.out.println(number2);
	      System.out.println(number1.floatValue());
        br();

        number1.reduce();
        System.out.println(number1);
        System.out.println(number1.floatValue());
        br();

        System.out.println(number1.compareTo(number2));
        br();


 	      Rational third = new Rational(1,0);
 	      System.out.println(third);
        br();
    }
}
