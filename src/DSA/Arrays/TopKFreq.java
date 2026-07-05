package DSA.Arrays;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFreq {
    public static void main(String[] args) {
        int t = 2;
        int[] nums = new int[]{1,1,1,2,2,3};
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.v-a.v);
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] res = new int[t];
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int key:map.keySet()){
            pq.add(new Pair(key,map.get(key)));
            if(pq.size()>t)
                pq.poll();
        }
        for(int i=0;i<t;i++){
            res[i] = pq.poll().k;
        }
        System.out.println(res);
    }
}

class Pair{
    int k;
    int v;
    Pair(int k,int v){
        this.k = k;
        this.v = v;
    }
}
