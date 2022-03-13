package Sort;

import java.util.Arrays;

/**
 * Describe:
 * Author: 九霄道长
 * CreateTime: 2022/2/22 14:10
 */

public class BucketSort {
    /**
     * 线性排序
     */
    public static void bucketSort(int arr[], int bucketSize) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int minValue = arr[0];
        int maxValue = arr[0];

        for (int value : arr) {
            if (value < minValue) {
                minValue = value;
                continue;
            }
            if (value > maxValue) {
                maxValue = value;
                continue;
            }
        }
        //几个桶
        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        int [][]buckets= new int[bucketCount][bucketSize];
        //用一个数组记录 每个桶有几个数
        int[] indexArr = new int[bucketCount];
        for (int i = 0; i <arr.length ; i++) {
            //在那个桶里
            int index=(arr[i]-minValue)/bucketSize;
            if (indexArr[index] == buckets[index].length) {
                ensureCapacity(buckets, index);
            }
            buckets[index][indexArr[index]++] = arr[i];
        }
        int k = 0;
        //循坏对桶进行 快排
        for (int i = 0; i <buckets.length ; i++) {
            if (indexArr[i]==0){
                continue;
            }
            quickRow(buckets[i],0,indexArr[i]-1);
            //快排完毕 输出回到数组
            for (int j = 0; j < indexArr[i]; j++) {
                arr[k++] = buckets[i][j];
                System.out.println(buckets[i][j]);
            }
        }
    }

    private static void quickRow(int[] bucket, int start, int tail) {
        if (start >= tail) {
            return;
        }
        int mid =partition(bucket,start,tail);
        quickRow(bucket,start,mid-1);
        quickRow(bucket,mid+1,tail);
    }

    private static int partition(int[] bucket, int start, int tail) {
        int pivot=bucket[tail];
        //记录起始位置
        int index=start;
        for (int i = start; i < tail; i++) {
            //与中间点比较
            if (bucket[i]<=pivot){
                swap(bucket,index,i);
                index++;
            }
        }
        swap(bucket,index,tail);
        return index;
    }
    /**
     * 交换
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    private static void ensureCapacity(int[][] buckets, int index) {
        int[] tempArr = buckets[index];
        int[] newArr = new int[tempArr.length * 2];
        for (int j = 0; j < tempArr.length; j++) {
            newArr[j] = tempArr[j];
        }
        buckets[index] = newArr;
    }

    public static void main(String[] args) {
        int arr[] = {1, 6, 4, 8, 7, 2, 1, 5, 15};
        bucketSort(arr, 5);
    }


}
