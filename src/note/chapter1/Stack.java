package note.chapter1;
import std.StdIn;
import std.StdOut;
import java.util.Iterator;

/**
 * Created by Beta_Su on 2018/1/2.
 * 基于链表实现的下压堆栈
 */
public class Stack<Item> implements Iterable<Item>{
      private Node first;
      private int N;
      // 定义节点的嵌套类
      private class Node {
          Item item;
          Node next;
      }
      public boolean isEmpty() {
          return first == null;
      }
      public int size() {
          return N;
      }
      public void push(Item item) {
          Node oldFirst = first;
          first = new Node();
          first.item = item;
          first.next = oldFirst;
          N++;
      }
      public Item pop() {
          Node oldFirst = first;
          first = first.next;
          N--;
          return oldFirst.item;
      }

      public static void main(String[] args) {
          Stack<String> s = new Stack<String>();
          while (!StdIn.isEmpty()) {
              String item = StdIn.readString();
              if (!item.equals("-")) {
                  s.push(item);
              } else if (!s.isEmpty()) {
                  StdOut.print(s.pop() + "");
              }
          }
          StdOut.println("(" + s.size() + "left on stack)");
      }
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() {
            return current != null;
        }
        public void remove () {}
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}
