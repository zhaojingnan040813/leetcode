package com.day7;

public class leetcode383 {
    public boolean canConstruct(String ransomNote, String magazine) {//后构成前
        if (ransomNote.length()>magazine.length()){
            return false;
        }
        StringBuilder sb=new StringBuilder(ransomNote);//

        for (int i = 0; i < magazine.length(); i++) {
            char a = magazine.charAt(i);
            for (int j = 0; j < sb.length(); j++) {
//                char b = ransomNote.charAt(j);
                if(sb.charAt(j)==a){
                    sb.deleteCharAt(j);
//                    break;//为什么要跳出内层循环呢
                }

            }
        }

        return sb.length()==0;
    }

    public boolean canConstruct1(String ransomNote, String magazine) {// 后包前
        if (ransomNote.length()>magazine.length()){
            return false;
        }
        int[] count =new int[26];
        for (char c: magazine.toCharArray()){
            count[c-'a']++;
        }
        for (char c:ransomNote.toCharArray()){
            if (--count[c-'a']<0){//也就是说count数组里面不能有小于0的,必须先-- 然后再判断它是否小于0
                return false;
            }
        }
        return true;



    }



    public static void main(String[] args) {
        leetcode383 solution = new leetcode383();

        // 测试用例1：正常情况
        System.out.println(solution.canConstruct("aba", "ab")); // 应输出 false

        // 测试用例2：需要重复字符
        System.out.println(solution.canConstruct("abc", "abccba")); // 应输出 true

        // 测试用例3：无法构建的情况
        System.out.println(solution.canConstruct("fight", "light")); // 应输出 false

        // 测试用例4：空字符串处理
        System.out.println(solution.canConstruct("", "abc"));       // 应输出 true
        System.out.println(solution.canConstruct("a", ""));          // 应输出 false

        // 测试用例5：字符数量不足
        System.out.println(solution.canConstruct("aaaaa", "aa")); // 应输出 false
    }
}
