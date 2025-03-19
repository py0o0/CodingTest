import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n][k + 1];
        xy[] v = new xy[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            v[i] = new xy();
            v[i].x = Integer.parseInt(st.nextToken());
            v[i].y = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < n; i++)
            for(int j = 0; j <= k; j++) dp[i][j] = Integer.MAX_VALUE;

        dp[0][0] = 0;

        for(int i = 1; i < n; i++){
            dp[i][0] = dp[i-1][0] + minus(v[i],v[i-1]);
            for(int j = 1; j<=k;j++){
                if(i-j-1 < 0) break;
                int min = Integer.MAX_VALUE;
                for(int l = 0; l <= j; l++){
                    if(dp[i-l-1][j - l] == Integer.MAX_VALUE) continue;
                    min = Math.min(min,dp[i-l-1][j - l] + minus(v[i],v[i-l-1]));
                }
                dp[i][j] = min;
            }
        }

        int min = Integer.MAX_VALUE;

        for(int j = 0; j <= k; j++) min = Math.min(min,dp[n-1][j]);

        System.out.println(min);


    }
    static int minus(xy a, xy b){
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    static class xy{
        int x,y;
    }

}