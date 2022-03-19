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
//        int[] arr = {8, 11, 19, 23, 27, 33, 45, 55, 67, 98};
//        int[] arr = {1, 3, 4, 5, 6, 11, 18,8, 8, 8};
//        int[] arr = {3, 4, 6, 7, 10};
        int[] arr = {3,5,6,8,9,10};

        //        普通二分查找
        //        binarySearch(arr, 8);
        //        递归二分查找
        //        binarySearchRecursion(arr, 0,arr.length-1,8);
//        binarySearchFirst(arr, 8);
//        binarySearchFinally(arr, 8);
//        binarySearchFirstGreaterTo(arr, 5);
        binarySearchFinallyLessThan(arr, 9);
    }

    private static void binarySearchFinallyLessThan(int[] arr, int i) {
        int low = 0;
        int hight = arr.length - 1;
        while (low <= hight) {
            int mid = (low + hight) / 2;
            if (arr[mid] <= i) {
                if (mid + 1 != arr.length && arr[mid + 1] <= i) {
                    low = mid + 1;
                } else {
                    System.out.println(arr[mid]);
                    System.out.println(mid);
                    return;
                }
                continue;
            } else {
                hight = mid-1;
            }
        }
    }

    private static void binarySearchFirstGreaterTo(int[] arr, int i) {
        int low = 0;
        int hight = arr.length - 1;
        while (low <= hight) {
            int mid = (low + hight) / 2;
            if (arr[mid] >= i) {
                if (mid - 1 != 0 && arr[mid - 1] >= i) {
                    hight = mid - 1;
                } else {
                    System.out.println(arr[mid]);
                    System.out.println(mid);
                    return;
                }
                continue;
            } else {
                low=mid+1;
            }
        }
    }

    private static void binarySearchFinally(int[] arr, int i) {
        int low = 0;
        int higt = arr.length - 1;
        while (low <= higt) {
            int mid = (low + higt) / 2;
            if (arr[mid] == i) {
                if (mid + 1 != arr.length && arr[mid + 1] == i) {
                    low = mid + 1;
                } else {
                    System.out.println(arr[mid]);
                    System.out.println(mid);
                    return;
                }
                continue;
            }
            if (arr[mid] > i) {
                higt = mid - 1;
            } else if (arr[mid] < i) {
                low = mid + 1;
            }
        }
    }

    private static void binarySearchFirst(int[] arr, int i) {
        int low = 0;
        int higt = arr.length - 1;
        while (low <= higt) {
            int mid = (low + higt) / 2;
            if (arr[mid] == i) {
                if (mid - 1 != -1 && arr[mid - 1] == i) {
                    higt = mid - 1;
                } else {
                    System.out.println(arr[mid]);
                    System.out.println(mid);
                    return;
                }
            }
            if (arr[mid] > i) {
                higt = mid - 1;
            } else if (arr[mid] < i) {
                low = mid + 1;
            }
        }
    }
}
