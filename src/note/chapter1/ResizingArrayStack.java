package note.chapter1;
import java.util.Iterator;

/**
 * Created by Beta_Su on 2018/1/2.
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {
    // 栈元素
    private Item[] a = (Item[]) new Object[1];
    // 元素数量
    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void resize(int max) {
        // 将栈移动到一个长度为max的新书组
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public void push(Item item) {
        if (N == a.length) resize(2 * a.length);
        a[N++] = item;
    }

    public Item pop() {
        Item item = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length / 4) resize(a.length / 2);
        return item;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        // 支持后进先出的迭代
        private int i = N;

        public boolean hasNext() {
            return i > 0;
        }

        public Item next () {
            return a[--i];
        }

        public void remove() {}

    }
}
