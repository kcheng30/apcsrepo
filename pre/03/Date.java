public class Hello{
  public static void main(String[] args){
    String day = "Monday";
    int date = 23;
    String month = "August";
    int year = 2021;

    String aFormat = day + ", " + month + " " + date + ", " + year;
    String eFormat = day + " " + date + " " + month + " " + year;

    System.out.println("American Format:");
    System.out.println(aFormat);
    System.out.println("European Format:");
    System.out.println(eFormat);
  }
}
