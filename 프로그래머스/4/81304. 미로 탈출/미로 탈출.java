import java.io.*;
import java.util.*;
class Solution {
    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        ArrayList<Road>[][] road = new ArrayList[n + 1][2];
        ArrayList<Integer> trap = new ArrayList<>();
        
        for(int i = 0; i <= n; i++){
            road[i][0] = new ArrayList<>();
            road[i][1] = new ArrayList<>();
        }
        
        for(int[] r : roads){
            road[r[0]][0].add(new Road(r[1], r[2]));
            road[r[1]][1].add(new Road(r[0], r[2]));
        }
        
        for(int t : traps){
            trap.add(t);
        }
        
        int[][] dp = new int[n + 1][1 << trap.size()];
        for(int i = 0; i <= n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        PriorityQueue<xy> pq = new PriorityQueue<>((a,b)->a.dis-b.dis);
        pq.add(new xy(start, 0, 0));
        
        while(!pq.isEmpty()){
            xy x = pq.poll();
            
            if(x.x == end){
                return x.dis;
            }
            
            int state = x.state;
            int curTrap = 0;
            for(int i = 0; i < trap.size(); i++){
                if(trap.get(i) == x.x){
                    state ^= (1 << i);
                    curTrap = (state >> i) & 1;
                    break;
                }
            }
            
            for(int next = 1; next <= n; next++){
                int nextTrap = 0;
                for(int i = 0; i < trap.size(); i++){
                    if(next == trap.get(i)){
                        nextTrap = (state >> i) & 1;
                        break;
                    }
                }
                int index = nextTrap ^ curTrap;
                
                for(Road r : road[x.x][index]){
                    if(next != r.x) continue;
                    if(dp[r.x][state] > x.dis + r.dis){
                        dp[r.x][state] = x.dis + r.dis;
                        pq.add(new xy(r.x, x.dis + r.dis, state));
                    }
                }
                
                
            }
        }
        
        return 0;
    }
    
    static class Road{
        int x, dis;
        Road(int a, int b){
            x = a; dis = b;
        }
    }
    static class xy{
        int x, dis, state;
        xy(int a, int b, int c){
            x = a; dis = b; state = c;
        }
    }
}