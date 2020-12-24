public class LinkedStack<T> implements StackADT<T> {
    private int count;
    private LinearNode<T> top;

    public LinkedStack()
    {
        count = 0;
        top = null;
    }

    public void push(T element)
    {
        LinearNode<T> temp = new LinearNode<T>(element);
        temp.setNext(top);
        top = temp;
        count++;
    }

    public T pop()
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");
        T result = top.getElement();
        top = top.getNext();
        count--;
        return result;
    }

    public T peek()
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");
        return top.getElement();
    }

    public boolean isEmpty()
    {
        return (count == 0);
    }

    public int size()
    {
        return count;
    }
}
