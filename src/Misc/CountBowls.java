package Misc;

class CountBowls {
    public static void main(String[] args) {
        bowlSubarrays(new int[]{2,5,3,1,4});
    }
    public static long bowlSubarrays(int[] nums) {
        long ans = 0;
        for(int i=0;i<nums.length;i++){
            int j = 2;
            while(i+j<nums.length){
                if(isAns(nums,i,i+j))
                    ans++;
                j++;
            }
        }
        return ans;
    }

    private static boolean isAns(int[] nums,int l,int r){
        int left = Math.min(nums[l],nums[r]);
        int right = -1;
        for(int i=l+1;i<r;i++){
            right = Math.max(nums[i],right);
        }
        return left>right;
    }
}