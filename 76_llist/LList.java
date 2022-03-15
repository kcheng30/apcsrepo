public class LList implements List {

    //lastest pointer
    private LLNode last;
    
    //pointer to first item in list
    private LLNode first;
    
    //amount of items in the list
    private int length;

    //Constructor: 
    //Time Complexity:
    public LList( String firstValue ){
        length = 1;
        first = new LLNode( firstValue, null);
        last = first; 
    }
    
    public String toString() {
        String result = "{" + this.get(0);
        for( int i = 1; i < length; i++){
            result+= "," + this.get(i);
        }
        result += "}";
        return result;
    }

    //Time Complexity: O(1)
    public boolean add(String x){
        //set the next of last node to a new node that has value x
        last.setNext( new LLNode( x,  null) );
        //set last to the node that was just made
        last = last.getNext();
        //increment length by 1
        length++;
        //return true when done
        return true;
    };

    //Time Complexity: O(n)
    public String get(int i){
        //create a temp value to not interfere with original first LLNode
        LLNode temp = first;
        //iterate through linked list until we get to desiered node (the ith node)
        for (int o = 0; o < i; o++) {
            //as we iterate, we move down the linked list until we get to the ith node
            //we "move down" by setting temp to its next node
            temp = temp.getNext();
        }
        //return the cargo of the ith node
        return temp.getCargo();
    };

    //Time Complexity: O(n)
    public String set(int i, String x){
        //create a temp value
        LLNode temp = first;
        //go deeper into the node tree until we reach desired length
        for( int o = 0; o < i; o++){
            temp = temp.getNext();
        }
        //create foo to store the old value
        String foo = temp.getCargo();
        //set the cargo to the new value
        temp.setCargo(x);
        //return the old value
        return foo;
    };

    //Time Complexity: O(1)
    public int size(){
        return length;
    };



    public static void main(String[] args) {
        //constructor test
        LList froghats = new LList( "alif" );
        System.out.println(froghats );
        
        //add test
        System.out.println("");
        froghats.add( "salaj" );
        froghats.add( "kevin" );
        froghats.add( "fred");
        System.out.println(froghats );

        //get test
        System.out.println("");
        System.out.println( froghats.get(0) );
        System.out.println( froghats.get(3) );
        
        //set test
        System.out.println("");
        System.out.println( froghats );
        froghats.set( 3, "george" );
        System.out.println( froghats );

    }

}
