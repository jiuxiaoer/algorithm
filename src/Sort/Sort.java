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
     * http://mp.weixin.qq.com/s?__biz=MzIxNTQ3NDMzMw==&mid=2247486212&idx=1&sn=ce7d4cd71f4d578dc9237b929f0b5937&chksm=979682f6a0e10be0461f2aedfdca9b05a5aa6ccd6c3776c1edc4158cd25f47e68438accd1e54#rd
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        //若数组长度为1或比1更小 直接返回
        if (arr.length<=1){
            return;
        }
        //数组从0开始 长度-1
        int mid =(arr.length -1)/2;
        //储存上半段数组
        int[] a1= new int[mid+1];
        //储存下半段数组
        int[] a2=new int[arr.length-mid-1];
        //赋值上半段
        copyArr(arr, 0, mid, a1);
        //赋值下半段
        copyArr(arr, mid+1, arr.length-1, a2);
        //拆分上半段
        mergeSort(a1);
        //拆分下半段
        mergeSort(a2);
        //因递归先进后出的特性 压栈完毕后 开始合并
        merge(a1, a2, arr);
    }

    private static void merge(int[] s1, int[] s2, int[] dest) {
        int i=0;
        int j=0;

        for (int k = 0; k <dest.length; k++) {
            //如果s1已经遍历完，直接把s2[j]复制给dest[pos]，并给j自增1
            if (i == s1.length){
                dest[k] = s2[j++];
                continue;
            }
            //如果s2已经遍历完，直接把s1[i]复制给dest[pos]，并给i自增1
            if (j == s2.length) {
                dest[k] = s1[i++];
                continue;
            }
            if (s1[i]<=s2[j]){
                dest[k]=s1[i++];
            }else {
                dest[k] = s2[j++];
            }
        }
    }

    /**
     * 将源数组中指定下标的元素复制到目标数组中
     * @param source    源数组
     * @param low       源数组初始下标
     * @param high      源数组末尾下标
     * @param dest      目标数组
     */
    private static void copyArr(int[] source, int low, int high, int[] dest) {
        for (int i = low; i <=high ; i++) {
            dest[i-low]=source[i];
        }
    }

    // 递归调用函数
    private static void mergeSortInternally(int[] a, int p, int r) {


    }

    public static void main(String[] args) {
        int[] arr = {11,8,3,9,7,1,2,5};
        mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
