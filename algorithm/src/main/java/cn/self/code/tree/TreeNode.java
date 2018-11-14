package cn.self.code.tree;

public class TreeNode<E> {

    E node;

    private TreeNode < String > left;

    private TreeNode < String > right;

    public TreeNode(E e) {
        this(e, null, null);
    }

    public TreeNode(E e, TreeNode < String > left, TreeNode < String > right) {
        this.node = e;
        this.left = left;
        this.right = right;
    }

    public TreeNode < String > left() {
        return left;
    }
    public TreeNode < String > right() {
        return right;
    }
}
