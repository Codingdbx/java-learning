package datastructure;

/**
 * 单向链表实现-背包
 *
 * created by dbx on 2019/4/14
 */
public class Bag {

    private SingleLinkedList list;

    public Bag(){
        list=new SingleLinkedList();
    }

    //添加元素
    public void add(Object obj){
        list.addHead(obj);
    }

    //返回背包元素大小
    public int getSize(){
        return list.getSize();
    }

    //判断是否为空
    public boolean isEmpty(){
        return list.isEmpty();
    }
}
