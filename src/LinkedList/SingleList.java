package LinkedList;


import org.w3c.dom.Node;

/**
 * Describe:
 * 单链表 实现增删改查
 * Author: 九霄道长
 * CreateTime: 2021/12/28 11:57
 */

public class SingleList<T> {
    /**
     * 头链表
     */
    private Node head;
    /**
     * 链表容量
     */
    private int size;
    public class Node{
        private T element;
        private Node next;

        public Node(T element, Node next) {
            this.element = element;
            this.next = next;
        }

        public Node() {
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    ", next=" + next +
                    '}';
        }
    }

    public SingleList() {
        this.head = new Node();
        this.size = 0;
    }

    public void addToTail(T e){
        Node node = head;
        while (node.getNext() != null) {
            node=node.getNext();
        }
        node.setNext(new Node(e,null));
        size++;
    }
    public void addToHead(T e){
        Node node = head.getNext();
        head.setNext(new Node(e,node));
        size++;
    }
    public void addToIndexAfter(int index,T e){
        if (index<0||index>=size){
            return;
        }
        Node node = head.getNext();
        int i=0;
        while (node != null) {
            if (i==index){
                node.setNext(new Node(e,node.getNext()));
                break;
            }
            node=node.getNext();
            i++;
        }
        size++;
    }
    public void addToIndexBefore(int index,T e){
        if (index<0||index>=size){
            return;
        }
        Node node = head;
        int i=0;
        while (node != null) {
            if (i==index){
                node.setNext(new Node(e, node.getNext()));
                break;
            }
            node=node.getNext();
            i++;
        }
        size++;
    }
    public void deleteByIndex(int index){
        if (index < 0 || index >= size) {
            return;
        }
        Node node = head;
        int i =0;
        while (node != null&&node.getNext() != null) {
            if (i == index) {
                node.setNext(node.getNext().getNext());
                break;
            }
            i++;
            node = node.getNext();
        }

        size--;
    }
    public void deleteByTail(){
        deleteByIndex(size-1);
    }
    public void deleteByHead(){
        deleteByIndex(0);
    }
    public void updateByIndex(int index,T e){
        Node node = selectByIndexToBefore(index);
        if (node == null) {
            return;
        }
        node.getNext().setElement(e);
    }
    public Node selectByIndex(int index){
        Node node = head.getNext();
        int i =0;
        while (node != null) {
            if (i == index) {
                return node;
            }
            node=node.getNext();
            i++;
        }
        return null;
    }
    public Node selectByIndexToBefore(int index){
        if (index <= 0) {
            return head;
        }
        index--;
        Node node = head.getNext();
        int i =0;
        while (node != null) {
            if (i == index) {
                return node;
            }
            node=node.getNext();
            i++;
        }
        return null;
    }
    public void printAll(){
        Node node = head.getNext();
        while (node != null) {
            System.out.print(node.element+",");
            node = node.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SingleList<Object> objectPalindrome = new SingleList<>();
        objectPalindrome.addToTail(1);
        objectPalindrome.addToTail(2);
        objectPalindrome.addToTail(3);
        objectPalindrome.addToTail(4);
        objectPalindrome.deleteByTail();
        objectPalindrome.deleteByHead();
        objectPalindrome.updateByIndex(10,999);

        objectPalindrome.printAll();

    }
}
