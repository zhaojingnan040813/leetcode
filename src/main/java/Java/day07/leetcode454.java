package Java.day07;

import java.util.HashMap;
import java.util.Map;

public class leetcode454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 哈希表记录前两组的和及其出现次数
        Map<Integer, Integer> sumMap = new HashMap<>();
        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
//                sumMap.getorDefault
                sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
            }
        }
        int count = 0;
        for (int c : nums3) {
            for (int d : nums4) {
                int temp = -(c + d);
//                Integer i = sumMap.get(temp);//如果找不到的话，它的返回值是多少
                count = count + sumMap.getOrDefault(temp, 0);//比如之和为2的在nums1和nums2里面出现了两次
//                count++;
            }
        }
        return count;
    }

}
