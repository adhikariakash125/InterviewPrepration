package DSA.Backtracking;

import java.util.ArrayList;
import java.util.List;

class PP {

    public static void main(String[] args) {
        partition("aab");
    }

    static List<List<String>> res;
    public static List<List<String>> partition(String s) {
        res = new ArrayList<>();
        solve(s,0,new ArrayList<>());
        return res;
    }

    private static void solve(String s, int index, ArrayList<String> ans){
        if(s.length()==0){
            res.add(ans);
            return;
        }
        for(int i=0;i<s.length();i++){
            String prefix = s.substring(0,i+1);
            String restOfString = s.substring(i+1);
            if(isPali(prefix)){
                ans.add(prefix);
                solve(restOfString,i,new ArrayList<>(ans));
                ans.removeLast();
            }
        }
    }

    private static boolean isPali(String s){
        int l = 0;
        int r = s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}