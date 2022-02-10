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

        for (int i = 0; i < arr.length; i++) {
            int index = -1;
            int min = arr[i];
            for (int j = i; j < arr.length - 1; j++) {
                if (min > arr[j + 1]) {
                    min = arr[j + 1];
                    index = j + 1;
                }
            }
            if (index > 0) {
                int temp = arr[i];
                arr[i] = min;
                arr[index] = temp;
            }


            System.out.println(min);
        }
    }

    /**
     * 归并待优化 2022-02-10
     * 优化：使用哨兵优化 数组合并
     * 使用非数组的形式 递归
     * http://mp.weixin.qq.com/s?__biz=MzIxNTQ3NDMzMw==&mid=2247486212&idx=1&sn=ce7d4cd71f4d578dc9237b929f0b5937&chksm=979682f6a0e10be0461f2aedfdca9b05a5aa6ccd6c3776c1edc4158cd25f47e68438accd1e54#rd
     *
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            //终止条件
            return;
        }
        //数据拆分开始
        //求数组中间数
        int mid = (arr.length -1)/2;
        //保留数组的前半部分
        int[] a1 = new int[mid+1];
        //保留数组的后半部分
        int[] a2 = new int[arr.length - 1 - mid];
        copyArray(arr, 0, mid, a1);
        copyArray(arr, mid + 1, arr.length - 1, a2);
        mergeSort(a1);
        mergeSort(a2);
        //数据拆分结束
        merge(a1,a2,arr);
    }

    /**
     *
     * @param a1 比较的数组
     * @param a2 比较的数组
     * @param arr 排序的数组
     */
    private static void merge(int[] a1, int[] a2, int[] arr) {
        int i=0 ,j =0;
        for (int k = 0; k <arr.length ; k++) {
            if (j==a2.length){
                arr[k]=a1[i++];
                continue;
            }
            if (i==a1.length){
                arr[k]=a2[j++];
                continue;
            }
            if (a1[i]<=a2[j]){
                arr[k] = a1[i++];
            }else {
                arr[k] = a2[j++];
            }

        }
    }

    /**
     * @param arr 数据源
     * @param i   数据搬迁开始下标
     * @param mid 数据搬迁结束下标
     * @param a1  被嵌入的数组
     */
    private static void copyArray(int[] arr, int i, int mid, int[] a1) {
        for (int j = i; j <= mid; j++) {
            a1[j - i] = arr[j];
        }
    }


    // 递归调用函数
    private static void mergeSortInternally(int[] a, int p, int r) {


    }

    public static void main(String[] args) {
        int[] arr = {11, 8, 3, 9, 7, 1, 2, 5};
        mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
