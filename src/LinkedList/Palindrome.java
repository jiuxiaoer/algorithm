package LinkedList;

import org.w3c.dom.Node;

/**
 * Describe:
 * Author: 九霄道长
 * CreateTime: 2021/12/28 10:44
 */

public class Palindrome<T> {
    /**
     * 哨兵机制头结点
     */
    private Node head;
    /**
     * 链表中的数据数量
     */
    private int size;
    private int MAXSIZE = 10;

    public Palindrome() {
        head = new Node<T>();
        size = 0;
    }



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

    public void addEnd(T e) {
        Node next = head;
        while (next.getNext() != null) {
            next = next.getNext();
        }
        next.setNext(new Node<T>(e, null));
        size++;
    }

    public boolean isPalindrome(Palindrome palindrome) {
        Node node = palindrome.head.getNext();

        Node k = node;
        Node m = node;
        Node n = null;
        while (k.getNext()!=null&&k != null) {
            k = k.getNext().getNext();
            //暂存慢指针的值
            Node next=m.getNext();
            //反转 慢指针 在n的前面添加元素
            m.next=n;
            n=m;
            m=next;
        }
        if (k!=null){
            m=m.getNext();
        }
        while (n != null) {
            if (!n.e.equals(m.e)) {
                return false;
            }
            n=n.getNext();
            m=m.getNext();
        }

        return true;
    }

    public static void main(String[] args) {
        Palindrome<Object> objectPalindrome = new Palindrome<>();
        objectPalindrome.addEnd(1);
        objectPalindrome.addEnd(2);

        objectPalindrome.addEnd(1);
        System.out.println(objectPalindrome.isPalindrome(objectPalindrome));
    }
}
