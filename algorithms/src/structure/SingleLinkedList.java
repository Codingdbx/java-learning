package structure;

/**
 * <p>Description: 单向链表的实现</p>
 *
 * @author dbx
 * @date 2020/9/22 16:13
 * @since JDK1.8
 */
public class SingleLinkedList {

    private int size;//链表节点的个数
    private Node head;//头节点

    //单向链表节点类
    private class Node {
        private Object item;//当前元素
        private Node next; //下一个节点的引用
        Node(Object obj) {
            this.item = obj;
        }
    }

    //在链表头添加元素
    public Object addHead(Object obj) {
        Node node = new Node(obj);
        //链表为空
        if (head == null) {
            head = node;
        } else {
            node.item = obj;
            node.next = head;//1.指向原来的头节点
            head = node;//2.将head指向新的节点
        }
        size++;
        return obj;
    }

    //在链表头删除元素
    public Object deleteHead() {
        Object obj = head.item;
        head = head.next;//删除头部元素
        size--;
        return obj;
    }

    //在链表尾添加元素
    public Object addLast(Object obj) {
        //①找到链表的最后一个节点
        Node oldLast = null;
        while (head.next != null) {
            oldLast = head.next;
        }
        //②将新的节点和原来的最后一个节点连接起来
        Node last = new Node(obj);
        oldLast.next = last;
        size++;
        return obj;
    }

    //判断链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

}
