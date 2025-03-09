package com.day01;

import java.util.Arrays;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 */
public class leetcode977 {

    public static void main(String[] args) {
        leetcode977 solution = new leetcode977();

        // 示例1
        int[] nums1 = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(solution.sortedSquares(nums1)));
        // 输出: [0, 1, 9, 16, 100]

        // 示例2
        int[] nums2 = {-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(solution.sortedSquares(nums2)));
        // 输出: [4, 9, 9, 49, 121]

        // 边界测试：全负数
        int[] nums3 = {-5, -4, -3};
        System.out.println(Arrays.toString(solution.sortedSquares(nums3)));
        // 输出: [9, 16, 25]

        // 边界测试：单个元素
        int[] nums4 = {5};
        System.out.println(Arrays.toString(solution.sortedSquares(nums4)));
        // 输出: [25]
    }

    /**
     * 暴力 (力扣上面竟然能过)
     *
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);

        return nums;
    }

    /**
     * 解法二：双指针从中间扩散（优化版）
     * 核心思路
     * 找到正负分界点（第一个非负数位置）
     * 左右指针向两边扩散，比较平方值
     * 时间复杂度 O(n)，空间复杂度 O(n)
     */
    public int[] sortedSquares1(int[] nums) {

        return null;//TODO

    }




















}
