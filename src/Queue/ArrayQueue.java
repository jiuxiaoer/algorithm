package Queue;

/**
 * Describe:
 * Author: 九霄道长
 * CreateTime: 2022/1/4 19:55
 */

public class ArrayQueue {
    private String[] data;
    private int size;
    private int head;
    private int tail;


    public boolean enqueue(String item) {
        //表示队列满了
        if (tail == size) {
            //等于0没办法真的满了直接返回吧
            if (head == 0) {
                return false;
            }
            //从头开始循环到尾巴
            for (int i = head; i <tail ; i++) {
                //i-head 等于0....
                this.data[i-head]=this.data[i];
            }

            tail-=head;
            head=0;
        }
        this.data[tail] = item;
        tail++;
        return true;
    }

    public String dequeue() {
        if (head == tail) {
            return null;
        }
        return this.data[head++];
    }

    public ArrayQueue(int size) {
        this.data = new String[size];
        this.size = size;
        this.head = 0;
        this.tail = 0;
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue("5");
        queue.enqueue("5");
        queue.enqueue("5");
        queue.enqueue("5");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }

}
