package leetcode;

/**
 * @author: Fengx
 * @date: 2021-07-10
 * @description: 136、只出现一次的数字
 *
 * 标签：位运算、哈希表
 * 题目
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。你可以不使用额外空间来实现吗？
 *
 * 示例1：
 * 输入: [2,2,1]
 * 输出: 1
 * 示例2：
 * 输入: [4,1,2,1,2]
 * 输出: 4
 **/
public class Solution136 {

    public int singleNumber(int[] nums) {
        int single = 0;
        for(int num : nums){
            // 异或运算 a ^ a = 0; a ^ 0 = a;
            single ^= num;
        }
        return single;
    }

}
