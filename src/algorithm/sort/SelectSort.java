package algorithm.sort;

import java.util.Arrays;

/**
 * @author: Fengx
 * @date: 2021-10-12
 * @description: 简单排序：选择排序
 *
 * 基本思想：在长度为N的无序数组中，第一次遍历n-1个数，找到最小的数值与第一个元素交换；
 * 第二次遍历n-2个数，找到最小的数值与第二个元素交换；
 * 。。。
 * 第n-1次遍历，找到最小的数值与第n-1个元素交换，排序完成。
 *
 * 时间复杂度：O(n^2)
 **/
public class SelectSort {

    public static String selectSort(int[] arr){
        // 遍历数组
        for(int i = 0; i < arr.length - 1; i++){
            // 定义最小值下标
            int minIndex = i;
            // 第二次遍历数组
            for(int j = i+1; j < arr.length; j++){
                // 判断数组后一个下标对应的值是否小于前一个下标对应的值
                if(arr[j] < arr[minIndex]){
                    // 是就交换下标
                    minIndex = j;
                }
            }
            // 判断最小值的下标是否改变，改变了就交换下标对应的值
            if(minIndex != i){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return Arrays.toString(arr);
    }

    public static void main(String[] args) {
        int[] arr = {4,5,2,6,1,3,4,7};
        System.out.println(selectSort(arr));
    }
}
