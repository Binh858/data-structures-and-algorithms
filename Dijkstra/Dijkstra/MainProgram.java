import java.util.Iterator;

public class MainProgram {
    public static void main(String[] args)
    {
        Graph<String> graph = new Graph<String>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("E");
        graph.addVertex("D");
        graph.addVertex("C");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("B", "E");
        graph.addEdge("B", "D");
        graph.addEdge("C", "E");
        graph.addEdge("C", "D");
        graph.addEdge("E", "D");

        // Iterator<String> it = graph.iteratorDFS("A");
        // while(it.hasNext())
        // {
        //     // System.out.println(it.next());
        // }

        Iterator<String> it2 = graph.iteratorBFS("A");

        while(it2.hasNext())
        {
            System.out.println(it2.next());
        }

        Network<String> network = new Network<String>();
        network.addVertex("A");
        network.addVertex("B");
        network.addVertex("C");
        network.addVertex("D");
        network.addVertex("E");
        network.addVertex("F");


        network.addEdge("A", "B", 4);
        network.addEdge("A", "C", 3);
        network.addEdge("B", "C", 1);
        network.addEdge("B", "D", 2);
        network.addEdge("C", "D", 4);
        network.addEdge("D", "E", 2);
        network.addEdge("E", "F", 6);

        network.dijkstraMinDistance("A");
    }
}
