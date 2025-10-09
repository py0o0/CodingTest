import java.io.*;
import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long start = 1;
        
        Arrays.sort(times);
        long end = (long)times[times.length - 1] * n + 1;
        
        while(start < end){
            long mid = (start + end) / 2;
            
            long sum = 0;
            for(int t : times)
                sum += mid/t;
            
            if(sum >= n)
                end = mid;
            else start = mid + 1;
        }
        answer = start;
        return answer;
    }
}