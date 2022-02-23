package Sort;

/**
 * Describe:
 * Author: 九霄道长
 * CreateTime: 2022/2/23 16:45
 */

public class KthSmallest {
    public static int kthSmallest(int[] arr, int k) {
        if (arr == null || arr.length < k) {
            return -1;
        }
        int partition = partition(arr, 0, arr.length - 1);
        while (partition + 1 != k) {
            if (partition + 1 < k) {
                 partition = partition(arr, partition + 1, arr.length - 1);
            }else {
                partition = partition(arr, 0, partition - 1);
            }
        }
        return arr[partition];
    }

    private static int partition(int[] arr, int start, int tail) {
        int pivot = arr[tail];
        int i = start;
        for (int j = start; j < tail; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, tail);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {
            1,5,4,3,2
        };
        System.out.println(kthSmallest(arr,3));
    }
}
