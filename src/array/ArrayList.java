package array;

/**
 * Describe:
 * Author: 九霄道长
 * CreateTime: 2021/12/26 11:04
 */

public class ArrayList<T> {

    /**
     * 数组容量
     */
    private T[] data;

    /**
     * 数组元素的个数
     */
    private int size;

    public ArrayList(int capacity) {
        this.data= (T[]) new  Object[capacity];
        this.size=0;
    }

    public ArrayList() {
        //默认为10
        this(5);
    }

    public void checkIndexAdd(int index){
        if (index<0||index>size){
            throw new IllegalArgumentException("数组下表越界");
        }
    }
    public void checkIndexDelete(int index){
        if (index<0||index>=size){
            throw new IllegalArgumentException("数组下表越界");
        }
    }
    /**
     * 在尾部添加元素
     * @param e
     */
    public void addEnd(T e){
        if (size == data.length) {
        }
        this.data[size]=e;
        size++;
    }

    /**
     * 在指定位置
     * @param index
     * @param e
     */
    public void addIndex(int index,T e){
        checkIndexAdd(index);
        //实际容量大于数组实际大小该扩容了
        if (size>= data.length){
            Expansion(2*data.length);
        }
        //如何在数组中间添加元素 添加元素我们需要让 坐标 下面的元素往后移动
        for (int i = size; i >index ; i--) {
            this.data[i] = this.data[i-1];
        }
        this.data[index] = e;
        size++;
    }

    public void deleteIndex(int index){
        checkIndexDelete(index);
        //删除元素把元素往前移动
        for (int i = index+1; i <=size; i++) {
            this.data[i-1]=this.data[i];
        }
        size--;
        //如果size 等于数组长度的4倍
        System.out.println(data.length/4);
        if (size== data.length/4&& data.length / 2 != 0){
            Expansion(data.length/2);
        }
    }
    public void PrintAll(){
        for (int i = 0; i <data.length ; i++) {
            System.out.println(data[i]);
        }
    }

    /**
     * 容器扩容方法
     * @param capacity
     */
    public void Expansion(int capacity){
        T[] newData = (T[]) new Object[capacity];
        for (int i = 0; i <size ; i++) {
            newData[i] = this.data[i];
        }
        this.data = newData;
    }
    public static void main(String[] args) {
        ArrayList<Object> objectArrayList = new ArrayList<>();
        objectArrayList.addEnd(666);
        objectArrayList.addEnd(1);
        objectArrayList.addEnd(2);
        objectArrayList.addEnd(3);
        objectArrayList.addEnd(4);
        objectArrayList.addIndex(5,5);

        objectArrayList.deleteIndex(0);
        objectArrayList.deleteIndex(0);
        objectArrayList.deleteIndex(0);
        objectArrayList.deleteIndex(0);
        objectArrayList.deleteIndex(0);
        objectArrayList.deleteIndex(0);
        objectArrayList.deleteIndex(0);


//        objectArrayList.PrintAll();
    }
}

