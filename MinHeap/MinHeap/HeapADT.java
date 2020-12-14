public interface HeapADT<T extends Comparable<T>> extends BinaryTreeADT<T> {
    public void addElement(T obj);
    public T removeMin();
    public T findMin();
}
