package DSA.Maths;

class Solution {
    public static void main(String[] args) {
        System.out.println(plusOne(new int[]{9}));
    }
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        digits[n-1] = digits[n-1] + 1;
        if(digits[n-1]<9) return digits;
        else {
            int carry = 0;
            for (int i = n - 1; i >= 0; i--) {
                int a = digits[i] + carry;
                digits[i] = a % 10;
                carry = a / 10;
            }
            digits[0] = digits[0] + carry;
        }
        if(digits[0]<=9) return digits;
        else{
            int[] nums = new int[n+1];
            nums[0] = digits[0]/10;
            nums[1] = digits[0]%10;
            for(int i=2;i<n+1;i++){
                nums[i] = digits[i];
            }
            return nums;
        }
    }
}