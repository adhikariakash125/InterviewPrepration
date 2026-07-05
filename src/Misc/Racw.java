package Misc;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Racw {
    public static void main(String[] args) {
        recoverOrder(new int[]{3,1,2,5,4},new int[]{1,3,4});
    }
    public static int[] recoverOrder(int[] order, int[] friends) {
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.v-b.v);
        int[] res = new int[friends.length];
        for(int i=0;i<order.length;i++){
            map.put(order[i],i);
        }
        for(int i:friends){
            pq.add(new Pair(i,map.get(i)));
        }
        int j = 0;
        while(!pq.isEmpty()){
            res[j++] = pq.remove().k;
        }
        return res;
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
