import std.Out;
import std.In;

public class Main {

    public static void cat (String[] args) {
        Out out = new Out(args[args.length - 1]);
        for (int i = 0; i < args.length - 1; i++) {
            In in = new In(args[i]);
            String s = in.readAll();
            out.println(s);
            in.close();
        }
        out.close();
    }

    public static void main(String[] args) {
        String[] a = {"text/in1.txt", "text/in2.txt", "text/out.txt"};
        cat(a);
    }

}

