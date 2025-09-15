import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        int[][] dp = new int[10001][4];
        dp[1][1] = 1;
        dp[2][1] = 1; dp[2][2] = 1;
        dp[3][1] = 1; dp[3][2] = 1; dp[3][3] = 1;

        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());

            for(int i = 4; i <= n; i++){
                if(dp[i][1] == 1) continue;
                dp[i][1] = 1;
                dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
                dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
            }

            System.out.println(dp[n][1] + dp[n][2] + dp[n][3]);
        }
    }
}