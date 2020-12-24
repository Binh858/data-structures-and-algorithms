import java.util.*;

public class Network<T>  extends Graph<T> implements NetworkADT<T>
{
   private double[][] adjMatrix;    // adjacency matrix

   @SuppressWarnings("unchecked")
   public Network()
   {
      numVertices = 0;
      this.adjMatrix = new double[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
      this.vertices = (T[])(new Object[DEFAULT_CAPACITY]);
   }

   public void addEdge (int index1, int index2, double weight)
   {
      if (indexIsValid(index1) && indexIsValid(index2))
      {
         adjMatrix[index1][index2] = weight;
         adjMatrix[index2][index1] = weight;
      }
   }

   public void removeEdge (int index1, int index2)
   {
      if (indexIsValid(index1) && indexIsValid(index2))
      {
         adjMatrix[index1][index2] = Double.POSITIVE_INFINITY;
         adjMatrix[index2][index1] = Double.POSITIVE_INFINITY;
      }
   }

   public void addEdge (T vertex1, T vertex2, double weight)
   {
      addEdge (getIndex(vertex1), getIndex(vertex2), weight);
   }

   public void addEdge (T vertex1, T vertex2)
   {
      addEdge (getIndex(vertex1), getIndex(vertex2), 0);
   }

   public void removeEdge (T vertex1, T vertex2)
   {
      removeEdge (getIndex(vertex1), getIndex(vertex2));
   }

   public void addVertex ()
   {
      if (numVertices == vertices.length)
         expandCapacity();

      vertices[numVertices] = null;
      for (int i = 0; i <= numVertices; i++)
      {
         adjMatrix[numVertices][i] = Double.POSITIVE_INFINITY;
         adjMatrix[i][numVertices] = Double.POSITIVE_INFINITY;
      }      
      numVertices++;
   }

   public void addVertex (T vertex)
   {
      if (numVertices == vertices.length)
         expandCapacity();

      vertices[numVertices] = vertex;
      for (int i = 0; i <= numVertices; i++)
      {
         adjMatrix[numVertices][i] = Double.POSITIVE_INFINITY;
         adjMatrix[i][numVertices] = Double.POSITIVE_INFINITY;
      }      
      numVertices++;
   }

   public void removeVertex (int index)
   {
      if (indexIsValid(index))
      {
         numVertices--;

         for (int i = index; i < numVertices; i++)
            vertices[i] = vertices[i+1];

         for (int i = index; i < numVertices; i++)
            for (int j = 0; j <= numVertices; j++)
               adjMatrix[i][j] = adjMatrix[i+1][j];

         for (int i = index; i < numVertices; i++)
            for (int j = 0; j < numVertices; j++)
               adjMatrix[j][i] = adjMatrix[j][i+1];
      }
   }

   public void removeVertex (T vertex)
   {
      for (int i = 0; i < numVertices; i++)
      {
         if (vertex.equals(vertices[i]))
         {
            removeVertex(i);
            return;
         }
      }
   }

   public Iterator<T> iteratorDFS(int startIndex)
   {
      Integer x;
      boolean found;
      LinkedStack<Integer> traversalStack = new LinkedStack<Integer>();
      ArrayList<T> resultList = new ArrayList<T>();
      boolean[] visited = new boolean[numVertices];

      if (!indexIsValid(startIndex))
         return resultList.iterator();

      for (int i = 0; i < numVertices; i++)
         visited[i] = false;
      
      traversalStack.push(startIndex);
      resultList.add(vertices[startIndex]);
      visited[startIndex] = true;
      
      while (!traversalStack.isEmpty())
      {
         x = traversalStack.peek();
         found = false;

         /** Find a vertex adjacent to x that has not been visited
             and push it on the stack */
         for (int i = 0; (i < numVertices) && !found; i++)
         {
            if((adjMatrix[x.intValue()][i] < Double.POSITIVE_INFINITY)
               && !visited[i])
            {
               traversalStack.push(i);
               resultList.add(vertices[i]);
               visited[i] = true;
               found = true;
            }
         }
         if (!found && !traversalStack.isEmpty())
            traversalStack.pop();
      }
      return resultList.iterator();
   }

   public Iterator<T> iteratorDFS(T startVertex)
   {      
      return iteratorDFS(getIndex(startVertex));
   }

   public Iterator<T> iteratorBFS(int startIndex)
   {
      Integer x;
      LinkedQueue<Integer> traversalQueue = new LinkedQueue<Integer>();
      ArrayList<T> resultList = new ArrayList<T>();

      if (!indexIsValid(startIndex))
         return resultList.iterator();

      boolean[] visited = new boolean[numVertices];
      for (int i = 0; i < numVertices; i++)
         visited[i] = false;
      
      
      traversalQueue.enqueue(startIndex);
      visited[startIndex] = true;
      
      while (!traversalQueue.isEmpty())
      {
         x = traversalQueue.dequeue();
         resultList.add(vertices[x.intValue()]);

         /** Find all vertices adjacent to x that have not been 
             visited and queue them up */
         for (int i = 0; i < numVertices; i++)
         {
            if((adjMatrix[x.intValue()][i] < Double.POSITIVE_INFINITY)
               && !visited[i])
            {
               traversalQueue.enqueue(i);
               visited[i] = true;
            }
         }
      }
      return resultList.iterator();
   }

   public Iterator<T> iteratorBFS(T startVertex)
   {      
      return iteratorBFS(getIndex(startVertex));
   }

   @SuppressWarnings("unchecked")
   protected void expandCapacity()
   {
      T[] largerVertices = (T[])(new Object[vertices.length*2]);
      double[][] largerAdjMatrix = 
         new double[vertices.length*2][vertices.length*2];

      for (int i = 0; i < numVertices; i++)
      {
         for (int j = 0; j < numVertices; j++)
         {
            largerAdjMatrix[i][j] = adjMatrix[i][j];
         }
         largerVertices[i] = vertices[i];
      }

      vertices = largerVertices;
      adjMatrix = largerAdjMatrix;
   }


   private int getMininumVertex(boolean[] spt, double[] distance)
   {
      double min = Double.POSITIVE_INFINITY;
      int vertex = -1;
      for(int i=0;i< numVertices; i++)
      {
         if (spt[i]==false && min>distance[i])
         {
            min = distance[i];
            vertex = i;
         }
      }

      return vertex;
   }

   @Override
   public void dijkstraMinDistance(T sourceVertex) {
      int sourceVertexIndex = getIndex(sourceVertex);

      boolean[] spt = new boolean[numVertices];
      double[] distance = new double[numVertices] ;
      double INFINITY = Double.POSITIVE_INFINITY;

      for (int i = 0; i<numVertices; i++)
      {
         distance[i] = INFINITY;
         spt[i] = false;
      }

      distance[sourceVertexIndex] = 0;

      for (int i = 0; i < numVertices; i++)
      {
         int nextIndex = getMininumVertex(spt,distance);

         spt[nextIndex] = true;

         for(int v =0; v<numVertices; v++)
         {
            if (adjMatrix[nextIndex][v]>0)
            {
               if (spt[v] == false && adjMatrix[nextIndex][v] != INFINITY)
               {
                  double k = adjMatrix[nextIndex][v] + distance[nextIndex];
                  if (k < distance[v])
                     distance[v] = k;
               }
            }
         }  
      }
      
      for(int i=0;i<numVertices;i++)
      {
         System.out.println("From " + vertices[sourceVertexIndex]+" to " + vertices[i] + ":" + distance[i]);
      }
   }
}
