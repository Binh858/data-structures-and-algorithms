public class BinaryTest {
    
        
    public static void main (String [] args)
    {
        BinarySearchTree t = new BinarySearchTree("abc");
        t.insert("b12");
        t.insert("c23");
        t.insert("aaa");
        t.insert("b11");
        t.printSortedList();
        System.out.print("\n" + t.search("c23"));

    }
}