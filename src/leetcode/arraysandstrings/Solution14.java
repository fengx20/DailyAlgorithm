package leetcode.arraysandstrings;

/**
 * @author: Fengx
 * @date: 2021-05-29
 * @description: 14、最长公共前缀
 *
 * 标签：字符串
 *
 * 题目：
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 **/
public class Solution14 {

    /**
     * 横向扫描
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for (String str : strs) {
            prefix = longestCommonPrefix(prefix, str);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2){
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while(index < length && str1.charAt(index) == str2.charAt(index)){
            index++;
        }
        return str1.substring(0, index);
    }

    // 分治法

    // 二分查找

    public static void main(String[] args) {
        String[] strs = {"abf", "abfk", "abjd", "a"};
        Solution14 solution14 = new Solution14();
        System.out.println(solution14.longestCommonPrefix(strs));
    }
}
