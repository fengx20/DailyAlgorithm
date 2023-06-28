package leetcode.array;

/**
 * @author: Fengx
 * @date: 2021-05-26
 * @description: 8、字符串转换整数 (atoi)
 *
 * 标签：字符串
 *
 * 题目：
 * 请你来实现一个myAtoi(string s)函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * 示例 1：
 * 输入：s = "42"
 * 输出：42
 * 解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
 * 第 1 步："42"（当前没有读入字符，因为没有前导空格）
 *          ^
 * 第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 *          ^
 * 第 3 步："42"（读入 "42"）
 *            ^
 * 解析得到整数 42 。
 * 由于 "42" 在范围 [-231, 231 - 1] 内，最终结果为 42 。
 *
 * 示例 2：
 * 输入：s = "   -42"
 * 输出：-42
 * 解释：
 * 第 1 步："   -42"（读入前导空格，但忽视掉）
 *             ^
 * 第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
 *              ^
 * 第 3 步："   -42"（读入 "42"）
 *                ^
 * 解析得到整数 -42 。
 * 由于 "-42" 在范围 [-231, 231 - 1] 内，最终结果为 -42 。
 **/
public class Solution8 {

    /**
     * 过程式
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        int sign = 1;
        int result = 0;
        int length = s.length();
        int i = 0;
        // 空格前导忽略
        while(i < length && s.charAt(i) == ' '){
            i++;
        }
        int start = i;
        // 循环开始第一个字符
        for(; i < length; i++){
            char c = s.charAt(i);
            // 确定符号,如果第一个字符是符号
            if(i == start && c == '+'){
                sign = 1;
            }else if(i == start && c == '-'){
                sign = -1;
            }else if(Character.isDigit(c)){
                int num = c - '0';
                if(result > Integer.MAX_VALUE/10 ||
                        (result == Integer.MAX_VALUE/10 && num > Integer.MAX_VALUE%10)){
                    return Integer.MAX_VALUE;
                }
                if(result < Integer.MIN_VALUE/10 ||
                        (result == Integer.MIN_VALUE/10 && -num < Integer.MIN_VALUE%10)){
                    return Integer.MIN_VALUE;
                }
                result = result * 10 + sign * num;
            }else{
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "   -234你好111";
        Solution8 solution8 = new Solution8();
        System.out.println(solution8.myAtoi(s));
    }
}
