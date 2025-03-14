import java.io.*;
import java.util.*;

class Main{

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int max,n,m;
    static char[][] v;
    static int[][] visit, dp;
    static int flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        v = new char[n][m];
        visit =  new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                v[i][j] = line.charAt(j);
            }
        }

        if(v[0][0] == 'H'){
            System.out.println(0);
            return;
        }

        visit[0][0] = 1;
        dfs(0,0,1);

        if(flag == 1) max = -1;
        System.out.println(max);

    }
    static void dfs(int x,int y,int cnt){
        max = Math.max(max,cnt);

        if(dp[x][y] >= cnt) return;

        dp[x][y] = cnt;

        int val = v[x][y] - '0';
        if(flag == 1)
            return;

        for(int i = 0; i<4;i++){
            if(flag == 1)
                return;

            int nx = x + val * dx[i];
            int ny = y + val * dy[i];

            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if(v[nx][ny] == 'H') continue;

            if(visit[nx][ny] == 1){
                flag = 1;
                return;
            }

            visit[nx][ny] = 1;
            dfs(nx,ny,cnt+1);
            visit[nx][ny] = 0;
        }
    }
}