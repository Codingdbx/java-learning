package datastructure;

/**
 * 单向链表实现-下压堆栈
 * created by dbx on 2019/4/14
 */
public class Stack {

    private SingleLinkedList list;

    public Stack(){
        list=new SingleLinkedList();
    }

    //添加栈顶元素
    public void push(Object obj){
        list.addHead(obj);
    }

    //移除栈顶元素
    public void pop(){
        list.deleteHead();
    }

    //判断是否为空
    public boolean isEmpty(){
        return list.isEmpty();
    }
}
