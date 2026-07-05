package DSA.Maths;

class Solution1 {
    public static void main(String[] args) {
        System.out.println(myPow(2.0, -2000));
    }
    public static double myPow(double x, int n) {
        double[] ans = new double[1];
        ans[0] = 1.0;
        double[] res;
        if(n<0){
            res = solver(ans,1/x,Math.abs(n));
        }else{
            res = solver(ans,x,n);
        }
        return res[0];
    }

    private static double[] solver(double[] ans, double x,int n){
        if(n<=0) return ans;
        ans[0] *= x;
        return solver(ans,x,n-1);
    }
}