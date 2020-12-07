import java.util.*;
import java.util.Iterator;

public class ArrayList<T> extends MyAbstractList<T> {
    public static final int INITIAL_CAPACITY = 16;
    protected T[] data = (T[]) new Object[INITIAL_CAPACITY];
   
    public ArrayList(T [] objects)
    {
        for(int i=0;i<objects.length;i++)
        {
            add(objects[i]);
        }
    }

    @Override
    /** Add a new element at the specified index */
    public void add(int index, T e) {
        ensureCapacity();
        // Move the elements to the right after the specified index
        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];
        // Insert new element to data[index]
        data[index] = e;
        // Increase size by 1
        size++;
    }

    /**
     * Create a new larger array, double the current size + 1
     */
    private void ensureCapacity() {
        if (size >= data.length) {
            T[] newData = (T[]) (new Object[size * 2 + 1]);
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    @Override
    /** Clear the list */
    public void clear() {
        data = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    /** Return true if this list contains the element */
    public boolean contains(T e) {
        for (int i = 0; i < size; i++)
            if (e.equals(data[i]))
                return true;
        return false;
    }

    @Override
    /** Return the element at the specified index */
    public T getIndex(int index) {
        checkIndex(index);
        return data[index];

    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index " + index + " out of bounds");
    }

    @Override
    /**
     * Return the index of the first matching element 66 * in this list. Return -1
     * if no match.
     */
    public int indexOf(T e) {
        for (int i = 0; i < size; i++)
            if (e.equals(data[i]))
                return i;
        return -1;
    }

    @Override
    /**
     * Return the index of the last matching element 75 * in this list. Return -1 if
     * no match.
     */
    public int lastIndexOf(T e) {

        for (int i = size - 1; i >= 0; i--)
            if (e.equals(data[i]))
                return i;
        return -1;
    }

    @Override
    /**
     * Remove the element at the specified position 84 * in this list. Shift any
     * subsequent elements to the left. 85 * Return the element that was removed
     * from the list.
     */
    public T remove(int index) {
        checkIndex(index);

        T e = data[index];

        // Shift data to the left
        for (int j = index; j < size - 1; j++)
            data[j] = data[j + 1];

        data[size - 1] = null; // This element is now null

        // Decrement size
        size--;
        return e;
    }

    @Override
    /**
     * Replace the element at the specified position in this list with the specified
     * element.
     */
    public T set(int index, T e) {
        checkIndex(index);
        T old = data[index];
        data[index] = e;
        return old;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i < size - 1)
                result.append(", ");
        }

        return result.toString() + "]";
    }

    /**
     * Trims the capacity to current size
     */
    public void trimToSize() {

        if (size != data.length) {
            T[] newData = (T[]) (new Object[size]);
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        } // If size == capacity, no need to trim
    }

    @Override
    /** Override iterator() defined in Iterable */
    public java.util.Iterator iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements java.util.Iterator {
        private int current = 0; // Current index

        @Override
        public boolean hasNext() {
            return (current < size);
        }

        @Override
        public T next() {
            return data[current++];
        }

        @Override
        public void remove() {
            ArrayList.this.remove(current);
        }
    }
}
