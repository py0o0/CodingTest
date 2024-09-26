    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;

    public class Main {


        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            int n = Integer.parseInt(br.readLine());

            long[] dp = new long[n + 1];
            
            if(n < 2){
                System.out.println(0);
                return;
            }

            dp[0] = 0;
            dp[1] = 0;
            dp[2] = 1;
            for(int i = 3; i <= n; i++)
                dp[i] = ((i-1) * (dp[i-1] + dp[i-2])) % 1000000000;

            System.out.println(dp[n]);


        }

    }
