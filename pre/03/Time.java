public class Hello{
  public static void main(String[] args){
    int hour = 19;
    int minute = 30;
    int second = 30;

    int secMidnight = (hour * 60 + minute) * 60 + second;
    System.out.print("Seconds passed since midnight: ");
    System.out.println(secMidnight);

    int secRemaining = 24 * 60 * 60 - secMidnight;
    System.out.print("Seconds remaining in the day: ");
    System.out.println(secRemaining);

    double dSecMidnight = secMidnight;
    System.out.print("Fraction of the day that has passed: ");
    System.out.println(dSecMidnight / (24 * 60 * 60));

    hour = 19;
    minute = 52;
    second = 25;
    int secMidnight2 = (hour * 60 + minute) * 60 + second;
    System.out.print("Time passed since exercise started: ");
    System.out.println((secMidnight2 - secMidnight) + " seconds");
  }
}
