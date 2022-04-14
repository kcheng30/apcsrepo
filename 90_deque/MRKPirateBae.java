//TNPG: Froghats 
//Roster: Alif Rahman, Salaj Rijal, Kevin Cheng
//APCS
//HW91 -- Deque the Halls
//2022-04-13
//time spent: 1 hour

/*
DISCO:
- Turns out LinkedList already implements Deque, so all we did was "pass-thru" the necessary LinkedList methods.

QCC:
- Are we doing this right?
- What other functionality should we add to our Deque?
- What are some good names for the interface methods? Should they be the same as stated in the API?
*/

public class MRKPirateBae {
    public static void main(String[] args) {
        
        Deck<String> deck = new Deck<String>();

        deck.addFirst("a");
        deck.addFirst("b");
        deck.addFirst("c");

        deck.addLast("x");
        deck.addLast("y");
        deck.addLast("z"); 

        //remove from end
        System.out.println("Remove from end: ");
        while ( ! deck.isEmpty() ) System.out.print( deck.removeLast() + " " );
        
        deck.addFirst("a");
        deck.addFirst("b");
        deck.addFirst("c");

        deck.addLast("x");
        deck.addLast("y");
        deck.addLast("z"); 

        //remove from beginning
        System.out.println("\nRemove from beginning: ");
        while ( ! deck.isEmpty() ) System.out.print( deck.removeFirst() + " " );

        //shuffle the order up
        deck.addFirst("a");
        deck.addLast("x");

        deck.addFirst("b");
        deck.addLast("y");
        
        deck.addFirst("c");
        deck.addLast("z"); 

        //remove from beginning
        System.out.println("\nRemove from beginning w/ a twist: ");
        while ( ! deck.isEmpty() ) System.out.print( deck.removeFirst() + " " );
        
        //should give nulls
    	System.out.println("Poll test on empty deque:");
	    System.out.println( deck.pollFirst() );
    	System.out.println("Remove test on empty deque (should return error)");
	    System.out.println( deck.removeLast() );
    }
}
