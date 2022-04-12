public class Driver {
    
    public static void main(String[] args) {

        //choose one 
        //Queue<Integer> nums = new ALQueue<Integer>();
        Queue<Integer> nums = new LLQueue<Integer>();


        //testing
        for( int i = 0; i <= 20; i += 2) nums.enqueue(i);
        while( !nums.isEmpty() ){
            System.out.print( nums.peekFront() + " ");
            System.out.println( nums.dequeue() );
        }
    }
    
}
