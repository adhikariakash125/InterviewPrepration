package DSA.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        combinationSum(new int[]{2,3,6,7},7);
    }
    static List<List<Integer>> res;
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        solve(candidates,0,new ArrayList<>(),target);
        return res;
    }

    private static void solve(int[] nums, int i, List<Integer> ans, int target){
        if(i>=nums.length || target<0){
            return;
        }
        if(target==0){
            res.add(ans);
            return;
        }
        ans.add(nums[i]);
        solve(nums,i,new ArrayList<>(ans),target-nums[i]);
        ans.removeLast();
        solve(nums,i+1,new ArrayList<>(ans),target);
        return;
    }
}