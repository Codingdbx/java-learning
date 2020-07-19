package datastructure;


/**
 * 单向链表实现-队列
 * created by dbx on 2019/4/14
 */
public class Queue {
    private SingleLinkedList list;

    public Queue(){
        list = new SingleLinkedList();
    }

    //向表尾添加元素
    public void insert(Object obj){
        list.addLast(obj);
    }

    //从表头删除元素
    public void delete(){
        list.deleteHead();
    }

    //判断是否为空
    public boolean isEmpty(){
        return list.isEmpty();
    }
}
