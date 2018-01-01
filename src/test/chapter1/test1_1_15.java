package test.chapter1;

/**
 * Created by gjt on 2018/1/1.
 */
public class test1_1_15 {
    public static int[] histogram(int[] a, int M) {
        int time = 0;
        int len = a.length - 1;
//        boolean match = false;
        int[] result = new int[len];
        while (len >= 0) {
            for (int i = 0; i < a.length; i++) {
                int cur = a[i];
                if (cur == len) {
                    result[len]++;
                }
            }
            len--;
        }
        return result;
    }
}
