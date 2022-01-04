package queue;

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
        //第一次入队
        if (tail == null) {
            //创建第一个节点
            Node newNode = new Node(value, null);
            //头 尾 节点指向 新节点
            head = newNode;
            tail = newNode;
        } else {
            //有了第一个节点之后  尾节点的下一个新建 新节点
            tail.next = new Node(value, null);
            // 上面的操作导致尾节点是倒数第二 现在切换一下 交换下位置   保证每次入队都在队尾
            tail = tail.next;
        }
        return true;
    }

    public String dequeue(){
        //头为空
        if (head==null) {
            return null;
        }
        //获取头的值
        String value = head.element;
        //头的下一个
        head=head.next;
        //若头的下一个为空
        if (head == null) {
            //尾也为空
            tail = null;
        }
        //返回数据
        return value;
    }
    public static void main(String[] args) {
        LinkedlistQueue queue= new LinkedlistQueue();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.dequeue();
        System.out.println(queue.dequeue());
    }
}
