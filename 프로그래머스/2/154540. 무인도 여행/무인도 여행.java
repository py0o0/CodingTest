import java.io.*;
import java.util.*;
class Solution {
    static char[][]map;
    static int[][]visit;
    static int cnt, n, m;
    public int[] solution(String[] maps) {
        int[] answer = {};
        
        ArrayList<Integer> an = new ArrayList<>();
        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];
        visit = new int[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++)
                map[i][j] = maps[i].charAt(j);
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 'X') continue;
                if(visit[i][j] == 1) continue;
                dfs(i,j);
                an.add(cnt);
                cnt = 0;
            }
        }
        if(an.size() == 0) an.add(-1);
        answer = new int[an.size()];
        for(int i = 0; i < an.size(); i++)
            answer[i] = an.get(i);
        
        Arrays.sort(answer);
        return answer;
    }
    static void dfs(int x, int y){
        if(x < 0 || x >= n || y < 0 || y >= m) return;
        if(visit[x][y] == 1 || map[x][y] == 'X') return;
        
        
        visit[x][y] = 1;
        cnt += map[x][y] - '0';
        dfs(x + 1, y);
        dfs(x - 1, y);
        dfs(x, y + 1);
        dfs(x, y - 1);
    }
    
}