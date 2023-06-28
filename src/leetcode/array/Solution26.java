package leetcode.array;

/**
 * @author: Fengx
 * @date: 2021-08-31
 * @description: 26、删除有序数组的重复项
 *
 * 标签：数组、双指针
 *
 * 题目：
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 说明:
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 你可以想象内部操作如下:
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 *      print(nums[i]);
 * }
 *
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2：
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 **/
public class Solution26 {

    public int removeDuplicates(int[] nums) {
        // 整型数组长度(数组必须是一个有序数组)
        int n = nums.length;
        // 边界条件：数组为空返回0
        if(n == 0){
            return 0;
        }
        // 指针1
        int fast = 1;
        // 指针2(去重后的数组长度)
        int slow = 1;
        // 循环遍历数组长度
        while(fast < n){
            // 如果此下标值与前一个下标值不相同
            if(nums[fast] != nums[fast - 1]){
                // 不重复的值赋给下标为slow的值
                nums[slow] = nums[fast];
                // 去重后的长度+1
                ++slow;
            }
            // 指针1向后移一位
            ++fast;
        }
        // 返回去重后的长度
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,4,6,6,9};
        Solution26 solution26 = new Solution26();
        System.out.println(solution26.removeDuplicates(nums));
        for(int i = 0; i < solution26.removeDuplicates(nums); i++){
            // 不需要考虑数组中超出新长度后面的元素
            System.out.print(nums[i]);
        }
    }
}
