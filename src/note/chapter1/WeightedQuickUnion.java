package note.chapter1;

import std.StdIn;
import std.StdOut;

/**
 * Created by Beta_Su on 2018/1/5.
 * 并查集  union-find
 * 通过 加权quick-union 实现
 * 总是将较小的树与较大的树连接
 *
 */
public class WeightedQuickUnion {
    // 父连接数组
    private int[] id;
    // （由触点索引的）各个根结点所对应的分量的大小
    private int[] sz;
    // 分量的数量
    private int count;

    // N为初始化的N个触点
    public WeightedQuickUnion(int N) {
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
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
        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        WeightedQuickUnion uf = new WeightedQuickUnion(N);
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
