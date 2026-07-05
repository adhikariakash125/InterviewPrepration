package DSA.BinarySearch;

public class FindInMinRotated {
    public static void main(String[] args) {
        int[] nums = new int[]{3,4,5,1,2};
        int l = 0;
        int r = nums.length-1;
        int n = nums.length;
        if(nums.length==1) System.out.println(nums[0]);
        if(nums[0]<nums[r]) System.out.println(nums[0]);
        while(l<=r){
            int mid = l + (r-l)/2;
            int prev = (mid+n-1)%n;
            int next = (mid+1)%n;
            if(nums[0]<nums[next] && nums[mid]<nums[prev]) System.out.println(nums[mid]);
            else if(nums[mid]>=nums[0]) l = mid+1;
            else r = mid-1;
        }
    }
}
