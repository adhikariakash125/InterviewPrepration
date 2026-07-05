package DSA.DP1;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
    static List<List<Integer>> res;
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        solve(candidates,target,new ArrayList<Integer>(),0);
        return res;
    }

    private static void solve(int[] candidates, int target, List<Integer> ans, int index){
        if(target<0) return;
        if(target==0){
            res.add(ans);
            return;
        }
        for(int i=0;i<candidates.length;i++){
            ans.add(candidates[i]);
            solve(candidates,target-candidates[i],new ArrayList<>(ans),i+1);
            ans.removeLast();
        }
    }
}