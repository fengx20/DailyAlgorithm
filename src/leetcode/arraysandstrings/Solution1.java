package leetcode.arraysandstrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Fengx
 * @date 2021-04-23
 * @description: 1、两数之和
 *
 * 标签：数组、哈希表
 *
 * 题目：
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 **/
public class Solution1 {
    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        // 遍历数组
        for(int i = 0; i < nums.length; i++){
            // 判断map的key里有没有target减去数组的一个值的差在不在map里，在的话说明数组中存在两个数之和等于target
            if(map.containsKey(target - nums[i])){
                // 返回这个差的下标 和 减数的下标
                return new int[] {map.get(target - nums[i]),i};
            }
            // 每次循环存数组的一个值和这个值的下标
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No Two Sum Solution");
    }

    public static void main(String[] args) {
        int[] nums = {1,4,5,6};
        int target = 10;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}

