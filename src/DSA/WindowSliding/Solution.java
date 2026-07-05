package DSA.WindowSliding;

import java.util.HashMap;

class Solution {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
    public static String minWindow(String s, String t) {
        HashMap<Character,Integer> f1 = new HashMap<>();
        HashMap<Character,Integer> f2 = new HashMap<>();
        int l = 0;
        int r = 0;
        String res = "";
        int minl = 10000;
        for(int i=0;i<t.length();i++) f1.put(t.charAt(i),f1.getOrDefault(t.charAt(i),0)+1);
        while(r<s.length()){
            f2.put(s.charAt(r),f2.getOrDefault(s.charAt(r),0)+1);
            while(solve(f1,f2,t)){
                if(minl>r-l+1) {
                    minl = r - l + 1;
                    res = s.substring(l, r + 1);
                    while (l <= r) {
                        f2.put(s.charAt(l),f2.get(s.charAt(l))-1);
                        l++;
                    }
                }
            }
            r++;
        }
        return res;
    }

    private static boolean solve(HashMap f1,HashMap f2,String t){
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            if(f1.get(ch)!=f2.get(ch)) return false;
        }
        return true;
    }
}