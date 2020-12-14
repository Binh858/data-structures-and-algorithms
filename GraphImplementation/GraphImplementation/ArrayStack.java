import java.util.Arrays;

public class ArrayStack<T> implements StackADT<T> {
    private int top;
    private T[] stack;

    @SuppressWarnings("unchecked")
    public ArrayStack(int initialCapacity)
    {
        top = 0;
        stack = (T[])(new Object[initialCapacity]);
    }

    public boolean isEmpty()
    {
        return (top == 0);
    }

    public int size()
    {
        return top;
    }

    public void push(T element)
    {
        if (size() == stack.length)
            expandCapacity();
        stack[top] = element;
        top++;
    }

    public T pop()
    {
        if(isEmpty())
        {
            throw new EmptyCollectionException("stack");
        }
        top--;
        T result = stack[top];
        stack[top] = null;
        return result;
    }

    public T peek()
    {
        if (isEmpty())
        {
            throw new EmptyCollectionException("stack");
        }
        return stack[top-1];
    }

    private void expandCapacity()
    {
        stack = Arrays.copyOf(stack, stack.length * 2);
    }
}
