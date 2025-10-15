
import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int n = targets.length;
        xy[] v = new xy[n];
        for(int i = 0; i < n; i++){
            v[i] = new xy();
            v[i].s = targets[i][0];
            v[i].e = targets[i][1];
        }
        
        Arrays.sort(v, (a,b)->a.s-b.s);
        int x = v[0].e;
        int cnt = 1;
        
        for(int i = 0; i < n; i++){
            if(x <= v[i].s){
                cnt++;
                x = v[i].e;
            }
            else if(x > v[i].e) x = v[i].e;
        }
        return cnt;
    }
    static class xy{
        int s, e;
    }
}