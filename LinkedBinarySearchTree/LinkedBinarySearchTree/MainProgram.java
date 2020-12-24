import java.util.Iterator;

public class MainProgram {
    public static void main(String[] args)
    {
        // LinkedBinaryTree<String> D = new LinkedBinaryTree<String>("D", null, null);
        // LinkedBinaryTree<String> E = new LinkedBinaryTree<String>("E", null, null);
        // LinkedBinaryTree<String> B = new LinkedBinaryTree<String>("B", D, E);
        // LinkedBinaryTree<String> C = new LinkedBinaryTree<String>("C", null, null);
        // LinkedBinaryTree<String> A = new LinkedBinaryTree<String>("A", B, C);

        // Iterator<String> it = A.iteratorInOrder();

        // while(it.hasNext())
        // {
        //     String result = it.next();
        //     System.out.println(result+" ");
        // }
        LinkedBinarySearchTree<Integer> A  = new LinkedBinarySearchTree<Integer>(10);
        A.addElement(20);
        A.addElement(6);
        A.addElement(15);
        A.addElement(89);
        A.addElement(7);
        A.addElement(12);
        Iterator<Integer> it = A.iteratorInOrder();

        while(it.hasNext())
        {
        Integer result = it.next();
        System.out.println(result+" ");
        }
        System.out.println("Height Binary Search Tree: "+A.height());
}
}
