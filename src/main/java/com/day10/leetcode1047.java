package com.day10;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class leetcode1047 {
    public String removeDuplicates(String s) {

        Stack<Integer> aaa = new Stack<>();


        ArrayDeque<Integer> bbb = new ArrayDeque<>();
        LinkedList<Integer> ccc = new LinkedList<>();//共有的方法有 push pop peek

        LinkedList<Integer> a = new LinkedList<>();
        ArrayDeque<Integer> b = new ArrayDeque<>();



        Deque<Character> deque = new LinkedList<>();//它即是队列也是栈
        Character ch;

        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (deque.isEmpty() || deque.peek() != ch) {
                deque.push(ch);//push是入栈
            } else {
                deque.pop();
            }
        }

        // 接下来考虑如何把这个栈转化成String 进行返回
        String str = "";
        while (!deque.isEmpty()) {
            str = deque.pop() + str;
        }
        return str;
    }


    public static void main(String[] args) {
        leetcode1047 solution = new leetcode1047();
        System.out.println(solution.removeDuplicates("abbaca")); // ca
        System.out.println(solution.removeDuplicates("aaaaaaaa")); // 空字符串
        System.out.println(solution.removeDuplicates("abbaac")); // ac
    }


}
