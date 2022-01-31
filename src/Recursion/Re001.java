package Recursion;

/**
 * Describe:
 * Author: 九霄道长
 * CreateTime: 2022/1/11 21:16
 */

public class Re001 {
    private static int i=0;
    public static int zuowei(int index){
        if (index==1){
            return 1;
        }
        i= zuowei(index-1)+1;
        System.out.println(i);
        return i;
    }


    static int f(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int ret = 0;
        int pre = 2;
        int prepre = 1;
        for (int i = 3; i <= n; ++i) {
            ret = pre + prepre;
            prepre = pre;
            pre = ret;
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(f(10));
    }
}
