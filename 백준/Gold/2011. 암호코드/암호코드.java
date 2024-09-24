    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;

    public class Main {


        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            String s = br.readLine();

            int[] dp = new int[s.length() + 1];
            dp[0] = 1;
            for (int i = 1; i <= s.length(); i++) {
                int cur = s.charAt(i - 1) - '0';
                if(cur >= 1 && cur <= 9) 
                    dp[i] += dp[i - 1];
                    
                

                if(i == 1) continue;

                int prev = s.charAt(i - 2) - '0';
                prev = prev * 10 + cur;

                if(prev >= 10 && prev <= 26) {
                    dp[i] += dp[i - 2];
                    dp[i] %= 1000000;
                }
            }
            System.out.println(dp[s.length()]);


        }

    }
