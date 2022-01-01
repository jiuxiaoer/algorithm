package Stack;

/**
 * Describe:
 * Author: 九霄道长
 * CreateTime: 2021/12/31 14:22
 */

public class ArrayStack {

    private String[] data;

    private int size;
    private int n;

    public ArrayStack(int n) {
        this.data = new String[n];
        this.size = 0;
        this.n = n;
    }

    public boolean push(String element){
        if (size == n){
            return false;
        }

        this.data[size++] = element;
        return true;
    }

    public String pop(){
        if (size==0){
            return null;
        }
        String datum = this.data[size - 1];
        size--;
        return datum;
    }
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");

        stack.pop();
        stack.pop();


    }
}
