package algorithm.sort;

import java.util.Arrays;

/**
 * @author: Fengx
 * @date: 2021-10-12
 * @description: 简单排序：冒泡排序
 *
 * 基本思想：两个数比较大小，较大的数下沉，较小的数冒起来。
 *
 * 时间复杂度：O(n^2)
 **/
public class BubbleSort {

    /**
     * 一般实现
     * 问题：顺序是正常的也会进行无意义的比较排序，直到 arr.length-1 次
     * @param arr
     */
    public static String bubbleSort(int[] arr){
        // 临时变量
        int temp;
        // 循环 arr.length-1 次
        for(int i = 0; i < arr.length - 1; i++){
            // 选出这一趟排序的最大值往后排
            for(int j = arr.length - 1; j > i; j--){
                // 后面的数与前面的数比较
                if(arr[j] < arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        return Arrays.toString(arr);
    }

    /**
     * 优化
     * 添加是否交换标志，如果已经是有序，则不进行比较排序
     * @param arr
     */
    public static String bubbleSort1(int[] arr){
        // 临时变量
        int temp;
        // 是否交换标志
        boolean flag;
        // 循环 arr.length-1 次
        for(int i = 0; i < arr.length - 1; i++){
            // 每次循环都要设置为false，才能判断后面元素是否发生了交换
            flag = false;
            // 选出这一趟排序的最大值往后排
            for(int j = arr.length - 1; j > i; j--){
                if(arr[j] < arr[j-1]){
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    // 发生了交换
                    flag = true;
                }
            }
            // 没有发生交换，说明后面都是有序，直接返回
            if(!flag){
                break;
            }
        }
        return Arrays.toString(arr);
    }

    public static void main(String[] args) {
        int[] arr = {3,6,1,7,2,9,7};
        System.out.println(bubbleSort(arr));
        System.out.println(bubbleSort1(arr));
    }
}
