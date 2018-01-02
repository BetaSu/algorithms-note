package note.chapter1;

import std.StdIn;
import std.StdOut;

import java.util.Stack;

/**
 * Created by Beta_Su on 2018/1/1.
 * 简单的表达式解释器，通过两个栈解析运算符，支持常见的二元运算符+-*／，以及平方根运算符sqrt，具体操作：
 * - 将操作数雅茹操作数栈
 * - 将运算符压入运算符栈
 * - 忽略左括号
 * - 在遇到右括号时，弹出一个运算符，弹出所需数量的操作数，并将运算符和操作数的运算结果压入操作数栈。
 * 在处理完最后一个右括号后操作数栈上只会有一个值，即表达式的值。
 */
public class Evaluate {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            // 读取字符， 如果是运算符则压入栈
            if (s.equals("(")) ;
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals(")")) {
                // 如果字符为")"，弹出运算符和操作数，计算结果并压入栈
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+")) v = vals.pop() + v;
                if (op.equals("-")) v = vals.pop() - v;
                if (op.equals("*")) v = vals.pop() * v;
                if (op.equals("/")) v = vals.pop() / v;
                if (op.equals("sqrt")) v = Math.sqrt(v);
                vals.push(v);
            }
            // 如果字符既非运算符也不是括号，将它作为double值压入栈
            else vals.push(Double.parseDouble(s));
        }
        StdOut.println(vals.pop());
    }
}
