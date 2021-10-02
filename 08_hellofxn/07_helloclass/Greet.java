//*
Kevin Cheng
APCS
HW08 -- Refactor Freshie Zero
2021-09-30

DISCOVERIES
Rediscovered how to use the Scanner class

UNRESOLVED QUESTIONS
How do I get one name to come out instead of all three at the same time?
*/

import java.util.Scanner;

public class Greet {
	public static void greet() {
		String name;
		Scanner Sname = new Scanner(System.in);
		System.out.println("What is your name?");
		name = Sname.nextLine();

		System.out.print("Greetings, ");
		System.out.println(name);
	}

	public static void main(String[] args) {
		greet();

		System.out.println("Hello to Dr.Zi,");
		System.out.println("Hello to A.F.,");
		System.out.println("And hello to you too");
	}
}
