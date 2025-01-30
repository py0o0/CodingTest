import java.util.*;
import java.io.*;

    class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            int d = Integer.parseInt(br.readLine());
            long[] dp = new long[1000001];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 3;
            for(int i = 4; i<=d; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
                dp[i] %= 15746;
            }
            System.out.println(dp[d]);
        }
    }
