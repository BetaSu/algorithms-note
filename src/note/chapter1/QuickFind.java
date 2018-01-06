package note.chapter1;

import std.StdIn;
import std.StdOut;

/**
 * Created by Beta_Su on 2018/1/5.
 * 并查集  union-find
 * 通过 quick-find 实现
 * 触点： 单一的对象（这里使用的是一个int）
 * （连通）分量： 几个互相连接的触点形成的集合
 */
public class QuickFind {
    // 数组id的index为分量id，对应的value为当前分量中某一个触点的值
    private int[] id;
    // 分量的数量
    private int count;

    // N为初始化的N个触点
    public QuickFind(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            // 初始化时触点都没有连接，每个触点自己为一个分量，所以index指向的值为该触点的值
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    // 如果p和q处在同一分量，返回true
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // 返回触点所在分量的标识符
    public int find(int p) {
        return id[p];
    }

    // 在p和q触点间建立连接
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID) return;
        for (int i = 0; i< id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickFind uf = new QuickFind(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + "components");
    }
}
