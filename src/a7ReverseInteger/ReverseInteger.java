package a7ReverseInteger;

/**
 * easy
 */
public class ReverseInteger {
    //@author bitzhuwei
    public int reverse1(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) return 0; //防止溢出，非常精妙的代码
            result = newResult;
            x = x / 10;
        }
        return result;
    }

    //@author Blankj
    public int reverse2(int x) {
        long res = 0;
        for (; x != 0; x /= 10) //把判断条件放进for中也是很惊艳的做法
            res = res * 10 + x % 10;
        return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0 : (int) res;
        //思路和第一个差不多，不过简写了很多东西，过滤条件也很正常
    }


    public static void main(String[] args) {
        ReverseInteger i = new ReverseInteger();
        System.out.println("第一种方法: " + i.reverse1(123));
        System.out.println("第二种方法: " + i.reverse2(- 231));
    }
}
