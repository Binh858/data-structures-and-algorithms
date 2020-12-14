import java.util.Iterator;

public class MainProgram {
    public static void main(String[] args)
    {
        Graph<String> graph = new Graph<String>();
        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addVertex("5");
        graph.addVertex("6");
        graph.addVertex("7");
        graph.addVertex("8");        
        graph.addVertex("9");
        graph.addEdge("1", "2");
        graph.addEdge("1", "3");
        graph.addEdge("1", "4");
        graph.addEdge("2", "4");
        graph.addEdge("2", "5");
        graph.addEdge("3", "6");
        graph.addEdge("4", "6");
        graph.addEdge("5", "7");
        graph.addEdge("5", "8");
        graph.addEdge("6", "9");
        graph.addEdge("7", "9");
        graph.addEdge("8", "9");
    }
}
