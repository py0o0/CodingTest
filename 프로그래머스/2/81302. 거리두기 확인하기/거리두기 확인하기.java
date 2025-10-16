import java.io.*;
import java.util.*;
class Solution {
    static char map[][][];
    static int visit[][];
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        visit = new int[5][5];
        map = new char[5][5][5];
        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 5; j++)
                for(int k = 0; k < 5; k++) map[i][j][k] = places[i][j].charAt(k);
        
        for(int i = 0; i < 5; i++){
            int flag = 1;
            for(int j = 0; j < 5; j++){
                for(int k = 0; k < 5; k++){
                    if(map[i][j][k] != 'P') continue;
                    if(!bfs(i,j,k)){
                        flag = 0; break;
                    }
                }if(flag == 0) break;
            }
            answer[i] = flag;
        }
        
        return answer;
    }
    static boolean bfs(int i, int j, int k){
        Queue<xy> q = new LinkedList<>();
        q.add(new xy(j,k,0));
        
        for(int l = 0; l < 5; l++) Arrays.fill(visit[l], 0);
        visit[j][k] = 1;
        
        while(!q.isEmpty()){
            xy x = q.poll();
            if(x.cnt == 2) continue;
            
            for(int l = 0; l < 4; l++){
                int nx = x.x + dx[l];
                int ny = x.y + dy[l];
                if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                if(visit[nx][ny] == 1) continue;
                if(map[i][nx][ny] == 'X') continue;
                if(map[i][nx][ny] == 'P') return false;
                visit[nx][ny] = 1;
                q.add(new xy(nx, ny, x.cnt + 1));
            }
        }
        
        return true;
    }
    
    static class xy{
        int x, y, cnt;
        xy(int a, int b,int c){
            x = a; y = b; cnt = c;
        }
    }
}