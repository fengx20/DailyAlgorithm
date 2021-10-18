package algorithm.sort;

import java.util.Arrays;

/**
 * @author: Fengx
 * @date: 2021-10-18
 * @description: 简单排序：插入排序
 *
 * 基本思想：在要排序的一组数中，假定前n-1个数已经排好序，现在将第n个数插到前面的有序数列中，使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
 *
 * 时间复杂度：O(n^2)
 **/
public class InsertSort {

    public static String insertSort(int[] arr){
        // 待插入元素
        int temp = 0;
        // 外层遍历
        for(int i = 0; i < arr.length-1; i++){
            // 内层下标+1遍历
            for(int j = i+1; j > 0; j--){
                // 判断前面的元素是否大于后面的元素，是就交换
                if(arr[j] < arr[j-1]){
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }else{
                    break;
                }
            }
        }
        return Arrays.toString(arr);
    }

    public static void main(String[] args) {
        int[] arr = {3,1,7,5,9,3,4,5,6,88};
        System.out.println(insertSort(arr));
    }
}
