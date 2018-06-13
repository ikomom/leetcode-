package b2RomanToInteger;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    Map<Character, Integer> map = new HashMap<>();

    public RomanToInteger(){
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    /**
     * @author ikonon
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] rm = s.toCharArray();
        int result = 0;
        int i = 0 , j = 1;
        for(;j < rm.length;i++,j++){
            if(map.get(rm[i]) >=  map.get(rm[j])){
                result += map.get(rm[i]);
            }else {
                result -= map.get(rm[i]);
            }
        }

        result += map.get(rm[i]);
        return result;
    }

    /**
     *一种新的思路，非常酷，但是比较难理解
     * 与前个字符的ascii码表比对，然后遍历字符表
     * @author andyreadsall
     */
    public int romanToInt1(String str) {
        int[] a = new int[26];
        a['I' - 'A'] = 1;
        a['V' - 'A'] = 5;
        a['X' - 'A'] = 10;
        a['L' - 'A'] = 50;
        a['C' - 'A'] = 100;
        a['D' - 'A'] = 500;
        a['M' - 'A'] = 1000;
        char prev = 'A';
        int sum = 0;
        for(char s : str.toCharArray()) {//字符串转化为字符数组，foreach遍历
            if(a[s - 'A'] > a[prev - 'A']) {
                sum = sum - 2 * a[prev - 'A'];//迭代到X时sum加了一个X，这是不必要的，所以在最后一个M需要减去2个prev值
            }
            sum = sum + a[s - 'A'];
            prev = s;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt1("MMXM"));

    }
}
