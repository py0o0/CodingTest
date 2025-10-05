import java.io.*;
import java.util.*;

class Solution {
    static int[][] v;
    static xy[] req;
    public int solution(int k, int n, int[][] reqs) {
        int answer = 0;
        
        req = new xy[reqs.length];
        
        for(int i = 0; i < reqs.length; i++){
            req[i] = new xy();
            req[i].a = reqs[i][0];
            req[i].b = reqs[i][1];
            req[i].c = reqs[i][2];
        }
        
        v = new int[k + 1][n + 1];
        for(int i = 1; i <= k; i++){
            for(int j = 1; j <= n; j++){
                cal(i, j);
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
        
        int[] consult = new int[k + 1];
        for(int i = 0; i <= k; i++) consult[i] = 2;
        
        int i = k;
        while(i++ < n){
            
            int maxGain = 0;
            int select = 0;
            for(int j = 1; j <= k; j++){
                int gain = v[j][ consult[j] - 1 ] - v[j][ consult[j] ];
                System.out.println(gain);
                if(maxGain < gain){
                    maxGain = gain;
                    select = j;
                }
            }
            if(maxGain == 0) break;
            consult[ select ]++;
        }
        
        for(i = 1; i <= k; i++)
            answer += v[i][ consult[i] - 1 ];
        
        
        
        return answer;
    }
    static class xy{
        int a,b,c;
    }
    
    static void cal(int x, int y){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int waitTime = 0;
        
        for(int i = 0; i < req.length; i++){
            if(req[i].c != x) continue;
            if(pq.size() < y){
                int finish = req[i].a + req[i].b;
                pq.add(finish);
                continue;
            }
            int prev = pq.poll();
            if(prev <= req[i].a){
                int finish = req[i].a + req[i].b;
                pq.add(finish);
                continue;
            }
            
            int wait = prev - req[i].a;
            waitTime += wait;
            int finish = prev + req[i].b;
            pq.add(finish);
        }
        v[x][y] = waitTime;
    
    }
    
    
}