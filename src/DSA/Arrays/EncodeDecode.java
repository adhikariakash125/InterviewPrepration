package DSA.Arrays;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {
    public static void main(String[] args) {
        String s = encode(List.of("we","say",":","yes","!@#$%^&*()"));
        decode(s);

    }

    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s:strs){
            sb.append("#");
            sb.append(s.length());
            sb.append(s);
        }
        return sb.toString();
    }

    public static List<String> decode(String str) {
        int i = 0;
        List<String> res = new ArrayList<>();
        while(i<str.length()){
            if(str.charAt(i)=='#'){
                int size = Integer.parseInt(str.substring(i+1,i+2));
                res.add(str.substring(i+2,i+2+size));
                i = i+size+2;
            }else {
                i++;
            }
        }
        return res;
    }
}
