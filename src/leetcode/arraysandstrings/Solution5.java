package leetcode.arraysandstrings;

/**
 * @author: Fengx
 * @date: 2021-04-28
 * @description: 5、最长回文子串
 *
 * 标签：字符串、动态规划
 *
 * 题目：
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 回文串：
 * 对于一个子串而言，如果它是回文串，并且长度大于 22，那么将它首尾的两个字母去除之后，它仍然是个回文串。
 * 例如对于字符串 “ababa”，如果我们已经知道 “bab” 是回文串，
 * 那么 “ababa” 一定是回文串，这是因为它的首尾两个字母都是 “a”。
 **/
public class Solution5 {

    /**
     * 动态规划
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        // 边界操作
        if(len < 2){
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        // dp[i][j]表示s[i..j]是否是回文串
        boolean[][] dp = new boolean[len][len];
        for(int i = 0; i < len; i++){
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        for(int L = 2; L <= len; L++){
            for(int i = 0; i < len; i++){
                int j = L + i - 1;
                if(j >= len){
                    break;
                }
                if(charArray[i] != charArray[j]){
                    dp[i][j] = false;
                }else{
                    if(j - i < 3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        String s = "abcbddbbddbc";
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.longestPalindrome(s));
    }
}
