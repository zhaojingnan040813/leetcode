package Java.day01;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。
 * 元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
 * <p>
 * Java的数组是固定长度的，一旦创建后，大小就不能改变。因此，直接删除元素是不可能的，
 * 但可以通过创建新数组或者移动元素来实现 。 我现在明白了题目那样子描述的用意了
 */
public class leetcode27 {
    // 添加测试用的 main 方法
    public static void main(String[] args) {
        leetcode27 solution = new leetcode27();

        // 测试用例1：正常情况
        int[] nums1 = {3, 2, 2, 3};
        System.out.println("新长度：" + solution.removeElement(nums1, 3)); // 应输出2
        printArray(nums1, 2);

        // 测试用例2：空数组
        int[] nums2 = {};
        System.out.println("新长度：" + solution.removeElement(nums2, 1)); // 应输出0

        // 测试用例3：全部元素需要移除
        int[] nums3 = {4, 4, 4, 4};
        System.out.println("新长度：" + solution.removeElement(nums3, 4)); // 应输出0

        // 测试用例4：无匹配元素
        int[] nums4 = {1, 2, 3, 4};
        System.out.println("新长度：" + solution.removeElement(nums4, 5)); // 应输出4
        printArray(nums4, 4);
    }

    // 新增辅助方法用于打印数组
    private static void printArray(int[] arr, int length) {
        System.out.print("[");
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i]);
            if (i < length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    /**
     * 暴力解法
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == val) {
                //后面的都前移一位，同时放弃i++ 也就是i--
//          这个删除数组元素的操作可以使用工具类来实现吗？

//   数组越界问题：
//当 j = size-1 时，j+1 = size 会导致访问 nums[size]
                for (int j = i; j < size - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                i--;
                size--;
            }
        }
        return size;//  数组的大小是固定的，创建完之后就不能修改了，肯定不能用数组的length属性
    }

    /**
     * 解法二：快慢双指针（通用最优解）
     */
    public int removeElement1(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {//注意这个0是从1开始而不是从1开始
            if(nums[fast]!=val){
                nums[slow]=nums[fast];//保留非 val 元素
                slow++;
            }
        }
        return slow;
    }
    /**
     * 解法三：首尾双指针（极简优化版)
     * 回头再补吧
     */
    public int removeElement2(int[] nums, int val) {
        return -1;
    }


}
