package Java.day08;

public class leetcode541 {
    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n; i = i + 2 * k) {//为什么i=i+2*k 而不是其他的
            int left=i;
//处理到位置i的时候，反转的结束位置应该是i +k -1(因为i本身是要反转的，第k个是不需要反转的)，但是如果i +k -1超过了数组长度，那么结束位置就是数组的最后一个索引。
            int right = Math.min(i+k-1,n-1);// 这个地方是关键，也是难理解的地方
            reverse(arr,left,right);
        }
        return new String(arr);


    }

}
