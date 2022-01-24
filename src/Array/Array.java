package Array;

/**
 * Describe:
 * Author: 九霄道长
 * CreateTime: 2021/12/26 11:04
 */

public class Array <T> {
    /**
     * 数组中存储的元素
     */
    private T data [];
    /**
     * 数组的大小
     */
    private int size;

    /**
     * 数组中实际的个数
     */
    private int count;

    /**
     * 构造函数
     * 定义数组的大小
     * @param size
     */
    public Array(int size) {
        this.data= (T[]) new  Object[size];
        this.size = size;
        this.count=0;
    }

    /**
     * 在数组尾部添加元素
     * @param e
     */
    public void  addEnd(T e){
        if (count >= size) {
            throw new IllegalArgumentException("数组元素已满");
        }
        this.data[count] = e;
        countAdded();
    }
    public void addIndex(int index,T e) {
        checkIndex(index);
        if (count >= size) {
            throw new IllegalArgumentException("数组元素已满");
        }
        // 把index 以后的数据都往后移动一位
        //从数组尾部到要插入的位置
        for (int i = count; i >index; i--) {
            this.data[i] =this.data[i-1];
        }
        this.data[index] = e;
        countAdded();
    }
    public void printAll(){
        for (int i = 0; i <count ; i++) {
            System.out.println(data[i]);
        }
    }
    public void  countAdded(){
        count++;
    }
    public void  countDeleteed(){
        count--;
    }
    public void checkIndex(int index){
        if (index<0||index>=size){
            throw new IllegalArgumentException("数组下表越界");
        }
    }
    public void checkIndexFind(int index){
        if (index<0||index>=count){
            throw new IllegalArgumentException("数组下表越界");
        }
    }
    public T find(int index){
        checkIndexFind(index);
        return this.data[index];
    }
    public void update(int index,T e){
        checkIndexFind(index);
        this.data[index] = e;
    }

    public void delete(int index){
        //删除指定下标的元素 指定位置后面的元素向后移动
        checkIndex(index);
        //index+1 从删除的坐标后面第一个开始
        for (int i = index+1; i <count ; i++) {
            // 把后面的值往前移动一位
            this.data[i-1] = this.data[i];
        }
        //删除末尾的数字
        T[] objectArray =  (T[]) new  Object[(count-1)];
        for (int i = 0; i < count-1; i++) {
            objectArray[i]=(this.data[i]);
        }
        this.data = objectArray;
        countDeleteed();
    }

    public static void main(String[] args) {
        Array<Object> objectArray = new Array<>(6);
        objectArray.addEnd(1);
        objectArray.addEnd(2);
        objectArray.addEnd(3);
        objectArray.addEnd(4);
        objectArray.addEnd(5);
        objectArray.addIndex(5,6);
        objectArray.delete(0);

        objectArray.printAll();

        objectArray.update(4,9999);
        System.out.println(objectArray.find(5));

    }
}

