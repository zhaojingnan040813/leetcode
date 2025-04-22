package Java.day06;

import java.util.HashMap;
import java.util.Map;

public class leetcode1 {
    public int[] twoSum(int[] nums, int target) {
        int[] res=new int[2];//题目要求了是两数之和

        Map<Integer,Integer> hashMap=new HashMap<>();//值是key，索引是value  这里面存放了好多
        for (int i=0;i< nums.length;i++){
            int temp=nums[i]-target;
            if (hashMap.containsKey(temp)){
                //这个时候表示找到了
                res[0]=i;
                res[0]=hashMap.get(temp);
                break;//你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。所以就直接跳出了

            }
            //不满足上面的if就是不满足，给它加入到哈希表里面

            hashMap.put(nums[i],i);
        }
        return res;

    }
}
