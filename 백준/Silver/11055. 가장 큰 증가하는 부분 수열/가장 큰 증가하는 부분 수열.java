import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] v = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            v[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[n];

        for(int i = 0; i < n; i++)
            dp[i] = v[i];

        int max = dp[0];
        for(int i=1;i<n;i++){
            for(int j = 0; j<i;j++){
                if(v[j]<v[i] && dp[i] < v[i] + dp[j])
                    dp[i] = v[i] + dp[j];

            }
            max = Math.max(max,dp[i]);
        }

        System.out.println(max);

    }

}
