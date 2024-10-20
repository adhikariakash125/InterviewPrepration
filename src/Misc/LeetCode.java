package Misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode {
    public static void main(String[] args) {
//        System.out.println(largestNumber(new int[]{10, 2}));
        findDuplicates();
    }
    public static String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        StringBuilder res = new StringBuilder();
        for(int i=0;i<nums.length;i++)
            s[i] = String.valueOf(nums[i]);
        List<String> list = Arrays.asList(s).stream().sorted((a, b) -> {
            String x = a + b;
            String y = b + a;
            return y.compareTo(x);
        }).toList();
        for (String x:list)
            res.append(x);
        if (list.getFirst().equals("0")) return "0";
        return res.toString();
    }

    public static void findDuplicates(){
        int[] ints = {6, 10, 2, 8, 1, 9, 4, 7, 3};
        int n = ints.length;
        int s = (n * (n+1))/2;
        int sum = Arrays.stream(ints).sum();
        System.out.println(s-sum);
//        for (int i=0;i<ints.length;i++){
//            int index = Math.abs(ints[i]-1);
//            if (ints[index]>0)
//                ints[index] = -ints[index];
//        }
//        for (int i=0;i<ints.length;i++){
//            if (ints[i]>0)
//                System.out.println(i+1);
//        }
    }

}
