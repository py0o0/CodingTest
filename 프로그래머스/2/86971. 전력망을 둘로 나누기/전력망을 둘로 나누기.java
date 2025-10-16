import java.io.*;
import java.util.*;
class Solution {
    static int cnt;
    static ArrayList<Integer>[] roads;
    static int[] visit;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        visit = new int[n+1];
        roads = new ArrayList[n+1];
        for(int i = 0; i <= n; i++) roads[i] = new ArrayList<>();
        for(int i = 0; i < wires.length; i++){
            roads[ wires[i][0] ].add(wires[i][1]);
            roads[ wires[i][1] ].add(wires[i][0]);
        }
        
        for(int i = 0; i < wires.length; i++){
            dfs(1, wires[i][0], wires[i][1]); // 시작점, 금지 길
            int x = n - cnt;
            x = Math.abs(x - cnt);
            answer = Math.min(answer, x);
            
            Arrays.fill(visit,0);
            cnt = 0;
        }
        
        
        return answer;
    }
    static void dfs(int s, int x1, int x2){
        if(visit[s] == 1) return;
        cnt++; visit[s] = 1;
        
        for(int e : roads[s]){
            if((s == x1 && e == x2) || (s == x2 && e == x1)) continue; //끊은 길
            dfs(e, x1, x2);
        }
    }
}