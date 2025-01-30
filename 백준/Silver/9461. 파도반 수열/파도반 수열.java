import java.util.*;
import java.io.*;

    class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            long[] dp = new long[101];
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;
            dp[4] = 2;
            for(int i = 5; i<101; i++) {
                dp[i] = dp[i - 3] + dp[i - 2];
            }

            int t = Integer.parseInt(br.readLine());
            while(t-- > 0) {
                int n = Integer.parseInt(br.readLine());
                System.out.println(dp[n]);
            }
        }
    }
