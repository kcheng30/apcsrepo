import java.util.ArrayList;
import java.util.List;


public class ALQueue<QUASAR> implements Queue<QUASAR> {

    private List<QUASAR> wrapped = new ArrayList<QUASAR>(); 


    public QUASAR peekFront(){
        return wrapped.get(0);
    }

    public QUASAR dequeue(){
        return wrapped.remove(0);
    }

    public void enqueue( QUASAR s ){
        wrapped.add(s);
    }

    public boolean isEmpty(){
        return wrapped.size() <= 0;
    }

}
