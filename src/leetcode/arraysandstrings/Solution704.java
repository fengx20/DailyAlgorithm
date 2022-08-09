package leetcode.arraysandstrings;

/**
 * @author: Fengx
 * @date: 2022-08-09
 * @description: 704、二分查找
 *
 * 标签：数组、二分查找
 *
 * 题目：
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 示例 1:
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 *
 * 示例2:
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 **/
public class Solution704 {

    public static int search(int[] nums, int target) {
        // 数组最左下标
        int left = 0;
        // 数组最右下标（数组长度 - 1，因为数组下标从 0 开始）
        int right = nums.length - 1;
        // 二分循环（需要判断相等，当数组只有一个值时）
        while(left <= right){
            // 取数组中间下标
            int mid = (right - left) / 2 + left;
            // 获取中间下标上的值
            int num = nums[mid];
            if(num == target){
                // 与目标值相等，返回下标
                return mid;
            } else if(num > target){
                // 由于是升序数组，如果值大于目标值，目标值肯定在中间下标的左侧，缩小范围
                right = mid - 1;
            } else{
                // 由于是升序数组，如果值小于目标值，目标值肯定在中间下标的右侧，缩小范围
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 10};
        System.out.println(search(nums, 1));
    }
}
