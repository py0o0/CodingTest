import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] v = new int[n];
        for (int i = 0; i < n; i++) v[i] = Integer.parseInt(br.readLine());
        Arrays.sort(v);
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int coin : v){
            for(int j = coin; j <= target; j++){
                dp[j] = dp[j] + dp[j - coin];
            }
        }
        System.out.println(dp[target]);

    }
}