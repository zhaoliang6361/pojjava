package cn.self.code.tree;

public class MyTree {
    TreeNode < String > root;
    public MyTree(TreeNode < String > root) {
        this.root = root;
    }
    public TreeEnum getEnumerator() {
        return new TreeEnum(root);
    }
}
