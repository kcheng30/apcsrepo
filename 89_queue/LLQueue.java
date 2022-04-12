import java.util.List;
import java.util.LinkedList;

public class LLQueue<QUASAR> implements Queue<QUASAR> {

    private List<QUASAR> wrapped = new LinkedList<QUASAR>(); 


    public QUASAR peekFront(){
        return wrapped.get(0);
    }

    public QUASAR dequeue(){
        return wrapped.remove(0);
    }

    public void enqueue( QUASAR x ){
        wrapped.add(x);
    }

    public boolean isEmpty(){
        return wrapped.size() <= 0;
    }

}
