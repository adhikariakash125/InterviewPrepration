package Algos;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {8, 7, 2, 1, 0, 9, 6};
        sorting(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void sorting(int[] nums, int low, int high) {
        if (low<high){
            int pivot = partition(nums,low, high);
            sorting(nums,low,pivot-1);
            sorting(nums,pivot+1,high);
        }
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                i++;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        int temp = nums[i+1];
        nums[i+1] = nums[high];
        nums[high] = temp;

        return i+1; // position from where partition is done
    }
}
