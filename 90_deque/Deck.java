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


import java.util.*;

public class Deck<T> implements Deque<T>{

    private LinkedList<T> wrapped = new LinkedList<T>();

    //remove the first element
    public T removeFirst(){
	if ( isEmpty() )
		throw new NoSuchElementException();
        return wrapped.removeFirst();
    }

    //remove the last element
    public T removeLast(){
	if ( isEmpty() )
		throw new NoSuchElementException();
        return wrapped.removeLast();
    }

    //add T x to the front of queue
    public void addFirst( T x){
        wrapped.addFirst(x);
    }

    //add T x to the end of queue
    public void addLast( T x){
        wrapped.addLast(x);
    }

    //peek the front element of queue
    public T peekFirst(){
        return wrapped.getFirst();
    }

    //peek the end element of the queue
    public T peekLast(){
        return wrapped.getLast();
    }


    //get the size of queue
    public int size(){
        return wrapped.size();
    }

    //check if queue
    public boolean isEmpty(){
        return size() <= 0;
    }

    //remove first but return null instead of error when empty
    public T pollFirst() {
        try   {
            return removeFirst();
        }
	    catch ( Exception e )	 {
            return null;
        }
    }
    
    //remove first but return null instead of error when empty
	public T pollLast() {
	    try {
		return removeLast();
		    }
	    catch ( Exception e ) {
		    return null;
	  }
	   }

}
