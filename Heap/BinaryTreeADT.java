import java.util.Iterator;
public class interface BinaryTreeADT<T> extends Iterable<T>
{
    //tra ve du lieu ben trong root
    public T getRootElement();
    //
    public boolean isEmpty();
    public int size();
    //kiem tra mot phan tu co ton tai trong cay hay ko
    public boolean contains(T targetElement);
    //
    public T find(T targetElement);
    //public String toString();
    public T sum(T element);
    public Iterator<T> iterator();
    public Iterator<T> iteratorInOrder();
    public Iterator<T> iteratorPreOrder();
    public Iterator<T> iteratorPostOrder();
    public Iterator<T> iteratorLevelOrder();
}