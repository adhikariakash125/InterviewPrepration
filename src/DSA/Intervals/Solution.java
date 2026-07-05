package DSA.Intervals;

import java.util.List;

/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public static void main(String[] args) {
        Interval interval = new Interval(0,30);
        Interval interval1 = new Interval(5,10);
        Interval interval2 = new Interval(15,20);
        Interval interval3 = new Interval(5,8);
        Interval interval4 = new Interval(9,15);
//        System.out.println(canAttendMeetings(List.of(interval, interval1, interval2)));
        System.out.println(canAttendMeetings(List.of(interval3, interval4)));
    }
    public static boolean canAttendMeetings(List<Interval> intervals) {
        Tree root = null;
        for(Interval i:intervals){
            if(root==null)
                root = new Tree(i.start,i.end);
            else{
                if(root.e>i.start && i.end> root.s) return false;
                else if(root.e<=i.start){
                    root.right = new Tree(i.start,i.end);
                    root = root.right;
                }else if(root.s>=i.end){
                    root.left = new Tree(i.start,i.end);
                    root = root.left;
                }
            }
        }
        return true;
    }
    public static class Interval {
        public int start, end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}

class Tree{
    int s;
    int e;
    Tree left;
    Tree right;

    Tree(int s,int e){
        this.s = s;
        this.e = e;
    }
}

