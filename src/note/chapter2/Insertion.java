package note.chapter2;

import std.In;
import std.StdOut;

/**
 * Created by Beta_Su on 2018/1/7.
 * 插入排序
 * 对于长度为N且主键不重复的数组，平均情况需要~N^2/4次比较以及~ N^2/4次交换
 * 最坏情况需要 ~N^2/2次比较和 ~N^2/2次交换
 * 最好情况需要 N-1 次比较和 0 次交换
 * 特点：时间取决于输入中元素的初始顺序
 */
public class Insertion {
    public static void sort(Comparable[] a) {
        // 将a[]按升序排列
        int N = a.length;
        for (int i = 1; i < N; i++) {
            // 将a[i]插入到a[i-1],a[i-2],a[i-3]...中
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j-1);
            }
        }
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
