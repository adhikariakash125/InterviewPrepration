package DSA.Arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSeq {
    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        for(int i:nums){
            if(!set.contains(i-1)){
                int ans = 1;
                while(set.contains(i+ans)){
                    ans++;
                }
                max = Math.max(ans,max);
            }
        }
        System.out.println(max);
    }
}
