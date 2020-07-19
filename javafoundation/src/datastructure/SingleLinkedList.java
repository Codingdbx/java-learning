package datastructure;

/**
 * 单向链表
 * <p>
 * created by dbx on 2019/4/14
 */
public class SingleLinkedList {

    private int size;//链表节点的个数
    private Node head;//头节点

    private class Node {

        private Object item;//元素
        private Node next; //下一个节点的引用

        public Node(Object obj) {
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
            node.next = head;//指向原来的头节点
            head = node;//将head指向新的节点
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

    //在链表的index(0--based)的位置添加新的元素
    public void add(int index, Object obj) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("位置不合法");
        }

        //对于头节点的特殊处理
        if (index == 0) {
            addHead(obj);
        } else {
            Node prev = head;
            //获取到需要添加元素位置的前一个元素
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }

            Node node = new Node(obj);
            node.next = prev.next;
            prev.next = node;

            size++;
        }

    }

    //判断链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }
}
