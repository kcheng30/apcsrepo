//TNPG: Froghats 
//Roster: Alif Rahman, Salaj Rijal, Kevin Cheng
//APCS
//HW90 -- Swabbing the Deque
//2022-04-12
//time spent: .5 hours

import java.util.LinkedList;

public class Deck<T> implements Deque<T>{

    private LinkedList<T> wrapped = new LinkedList<T>();

    //remove the first element
    public T removeFirst(){
        return wrapped.removeFirst();
    }

    //remove the last element
    public T removeLast(){
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

    //test cases
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

    }

}