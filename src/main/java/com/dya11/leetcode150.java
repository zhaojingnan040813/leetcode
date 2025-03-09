package com.dya11;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class leetcode150 {
    public int evalRPN(String[] tokens) {
//        Stack<Integer> stack = new Stack<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {// 这个字符串从前往后开始遍历，遇到数字就入栈，遇到运算符就弹栈
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;

                case "-"://先弹出来的是被减掉的
                    Integer a = stack.pop();
                    Integer b = stack.pop();
                    stack.push(b - a);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    Integer c = stack.pop();
                    Integer d = stack.pop();
                    stack.push(d / c); //两个整数之间的除法总是 向零截断 。
                    break;
                default:
                    stack.push(Integer.valueOf(token));
            }

        }
        return stack.pop();

    }

    public static void main(String[] args) {
        leetcode150 solution = new leetcode150();
        System.out.println(solution.evalRPN(new String[]{"2","1","+","3","*"})); // 9
        System.out.println(solution.evalRPN(new String[]{"4","13","5","/","+"})); // 6
        System.out.println(solution.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"})); // 22
    }
}
