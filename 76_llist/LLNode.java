public class LLNode {

    private String value;
    private LLNode connection;

    public LLNode( String value, LLNode connection){
         this.value = value;
         this.connection = connection;
    }

    public String car(){
        return value;
    }

    public LLNode cdr(){
        return connection;
    }

    public void setCar( String value ){
        this.value = value;
    }

    public void setCdr( LLNode connection ){
        this.connection = connection;
    }

}