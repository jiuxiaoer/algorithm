package LinkedList;

import org.w3c.dom.Node;

/**
 * Describe:
 * Author: 九霄道长
 * CreateTime: 2021/12/28 16:53
 */

public class DoubleLinkedList<T> {
    private Node head;
    private int size;


    public void addToTail(T element){

    }

    public DoubleLinkedList() {
        this.head = new Node();
        this.size = 0;
    }

    public void addToHead(T element){
        Node node = head.getNext();
        head.setNext(new Node(element,node,head));
    }
    private void printAll(){
        Node node = head.getNext();
        while (node != null) {
            System.out.print(node.getElement()+",");
            node = node.getNext();
        }
    }
    public class Node{
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
        doubleLinkedList.addToHead(1);
        doubleLinkedList.addToHead(2);
        doubleLinkedList.printAll();

    }
}
