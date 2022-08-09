package algorithm.sort;

import java.util.Arrays;

/**
 * @author: Fengx
 * @date: 2022-06-27
 * @description:
 **/
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {1,2,4,5,7,3};
        System.out.println(Arrays.toString(quickSort(array, 0, array.length - 1)));
    }

    public static int[] quickSort(int[] array, int low, int high){
        if(low < high){
            int position = partition(array, low, high);
            quickSort(array, low, position - 1);
            quickSort(array, position + 1, high);
        }
        return array;
    }

    public static int partition(int[] array, int low, int high){
        int pivot = array[high];
        int pointer = low;
        for(int i = low; i < high; i++){
            if(array[i] <= pivot){
                int temp = array[i];
                array[i] = array[pointer];
                array[pointer] = temp;
                pointer++;
            }
            System.out.println(Arrays.toString(array));
        }
        int temp = array[pointer];
        array[pointer] = array[high];
        array[high] = temp;
        return pointer;
    }

}
