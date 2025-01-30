import java.util.*;
import java.io.*;

    class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            int n = Integer.parseInt(br.readLine());
            int[] v = new int[n];
            int[][]dp = new int[n][3];
            for (int i = 0; i < n; i++)
                v[i] = Integer.parseInt(br.readLine());
            if(n == 1){
                System.out.println(v[0]);
                return;
            }
            dp[0][1] = v[0];
            dp[1][2] = dp[0][1] + v[1];
            dp[1][1] = v[1];

            for(int i = 2; i<n;i++){
                dp[i][2] = dp[i-1][1] + v[i];
                dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2]) + v[i];
            }
            System.out.println(Math.max(dp[n-1][2], dp[n-1][1]));
        }
    }
