package com.day02;

/**
 * 题目中虽然没说，但是根据滑动窗口，它要是连续的
 * 子数组，它的定义就是连续的
 *
 */
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int result = Integer.MAX_VALUE; // 初始化结果为最大整数，便于后续取最小值
        int sum = 0;                     // 记录当前子数组的和
        int subLength;                    // 记录当前子数组的长度

        // 外层循环：以每个元素作为子数组的起点
        for (int i = 0; i < nums.length; i++) {
            sum = 0; // 重置子数组和
            // 内层循环：从起点 i 开始累加元素，直到子数组和 ≥ s
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) { // 子数组和满足条件
                    subLength = j - i + 1; // 计算当前子数组长度
                    result = Math.min(result, subLength); // 更新最小长度
                    break; // 找到最短子数组后立即终止内层循环
                }
            }
        }
        // 如果 result 未被更新，说明没有符合条件的子数组，返回 0
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}