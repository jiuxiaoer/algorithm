package Queue;

/**
 * Describe:
 * Author: 九霄道长
 * CreateTime: 2022/1/4 20:50
 */

public class LinkedlistQueue {
    private int size;

    private Node head;
    private Node tail;
    public class Node {
        private Node next;
        private String element;

        public Node( String element,Node next) {
            this.next = next;
            this.element = element;
        }

        public Node() {
        }
    }



    public boolean enqueue(String value){
        if (head == null){
            Node node =new Node(value,null);
            head = node;
            tail = node;
            return true;
        }
        tail.next=new Node(value, null);
        tail=tail.next;
        return true;

    }

    public String dequeue(){
        if (head == null){
            return null;
        }
        String value=head.element;
        head = head.next;
        return value;
    }
    public static void main(String[] args) {
        LinkedlistQueue queue= new LinkedlistQueue();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.dequeue());
    }
}
