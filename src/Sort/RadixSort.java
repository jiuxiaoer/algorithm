package Sort;

import java.util.Arrays;

/**
 * 基数排序
 * Describe:
 * Author: 九霄道长
 * CreateTime: 2022/3/14 14:45
 */

public class RadixSort {
    public static void radixSort(int[] arr) {
        //找到其中最大值
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int numLength = getNumLength(max);
        sort(arr, numLength);
    }

    private static void sort(int[] arr, int numLength) {
        int mod = 10;
        int dev = 1;
        for (int i = 0; i < numLength; i++, dev *= 10, mod *= 10) {
            int[][] counter = new int[mod * 2][0];
            for (int j = 0; j < arr.length; j++) {
                int bucket = ((arr[j] % mod) / dev) + mod;
                counter[bucket] = arrayAppend(counter[bucket], arr[j]);
            }
            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    arr[pos++] = value;
                }
            }
        }
    }

    private static int getNumLength(long Max) {
        if (Max == 0) {
            return 1;
        }
        int lenght = 0;
        for (long temp = Max; temp != 0; temp /= 10) {
            lenght++;
        }
        return lenght;
    }

    private static int[] arrayAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {9521, 5410, 7622};
        radixSort(arr);
    }
}
