import java.io.*;
import java.util.*;
class Solution {
    static int[][] dp;
    static int[][] visit;
    static int[] dx = {1,0,0,-1};
    static int[] dy = {0,-1,1,0};
    static String[] str = {"d", "l", "r", "u"};
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        
        x-= 1; y-=1; r-=1; c-=1;
        dp = new int[n][m];
        visit = new int[n][m];
        
        Queue<xy> q = new LinkedList<>();
        q.add(new xy(r, c, 0, ""));
        visit[r][c] = 1;
        
        while(!q.isEmpty()){
            xy a = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = a.x + dx[i];
                int ny = a.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(visit[nx][ny] == 1) continue;
                visit[nx][ny] = 1;
                dp[nx][ny] = a.cnt + 1;
                q.add(new xy(nx, ny, a.cnt + 1, ""));
            }
        }
        
        PriorityQueue<xy> pq = new PriorityQueue<>((a,b)->a.s.compareTo(b.s));
        pq.add(new xy(x, y, k, ""));
        
        while(!pq.isEmpty()){
            xy a = pq.poll();
            for(int i = 0; i < 4; i++){
                int nx = a.x + dx[i];
                int ny = a.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(a.cnt - 1 < dp[nx][ny]) continue;
                if((a.cnt - 1) % 2 != dp[nx][ny] % 2) continue; //홀짝에 따라 갈수 없는 경로
                
                String s = a.s + str[i];
                if(nx == r && ny == c && a.cnt - 1 == 0) 
                    return s;
                
                pq.add(new xy(nx, ny, a.cnt - 1, s));
            }
        }
        answer = "impossible";
        return answer;
    }
    static class xy{
        int x, y, cnt;
        String s;
        xy(int a, int b, int c, String d){
            x = a; y = b; cnt = c; s = d;
        }
    }
}