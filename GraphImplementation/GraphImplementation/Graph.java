import java.util.Iterator;
import java.util.ArrayList;

public class Graph<T> implements GraphADT<T> {
    private int numVertices;
    private boolean[][] adjMatrix;
    private T[] vertices;
    private int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public Graph()
    {
        numVertices = 0;
        adjMatrix = new boolean[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        vertices = (T[])(new Object[DEFAULT_CAPACITY]);
    }

    public void addEdge(int index1, int index2)
    {
        if (indexIsValid(index1) && indexIsValid(index2))
        {
            adjMatrix[index1][index2] = true;
            adjMatrix[index2][index1] = true;
        }
    }

    @Override
    public void addEdge(T vertex1, T vertex2) {
        addEdge(getIndex(vertex1), getIndex(vertex2));
    }

    public void removeEdge(int index1, int index2)
    {
        if(indexIsValid(index1) && indexIsValid(index2))
        {
            adjMatrix[index1][index2] = false;
            adjMatrix[index2][index1] = false;
        }
    }

    @Override
    public void removeEdge(T vertex1, T vertex2) {
        removeEdge(getIndex(vertex1), getIndex(vertex2));
    }

    public void addVertex()
    {
        if (numVertices == vertices.length)
            expandCapacity();
        vertices[numVertices] = null;

        for(int i=0; i<=numVertices; i++)
        {
            adjMatrix[numVertices][i] = false;
            adjMatrix[i][numVertices] = false;
        }
        numVertices++;
    }

    public void addVertex(T vertex)
    {
        if (numVertices == vertices.length)
            expandCapacity();
        vertices[numVertices] = vertex;

        for(int i=0; i<=numVertices; i++)
        {
            adjMatrix[numVertices][i] = false;
            adjMatrix[i][numVertices] = false;
        }
        numVertices++;
    }

    public void removeVertex(int index)
    {
        if(indexIsValid(index))
        {
            numVertices --;
            for(int i=index;i<numVertices;i++)
                vertices[i] = vertices[i+1];
            
            for (int i=index; i<numVertices;i++)
                for(int j=0; j<=numVertices; j++)
                    adjMatrix[i][j] = adjMatrix[i+1][j];
            
            for (int i=index; i<numVertices;i++)
                for(int j=0; j<=numVertices; j++)
                    adjMatrix[j][i] = adjMatrix[j][i+1];

        }
    }

    @Override
    public void removeVertex(T vertex) {
        removeVertex(getIndex(vertex));
    }


    @Override
    public boolean isEmpty() {
        return (numVertices == 0);
    }

    @Override
    public int size() {
        return numVertices;
    }

    @SuppressWarnings("unchecked")
    private void expandCapacity()
    {
        T[] largerVertices = (T[]) (new Object[vertices.length*2]);
        boolean[][] largerAdjMatrix = new boolean[vertices.length*2][vertices.length*2];

        for(int i=0;i<numVertices;i++)
        {
            for (int j=0;j<numVertices; j++)
            {
                largerAdjMatrix[i][j] = adjMatrix[i][j];
            }
            largerVertices[i] = vertices[i];
        }

        vertices = largerVertices;
        adjMatrix = largerAdjMatrix;
    }

    private boolean indexIsValid(int index)
    {
        return (index<numVertices && index>=0);
    }

    private int getIndex(T vertex)
    {
        for(int i =0; i<numVertices; i++)
        {
            if (vertices[i].equals(vertex))
                return i;
        }
        return -1;
    }
}
