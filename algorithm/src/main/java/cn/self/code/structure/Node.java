package cn.self.code.structure;

/**
 * 链表对象
 * @author andy
 */
public class Node {

    // 数据域，存放String类的数据
    Object data;
    // 指向下一个节点
    Node next;
    // 构造函数
    public Node(Object data) {
        setData(data);
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 返回数据
     */
    public Object getData() {
        return data;
    }
}
