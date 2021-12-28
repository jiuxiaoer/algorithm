package LinkedList;


import java.util.Scanner;

/**
 * 单链表的 LRU算法 最少使用淘汰策略
 * 在链表头部新增  删除尾部节点 找到一个节点的前驱节点 删除节点 一个节点是否在链表内存在 如果存在则 移到前面
 * Describe:
 * Author: 九霄道长
 * CreateTime: 2021/12/27 10:14
 */

public class LRULinkedList<T> {
    /**
     * 哨兵机制头结点
     */
    private Node head;
    /**
     * 链表中的数据数量
     */
    private int size;
    private int MAXSIZE = 10;

    public class Node<T> {
        private T e;
        private Node next;

        public Node(T e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node() {
        }

        public T getE() {
            return e;
        }

        public void setE(T e) {
            this.e = e;
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
                    "e=" + e +
                    ", next=" + next +
                    '}';
        }
    }

    public LRULinkedList() {
        head = new Node<T>();
        size = 0;
    }

    public void add(T e) {
        Node previou = findPreviou(e);
        if (previou != null) {
            deleteNext(previou);
            addTop(e);
        } else {
            if (size >= MAXSIZE) {
                deleteEnd();
            }
            addTop(e);
        }
    }

    /**
     * 再链表尾部插入元素
     *
     * @param e
     */
    public void addTop(T e) {
        //获取到链表元素
        Node next = head.getNext();
        //在链表尾部添加元素
        head.setNext(new Node<T>(e, next));
        size++;
    }

    public void addEnd(T e) {
        Node next = head;
        while (next.getNext() != null) {
            next = next.getNext();
        }
        next.setNext(new Node<T>(e, null));
        size++;
    }

    public void deleteEnd() {
        Node node = head;
        if (node.getNext() == null) {
            return;
        }
        while (node.getNext().getNext() != null) {
            node = node.getNext();
        }
        node.setNext(null);
        size--;
    }
    public void deleteNext(Node node){
        node.setNext(node.getNext().getNext());
        size--;
    }
    public Node findPreviou(T e) {
        Node node = head;
        while (node.getNext() != null) {
            if (node.getNext().getE().equals(e)) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    public void printAll(){
        Node node = head.getNext();
        while (node != null) {
            System.out.print(node.getE()+",");
            node = node.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRULinkedList<Object> objectLRULinkedList = new LRULinkedList<>();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            objectLRULinkedList.add(scanner.nextInt());
            objectLRULinkedList.printAll();
        }
    }
}
