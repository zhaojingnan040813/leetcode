package Java.day02;

public class leetcode59 {
    public static void main(String[] args) {
        leetcode59 solution = new leetcode59();

        // 示例1：输出应为 2
        System.out.println(solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));

        // 示例2：输出应为 1
        System.out.println(solution.minSubArrayLen(4, new int[]{1, 4, 4}));

        // 示例3：输出应为 0
        System.out.println(solution.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1}));
    }

    /**
     * 时间复杂度	O(n²)，每个起点 i 最多遍历 n 个终点 j。
     * 暴力解法
     */
    public int minSubArrayLen(int target, int[] nums) {

        int sum = 0;
        int minLenght;
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum >= target) {
                    minLenght = j - i + 1;
                    res = Math.min(res, minLenght);
                    break;
                }
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    /**
     * （滑动窗口法，最优解）
     */
    public int minSubArrayLen1(int target, int[] nums) {
//：这三个变量在滑动窗口算法中各司其职，缺一不可。left控制窗口起始，
// currentSum维护窗口和，minLength记录结果。没有它们，算法无法正确执行。
        int left = 0;
        int currentSum = 0;
        int minLenght = Integer.MAX_VALUE;//求最小值要用最大值来初始化
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];
            while (currentSum >= target) {
                minLenght = Math.min(minLenght, right - left + 1);//结果就存储在了这个全局变量中，后面窗口你才能放心的滑动
                currentSum -= nums[left];
                left++;
            }
        }
        return minLenght == Integer.MAX_VALUE ? 0 : minLenght;

    }

}
























