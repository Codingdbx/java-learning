package structure;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 下压堆栈的实现,使用了链表数据结构（链表的特点是：寻址困难，插入和删除容易）
 *
 * Created by DBC-PC on 2018/7/28
 */
public class Stack<Item> implements  Iterable<Item> {

    private Node<Item> head;//栈顶
    private int n;//元素数量

    //定义了节点的嵌套类
    private class Node<Item>{
        Item item;
        Node<Item> next;
    }

    public boolean isEmpty(){
        return  head==null;
    }

    public int size(){
        return  n;
    }

    //向栈顶添加元素
    public void push(Item item){
        Node oldfirst=head;
        head=new Node();
        head.item=item;
        head.next=oldfirst;
        n++;
    }

    //从栈顶删除元素
    public Item pop(){
        Item item=head.item;
        head=head.next;
        n--;
        return  item;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    private class ListIterator<Item> implements Iterator<Item> {

        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item=current.item;
            current=current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }
}
