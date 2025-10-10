import java.io.*;
import java.util.*;
class Solution {
    
    static int N, M;
    static int[][] in;
    static int min;
    static Set<String> set;
    
    public int solution(int[][] info, int n, int m) {
        int answer = 0;
        N = n;
        M = m;
        in = info;
        min = Integer.MAX_VALUE;
        set = new HashSet<>();
        
        dfs(0, 0, 0);
        
        answer = (min == Integer.MAX_VALUE ? -1 : min);
        
        return answer;
    }
    static void dfs(int i, int a, int b){
        if(a >= N) return;
        if(b >= M) return;
        
        if(i >= in.length){
            min = Math.min(a,min);
            return;
        }
        String s = i + " " + a + " " + b;
        if(set.contains(s)) return;
        set.add(s);
        
        dfs(i + 1, a + in[i][0], b);
        dfs(i + 1, a, b + in[i][1]);
        
    }
}