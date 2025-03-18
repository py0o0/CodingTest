import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] dp = new int[target+1];

        int[] coins = new int[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            coins[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(coins);
        dp[0] = 1;

        for(int coin : coins){
            for(int j = coin; j <= target; j++){
                dp[j] += dp[j - coin];
            }
        }
        System.out.println(dp[target]);

    }


}