import java.io.*;
import java.util.*;
class Solution {
    static char[][] map;
    static int[][] visit;
    static int n, m;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        
        
        n = storage.length;
        m = storage[0].length();
        map = new char[n][m];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                map[i][j] = storage[i].charAt(j);
        
        Queue<xy> q = new LinkedList<>();
        for(String req : requests){
            int flag = (req.length() == 1 ? 0 : 1);
            char c = req.charAt(0);
            
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(map[i][j] != c) continue;
                    int edge = 0;
                    visit = new int[n][m];
                    for(int k = 0; k < 4; k++)
                        edge += dfs(i + dx[k], j + dy[k]);
                    
                    
                    if(edge != 0 || flag == 1) q.add(new xy(i, j));
                }
            }
            
            while(!q.isEmpty()){
                xy x = q.poll();
                map[x.x][x.y] = '0';
            }
            
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++)
                    System.out.print(map[i][j]);
                System.out.println();
            }
            System.out.println();
            
        }
        
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] != '0') answer++;
            }
        }
        
        return answer;
    }
    static int dfs(int i, int j){
        if(i < 0 || i >= n || j < 0 || j >= m) return 1;
        if(map[i][j] != '0') return 0;
        if(visit[i][j] == 1) return 0;
        visit[i][j] = 1;
        
        int cnt = 0;
        for(int k = 0; k < 4; k++)
            cnt += dfs(i + dx[k], j + dy[k]);
        return cnt;
    }
    
    
    static class xy{
        int x, y;
        xy(int a, int b){
            x = a; y = b;
        }
    }
}