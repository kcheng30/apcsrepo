/*****************************************************
  * Team Turtle Hats
  * Jacob Ng Kevin Cheng Hamim Seam
  * APCS
  * HW49 -- Rational Standards Compliance
  * 2021-12-22
  * Time spent: 1hr
  *****************************************************/

  /*
  Disco
  -Rational other = (Rational) r; with r being the parameter of the method typecasted r from object to Rational
  -Object can store anything. Maybe? It could be a string or Rational for sure.
  -if( other instanceof Rational == true) syntax for instanceof
  QCC
  -
  */

public class Rational implements Comparable{

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

    public int compareTo(Object r){
        //other = new Rational();
        Rational other = (Rational) r;
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


    public boolean equals(Object other){
    	if( other instanceof Rational == true){
         Rational r = (Rational) other;
         //other = new Rational();
    	   r.reduce();
         this.reduce();

         if(this.compareTo(r) == 0){
            return true;
         }else{
            return false;
         }
    	}
         System.out.println("You dumb dumb baby pig.");
    	   return false;
    }


    public static void main( String[] args ){
      Rational number1 = new Rational(3,4);
      Rational number2 = new Rational(6,8);
      Rational number3 = new Rational(1,2);
      Object number4 = new Rational(3,4);
      Object number5 = "Not a Rational";

      System.out.println("Should be true: " + number1.equals(number2));
      System.out.println("Should be false: " + number1.equals(number3));
      System.out.println("Should be true: " + number1.equals(number4));
      System.out.println("Should be false: " + number1.equals(number5));



    }
    /*
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
      */
}
