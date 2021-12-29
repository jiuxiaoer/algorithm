package LinkedList;



/**
 * Describe:
 * Author: 九霄道长
 * CreateTime: 2021/12/28 16:53
 */

public class DoubleLinkedList<T> {
    private Node head;
    private int size;


    public void addToTail(T element) {
        Node node = head;
        while (node.getNext() != null) {
            node = node.getNext();
        }
        node.setNext(new Node(element,null,node));
        size++;
    }
    public Node selectByIndex(int index){
        if (index<0||index > size) {
            return null;
        }
        Node node =head.getNext();
        int i=0;
        while (node != null) {
            if (i==index){
                return node;
            }
            i++;
            node = node.getNext();
        }
        return null;
    }
    public DoubleLinkedList() {
        this.head = new Node();
        this.size = 0;
    }

    public void addToAfter(int index,T element){
        if (index<0||index > size) {
            return ;
        }
        Node node = selectByIndex(index);
        node.setNext(new Node(element,node.getNext(),node));
        size++;
    }

    public void addToBefore(int index,T element){
        if (index<0||index > size) {
            return ;
        }
        Node node = selectByIndex(index).getHead();
        Node newNode = new Node(element, node.getNext(), node);
        node.getNext().setHead(newNode);
        node.setNext(newNode);
        size++;
    }
    public void addToHead(T element) {
        Node node = head.getNext();
        if (node != null) {
            Node snode = new Node(element, node, head);
            node.setHead(snode);
            head.setNext(snode);
        } else {
            head.setNext(new Node(element, node, head));
        }
        size++;
    }
    public void deleteByIndex(int index){
        if (index<0||index > size) {
            return ;
        }
        Node node = selectByIndex(index).getHead();
        node.setNext(node.getNext().getNext());
        if (node.getNext()!=null){
            node.getNext().setHead(node);
        }

    }
    public void updateByIndex(int index ,T element){
        if (index<0||index > size) {
            return ;
        }
        selectByIndex(index).setElement(element);
    }
    private void printAll() {
        Node node = head.getNext();
        while (node != null) {
            System.out.print(node.getElement() + ",");
            node = node.getNext();
        }
    }

    public class Node {
        private T element;
        private Node next;

        private Node head;

        public Node(T element, Node next, Node head) {
            this.element = element;
            this.next = next;
            this.head = head;
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

        public Node getHead() {
            return head;
        }

        public void setHead(Node head) {
            this.head = head;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    ", next=" + next +
                    ", head=" + head +
                    '}';
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//        doubleLinkedList.addToHead(1);
//        doubleLinkedList.addToHead(2);
//        doubleLinkedList.addToHead(3);
//        doubleLinkedList.addToHead(4);
//        doubleLinkedList.addToHead(5);
        doubleLinkedList.addToTail(1);
        doubleLinkedList.addToTail(2);
        doubleLinkedList.addToTail(3);
        doubleLinkedList.addToTail(4);
        doubleLinkedList.addToAfter(3,5);
        doubleLinkedList.addToBefore(0,9);
        doubleLinkedList.updateByIndex(0,100);
        doubleLinkedList.deleteByIndex(5);
        doubleLinkedList.printAll();

    }
}
