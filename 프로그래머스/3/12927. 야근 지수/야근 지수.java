import java.io.*;
import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>((x, y) -> Long.compare(y, x));
        
        for(int i = 0; i < works.length; i++)
            pq.add((long)works[i]);
        
        for(int i = 0; i < n; i++){
            long x = pq.poll();
            if(x == 0) break;
            pq.add(x - 1);
        }
        while(!pq.isEmpty()){
            long x = pq.poll();
            answer += x * x;
        }
        
        return answer;
    }
}