package Java.day09;


public class leetcode151 {

    public static void main(String[] args) {
        leetcode151 solution = new leetcode151();

        // 测试用例1：标准情况
        System.out.println("Test 1: |" + solution.reverseWords("hello world") + "|");

        // 测试用例2：前后有空格
        System.out.println("Test 2: |" + solution.reverseWords("  a good   example  ") + "|");

        // 测试用例3：空字符串
        System.out.println("Test 3: |" + solution.reverseWords("") + "|");

        // 测试用例4：纯空格字符串
        System.out.println("Test 4: |" + solution.reverseWords("    ") + "|");
    }

    public static void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char temp = chars[j];
            chars[j] = chars[i];
            chars[i] = temp;
            i++;
            j++;
        }
    }

    //  这个方法也太难了叭
    public String reverseWords1(String s) {
//      1. 去除空格
        char[] chars = s.toCharArray();
        int n = chars.length;
        int slow = 0;
        boolean inWord = false;
        for (int i = 0; i < n; i++) {// i 就是快指针 fast
            if (chars[i] != ' ') {// 注意这里要用单引号里面加一个空格
                //看下一个位置是不是空格或不是空格，所以这里用了两个分支
                if (inWord) {
                    chars[slow] = chars[i];
                    slow++;


                } else {// 此时是空格的开始
                    if (slow != 0)
                        chars[slow++] = ' ';
                    chars[slow++] = chars[i];
                    inWord = true;
                }

            } else {
                inWord = false;// 是空格就离开单词
            }
        }

        if (slow == 0) return "";
//      2. 反转整个字符串
        reverse(chars, 0, n - 1);
//      3. 反转每个单词 这个slow 是去掉多余空格以后，字符串的长度吧
        int start=0;
        for (int i = 0; i <= slow; i++) {
            if (i == slow || chars[i]==' '){
                reverse(chars,start,i-1);
                start=i+1;
            }
        }

        return new String(chars,0,slow);


    }

    public String reverseWords(String s) {
        String trimmed = s.trim();
        if (trimmed.isEmpty()) {
            return "";
        }
        //：   \\s表示匹配任何空白字符，+表示一次或多次重复
        String[] words = trimmed.split("\\s+");//split的返回值是一个字符串数组
        // 接下来反转这个 string 数组
        int left = 0, right = words.length - 1;
        while (left < right) {//用小于等于应该也是可以的
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        return String.join(" ", words);
    }


}
