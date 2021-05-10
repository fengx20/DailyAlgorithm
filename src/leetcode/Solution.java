package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 两数之和
 * @author: 冯晓
 * @create: 2021-05-11
 **/
public class Solution {
    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
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
