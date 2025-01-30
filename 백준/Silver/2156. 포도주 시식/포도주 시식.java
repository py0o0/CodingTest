import java.util.*;
import java.io.*;

    class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            int n = Integer.parseInt(br.readLine());
            long[] v = new long[n];
            long[][] dp = new long[n][3];

            for (int i = 0; i < n; i++)
                v[i] = Long.parseLong(br.readLine());

            if(n == 1){
                System.out.println(v[0]);
                return;
            }
            else if(n == 2){
                System.out.println(v[0] + v[1]);
                return;
            }

            dp[0][1] = v[0];
            dp[1][1] = v[1];
            dp[1][2] = v[1] + v[0];
            dp[2][1] = v[0] + v[2];
            dp[2][2] = dp[1][1] + v[2];
            long max = Math.max(dp[1][1], dp[1][2]);
            for(int i = 3; i < n; i++){
                dp[i][2] = dp[i-1][1] + v[i];

                dp[i][1] = Math.max(dp[i-2][1], Math.max(dp[i-2][2],dp[i-3][2])) + v[i];
                max = Math.max(max, dp[i][2]);
                max = Math.max(max, dp[i][1]);
             }
            System.out.println(max);
        }
    }
