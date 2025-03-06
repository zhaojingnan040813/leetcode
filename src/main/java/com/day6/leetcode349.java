package com.day6;

import java.util.HashSet;
import java.util.Set;

public class leetcode349 {
    public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> hashSet=new HashSet<Integer>();// 利用set这种结构来实现去重
        for (Integer k:nums1){
            //看k是否在nums2里面,有没有工具类可以实现这种效果，反正在JS中可以直接用includes方法来判断一个元素是否在数组里面
            if (nums2.length>0){
                for (int i=0;i<nums2.length;i++){
                    if (k==nums2[i]){
                        hashSet.add(k);
                    }
                }
            }

        }
        // 将hashSet转换成数组
        int[] result=new int[hashSet.size()];
        int i=0;
        for (Integer k:hashSet){
            result[i++]=k;
        }
        return result;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums2Set=new HashSet<>();
        for (int k : nums2) {
            nums2Set.add(k);
        }
        // 我们要的是重复的，要的是叠加的部分，而不是去重
        Set<Integer> resSet=new HashSet<>();
        for (int k : nums1) {
            if(nums2Set.contains(k)){
                resSet.add(k);
            }

        }
        //resSet就是我们想要的结果
        int[] res=new int[resSet.size()];
        int index=0;
        for (Integer k : resSet) {
            res[index++]=k;
        }
        return res;
    }
}
