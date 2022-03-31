
import java.util.ArrayList;

public class ALStack<PANCAKE> implements Stack<PANCAKE>{


    private ArrayList<PANCAKE> _stack; 

    public ALStack(){

        _stack = new ArrayList<PANCAKE>();

    }

    //Return true if this stack is empty, otherwise false.
    public boolean isEmpty(){
        return _stack.size() == 0;
    };

    //Return top element of stack without popping it.
    public PANCAKE peekTop(){
        return _stack.get( _stack.size()-1 );
    };

    //Pop and return top element of stack.
    public PANCAKE pop(){
        if( isEmpty() ) return null;
        return _stack.remove( _stack.size()-1 );
    };

    //Push an element onto top of this stack.
    public void push( PANCAKE x ){
        _stack.add(x);
    };

    

}