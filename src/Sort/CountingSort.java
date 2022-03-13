package Sort;

/**
 * Describe:
 * Author: 九霄道长
 * CreateTime: 2022/3/13 19:15
 */

public class CountingSort {
    /**
     * 计数排序
     *
     * @param arr
     */
    public static void countingSort(int[] arr) {
        //先找到最大值
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        //声明计数数组
        int c[] = new int[max + 1];
        //计算每个元素的个数
        for (int i = 0; i < arr.length; i++) {
            c[arr[i]]++;
        }
        //判断出所在数值区间
        for (int i = 1; i < max+1; i++) {
            c[i]=c[i-1]+c[i];
        }

        int k[] =new int[arr.length];
        //从后往前根据区间插入数据
        for (int i = arr.length-1; i >=0 ; i--) {
            int index=c[arr[i]]-1;
            k[index]=arr[i];
            c[arr[i]]--;
        }
        for (int i = 0; i <k.length ; i++) {
            System.out.println(k[i]);
        }
    }

    public static void main(String[] args) {
        int arr[] = {2, 5, 3, 0, 2, 3, 0, 3};
        countingSort(arr);
    }
}
