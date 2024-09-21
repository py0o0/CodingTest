import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        int[] dp = new int[k + 1];

        for(int i=0; i<n; i++)
            coins[i] = Integer.parseInt(br.readLine());
        Arrays.sort(coins);
        dp[0] = 0;

        for(int coin : coins){
            for(int j=coin; j<=k; j++){
                if(dp[j - coin] == 0 && j-coin != 0) continue;
                if(dp[j] == 0)
                    dp[j] = dp[j - coin] + 1;
                else
                    dp[j] = Math.min(dp[j - coin] + 1, dp[j]);
            }

        }
        if(dp[k] == 0)
            System.out.println(-1);
        else
            System.out.println(dp[k]);

    }

}
