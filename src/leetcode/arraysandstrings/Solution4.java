package leetcode.arraysandstrings;

/**
 * @author: Fengx
 * @date: 2021-04-26
 * @description: 4、寻找两个正序数组的中位数
 *
 * 标签：数组、二分查找、分治
 *
 * 题目：
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 **/
public class Solution4 {

    /**
     * 二分查找
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int totalLength = length1 + length2;
        if(totalLength % 2 == 1){
            int midIndex = totalLength / 2;
            return getKthElement(nums1, nums2, midIndex + 1);
        }else{
            int midIndex1 = totalLength / 2 - 1;
            int midIndex2 = totalLength / 2;
            return (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
        }
    }

    public static int getKthElement(int[] nums1, int[] nums2, int k){
        int length1 = nums1.length;
        int length2 = nums2.length;
        int index1 = 0;
        int index2 = 0;
        while(true){
            // 边界情况
            // 第一个数组为空,直接返回第二个数组中位数
            if(index1 == length1){
                return nums2[index2 + k - 1];
            }
            // 与上类似
            if(index2 == length2){
                return nums1[index1 + k - 1];
            }
            if(k == 1){
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1];
            int pivot2 = nums2[newIndex2];
            if(pivot1 <= pivot2){
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            }else{
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,5,6};
        int[] nums2 = {3,6,7,9};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
