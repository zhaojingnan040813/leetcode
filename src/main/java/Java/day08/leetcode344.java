package Java.day08;

public class leetcode344 {
    public void reverseString(char[] s) {

        String str1=new String(s);
//        String str1=String.valueOf(s);
        String reversed=new StringBuilder(str1).reverse().toString();
        char[] charArray = reversed.toCharArray();
        s=charArray;//这样并不会改变原数组，但是s[i] 会改变原数组

    }

    public void reverseString1(char[] s) {
        int left=0;
        int right=s.length-1;
        while (left<right){//不用等于
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
    }


}
