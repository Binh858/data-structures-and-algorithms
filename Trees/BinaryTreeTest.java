public class BinaryTreeTest {
    public static void main (String [] args){

    BinaryTreeNode t2 = new BinaryTreeNode(); 
        int arr[] = { 1, 2, 3, 4, 5, 6, 6, 6, 6 }; 
        t2.root = t2.insertLevelOrder(arr, t2.root, 0); 
        t2.inOrder(t2.root);
    }
    
}
