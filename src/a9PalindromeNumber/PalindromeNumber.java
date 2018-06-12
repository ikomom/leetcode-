package a9PalindromeNumber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PalindromeNumber {
    /**
     * 转化为字符串并且比对
     * @author ikonon
     * @param x
     * @return
     */
    public boolean isPalindromeMy(int x) {
        if(x<0) return false;
        char[] a = (x+"").toCharArray();
        if(a.length == 1) return true;
        int count = 0;
        int count1 = 0;
        int end = a.length -1;
        int half = a.length /2;
        if(a.length % 2 == 0){ //偶数
            for(int i = 0; i< a.length; i++){
                if(a[i] == a[end - i]){
                    count++;
                }
            }
        }else {//奇数
            for(int j =0; j < a.length; j++){
                if (j == half) break;
                if (a[j] == a[end - j]){
                    count1++;
                }
            }
        }

        if(count/2 == half || count1 == half){
            return true;
        }else {
            return false;
        }

    }

    /**
     *不转化成字符串，把数字反向与原来字符串比较
     */
    public boolean isPalindromeMy1(int x) {
        if(x < 0 || (x != 0 && x % 10 == 0)){
            return false;
        }
        int rev = 0;
        //把要判断的数字翻转
        while (x > rev){
            rev = rev * 10 + x % 10;
            x = x / 10;
        }

        return x == rev || rev / 10 == x; // 偶数时 || 奇数时
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeNumber().isPalindromeMy1(63556222));
    }
}
