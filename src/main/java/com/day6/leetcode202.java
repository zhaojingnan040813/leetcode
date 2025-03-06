package com.day6;

import java.util.HashSet;
import java.util.Set;

public class leetcode202 {

    private static int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            int dight = n % 10;
            sum += dight * dight;
            n = n / 10;
        }
        return sum;
    }

    public static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {//是否等于1或者出现重复
            seen.add(n);// 使用HashSet来存储出现过的数字，上面的while条件就是判断重复的
            n = getSum(n);

        }
        return n == 1;
    }

    public static boolean isHappy2(int n) {
        int slow = n;//慢指针
        int fast = getSum(n);//快指针，他们的相对速度是1，那么就一定会相遇
        while (fast != 1 && fast != slow) { //当fast!=1 , 快慢指针相遇时候也会跳出循环
            slow = getSum(slow);
            fast = getSum(getSum(fast));
        }
        return fast == 1;
    }


    // 测试
    public static void main(String[] args) {
        System.out.println(isHappy(19)); // true（快乐数）
        System.out.println(isHappy(2));  // false（会进入循环）
    }

}
