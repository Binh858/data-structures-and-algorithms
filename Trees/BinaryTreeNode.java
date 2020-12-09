public class BinaryTreeNode {

    private Node value;

    private BinaryTreeNode left;

    private BinaryTreeNode right;

    /* Các phương thức khởi dựng */

    public BinaryTreeNode() {

        value = new Node();

        left = null;

        right = null;

    }

    public BinaryTreeNode(Node value) {

        this.value = value;

        left = null;

        right = null;

    }

    /* Phương thức truy nhập thuộc tính value */

    public Node getValue() {

        return value;

    }

    public void setValue(Node value) {

        this.value = value;

    }

    /* Phương thức truy nhập thuộc tính left */

    public BinaryTreeNode getLeft() {

        return left;

    }

    public void setLeft(BinaryTreeNode left) {

        this.left = left;

    }

    /* Phương thức truy nhập thuộc tính right */

    public BinaryTreeNode getRight() {

        return right;

    }

    public void setRight(BinaryTreeNode right) {

        this.right = right;

    }

}