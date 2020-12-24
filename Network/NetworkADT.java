import java.util.Iterator;

public interface NetworkADT<T> extends GraphADT<T>
{
   public void addEdge (T vertex1, T vertex2, double weight);
   
   // public void dijkstraMinDistance(T sourceVertex);
}
