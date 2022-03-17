package Find;

/**
 * Describe:
 * Author: 九霄道长
 * CreateTime: 2022/3/17 17:58
 */

public class BinarySearch {
    public static void binarySearch(int[] arr, int tarGet) {
        int low = 0;
        int higt = arr.length - 1;
        while (low <= higt) {
            int mid = (low + higt) / 2;
            if (arr[mid] == tarGet) {
                System.out.println(arr[mid]);
//                return;
            }
            if (arr[mid] > tarGet) {
                higt = mid - 1;
                continue;
            }
            low = mid + 1;

        }

    }

    public static void binarySearchRecursion(int[] arr, int low, int higt, int tarGet) {
        if (low > higt) {
            return;
        }
        int mid = (low + higt) / 2;
        if (arr[mid] == tarGet) {
            System.out.println(tarGet);
            return;
        }
        if (arr[mid] > tarGet) {
            higt = mid - 1;
            binarySearchRecursion(arr, low, higt, tarGet);
        } else {
            low = mid + 1;
            binarySearchRecursion(arr, low, higt, tarGet);
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 11, 19, 23, 27, 33, 45, 55, 67, 98};
//        binarySearch(arr, 8);
        binarySearchRecursion(arr, 0,arr.length-1,8);
    }
}
