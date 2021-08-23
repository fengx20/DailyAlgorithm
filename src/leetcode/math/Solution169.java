package leetcode.math;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Fengx
 * @date: 2021-07-19
 * @description: 169、多数元素
 *
 * 标签：位运算、数组、分治算法
 * 题目
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例1：
 * 输入：[3,2,3]
 * 输出：3
 * 示例2：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * 进阶
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 **/
public class Solution169 {

    private Map<Integer, Integer> countNums(int[] nums){
        Map<Integer, Integer> count = new HashMap<>();
        for(int num : nums){
            if(!count.containsKey(num)){
                count.put(num, 1);
            }else{
                count.put(num, count.get(num)+1);
            }
        }
        return count;
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);
        Map.Entry<Integer, Integer> majorityEntry = null;
        for(Map.Entry<Integer, Integer> entry : counts.entrySet()){
            if(majorityEntry == null || entry.getValue() > majorityEntry.getValue()){
                majorityEntry = entry;
            }
        }
        assert majorityEntry != null;
        return majorityEntry.getKey();
    }
}
