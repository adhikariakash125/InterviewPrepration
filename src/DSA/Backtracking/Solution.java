package DSA.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSum2 {
    static List<List<Integer>> res;

    public static void main(String[] args) {
        combinationSum2(new int[]{2,5,2,1,2},5);
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates,0,new ArrayList<>(),target);
        return res;
    }

    public static void solve(int[] nums,int i,List<Integer> ans,int target){
        if(i>=nums.length || target<0 || res.contains(ans)) return;
        if(target==0){
            res.add(ans);
            return;
        }
        ans.add(nums[i]);
        solve(nums,i+1,new ArrayList<>(ans),target-nums[i]);
        ans.removeLast();
        solve(nums,i+1,new ArrayList<>(ans),target);
    }
}