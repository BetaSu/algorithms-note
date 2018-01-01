package test.chapter1;

/**
 * Created by gjt on 2017/12/31.
 */
public class test1_1_14 {
    public static int power(int num, int time) {
        int result = 1;
        while (time > 0) {
            result *= num;
            time--;
        }
        return result;
    }
    public static void main(int N) {
        int try_time = 0;
        while (power(2, try_time) < N) {
           try_time++;
        }
        System.out.println(power(2, 2));
        System.out.print("N is:" + N + ", result is:" + (try_time - 1));
    }
}
