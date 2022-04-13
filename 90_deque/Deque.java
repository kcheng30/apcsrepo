public interface Deque<T> {
    
    public T removeLast();

    public T removeFirst();

    public void addFirst( T x);

    public void addLast( T x);

    public T peekFirst();

    public T peekLast();

    public int size();

    public boolean isEmpty();

}
