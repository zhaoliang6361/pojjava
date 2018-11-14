package cn.self.code.tree;

public class TreeReader {
    public static void main(String[] args) {
        TreeNode < String > n1 = new TreeNode < String > ("n1");
        TreeNode < String > n2 = new TreeNode < String > ("n2");
        TreeNode < String > n3 = new TreeNode < String > ("n3");
        TreeNode < String > n4 = new TreeNode < String > ("n4");
        TreeNode < String > n5 = new TreeNode < String > ("n5");
        TreeNode < String > n6 = new TreeNode < String > ("n6", null, n1);
        TreeNode < String > n7 = new TreeNode < String > ("n7", n2, null);
        TreeNode < String > n8 = new TreeNode < String > ("n8", n7, null);
        TreeNode < String > n9 = new TreeNode < String > ("n9", null, n5);
        TreeNode < String > n10 = new TreeNode < String > ("n10", n4, n9);
        TreeNode < String > n11 = new TreeNode < String > ("n11", n6, n8);
        TreeNode < String > n12 = new TreeNode < String > ("n12", n3, n10);
        TreeNode < String > root = new TreeNode < String > ("root", n11, n12);
        MyTree tree = new MyTree(root);
        TreeEnum eum = tree.getEnumerator();
        while (eum.hasMoreElement()) {
            System.out.print(eum.next().node + "--");
        }
        System.out.println("end");
    }

}
