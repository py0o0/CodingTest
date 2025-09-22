import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        if(n < 2){
            System.out.println("0"); return;
        }

        int[] v = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) v[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[n];

        dp[1] = Math.abs(v[0] - v[1]);

        for(int i = 2; i < n; i++){
            int max = v[i];
            int min = v[i];

            for(int j = i - 1; j > 0; j--){
                max = Math.max(max, v[j]);
                min = Math.min(min, v[j]);

                dp[i] = Math.max(dp[i], dp[j - 1] + (max - min));
            }
        }
        System.out.println(dp[n-1]);
    }
}