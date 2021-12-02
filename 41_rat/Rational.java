/*****************************************************
  * Team Turtle Hats
  * Jacob Ng Kevin Cheng Hamim Seam
  * APCS
  * HW41 -- Be Rational
  * 2021-12-01
  * Time spent: 0.5hrs
  *****************************************************/

  /*
  Disco
  -this() has to go at the beginning of a constructor
  -Accessor methods
  QCC
  -Credit to senpai Faiza for introducing the idea of getNum() and getDenom()
  -Jacob forgot that .method needs to actually be .method()
  -Jacob also forgot that when creating a new object, you need to put the object type in front.
  -should floatValue() return a double or float?
  */

public class Rational{

    private int numerator, denominator;    
    
    Rational(){
        numerator = 0;
        denominator = 1;
    }
    
    Rational( int n, int d){
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
    
    
    public int getNum(){
        return this.numerator;
    }
    
    public int getDenom(){
        return this.denominator;
    }
    
    public static void main( String[] args ){
        Rational number1 = new Rational(3,4);
        Rational number2 = new Rational(4,6);
        
        System.out.println(number1);
        System.out.println(number2);
        
 	System.out.println(number1.floatValue());
 	System.out.println(number2.floatValue());
 	
 	number1.multiply(number2);
 	System.out.println(number1);
 	System.out.println(number2);
 	System.out.println(number1.floatValue());
 	
 	number1.divide(number2);
 	System.out.println(number1);	
 	System.out.println(number2);       
	System.out.println(number1.floatValue());
 	
 	Rational third = new Rational(1,0);
 	System.out.println(third);
    }
}
