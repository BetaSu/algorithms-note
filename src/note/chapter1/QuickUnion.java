package note.chapter1;

import std.StdIn;
import std.StdOut;

/**
 * Created by Beta_Su on 2018/1/5.
 * 并查集  union-find
 * 通过 quick-union 实现
 *
 */
public class QuickUnion {
    // 数组id的index为分量id，对应的value为同一个分量中另一个触点的id（可能是他自己）
    private int[] id;
    // 分量的数量
    private int count;

    // N为初始化的N个触点
    public QuickUnion(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
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
        while (id[p] != p) {
            p = id[p];
        }
        return p;
    }

    // 在p和q触点间建立连接
    public void union(int p, int q) {
        // 将p和q的根结点统一
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickUnion uf = new QuickUnion(N);
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
