import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] coins = new int[n];

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < n; i++)
                coins[i] = Integer.parseInt(st.nextToken());

            int k = Integer.parseInt(br.readLine());

            int[] dp = new int[k + 1];
            
            dp[0] = 1;
            
            for(int coin : coins){
                for(int j = coin; j <= k; j++)
                    dp[j] += dp[j - coin];
            }
            System.out.println(dp[k]);
        }

    }



}