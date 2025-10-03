import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        
        int a = scores[0][0]; int b = scores[0][1];
        
        int n = scores.length;
        xy[] v = new xy[n];
        
        for(int i = 0
            ; i < n; i++){
            v[i] = new xy();
            v[i].x = scores[i][0];
            v[i].y = scores[i][1];
        }
        
        Arrays.sort(v, (x, y) -> {
            if(x.x == y.x) return x.y - y.y;
            return y.x - x.x;
        });

        
        int max = v[0].y;
        for(int i = 0; i < n; i++){
            if(v[i].y < max){ 
                if(v[i].x == a && v[i].y == b){
                    return -1;
                }
                v[i].x = v[i].y = 0;
            }
            else max = Math.max(v[i].y , max);
        }
        
        for(int i = 0; i < n; i++){
            if(a + b < v[i].x + v[i].y) answer++;
        }
        
        
        return answer;
    }
    static class xy{
        int x, y;
    }
}