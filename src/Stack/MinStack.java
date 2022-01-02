package Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Describe:
 * Author: 九霄道长
 * CreateTime: 2022/1/2 14:53
 */

class MinStack {

    private Node head;

    private Deque<Integer> e;
    private int size;

    public MinStack() {
        this.head = new Node();
        this.e = new LinkedList<>();
        e.push(Integer.MAX_VALUE);
    }


    private class Node<T> {
        private int element;
        private Node next;

        public Node(int element, Node next) {
            this.element = element;
            this.next = next;
        }

        public Node() {
        }

        public int getElement() {
            return element;
        }

        public void setElement(int element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public void push(int val) {
        Node node = this.head.next;
        if (node == null) {
            head.next = new Node(val, node);
        } else {
            head.next = new Node(val, node);
        }
        e.push(Math.min(e.peek(), val));
    }

    public void pop() {
        if (head.next != null) {
            head.next = head.next.next;
            e.pop();
        }
    }

    public int top() {
        if (head.next == null) {
            return 0;
        }
        return this.head.next.getElement();
    }

    public int getMin() {
        return e.peek();
    }

    public static void main(String[] args) {
        MinStack main = new MinStack();
        main.push(0);
        main.push(-2);
        main.push(-3);
        main.push(999);
        main.push(999);
        main.push(999);
        main.push(999);
        main.push(999);
        System.out.println(main.getMin());
        main.pop();
        main.pop();

        System.out.println(main.top());
        System.out.println(main.getMin());
    }


}