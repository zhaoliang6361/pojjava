package cn.self.code.tree;

import java.util.Stack;

public class TreeEnum {
    private TreeNode < String > root;
    private Stack < TreeNode < String >> store; /* 保存遍历左子树但未遍历右子树的结点 */
    private TreeNode < String > next;
    public TreeEnum(TreeNode < String > root) {
        this.root = root;
        store = new Stack< TreeNode < String >>();
        next = root;
    }
    public TreeNode < String > next() {
        TreeNode < String > current = next;
        if (next != null) {
            /* 如果当前结点的左子树不为空,则遍历左子树,并标记当前结点未遍历右子树 */
            if (next.left() != null) {
                store.push(next);
                next = next.left();
            }
            // 如果当前结点的左子树为空,则遍历右子树
            else if (next.right() != null) {
                next = next.right();
            }
            /* 如果当前结点为叶子,则找未遍历右子树的结点并且遍历它的右子树 */

            else {
                if (!store.empty()) /* 判断是否还有结点的右子树未遍历 */ {
                    TreeNode < String > tmp = store.pop();
                    /* 如果有未遍历右子树的结点,但它的右子树为空,且还有结点的右子树未遍历, */
                    /* 则一直往上取,直到取到未遍历右子树且右子树不为空的结点,遍历它的右子树. */
                    while ((tmp.right() == null) && !store.empty()) {
                        tmp = store.pop();
                    }
                    next = tmp.right();
                }
                else {
                    /* 如果没有哪个结点右子树未遍历,则表示没有下一个结点了,设置next为null */
                    next = null;
                }
            }
        }
        return current;
    }
    public boolean hasMoreElement() {
        return next != null;
    }
}
