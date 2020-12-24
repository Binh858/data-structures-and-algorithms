public class EmptyCollectionException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 8084488539524488189L;

    public EmptyCollectionException(String collection)
    {
        super("The " + collection + " is empty");
    }
}
