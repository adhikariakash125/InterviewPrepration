package DesignPatterns.Singelton;

class Solution {
    private Solution(){};
    private static class BPHelper{
        private static final Solution obj = new Solution();
    }
    public static Solution getInstance(){
        return BPHelper.obj;
    }
}