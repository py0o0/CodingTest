import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[10001][200];
        for(int i =0; i < m; i++){
            int x = Integer.parseInt(br.readLine());
            dp[x][0] = -1;
            if(x == 2){
                System.out.println(-1);
                return;
            }
        }

        Queue<xy>q = new LinkedList<>();
        q.add(new xy(2, 1, 1));
        dp[1][0] = 1;
        dp[2][1] = 1;

        int[] dx = {-1,0,1};
        while(!q.isEmpty()){
            xy x = q.poll();

            for(int i = 0; i < 3; i++){
                int jump = x.jump + dx[i];
                if(jump < 1) continue;
                int nx = x.cur + jump;

                if(nx == n){
                    System.out.println(x.cnt + 1); return;
                }
                if(nx > n || dp[nx][0] == -1 || dp[nx][jump] != 0) continue;
                dp[nx][jump] = x.cnt + 1;
                q.add(new xy(nx, jump, dp[nx][jump]));
            }

        }
        System.out.println(-1);

    }
    static class xy{
        int cur, jump, cnt;
        xy(int cur, int jump, int cnt){
            this.cur = cur;
            this.jump = jump;
            this.cnt = cnt;
        }
    }
}