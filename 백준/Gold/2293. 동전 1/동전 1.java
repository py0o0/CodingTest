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

        int[] dp = new int[k + 1];

        int[] coins = new int[n];

        for(int i= 0; i<n;i++)
            coins[i] = Integer.parseInt(br.readLine());
        Arrays.sort(coins);

        dp[0] = 1;

        for(int i = 0; i< n; i++){
            int coin = coins[i];
            for(int j= coin; j<=k;j++){
                if(j - coin < 0)
                    continue;
                dp[j] = dp[j] + dp[j - coin];

            }
            
        }
        System.out.println(dp[k]);


    }



}
