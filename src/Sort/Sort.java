package Sort;

/**
 * Describe:
 * Author: 九霄道长
 * CreateTime: 2022/1/15 11:02
 */

public class Sort {

    public static void bubbleSort(int[] arr) {
        //冒泡循环即为 两两相比 把最大最小的数放到最后面或者最前面
        //外层控制循环次数 有多少个元素循环多少次
        for (int i = 0; i < arr.length; i++) {
            //里层循环 arr.length-i 是指的是 -i 以前的数据已经排序完毕  -1 是因为比对时+1 方式数组下标越界
            //表示本次循环 有没有 数据交换  若没有交换即为 已经排序好
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
//                System.out.print(j+"   "+(j+1)+"   ");
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            // 没有交换直接返回吧
            if (!flag) {
                return;
            }
//            System.out.println();
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;

        }
    }

    public static void selectionSort(int[] arr) {

        for (int i = 0;  i< arr.length ; i++) {
            int index=-1;
            int min=arr[i];
            for (int j = i; j < arr.length-1 ; j++) {
                if (min>arr[j+1]){
                    min=arr[j+1];
                    index=j+1;
                }
            }
            if (index>0){
                int temp=arr[i];
                arr[i]=min;
                arr[index]=temp;
            }


            System.out.println(min);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 1, 3, 4};
        selectionSort(arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
    }
}
