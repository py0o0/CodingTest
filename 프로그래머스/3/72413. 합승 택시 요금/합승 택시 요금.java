import java.io.*;
import java.util.*;
class Solution {
    static ArrayList<Road>[] roads;
    static int[][] dp;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        
        roads = new ArrayList[n + 1];
        dp = new int[n+1][n+1];
        
        for(int i = 0; i <= n; i++){
            roads[i] = new ArrayList<>();
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        for(int[] f : fares){
            roads[f[0]].add(new Road(f[1], f[2]));
            roads[f[1]].add(new Road(f[0], f[2]));
        }
        
        dijkstra(s);  //출발지, a, b 지점 기준 거리만 구하면 되니 총 3번만 필요
        dijkstra(a);
        dijkstra(b);
        
        for(int i = 1; i <= n; i++){
            int cost = dp[s][i] + dp[a][i] + dp[b][i]; // i 까지 합승 후 각자
            answer = Math.min(answer, cost);
        }
        
        return answer;
    }
    
    static void dijkstra(int i){
        dp[i][i] = 0;
        PriorityQueue<Road> pq = new PriorityQueue<>((a,b)->a.dis - b.dis);
        pq.add(new Road(i, 0));
        
        while(!pq.isEmpty()){
            Road x = pq.poll();
            for(Road road : roads[x.x]){
                if(dp[i][road.x] > dp[i][x.x] + road.dis){
                    dp[i][road.x] = dp[i][x.x] + road.dis;
                    pq.add(new Road(road.x, dp[i][x.x] + road.dis));
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