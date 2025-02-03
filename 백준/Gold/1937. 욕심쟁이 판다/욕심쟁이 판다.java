import java.io.*;
import java.util.*;

class Main{

    static int[][] map;
    static int[][] dp;
    static int n;
    static int[] dx = {0, 0, 1, -1};  // 4방향 이동
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];


        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int max = 0;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                max = Math.max(max, dfs(i,j));
            }

        System.out.println(max);

    }
    static int dfs(int x, int y){
        if (dp[x][y] != 0) return dp[x][y]; // 이미 방문한 곳이면 반환 (메모이제이션)

        dp[x][y] = 1; // 자기 자신 포함
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] > map[x][y]) {
                dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
            }
        }
        return dp[x][y];
    }

    static class xy{
        int x,y,val;
        xy(int x,int y,int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }


}