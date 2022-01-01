package Stack;

/**
 * Describe:
 * Author: 九霄道长
 * CreateTime: 2022/1/1 13:38
 */

public class LinkedStack<T> {
    /**
     * 链表
     */
    private Node head;
    /**
     * 栈容量
     */
    private int size;

    public class Node {
        private T e;
        private Node next;

        public Node(T e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node() {
        }
    }

    public boolean push(T e) {
        Node node = head.next;
        head.next = new Node(e, node);
        return true;
    }

    public T pop() {
        if (head.next==null){
            return null;
        }
        Node node = head.next;
        head.next = head.next.next;
        return node.e;
    }
    public void printAll(){
        Node node = head.next;
        while (node != null) {
            System.out.print(node.e+",");
            node = node.next;
        }
        System.out.println();
    }

    public LinkedStack() {
        this.head=new Node();
        this.size=0;
    }

    public static void main(String[] args) {
        LinkedStack linkedStack =new LinkedStack();
        linkedStack.push(1);
        linkedStack.push(2);
        linkedStack.push(3);
        linkedStack.push(4);
        linkedStack.push(5);
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());
    }
}
