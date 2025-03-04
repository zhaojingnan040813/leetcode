package com.day01;

import java.util.ArrayList;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 */
class Solution {
    public int[] sortedSquares(int[] nums) {
//        ArrayList<Integer> list = new ArrayList<Integer>();
        int slow = 0;
        int fast = nums.length - 1;
        int index= nums.length-1;

        int[] res=new int[nums.length];
        while (slow <= fast) {
            if (Math.pow(nums[slow], 2) < Math.pow(nums[fast], 2)) {
                res[index--]=(int) Math.pow(nums[fast], 2);
                fast--;


            }else {
                res[index--]= (int) Math.pow(nums[slow], 2);
                slow++;

            }
        }
        return res;


    }
}
/**
 * left和right指针用于遍历原数组的两端，比较绝对值大小，而独立的index指针则负责填充结果数组的正确位置
 */