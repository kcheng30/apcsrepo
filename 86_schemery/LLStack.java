
import java.util.LinkedList;
import java.util.List;

public class LLStack<PANCAKE> implements Stack<PANCAKE>{

    private List<PANCAKE> _stack;

    public LLStack(){
        _stack = new LinkedList<PANCAKE>();
    }

    //Return true if this stack is empty, otherwise false.
    public boolean isEmpty() {
        return _stack.size() == 0;
    }
    //Return top element of stack without popping it.
    public PANCAKE peekTop(){
        return _stack.get( _stack.size() - 1 );
    };

    //Pop and return top element of stack.
    public PANCAKE pop(){
        return _stack.remove( _stack.size()-1 ); 
    };

    //Push an element onto top of this stack.
    public void push( PANCAKE x ){
        _stack.add( x );
    };

}