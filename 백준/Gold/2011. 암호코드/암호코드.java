import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String s = br.readLine();
        long[]dp = new long[s.length() + 1];

        if (s.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= s.length(); i++){
            int cur = s.charAt(i - 1) - '0';
            int prev = s.charAt(i - 2) - '0';
            prev = prev * 10 + cur;

            if(cur >= 1 && cur <= 9) dp[i] += dp[i - 1];
            if(prev >= 10 && prev <= 26) dp[i] += dp[i - 2];

            dp[i] %= 1000000;
        }
        System.out.println(dp[s.length()]);
    }
}