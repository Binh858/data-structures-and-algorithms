public class EmptyCollectionException extends RuntimeException{
    public EmptyCollectionException(String collection)
    {
        super("The colletion" +collection+"is Empty");
    }
    
}
