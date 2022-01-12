package recursion;

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
    public static void main(String[] args) {
        System.out.println(zuowei(10));
    }
}
