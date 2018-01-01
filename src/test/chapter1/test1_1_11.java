package test.chapter1; /**
 * Created by gjt on 2017/12/31.
 */

import std.StdRandom;
public class test1_1_11 {
    public static final int ROW = 7;
    public static final int COL = 4;
    public static boolean[][] randomInit(boolean[][] a) {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                a[i][j] = StdRandom.bernoulli();
            }
        }
        return a;
    }

    public static void printTable(boolean[][] a) {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (a[i][j]) {
                    System.out.println("*" + "row" + i + "col" + j);
                } else {
                    System.out.println(" " + "row" + i + "col" + j);
                }
            }
        }
    }

    public static void main () {
        boolean[][] a = new boolean[ROW][COL];
        a = randomInit(a);
        printTable(a);
    }
}
