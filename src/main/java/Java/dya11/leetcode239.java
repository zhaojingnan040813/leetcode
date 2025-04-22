package Java.dya11;

import java.util.Arrays;

public class leetcode239 {
    /**
     * 方法一，暴力模拟法
     * 时间复杂度：O(nk)
     * 空间复杂度：O(1)（不包含结果数组）
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 条件1：防止空指针       条件2：处理空数组
        if (nums == null || nums.length == 0)
            return new int[0];
        int n = nums.length;
        int[] res = new int[n - k + 1];//这是剩余数组的长度，为什么不是 n-k  看实例也就知道了
        for (int i = 0; i <= n - k; i++) {//这个邻接条件我可以理解
            int max = nums[i];
//        。例如，当k=3时，i=0的窗口包括0,1,2三个索引  也就是 i < 3
            for (int j = i; j < i + k; j++) {//这个临界条件我理解不了
                if (nums[j] > max) { // 这里用 >= 应该也是可以的
                    max = nums[j];
                }
            }
            res[i]=max;
        }

        return res;

    }

    /**
     * 方法二  双端队列（单调队列）
     * @param
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {


        return null;

    }


    /**
     * 分块预处理（进阶优化）
     * @param args
     */


    public static void main(String[] args) {
        leetcode239 solution = new leetcode239();
        int[] nums1 = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums1, 3))); // [3,3,5,5,6,7]

        int[] nums2 = {1};
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums2, 1))); // [1]
    }
}


