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


public interface Deque<T> {
   	
    public T removeLast();

    public T removeFirst();

    public void addFirst( T x );

    public void addLast( T x );

    public T peekFirst();

    public T peekLast();

    public int size();

    public boolean isEmpty();

    public T pollFirst();

    public T pollLast();
    /*
    */
}
