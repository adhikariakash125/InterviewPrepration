package DSA.Stack;

import java.util.Arrays;
import java.util.Stack;

public class MonotonicStack {
    public static void main(String[] args) {
        // Find next greater element
        // TIP:- for anything next greater or larger use monotonic decreasing
        // TIP:- for anything next smaller use monotonic increasing
        int[] nums = new int[]{2,1,5,6,2,3};
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(res,-1);
        stack.push(0);
        for (int i=0;i<nums.length;i++){
            while (!stack.isEmpty() && nums[i]>nums[stack.peek()]){
                int index = stack.pop();
                res[index] = nums[i];
            }
            stack.push(i);
        }
        Arrays.stream(res).forEach(System.out::println);
    }
}
