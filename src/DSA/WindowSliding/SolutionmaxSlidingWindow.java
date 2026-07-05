package DSA.WindowSliding;

import java.util.ArrayList;
import java.util.List;

class SolutionmaxSlidingWindow {
    public static void main(String[] args) {
        maxSlidingWindow(new int[]{1,-1},1);
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int maxn = Integer.MIN_VALUE;
        List<Integer> res = new ArrayList<>();
        int r = 0;
        int l = 0;
        while(r<nums.length){
            maxn = Math.max(maxn,nums[r]);
            if(r-l+1==k){
                res.add(maxn);
                l++;
            }
            r++;
        }
        int n = res.size();
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}