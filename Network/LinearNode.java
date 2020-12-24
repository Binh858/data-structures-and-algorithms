public class LinearNode<T> {
    private LinearNode<T> next;
    private T element;

    public LinearNode(T element)
    {
        this.element = element;
        next = null;
    }

    public T getElement()
    {
        return this.element;
    }

    public void setElement(T element)
    {
        this.element = element;
    }

    public LinearNode<T> getNext()
    {
        return this.next;
    }

    public void setNext(LinearNode<T> next)
    {
        this.next = next;
    }
}
