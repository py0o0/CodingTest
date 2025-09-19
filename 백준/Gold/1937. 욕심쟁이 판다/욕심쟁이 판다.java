import java.util.*;
import java.io.*;

public class Main{

    static int n;
    static int[][] map;
    static int [][] dp;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j], dfs(i, j));
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max);
    }
    static int dfs(int x, int y){
        if(dp[x][y] != 0) return dp[x][y];

        dp[x][y] = 1;

        for(int k = 0; k < 4; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if(map[x][y] >= map[nx][ny]) continue;

            dp[x][y] = Math.max(1 + dfs(nx, ny), dp[x][y]);
        }

        return dp[x][y];
    }
}