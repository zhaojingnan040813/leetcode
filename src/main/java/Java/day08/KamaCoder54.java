package Java.day08;

import java.util.Scanner;

public class KamaCoder54 {
    public static String replaceDigitsWithNumber(String s) {
        int count = 0;// 表示数字的个数
        int sOldSize = s.length();
        for (int k: s.toCharArray()) {
            if (Character.isDigit(k)) {
                count++;
            }
        }
        char[] newS = new char[s.length() + count * 5];//我们只开辟了这一个额外的空间
        int sNewSize = newS.length;
//      System.arraycopy(源数组, 源起始索引, 目标数组, 目标起始索引, 拷贝长度);剩余的应该是用0补齐
        System.arraycopy(s.toCharArray(), 0, newS, 0, sOldSize);
        // 为什么不是j<=i
        for (int i = sNewSize - 1, j = sOldSize - 1;j<i; i--,j--){//i是新数组，很显然i更大一些
            if (!Character.isDigit(newS[j])){
//            后续newS[j]上面的数还是要改动的
                newS[i]=newS[j];//因为这两个数组是一样的，你也可以用 oldS[j]
            }else {//如果是数字的话就直接盖掉这个数字
                newS[i]='r';//注意用的不是newS[j]
                newS[i - 1] = 'e';
                newS[i - 2] = 'b';
                newS[i - 3] = 'm';
                newS[i - 4] = 'u';
                newS[i - 5] = 'n';
                i -= 5;
            }
        }
        return new String(newS);
    }

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String s=scanner.next();
        System.out.println(replaceDigitsWithNumber(s));
    }


}
