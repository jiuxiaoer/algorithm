package queue;

/**
 * Describe:
 * Author: 九霄道长
 * CreateTime: 2022/1/4 19:55
 */

public class ArrayQueue {
    private String [] data;
    private int size;
    private int head;
    private int tail;


    public boolean enqueue(String item){
        if (tail==size) {
            return false;
        }
        this.data[tail]=item;
        tail++;
        return true;
    }

    public String dequeue(){
        if (head==tail) {
            return null;
        }
        return this.data[head++];
    }
    public ArrayQueue(int size) {
        this.data=new String[size];
        this.size = size;
        this.head=0;
        this.tail=0;
    }

    public static void main(String[] args) {
    ArrayQueue queue  =new  ArrayQueue(5);
    queue.enqueue("1");
    queue.enqueue("2");
    queue.enqueue("3");
    queue.enqueue("4");
    queue.enqueue("5");
    queue.enqueue("5");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }

}
