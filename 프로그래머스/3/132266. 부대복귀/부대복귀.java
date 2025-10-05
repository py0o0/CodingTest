import java.io.*;
import java.util.*;
class Solution {
    static ArrayList<Road>[] road;
    static int[] dp;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        road = new ArrayList[n + 1];
        dp = new int[n+1];
        for(int i = 0; i <= n; i++){
            road[i] = new ArrayList<>();
            dp[i] = Integer.MAX_VALUE;
        }
        
        for(int i = 0; i < roads.length; i++){
            road[ roads[i][0] ].add(new Road( roads[i][1] , 1));
            road[ roads[i][1] ].add(new Road( roads[i][0] , 1));
        }
        
        dijkstra(destination);
        
        int[] answer = new int[ sources.length ];
        int i = 0;
        for(int x : sources){
            answer[i++] = (dp[x] == Integer.MAX_VALUE ? -1 : dp[x]);
        }
        
        return answer;
    }

    static void dijkstra(int i){
        dp[i] = 0;
        PriorityQueue<Road> pq = new PriorityQueue<>((a, b) -> a.dis - b.dis);
        pq.add(new Road(i, 0));
        
        while(!pq.isEmpty()){
            Road x = pq.poll();
            for(Road r : road[x.x]){
                if(dp[r.x] > dp[x.x] + r.dis){
                    dp[r.x] = dp[x.x] + r.dis;
                    pq.add(new Road(r.x, dp[x.x] + r.dis));
                }
            }
        }
    }
    
    static class Road{
        int x, dis;
        Road(int x, int dis){
            this.x = x;
            this.dis = dis;
        }
    }
}