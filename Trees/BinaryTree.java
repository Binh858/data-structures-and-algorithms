public class BinaryTree {

    private BinaryTreeNode root;

    /* Các phương thức khởi dựng */

    public BinaryTree() {

        root = null;

    }

    public BinaryTree(Node value) {

        root = new BinaryTreeNode(value);

    }

    /* Phương thức trả về node có giá trị @value */

    public BinaryTreeNode getNode(Node value) {

        return searchNode(root, value);

    }

    /*
     * Phương thức tìm kiếm đệ qui một node có giá trị @value
     * 
     * trên một cây con có gốc là @treeNode
     */

    private BinaryTreeNode searchNode(BinaryTreeNode treeNode, Node value) {

        if (treeNode.getValue().equals(value))

            return treeNode;

        if (treeNode == null)

            return null;

        BinaryTreeNode result = null;

        // Tìm trên nhánh con bên trái

        result = searchNode(treeNode.getLeft(), value);

        // Tìm trên nhánh con bên phải

        if (result == null)

            result = searchNode(treeNode.getRight(), value);

        return result;

    }

    /* Phương thức thêm node con bên trái của node @treeNode */

    public boolean insertLeft(BinaryTreeNode treeNode, Node value) {

        if ((treeNode == null) || (treeNode.getLeft() != null))

            return false;

        BinaryTreeNode newNode = new BinaryTreeNode(value);

        treeNode.setLeft(newNode);

        return true;

    }

    /* Phương thức thêm node con bên phải của node @treeNode */

    public boolean insertRight(BinaryTreeNode treeNode, Node value) {

        if ((treeNode == null) || (treeNode.getRight() != null))

            return false;

        BinaryTreeNode newNode = new BinaryTreeNode(value);

        treeNode.setRight(newNode);

        return true;

    }

    /* Phương thức xóa node con bên trái của node @treeNode */

    public boolean removeLeft(BinaryTreeNode treeNode) {

        // Node hiện tại rỗng

        if (treeNode == null)

            return false;

        // Node con trái không phải là node lá

        if ((treeNode.getLeft() != null) &&

                ((treeNode.getLeft().getLeft() != null) || (treeNode.getLeft().getRight() != null)))

            return false;

        treeNode.setLeft(null);

        return true;

    }

    /* Phương thức xoá node con bên phải của node @treeNode */

    public boolean removeRight(BinaryTreeNode treeNode) {

        // Node hiện tại rỗng

        if (treeNode == null)

            return false;

        // Node con phải không phải là node lá

        if ((treeNode.getRight() != null) &&

                ((treeNode.getRight().getLeft() != null) || (treeNode.getRight().getRight() != null)))

            return false;

        treeNode.setRight(null);

        return true;

    }

    /* Phương thức duyệt cây theo thứ tự trước */

    public Node[] preTravese() {

        Node[] result = null;

        preOrder(root, result);

        return result;

    }

    /*
     * Phương thức duyệt cây con @treeNode theo thứ tự trước và kết quả trả về nằm
     * trong @result
     */

    private void preOrder(BinaryTreeNode treeNode, Node[] result) {

        if (treeNode != null)

            addNode(result, treeNode.getValue());

        preOrder(treeNode.getLeft(), result);

        preOrder(treeNode.getRight(), result);

    }

    }

    /* Phương thức thêm một @node vào cuối một danh sách các @nodes */

    private void addNode(Node[] nodes, Node node) {

        if (nodes == null) {// Danh sách ban đầu rỗng

            nodes = new Node[1];

            nodes[0] = node;

            return;

        }

        Node[] tmpNodes = new Node[nodes.length + 1];

        for (int i = 0; i < nodes.length; i++)

            tmpNodes[i] = nodes[i];

        tmpNodes[nodes.length] = node;

        nodes = tmpNodes;

    }

    /* Phương thức duyệt cây theo thứ tự giữa */

    public Node[] inTravese() {

        Node[] result = null;

        inOrder(root, result);

        return result;

    }

    /*
     * Phương thức duyệt cây con @treeNode theo thứ tự giữa
     * 
     * và kết quả trả về nằm trong @result
     */

    private void inOrder(BinaryTreeNode treeNode, Node[] result) {

        if (treeNode != null) {

            inOrder(treeNode.getLeft(), result);

            addNode(result, treeNode.getValue());
            inOrder(treeNode.getRight(), result);

        }

    }

    /* Phương thức duyệt cây theo thứ tự sau */

    public Node[] posTravese() {

        Node[] result = null;

        posOrder(root, result);

        return result;

    }

    /*
     * Phương thức duyệt cây con @treeNode theo thứ tự sau và kết quả trả về nằm
     * trong @result
     */

    private void posOrder(BinaryTreeNode treeNode, Node[] result) {

        if (treeNode != null) {

            posOrder(treeNode.getLeft(), result);

            posOrder(treeNode.getRight(), result);

            addNode(result, treeNode.getValue());

        }

    }

}
