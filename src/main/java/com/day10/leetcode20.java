package com.day10;

import java.util.Deque;
import java.util.LinkedList;

public class leetcode20 {
    public static boolean isValid(String s) {

        Deque<Character> deque = new LinkedList<>();//它即是队列也是栈
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            // 碰到左括号，就把响应的右括号入栈
            if (ch == '(') {
                deque.push(')');//表示入栈
            } else if (ch == '{') {
                deque.push('}');
            } else if (ch == '[') {
                deque.push(']');
            } else if (deque.isEmpty() || deque.peek() != ch) {
                return false;
            } else {//这个时候算是匹配上了，我们要弹栈
                deque.pop();

            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        // 标准测试用例
        System.out.println(isValid("()"));     // true
        System.out.println(isValid("(){}"));   // true
        System.out.println(isValid("(]"));     // false
        System.out.println(isValid("([])"));   // true

        // 补充边界测试用例
        System.out.println(isValid(""));       // true (空字符串)
        System.out.println(isValid("["));      // false
        System.out.println(isValid("{[}]"));   // false


    }
}
