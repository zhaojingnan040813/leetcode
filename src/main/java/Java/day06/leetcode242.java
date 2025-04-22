package Java.day06;

import java.util.HashMap;

public class leetcode242 {
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (Character k : s.toCharArray()){
            //这个方法的作用是当键k存在时返回对应的值，否则返回默认值0
            hashMap.put(k, hashMap.getOrDefault(k,0)+1);//第二个参数是对应字符的出现次数
        }

        // 遍历t 减少哈希表中的计数
        for (Character k: t.toCharArray()){
            if (!hashMap.containsKey(k)){
                return false;
            }
            int currentCount = hashMap.get(k);//当前遍历到的字符的计数

            if (currentCount==0){
                return false;
            }
            hashMap.put(k,currentCount-1);

//            hashMap.remove(k,);//第二个参数是对应字符的出现次数-1  注意不是用这个AP!
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t)); // 输出: true
    }

    public boolean isAnagram1(String s, String t){
        if(s.length()!=t.length()){
            return false;
        }
        int[] count = new int[26];
        for (char c:s.toCharArray()){
            count[c-'a']++;
        }
        for(char c :t.toCharArray()){
//            count[c-'a']--;
            if (--count[c-'a']<0){
                return false;
            }
        }
        return true ;


    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char c : s.toCharArray()) map1.put(c, map1.getOrDefault(c, 0) + 1);
        for (char c : t.toCharArray()) map2.put(c, map2.getOrDefault(c, 0) + 1);
        return map1.equals(map2); //这样好像也不错，调用哈希表的equals方法
    }





}
