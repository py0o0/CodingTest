import java.io.*;
import java.util.*;
class Solution {
    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        ArrayList<Road>[][] road = new ArrayList[n + 1][2];
        ArrayList<Integer> trap = new ArrayList<>();
        
        for(int i = 0; i <= n; i++){
            for(int j = 0; j < 2; j++) road[i][j] = new ArrayList<>();
        }
        for(int[] r : roads){
            road[r[0]][0].add(new Road(r[1], r[2])); //함정 밟지 않음
            road[r[1]][1].add(new Road(r[0], r[2])); //함정 밟음
        }
        for(int t : traps){
            trap.add(t);
        }
        
        int[][] dp = new int[n + 1][1 << trap.size()];
        for (int i = 1; i <= n; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        
        PriorityQueue<xy> pq = new PriorityQueue<>((a,b)->a.cost - b.cost);
        pq.add(new xy(start, 0, 0));
        
        while(!pq.isEmpty()){
            xy x = pq.poll();
            
            if(x.cur == end){
                return x.cost;
            }
            
            int trapState = x.state;
            for(int i = 0; i < trap.size(); i++){
                if(trap.get(i) == x.cur){
                    trapState ^= (1 << i); // 트랩 상태
                    break;
                }
            }
            
            
            for(int next = 1; next <= n; next++){
                int dir = 0;
                int curTrap = 0, nextTrap = 0;
                
                for(int i = 0; i < trap.size(); i++){
                    if(trap.get(i) == x.cur && ((trapState >> i) & 1) == 1)
                        curTrap = 1;
                    if(trap.get(i) == next && ((trapState >> i) & 1) == 1)
                        nextTrap = 1;
                }
                
                int index = curTrap ^ nextTrap;
                
                for(Road r : road[x.cur][index]){
                    if(r.x != next) continue;
                    if(dp[r.x][trapState] > x.cost + r.dis){
                        dp[r.x][trapState] = x.cost + r.dis;
                        pq.add(new xy(r.x,  x.cost + r.dis ,trapState));
                    }
                }
            }
            
        }
        
        return 0;
    }
    static class xy{
        int cur, cost, state;
        xy(int a, int b, int c){
            cur = a; cost = b; state = c;
        }
    }
    
    static class Road{
        int x, dis;
        Road(int a, int b){
            x = a; dis = b;
        }
    }
}