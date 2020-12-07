import java.util.ArrayList;
import java.util.Iterator;
public class LinkedBinaryTree<T> implements BinaryTreeADT<T> {
    protected int count;
    protected BinaryTreeNode<T> root;

    public LinkedBinaryTree() {
        count = 0;
        root = null;
    }

    public LinkedBinaryTree(T element, LinkedBinaryTree<T> leftSubTree, LinkedBinaryTree<T> rightSubTree) {
        count = 1;
        root = new BinaryTreeNode<T>(element);
        if (leftSubTree != null) {
            count = count + leftSubTree.size();
            root.setLeft(leftSubTree.root);
        } else
            root.setLeft(null);

        if (rightSubTree != null) {
            count = count + rightSubTree.size();
            root.setRight(rightSubTree.root);
        } else
            root.setRight(null);
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public T getRootElement() {
        if (root == null)
            throw new EmptyCollectionException("LinkedBinaryTree");
        return root.element;
    }

    public BinaryTreeNode<T> getRootNode() {
        if (root == null)
            throw new EmptyCollectionException("LinkedBinaryTree");
        return root;
    }

    public boolean contains(T targetElement) {
        boolean found = false;
        try {
            T temp = find(targetElement);
            found = true;
        } catch (ElementNotFoundException ex) {
            found = false;
        }

        return found;
    }

    public T find(T targetElement) {
        BinaryTreeNode<T> result = findNode(targetElement, root);
        if (result == null)
            throw new ElementNotFoundException("Linked Binary Tree");
        return result.getElement();
    }

    // Tim node
    public BinaryTreeNode<T> findNode(T targetElement, BinaryTreeNode<T> next) {
        if (next == null)
            return null;

        if (next.getElement().equals(targetElement))
            return next;

        BinaryTreeNode<T> left = findNode(targetElement, next.getLeft());
        if (left != null)
            return left;

        BinaryTreeNode<T> right = findNode(targetElement, next.getRight());
        if (right != null)
            return right;

        return null;
    }

    public void inOrder(BinaryTreeNode<T> root, ArrayList<T> temp) {
        if (root != null) {
            inOrder(root.left, temp);
            temp.add(root.element);
            inOrder(root.right, temp);
        }
    }

    public void preOder(BinaryTreeNode<T> root, ArrayList<T> temp) {
        if (root != null) {
            temp.add(root.element);
            preOder(root.left, temp);
            preOder(root.right, temp);
        }
    }

    public void postOder(BinaryTreeNode<T> root, ArrayList<T> temp) {
        if (root != null) {
            postOder(root.left, temp);
            postOder(root.right, temp);
            temp.add(root.element);
        }

    }
    public Iterator<T> iteratorInOrder() {
        ArrayList<T> temp = new ArrayList<T>();
        inOrder(root, temp);
        return temp.iterator();
    }

    public Iterator<T> iteratorPreOrder() {
        ArrayList<T> temp1 = new ArrayList<T>();
        preOder(root, temp1);
        return temp1.iterator();
    }

    public Iterator<T> iteratorPostOrder() {
        ArrayList<T> temp2 = new ArrayList<T>();
        postOder(root, temp2);
        return temp2.iterator();
    }

}
