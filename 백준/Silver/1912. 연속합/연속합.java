import java.util.*;
import java.io.*;

    class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            int n = Integer.parseInt(br.readLine());
            int[] v = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++)
                v[i] = Integer.parseInt(st.nextToken());
            int[] dp = new int[n];

            dp[0] = v[0];
            for(int i = 1; i < n; i++){
                int sum = dp[i-1] + v[i];
                if(sum < v[i])
                    dp[i] = v[i];
                else dp[i] = sum;
            }
            int an = dp[0];
            for(int i = 0; i < n; i++) {
                an = Math.max(an, dp[i]);
            }

            System.out.println(an);
        }
    }
