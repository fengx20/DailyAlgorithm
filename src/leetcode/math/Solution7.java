package leetcode.math;

/**
 * @author: Fengx
 * @date: 2021-12-13
 * @description: 7、整数反转
 *
 * 数学
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围[−2^31, 2^31− 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 *
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 *
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 *
 * 输入：x = 0
 * 输出：0
 **/
public class Solution7 {

    public static void main(String[] args) {
        int a = 234;
        System.out.println(reverse(a));
    }

    public static int reverse(int x) {
        int rev = 0;
        while(x != 0){
            if(rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10){
                return 0;
            }
            int digit = x % 10;
            System.out.println("digit="+digit);
            x /= 10;
            System.out.println("x="+x);
            rev = rev * 10 + digit;
            System.out.println("rev="+rev);
        }
        return rev;
    }
}
