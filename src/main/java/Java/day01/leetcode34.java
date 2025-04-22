package Java.day01;

/**
 * 二分查找：目标元素 target 在有序数组中很可能存在多个
 */
public class leetcode34 {
    /**
     * 暴力解法，也挺难得
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int first = -1, last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
// first 没有被赋值过，表示第一次出现，因为前面有连续的target 后面可能也有连续的target
//    错！！！它是递增的，所以后面不可能又出现连续的
                if (first == -1) {
                    first = i;

                }
                last = i;
            }
        }
        return new int[]{first, last};
    }

    /**
     * 二分查找查找到的不一定是第一个出现的吧
     */


    // 两次二分查找，分开查找第一个和最后一个
    // 时间复杂度 O(log n), 空间复杂度 O(1)
    // [1,2,3,3,3,3,4,5,9]
    public int[] searchRange2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int first = -1;
        int last = -1;
        // 找第一个等于target的位置
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                first = middle;
                right = middle - 1; //重点
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        // 最后一个等于target的位置
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
// 当 nums[middle] == target 时，当前 middle 可能是第一个、
// 第二个、... 或最后一个 target，但无法确定。
// 因此需要继续向左半区搜索（right = middle - 1），确保不会漏掉更左边的 target。
                last = middle;//这个地方的赋值可能会执行多次
                left = middle + 1; //重点，持续向右收缩代码
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return new int[]{first, last};
    }


}





























