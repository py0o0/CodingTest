import java.io.*;
import java.util.*;

class Solution {
    static int[][] map;
    static int[][][] visit;
    static int n, m, an;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    
    public int solution(int[][] maze) {
        int answer = 0;
        
        map = maze;
        n = maze.length;
        m = maze[0].length;
        an = Integer.MAX_VALUE;
        visit = new int[n][m][2];
        
        xy R = new xy(0 ,0);
        xy B = new xy(0, 0);
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j]==1){
                    R.x = i; R.y = j;
                }
                else if(map[i][j] == 2){
                    B.x = i; B.y = j;
                }
            }
        }
        
        dfs(R, B, 0, 0, 0, 0);
        
        answer = an;
        if(answer == Integer.MAX_VALUE) answer = 0;
            
        return answer;
    }
    
    static void dfs(xy R, xy B,int turn,int sucR,int sucB, int cnt){
        if(R.x < 0 || R.x >= n || R.y < 0 || R.y >= m) return;
        if(B.x < 0 || B.x >= n || B.y < 0 || B.y >= m) return;
        if(R.x == B.x && R.y == B.y ) return;
        if(map[R.x][R.y] == 5 || map[B.x][B.y] == 5) return;
        if(turn == 0 && visit[R.x][R.y][turn] == 1) return;
        if(turn == 1 && visit[B.x][B.y][turn] == 1) return;
        
        if(map[R.x][R.y] == 3) sucR = 1;
        if(map[B.x][B.y] == 4) sucB = 1;
        if(sucR == 1 && sucB == 1){
            an = Math.min(an, cnt);
            return;
        }
        
        xy ball;
        if(turn == 0) ball = new xy(R.x, R.y);
        else ball = new xy(B.x, B.y);
        
        visit[ball.x][ball.y][turn] = 1;
        
        if(sucB == 1){
            for(int i = 0; i < 4; i++)
                dfs(new xy(R.x + dx[i], R.y + dy[i]), B, 0, sucR, sucB, cnt + 1);
        }
        else if(sucR == 1){
            for(int i = 0; i < 4; i++)
                dfs(R, new xy( B.x + dx[i], B.y + dy[i] ), 1, sucR, sucB, cnt + 1);
        }
        
        else if(turn == 0){
            for(int i = 0; i < 4; i++)
                dfs(R, new xy( B.x + dx[i], B.y + dy[i] ), 1, sucR, sucB, cnt);
        }
        else if(turn == 1){
            for(int i = 0; i < 4; i++)
                dfs(new xy(R.x + dx[i], R.y + dy[i]), B, 0, sucR, sucB, cnt + 1);
        }
        visit[ball.x][ball.y][turn] = 0;
    }
    
    static class xy{
        int x, y;
        xy(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}