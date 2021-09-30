import java.util.Scanner;

public class Greet {
	public static void greet() {
		String name;
		Scanner Sname = new Scanner(System.in);
		System.out.println("What is your name?");
		name = Sname.nextString();

		System.out.print("Greetings, ");
		System.out.println(name);
	}
	public static void main(String[] args) {
		greet();
	}
}
