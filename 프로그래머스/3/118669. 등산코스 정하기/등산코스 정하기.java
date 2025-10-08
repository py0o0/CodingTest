import java.io.*;
import java.util.*;
class Solution {
    static ArrayList<Road>[] roads;
    static int[] mountain, start, dp;
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int m = summits.length;
        int k = gates.length;
        
        roads = new ArrayList[n + 1];
        dp = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            roads[i] = new ArrayList<>();
            dp[i] = Integer.MAX_VALUE;
        }
        
        for(int i = 0; i < paths.length; i++){
            roads[ paths[i][0] ].add(new Road(paths[i][1], paths[i][2]));
            roads[ paths[i][1] ].add(new Road(paths[i][0], paths[i][2]));
        }
        
        mountain = new int[50001];
        for(int i = 0; i < m; i++) mountain[ summits[i] ] = 1;
        start = new int[k];
        for(int i = 0; i < k; i++) start[i] = gates[i];
        
        dijkstra();
        
        int[] answer = new int[2];
        answer[1] = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            if(mountain[i] != 1) continue;
            if(answer[1] > dp[i]){
                answer[0] = i;
                answer[1] = dp[i];
            }
            
        }
        
        return answer;
    }
    void dijkstra(){
        PriorityQueue<Road> pq = new PriorityQueue<>((a, b) -> a.dis - b.dis);
        for(int s : start){
            pq.add(new Road(s, 0)); // 출발지 삽입
            dp[s] = 0;
        }
        
        while(!pq.isEmpty()){
            Road x = pq.poll();
            if (dp[x.x] < x.dis) continue;
            if(mountain[x.x] == 1) continue;
            
            for(Road road : roads[x.x]){
                int dis = Math.max(dp[x.x], road.dis);
                if(dp[road.x] > dis){
                    dp[road.x] = dis;
                    pq.add(new Road(road.x, dis));
                }
            }
        }
    }
    
    
    static class Road{
        int x, dis;
        Road(int a, int b){
            x = a; dis = b;
        }
    }
}