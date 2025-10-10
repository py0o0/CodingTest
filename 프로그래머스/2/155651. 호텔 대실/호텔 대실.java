import java.io.*;
import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 1;
        int n = book_time.length;
        xy[] v = new xy[n];
        for(int i = 0; i < n; i++){
            v[i] = new xy();
            int st = Integer.parseInt(book_time[i][0].substring(0,2));
            int et = Integer.parseInt(book_time[i][0].substring(3,5));
            v[i].st = st * 60 + et;
            
            st = Integer.parseInt(book_time[i][1].substring(0,2));
            et = Integer.parseInt(book_time[i][1].substring(3,5)) + 10;
            v[i].et = st * 60 + et;
        }
        
        Arrays.sort(v, (a,b)->a.st-b.st);
        PriorityQueue<xy> pq = new PriorityQueue<>((a,b)->a.et - b.et);
        for(xy x : v){
            if(pq.size() == 0){
                pq.add(x); continue;
            }
            while(!pq.isEmpty() && pq.peek().et <= x.st){
                pq.poll();
            }
            
            pq.add(x);
            answer = Math.max(answer, pq.size());
        }
        
        
        return answer;
    }
    static class xy{
        int st, et;
    }
}