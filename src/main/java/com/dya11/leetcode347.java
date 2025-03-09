package com.dya11;

import java.util.*;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 * 我的第一想法就是使用哈希 map
 */
public class leetcode347 {

    /**
     * 方法一：使用HashMap
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> count=new HashMap<>();
        for (int num:nums){
            count.put(num,count.getOrDefault(num,0)+1);
        }

        // 如何拿到哈希表的前K个元素，然后把他们放到一个数组里面

        // 哈希表里面的元素默认不是按照频率来进行排序的
//        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(count.entrySet());
//     每个 Entry 对象包含一对键值数据 ，list列表里面存储的是 Entry
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(count.entrySet());

        list.sort((a,b)->
            b.getValue()-a.getValue()
        );// 这是Java中lambda表达式的写法，实现了按照hashMap中value的大写进行排序
        int[] result=new int[k];
        for (int i=0;i<k;i++){
            result[i]=list.get(i).getKey();
        }
        return result;
    }

    /**
     * 方案二：哈希表 + 堆（优化版）
     * 算了，懒得写了
     *
     */

    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer,Integer> count=new HashMap<>();
        for (int num:nums){
            count.put(num,count.getOrDefault(num,0)+1);
        }

        return null;

    }

    public static void main(String[] args) {
        // 基础测试用例
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        System.out.println(Arrays.toString(topKFrequent(nums1, k1))); // 输出: [1, 2]

        // 单元素测试用例
        int[] nums2 = {1};
        int k2 = 1;
        System.out.println(Arrays.toString(topKFrequent(nums2, k2))); // 输出: [1]

        // 所有元素相同
        int[] nums3 = {5, 5, 5, 5};
        int k3 = 1;
        System.out.println(Arrays.toString(topKFrequent(nums3, k3))); // 输出: [5]

        // 多频率层级测试
        int[] nums4 = {1, 1, 2, 2, 3, 3, 3};
        int k4 = 2;
        System.out.println(Arrays.toString(topKFrequent(nums4, k4))); // 输出: [3, 2]

        // k等于不同元素总数
        int[] nums5 = {4, 4, 4, 3, 3, 2, 2, 1};
        int k5 = 4;
        System.out.println(Arrays.toString(topKFrequent(nums5, k5))); // 输出: [4, 3, 2, 1]

        // 特殊频率分布（包含多个同频元素）
        int[] nums6 = {10, 10, 10, 20, 20, 30};
        int k6 = 2;
        System.out.println(Arrays.toString(topKFrequent(nums6, k6))); // 输出: [10, 20]
    }



}
