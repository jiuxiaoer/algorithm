package Recursion;

/**
 * Describe:
 * Author: 九霄道长
 * CreateTime: 2022/1/12 8:59
 */

public class Re002 {
    private static int i = 0;

    public static int Re002(int index) {
        if (index == 1) {
            return 1;
        }
        if (index == 2) {
            return 2;
        }
        int a = Re002(index - 1);
        int b = Re002(index - 2);
        System.out.println(a + "+" + b);
        i = a + b;
        System.out.println(i);
        return i;
    }

    public static int Re003(int index) {
        // 5  1x2x3x4x5
        if (index ==0) {
            return 1;
        }else {
            return index*Re003(index-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(Re003(6));
    }
}
