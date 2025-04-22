package Java.day01;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 */
public class letcode704 {

    // 新增 main 方法
    public static void main(String[] args) {
        letcode704 solution = new letcode704();

        // 测试用例1：正常存在
        int[] nums1 = {-1, 0, 3, 5, 9, 12};
        System.out.println(solution.search(nums1, 9)); // 应输出4

        // 测试用例2：不存在
        System.out.println(solution.search(nums1, 2)); // 应输出-1

        // 测试用例3：边界检查
        System.out.println(solution.search(nums1, -1)); // 应输出0


        System.out.println(solution.search(nums1, 12)); // 应输出5
    }

    /**
     * 它既然说了升序，就不要用暴力解法了
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        int mid=0;
        while(left<=right){
            mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid-1;
            }else{
                return mid;
            }

        }
        return -1;

    }

}

































