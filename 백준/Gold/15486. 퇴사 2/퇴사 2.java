import java.util.*;
import java.io.*;

public class Main{

    static String str;
    static String input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        xy[] v = new xy[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            v[i] = new xy();
            v[i].x = Integer.parseInt(st.nextToken());
            v[i].val = Long.parseLong(st.nextToken());
        }

        long[] dp = new long[n + 1];
        for(int i = 0; i < n; i++){
            if(i != 0){
                dp[i] = Math.max(dp[i], dp[i-1]);
            }

            if(i + v[i].x <= n){
                dp[i + v[i].x] = Math.max(dp[i+v[i].x], dp[i] + v[i].val);
            }
        }
        dp[n] = Math.max(dp[n], dp[n-1]);



        System.out.println(dp[n]);

    }
    static class xy{
        int x;
        long val;
    }

}