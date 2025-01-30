import java.util.*;
import java.io.*;

    class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            int n = Integer.parseInt(br.readLine());
            int[][] v = new int[n][n];
            int[][] dp = new int[n][n];

            for(int i = 0; i<n;i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<=i; j++)
                    v[i][j] = Integer.parseInt(st.nextToken());
            }
            dp[0][0] = v[0][0];
            long an = dp[0][0];
            for(int i = 1; i<n; i++){
                for(int j = 0; j<=i; j++){
                    if(j == 0) dp[i][j] = dp[i-1][j] + v[i][j];
                    else if(j == i) dp[i][j] = dp[i-1][j-1] + v[i][j];
                    else
                        dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + v[i][j];
                    an = Math.max(an, dp[i][j]);
                }
            }

            System.out.println(an);
        }
    }
